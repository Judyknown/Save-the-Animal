import java.util.Scanner;

/**
 * This class demonstrates a prime challenge game for one person
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class PrimeChallenge
{
    private Player player;
    private NumberGenerator numberGenerator;
    private char level;
    private int guessNumber;
    private boolean isHardMode;
    private int giveUp;
    
    /**
    * Default constructor which creates the object of the class PrimeChallenge
    * 
    */
    public PrimeChallenge()
    {
        player = new Player();
        numberGenerator = new NumberGenerator();
        level = '0';
        guessNumber = 0;
        isHardMode = false;
        giveUp = 0;
    }

    /**
    * Non-Default constructor which creates the object of the class PrimeChallenge
    * 
    * @param player            An object variable of class Play.
    * @param numberGenerator   An object variable of class NumberGenerator.
    * @param level             Accept the level chose by player as a character.
    * @param guessNumber       Accept the fixed level random number as an integer.
    * @param isHardMode        Accept the upgraded mode as a boolean.
    * @param giveUp            Accept the give up time(s) as an integer.
    */
    public PrimeChallenge(Player currPlayer, NumberGenerator currNumberGenerator, char currLevel, int currGuessNumber, boolean currIsHardMode, int currGiveUp)
    {
        player = currPlayer;
        numberGenerator = currNumberGenerator;
        level = currLevel;
        guessNumber = currGuessNumber;
        isHardMode = currIsHardMode;
        giveUp = currGiveUp;
    }

    /**
    * This is a method to get the correct answer for a number classification
    * 
    * @return      The correct answee for a number classification as a character.
    */
    public char decidePrime()
    {
        char correctAnswer = 'Y';
        
        if (guessNumber == 1)
            correctAnswer = 'N';

        for(int j = 2; j < guessNumber; j++)
        {
            if(guessNumber % j == 0)
                correctAnswer = 'N';
        }

        return correctAnswer;
    }

    /**
    * Accessor method to get the give up time(s)
    * 
    * @return       The give up time(s) as an integer.
    */
    public int getGiveUp()
    {
        return giveUp;
    }

    /**
    * Accessor method to get the fixed level random number
    * 
    * @return       The fixed level random number as an integer.
    */
    public int getGuessNumber()
    {
        return guessNumber;
    }

    /**
    * Accessor method to get the upgraded mode
    * 
    * @return       The upgraded mode as a boolean.
    */
    public boolean getIsHardMode()
    {
        return isHardMode;
    }

    /**
    * Accessor method to get the level chose by player
    * 
    * @return       The level chose by player as a character.
    */
    public char getLevel()
    {
        return level;
    }

    /**
    * Accessor method to get the player object
    * 
    * @return      The player as a object of class Play.
    */
    public Player getPlayer()
    {
        return player;
    }

    /**
    * Accessor method to get the numberGenerator object
    * 
    * @return       The numberGenerator as a object of class NumberGenerator.
    */
    public NumberGenerator getNumberGenerator()
    {
        return numberGenerator;
    }

    /**
    * This is a method to get the players choice of level
    * 
    */
    public void inputLevel()
    {
        System.out.println("==========================");
        System.out.println("Level 1 means random number will generate from 1-100.");
        System.out.println("Level 2 means random number will generate from 1-400.");
        
        do{
            System.out.println("What Level do you want to select? (1/2)");
            Scanner console = new Scanner(System.in);
            level = console.next().charAt(0);
            
            switch(level)
            {
                case '1':
                    break;
                case '2':
                    break;
                default:
                    level = '0';
                    System.out.println("Your input is invalid. Please try it again.");
                    break;
            }
        }while(level == '0');
    }

    /**
    * This is a method to validate the players name whether alphabetic
    * 
    * @param name   The players name as a string.
    * @return    The players name alphabetic validation as a boolean.
    */
    public boolean isAlphabetic(String name)
    {
        for(int i = 0; i < name.length(); i++)
        {
            if(!(Character.isLetter(name.charAt(i))))
                return false;
        }
        return true;
    }

    /**
    * This is a method to validate the players name length under 10 characters
    * 
    * @param name   The players name as a string.
    * @return      The players name length validation as a boolean. 
    */
    public boolean isStringLengthInRange(String name)
    {
        if(name.length() >= 1 && name.length() <=10)
            return true;
        else 
            return false;
    }

    /**
    * This is a method to generate a random number
    * 
    */
    public void levelNumberGenerator()
    {
        if(level == '1')
            guessNumber = numberGenerator.generateNumber(100);  
        else if(level == '2')
            guessNumber =numberGenerator.generateNumber(400);
    }

    /**
    * This is a method to validate the players name input
    * 
    */ 
    public void nameValidation()
    {
        Scanner console = new Scanner(System.in);
        String inputName = "";
        boolean flagNameLength = false;
        boolean flagNameAlph = false;
        boolean flagBoth = false;

        do
        {
            flagNameLength = false;
            flagNameAlph = false;
            flagBoth = false;

            System.out.println("==========================");
            System.out.println("1. Only alphabetic character(s)(upper and/or lower case) can be valid.");
            System.out.println("2. Please input no more than 10 characters in length.");
            System.out.println("What is your player name?");
            player.setName(console.nextLine());

            if(isStringLengthInRange(player.getName()) && isAlphabetic(player.getName()))
                flagBoth = false;
            else if(isStringLengthInRange(player.getName()) && !(isAlphabetic(player.getName())))
                flagNameAlph = true;
            else if(!(isStringLengthInRange(player.getName())) && isAlphabetic(player.getName()))
                flagNameLength = true;
            else 
                flagBoth = true;

            if(flagBoth)
                System.out.println("***Sorry. Your name has invalid character(s) and its length is invalid. Please try it again.");
            else if(flagNameAlph)
                System.out.println("***Sorry. Your name has invalid character(s). Please try it again.");
            else if(flagNameLength)
                System.out.println("***Sorry. Your name's length is invalid. Please try it again.");
        }while(flagNameAlph || flagNameLength || flagBoth);
    }

    /**
    * This is a method to get the players certain answer for a number classification
    * 
    * @return      The players certain answer for a number classification as a character.
    */
    public char promptInputs()
    {
        char answer;
        
        do{
            System.out.println("Do you think this random number is a prime?(Y/N/Q)");
            Scanner console = new Scanner(System.in);
            answer = console.next().charAt(0);
            
            switch(answer)
            {
                case equalIgnoreCase('Y'):
                    break;
                case 'N':
                    break;
                case 'Q':
                    break;
                default:
                    answer = '0';
                    System.out.println("Your input is invalid. Please try it again.");
                    break;
            }
        }while(answer == '0');
        
        return answer;
    }

    /**
    * This is a method to run the classification of a round of Prime Challenge with a loop
    * 
    */
    public void roundClassification()
    {
        player.setTotalCorrect(0);
        
        for (int c = 0; c < 10; c++)
        {
            levelNumberGenerator();
            selectMode();
            System.out.println("#" + (c + 1) + " random number is:" + guessNumber);
            char answer = promptInputs();
            char correctAnswer = decidePrime();
            
            if (answer == 'Q')
            {
                player.setTotalCorrect(0);
                giveUp++;
                System.out.println("Quit! This round is over."); 
                c = 10;

            }
            else if (answer == correctAnswer)
            {
                System.out.println("Congratulation! Correct.");
                player.setTotalCorrect(player.getTotalCorrect() + 1);
            }
            else
            {
                System.out.println("Sorry. Wrong. This round is over."); 
                c = 10;
            }
        }
    }
    
    /**
    * This is a method to get players willingness to play again
    * 
    * @return      A players willingness to play again as a boolean.
    */
    public char runningGameAgain()
    {
        char again;
        
        do{
            System.out.println("Do you want to play again?(Y/N)");
            Scanner console = new Scanner(System.in);
            again = console.next().charAt(0);
            switch(again)
            {
                case 'Y':
                    break;
                case 'N':
                    break;
                default:
                    again = '0';
                    System.out.println("Your input is invalid. Please try it again.");
                    break;
            }
        }while(again == '0');

        return again;
    } 

    /**
    * This is a method to run this Prime Challenge with a loop
    * 
    */
    public void runningGame()
    {
        nameValidation();
        char again = 'N';
        
        do
        {
            inputLevel();
            runningRound();
            again = runningGameAgain();
        }while(again == 'Y');
    }

    /**
    * This is a method to run a round of Prime Challenge with a loop
    * 
    */
    public void runningRound()
    {
        int wholeCorrect = 0;
        for (int r = 0; r < 3; r++)
        {
            System.out.println("====================");
            System.out.println("Welcome to Round " + (r+1) + ".");
            System.out.println("***During this round, if you want to give up and quit, please input Q.***");
            System.out.println("Level " + level);
            
            if ((r != 0) && (player.getTotalCorrect() == 10))
                isHardMode = true;
            
            if (isHardMode == true)
                System.out.println("Hard Mode");
            else
                System.out.println("Easy Mode");
            
            roundClassification();
            int roundScore = player.getTotalCorrect();
            wholeCorrect += roundScore;
            
            if (player.getTotalCorrect() == 10)
                roundScore = player.getTotalCorrect() + 2;
            
            if (isHardMode)
                roundScore = roundScore * 2;
            
            System.out.println("This round's cumulative correct score is:" + roundScore);
            player.setScore(player.getScore() + roundScore);
        }
        System.out.println("Your average score is： " );
        System.out.printf("%.2f%n",(player.getScore() / (3 - giveUp)));
        System.out.println("Your total correct is： " + wholeCorrect);
    }

    /**
    * This is a method to select a hard mode random number with a loop
    * 
    */
    public void selectMode()
    {
        if (isHardMode)
        {   
            boolean changeToHard = false;
            
            do{ 
                if((guessNumber%2 == 0) ||(guessNumber%5 == 0))
                {
                    changeToHard = true; 
                    levelNumberGenerator();
                }
                else
                changeToHard = false;    
            }while(changeToHard);
        }
    }

    /**
    * Mutator method to set the give up time(s)
    * 
    * @param giveUp   The give up time(s) as an integer.
    */
    public void setGiveUp(int myGiveUp)
    {
        giveUp = myGiveUp;
    }

    /**
    * Mutator method to set the fixed level random number
    * 
    *  @param guessNumber  The fixed level random number as an integer.
    */
    public void setGuessNumber(int myGuessNumber)
    {
        guessNumber = myGuessNumber;
    }

    /**
    * Mutator method to set the upgraded mode
    *
    * @param isHardMode  The upgraded mode as a boolean.
    */
    public void setIsHardMode(boolean myIsHardMode)
    {
        isHardMode = myIsHardMode;
    }

    /**
    * Mutator method to set the level chose by player
    * 
    * @param level   The level chose by player as a character.
    */
    public void setLevel(char myLevel)
    {
        level = myLevel;
    }

    /**
    * Mutator method to set the numberGenerator object
    * 
    * @param numberGenerator   An object variable of class NumberGenerator.
    */
    public void setNumberGenerator(NumberGenerator myNumberGenerator)
    {
        numberGenerator = myNumberGenerator;
    }

    /**
    * Mutator method to set the player object
    * 
    * @param player   An object variable of class Play.
    */
    public void setPlayer(Player myPlayer)
    {
        player = myPlayer;
    }

    /**
    * This is a method to being the program
    * 
    * @param args       An array of Strings representing command line arguments.
    */
    public static void main(String[] args)
    {
        PrimeChallenge pri = new PrimeChallenge();
        pri.runningGame();
    }
}
