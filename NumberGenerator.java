import java.lang.Math;

/**
 * This class demonstrates a random number generator 
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class NumberGenerator
{
    private int randomNumber;
    
    /**
    * Default constructor which creates the object of the class NumberGenerator
    * 
    */
    public NumberGenerator()
    {
        randomNumber = 0;
    }

    /**
    * Non-Default constructor which creates the object of the class NumberGenerator
    * 
    * @param randomNumber   Accept the random number as an integer.
    */
    public NumberGenerator(int newRandomNumber)
    {
        randomNumber = newRandomNumber;
    }

    /**
    * Accessor method to get the randomNumber object
    * 
    * @return       The random number as an integer.
    */
    public int getRandomNumber()
    {
        return randomNumber;
    }

    /**
    * Mutator method to set the randomNumber object
    * 
    *  @param myRandomNumber        The random number as an integer.
    */
    public void setRandomNumber(int myRandomNumber)
    {
        randomNumber = myRandomNumber;
    }

    /**
    * Generate a random number under a max value and above a min value
    * 
    *  @return        The random number as an integer.
    */
    public int generateNumber(int min, int max)//generate a number from min to max
    {
        int randomNumber = (int)(Math.random() * (max - min) + 1) + min;
        return randomNumber; 
    }

}//end of class
