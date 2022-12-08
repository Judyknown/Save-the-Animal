/**
 * This class stores the information of a Predator
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Predator
{
    private String predatorNo;
    private int locationNo;
    private boolean alive;
    private int healthStatus;

    /**
    * Default constructor which creates the object of the class Predator
    * 
    */
    public Predator()
    {
        predatorNo = "Unknown";
        locationNo = 0;
        alive = false;
        healthStatus = 3;
    }

    /**
    * Non-Default constructor which creates the object of the class Predator
    * 
    * @param newPredatorNo           Accept the predator's code as a string.
    * @param newLocationNo        Accept the location number as an integer.
    * @param newAlive             Accept the predator's alive status as a boolean.
    * @param newHealthStatus      Accept the predator's healthStatus as an integer.
    */
    public Predator(String newPredatorNo, int newLocationNo, boolean newAlive, int newHealthStatus)
    {
        predatorNo = newPredatorNo;
        locationNo = newLocationNo;
        alive = newAlive;
        healthStatus = newHealthStatus;
    }
    
    /**
    * Display method to show the attributes of the Cat
    * 
    */
    public void displayC()
    {
        System.out.println("CatNo: " + predatorNo);
        System.out.println("Cat's location: " + locationNo);
        System.out.println("Cat is alive: " + alive);
        System.out.println("Cat's health status: " + healthStatus);
    } 

    /**
    * Display method to show the attributes of the Fox
    * 
    */
    public void displayF()
    {
        System.out.println("FoxNo: " + predatorNo);
        System.out.println("Fox's location: " + locationNo);
        System.out.println("Fox is alive: " + alive);
        System.out.println("Fox's health status: " + healthStatus);
    } 

    /**
    * Accessor method to get the predator's alive status
    * 
    * @return       The predator's alive status as a boolean.
    */
    public boolean getAlive()
    {
        return alive;
    }

    /**
    * Accessor method to get the predator's health status
    * 
    * @return       The predator's health status as an integer.
    */
    public int getHealthStatus()
    {
        return healthStatus;
    }

    /**
    * Accessor method to get the predator's location number
    * 
    * @return       The predator's location number as an integer.
    */
    public int getLocationNo()
    {
        return locationNo;
    }

    /**
    * Accessor method to get the predator's code
    * 
    * @return       The predator's code as a string.
    */
    public String getPredatorNo()
    {
        return predatorNo;
    }

    /**
    * Mutator method to set the predator's alive status
    * 
    * @param myAlive   The predator's alive status as a boolean.
    */
    public void setAlive(boolean myAlive)
    {
        alive = myAlive;
    }    

    /**
    * Mutator method to set the predator's health status
    * 
    * @param myHealthStatus   The predator's health status as an integer.
    */
    public void setHealthStatus(int myHealthStatus)
    {
        healthStatus = myHealthStatus;
    }

    /**
    * Mutator method to set the predator's location number
    * 
    * @param myLocationNo   The predator's location number as an integer.
    */
    public void setLocationNo(int myLocationNo)
    {
        locationNo = myLocationNo;
    }

    /**
    * Mutator method to set the predator's code
    * 
    * @param myPredatorNo   The predator's code as a string.
    */
    public void setPredatorNo(String myPredatorNo)
    {
        predatorNo = myPredatorNo;
    }
}
