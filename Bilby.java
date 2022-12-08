/**
 * This class stores the information of one Bilby
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Bilby
{
    private String bilbyNo;
    private int locationNo;
    private boolean alive;
    
    /**
    * Default constructor which creates the object of the class Bilby
    * 
    */
    public Bilby()
    {
        bilbyNo = "B000";
        locationNo = 0;
        alive = false;
    }

    /**
    * Non-Default constructor which creates the object of the class Bilby
    * 
    * @param newBilbyNo              Accept the bilby's code as a string.
    * @param newLocationNo      Accept the location number as an integer.
    * @param newAlive             Accept the bilby's alive status as a boolean.
    */
    public Bilby(String newBilbyNo, int newLocationNo, boolean newAlive)
    {
        if(newBilbyNo == null || newBilbyNo.trim().isEmpty())
            throw new IllegalArgumentException("Bibly code cannot be null or empty");
        if(newLocationNo > 11)
            throw new IllegalArgumentException("Bibly location number cannot be more than 10");
        if(newLocationNo < 0)
            throw new IllegalArgumentException("Bibly location number cannot be less than 0");
        bilbyNo = newBilbyNo;
        locationNo = newLocationNo;
        alive = newAlive;
    }

    /**
    * Display method to show the attributes of the bilby
    * 
    */
    public void display()
    {
        System.out.println("BilbyNo: " + bilbyNo);
        System.out.println("Bilby's location: " + locationNo);
        System.out.println("Bilby is alive: " + alive);
    }

    /**
    * Accessor method to get the bilby's alive status
    * 
    * @return       The bilby's alive status as a boolean.
    */
    public boolean getAlive()
    {
        return alive;
    }

    /**
    * Accessor method to get the bilby's code 
    * 
    * @return       The bilby's code as a string.
    */
    public String getBilbyNo()
    {
        return bilbyNo;
    }

    /**
    * Accessor method to get the location number 
    * 
    * @return       The location number as an integer.
    */
    public int getLocationNo()
    {
        return locationNo;
    }

    /**
    * Mutator method to set the bilby's alive status
    * 
    * @param myAlive   The bilby's alive status as a boolean.
    */
    public void setAlive(boolean myAlive)
    {
        alive = myAlive;
    }

    /**
    * Mutator method to set the bilby's code as a string
    * 
    * @param myBilbyNo   The bilby's code as a string.
    */
    public void setBilbyNo(String myBilbyNo)
    {
        if(myBilbyNo == null || myBilbyNo.trim().isEmpty())
            throw new IllegalArgumentException("Bibly code cannot be null or empty");
        bilbyNo = myBilbyNo;
    }

    /**
    * Mutator method to set the location number as an integer.
    * 
    * @param myLocationNo   The location number as an integer.
    */
    public void setLocationNo(int myLocationNo)
    {
        if(myLocationNo > 10)
            throw new IllegalArgumentException("Bibly location number cannot be more than 10");
        if(myLocationNo < 0)
            throw new IllegalArgumentException("Bibly location number cannot be less than 0");
        locationNo = myLocationNo;
    }

    /**
    * This is a method to test Bilby's Test Strategy.
    * 
    */
    /**public void test()
    {
        //System.out.println("Create a Bilby objest with the default constructor");
        //Bilby bil1 = new Bilby();
        //bil1.display();

        //System.out.println("Create a Bilby objest with the non-default constructor with valid field values");
        //Bilby bil2 = new Bilby("B001", 2, true);
        //bil2.display();

        //System.out.println("Create a Bilby objest with the non-default constructor with invalid field values");
        //Bilby bil3 = new Bilby("", 10, true);
        //bil3.display();

        //System.out.println("Create a Bilby objest with the non-default constructor with invalid field values");
        //Bilby bil4 = new Bilby("C001", -1, true);
        //bil4.display();

        //System.out.println("Test getAlive() with the default value");
        //Bilby bil5 = new Bilby();
        //System.out.println("getAlive(): " + bil5.getAlive());    

        //System.out.println("Test getBilbyNo() with the default value");
        //Bilby bil6 = new Bilby();
        //System.out.println("getBilbyNo(): " + bil5.getBilbyNo());

        //System.out.println("Test getLocationNo() with the default value");
        //Bilby bil7 = new Bilby();
        //System.out.println("getLocationNo(): " + bil7.getLocationNo());

        //System.out.println("Test setAlive() with valid field values");
        //Bilby bil8 = new Bilby();
        //bil8.setAlive(true);
        //System.out.println("setAlive(): " + bil8.getAlive());

        //System.out.println("Test setAlive() with invalid field values");
        //Bilby bil9 = new Bilby();
        //bil9.setAlive("abc");
        //System.out.println("setAlive(): " + bil9.getAlive());

        //System.out.println("Test setBilbyNo() with valid field values");
        //Bilby bil10 = new Bilby();
        //bil10.setBilbyNo("B008");
        //System.out.println("setBilbyNo(): " + bil10.getBilbyNo());

        //System.out.println("Test setBilbyNo() with invalid field values");
        //Bilby bil11 = new Bilby();
        //bil11.setBilbyNo("");
        //System.out.println("setBilbyNo(): " + bil11.getBilbyNo());

        //System.out.println("Test setLocationNo() with the valid field values");
        //Bilby bil12 = new Bilby();
        ///bil12.setLocationNo(2);
        //System.out.println("setLocationNo(): " + bil12.getLocationNo());

        //System.out.println("Test setLocationNo() with invalid field values");
        //Bilby bil13 = new Bilby();
        //bil13.setLocationNo(12);
        //System.out.println("setLocationNo(): " + bil13.getLocationNo());
    }*/
}
