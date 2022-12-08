import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class stores the information of a population
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Population
{
    private int aliveBilby;
    private int aliveFox;
    private int aliveCat;
    private int bornBilby;
    private int bornFox;
    private int bornCat;
    private int deadBilby;
    private int deadFox;
    private int deadCat;

    /**
    * Default constructor which creates the object of the class Population
    * 
    */
    public Population()
    {
        aliveBilby = 0;
        aliveFox = 0;
        aliveCat = 0;
        bornBilby = 0;
        bornFox = 0;
        bornCat = 0;
        deadBilby = 0;
        deadFox = 0;
        deadCat = 0;
    }

    /**
    * Non-Default constructor which creates the object of the class Population
    * 
    * @param currAliveBilby   Accept the alive bilby number as an integer.
    * @param currAliveFox   Accept the alive fox as an integer.
    * @param currAliveCat   Accept the alive cat as an integer.
    * @param currBornBilby   Accept the born fox as an integer.
    * @param currBornFox   Accept the born bilby as an integer.
    * @param currBornCat   Accept the born cat as an integer.
    * @param currDeadBilby   Accept the dead bilby as an integer.
    * @param currDeadFox   Accept the dead fox as an integer.
    * @param currDeadCat   Accept the dead cat as an integer.
    */
    public Population(int currAliveBilby, int currAliveFox, int currAliveCat, int currBornBilby, int currBornFox, int currBornCat, int currDeadBilby, int currDeadFox, int currDeadCat)
    {
        aliveBilby = currAliveBilby;
        aliveFox = currAliveFox;
        aliveCat = currAliveCat;
        bornBilby = currBornBilby;
        bornFox = currBornFox;
        bornCat = currBornCat;
        deadBilby = currDeadBilby;
        deadFox = currDeadFox;
        deadCat = currDeadCat;
        
    }

    /**
    * Display method to show the whole state of the object
    * 
    */
    public void display()
    {
        System.out.println("Alive Bilby Number: " + aliveBilby);
        System.out.println("Alive Fox Number: " + aliveFox);
        System.out.println("Alive Cat Number: " + aliveCat);
        System.out.println("Born Bilby Number: " + bornBilby);
        System.out.println("Born Fox Number: " + bornFox);
        System.out.println("Born Cat Number: " + bornCat);
        System.out.println("Dead Bilby Number: " + deadBilby);
        System.out.println("Dead Fox Number: " + deadFox);
        System.out.println("Dead Cat Number: " + deadCat);
    }

    /**
    * Display method to show the alive state of the object
    * 
    */
    public void displayAlive()
    {
        System.out.println("Alive Bilby Number: " + aliveBilby);
        System.out.println("Alive Fox Number: " + aliveFox);
        System.out.println("Alive Cat Number: " + aliveCat);
    }

    /**
    * Display method to show the alive state of the bibies
    * 
    */
    public void displayAliveBilby()
    {
        System.out.println("Alive Bilby Number: " + aliveBilby);
    }

    /**
    * Display method to show the born state of the object
    * 
    */
    public void displayBorn()
    {
        System.out.println("Born Bilby Number: " + bornBilby);
        System.out.println("Born Fox Number: " + bornFox);
        System.out.println("Born Cat Number: " + bornCat);
    }

    /**
    * Display method to show the alive and dead state of the object
    * 
    */
    public void displayDA()
    {
        System.out.println("Alive Bilby Number: " + aliveBilby);
        System.out.println("Alive Fox Number: " + aliveFox);
        System.out.println("Alive Cat Number: " + aliveCat);
        System.out.println("Dead Bilby Number: " + deadBilby);
        System.out.println("Dead Fox Number: " + deadFox);
        System.out.println("Dead Cat Number: " + deadCat);      
    }

    /**
     * Accessor method to get the alive bilby number.
     *
     * @return   The alive bilby number as an integer.
     */
    public int getAliveBilby()
    {
        return aliveBilby;
    }
    
    /**
     * Accessor method to get the alive cat number.
     *
     * @return   The cat bilby number as an integer.
     */
    public int getAliveCat()
    {
        return aliveCat;
    }

    /**
     * Accessor method to get the alive fox number.
     *
     * @return   The alive fox number as an integer.
     */
    public int getAliveFox()
    {
        return aliveFox;
    }

    /**
     * Accessor method to get the born bilby number.
     *
     * @return   The born bilby number as an integer.
     */
    public int getBornBilby()
    {
        return bornBilby;
    }

    /**
     * Accessor method to get the born cat number.
     *
     * @return   The born cat number as an integer.
     */
    public int getBornCat()
    {
        return bornCat;
    }

    /**
     * Accessor method to get the born fox number.
     *
     * @return   The born fox number as an integer.
     */
    public int getBornFox()
    {
        return bornFox;
    }

    /**
     * Accessor method to get the dead bilby number.
     *
     * @return   The dead bilby number as an integer.
     */
    public int getDeadBilby()
    {
        return deadBilby;
    }

    /**
     * Accessor method to get the dead cat number.
     *
     * @return   The dead cat number as an integer.
     */
    public int getDeadCat()
    {
        return deadCat;
    }

    /**
     * Accessor method to get the dead fox number.
     *
     * @return   The dead fox number as an integer.
     */
    public int getDeadFox()
    {
        return deadFox;
    }

    /**
    * Mutator method to set the alive bilby number.
    * 
    * @param newAliveBilby   An object variable of class Population.
    */
    public void setAliveBilby(int newAliveBilby)
    {
        aliveBilby = newAliveBilby;
    }

    /**
    * Mutator method to set the alive cat number.
    * 
    * @param newAliveCat   An object variable of class Population.
    */
    public void setAliveCat(int newAliveCat)
    {
        aliveCat = newAliveCat;
    }

    /**
    * Mutator method to set the alive fox number.
    * 
    * @param newAliveFox   An object variable of class Population.
    */
    public void setAliveFox(int newAliveFox)
    {
        aliveFox = newAliveFox;
    }

    /**
    * Mutator method to set the born bilby number.
    * 
    * @param newBornBilby   An object variable of class Population.
    */
    public void setBornBilby(int newBornBilby)
    {
        bornBilby = newBornBilby;
    }

    /**
    * Mutator method to set the born cat number.
    * 
    * @param newBornCat   An object variable of class Population.
    */
    public void setBornCat(int newBornCat)
    {
        bornCat = newBornCat;
    }

    /**
    * Mutator method to set the born bilby number.
    * 
    * @param newBornFox   An object variable of class Population.
    */
    public void setBornFox(int newBornFox)
    {
        bornFox = newBornFox;
    }

    /**
    * Mutator method to set the dead bilby number.
    * 
    * @param newDeadBilby   An object variable of class Population.
    */
    public void setDeadBilby(int newDeadBilby)
    {
        deadBilby = newDeadBilby;
    }

    /**
    * Mutator method to set the dead cat number.
    * 
    * @param newDeadCat   An object variable of class Population.
    */
    public void setDeadCat(int newDeadCat)
    {
        deadCat = newDeadCat;
    }

    /**
    * Mutator method to set the dead fox number.
    * 
    * @param newDeadFox   An object variable of class Population.
    */
    public void setDeadFox(int newDeadFox)
    {
        deadFox = newDeadFox;
    }
}
//end of class
