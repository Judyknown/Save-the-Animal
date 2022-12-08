import java.util.Scanner;

/**
 * This class stores the information of the player who will play the prime challenge game
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Player
{
    private String name;
    private int totalCorrect;
    private double score;

    /**
    * Default constructor which creates the object of the class Player
    * 
    */
    public Player()
    {
        name = "Unknown";
        totalCorrect = 0;
        score = 00.00;
    }

    /**
    * Non-Default constructor which creates the object of the class Player
    * 
    * @param name              Accept the players name as a string.
    * @param totalCorrect      Accept the round correct time(s) as an integer.
    * @param score             Accept the total score as a double.
    */
    public Player(String plaName, int plaTotalCorrect, double plaScore)
    {
        name = plaName;
        totalCorrect = plaTotalCorrect;
        score = plaScore;
    }

    /**
    * Accessor method to get the players name
    * 
    * @return       The players name as an String.
    */
    public String getName()
    {
        return name;
    }

    /**
    * Accessor method to get the round correct time(s)
    * 
    * @return       The round correct time(s) as an integer.
    */
    public int getTotalCorrect()
    {
        return totalCorrect;
    }

    /**
    * Accessor method to get the total score
    * 
    * @return       The total score as a double.
    */
    public double getScore()
    {
        return score;
    }

    /**
    * Mutator method to set the players name
    * 
    * @param name      The players name as a string.
    */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
    * Mutator method to set the round correct time(s)
    * 
    * @param totalCorrect      The round correct time(s) as an integer.
    */
    public void setTotalCorrect(int newTotalCorrect)
    {
        totalCorrect = newTotalCorrect;
    }

    /**
    * Mutator method to set the total score
    * 
    * @param score             The total score as a double.
    */
    public void setScore(double newScore)
    {
        score = newScore;
    }

}//end of class
