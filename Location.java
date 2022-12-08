import java.util.ArrayList;

/**
 * This class stores the information of a location
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Location
{
    private int locationNo;
    private ArrayList<Bilby> bilbies;
    private ArrayList<Predator> foxes;
    private ArrayList<Predator> cats;
    private boolean hunted;
    private Population population;

    /**
    * Default constructor which creates the object of the class Location
    * 
    */
    public Location()
    {
        locationNo = 0;
        bilbies = new ArrayList<Bilby>();
        foxes = new ArrayList<Predator>();
        cats = new ArrayList<Predator>();
        hunted = false;
        population = new Population();
    }

    /**
    * Non-Default constructor which creates the object of the class Population
    * 
    * @param newLocationNo   Accept the location number as an integer.
    * @param currBilbies   Accept the bilbies collections as an arraylist.
    * @param currFoxes   Accept the bilbies collections as an arraylist.
    * @param currCats   Accept the bilbies collections as an arraylist.
    * @param currHunted   Accept the hunted state as a boolean.
    * @param currPopulation   An object variable of class Population.
    */
    public Location(int newLocationNo, ArrayList<Bilby> currBilbies, ArrayList<Predator> currFoxes, ArrayList<Predator>currCats, boolean currHunted, Population currPopulation)
    {
        locationNo = newLocationNo;
        bilbies = currBilbies;
        foxes = currFoxes;
        cats = currCats;
        hunted = currHunted;
        population = currPopulation;
    }

    /**
    * This is a method to add new object to arraylist bilbies
    * 
    * @param   newBilby   The new object of arraylist bilbies.
    */
    public void addBilby(Bilby newBilby)
    {
        bilbies.add(newBilby);
    }

    /**
    * This is a method to add new object to arraylist foxes
    * 
    * @param   newFox   The new object of arraylist bilbies.
    */
    public void addFox(Predator newFox)
    {
        foxes.add(newFox);
    }

    /**
    * This is a method to add new object to arraylist cats
    * 
    * @param   newCat   The new object of arraylist bilbies.
    */
    public void addCat(Predator newCat)
    {
        cats.add(newCat);
    }

    /**
    * Display method to show the whole state of the object
    * 
    */
    public void display()
    {
        System.out.println("\n***locationNo: " + locationNo + "***");
        System.out.println("\n@List of bilbies: ");
        for(Bilby element: bilbies)
            element.display();
        System.out.println("\n@List of foxes: ");
        for(Predator element: foxes)
            element.displayF();
        if (foxes.size() <= 0)
            System.out.println("This location has no fox.");
        System.out.println("\n@List of cats: ");
        for(Predator element: cats)
            element.displayC();
        if (cats.size() <= 0)
            System.out.println("This location has no cat.");
        System.out.println("***Have hunted?: " + hunted + "***\n");
        population.display();
    }

    /**
    * This is a method to get the bilbies collection
    * 
    * @return      The bilbies arraylist of the Location.
    */
    public ArrayList<Bilby> getBilbies()
    {
        return bilbies;
    }

    /**
    * This is a method to get the size of bilbies collection
    * 
    * @return      The size of the bilby arraylist of the Location.
    */
    public int getBilbySize()
    {
        return bilbies.size();
    }

    /**
    * This is a method to get the cats collection
    * 
    * @return      The cats arraylist of the Location.
    */
    public ArrayList<Predator> getCats()
    {
        return cats;
    }

    /**
    * This is a method to get the size of cats collection
    * 
    * @return      The size of the cats arraylist of the Location.
    */
    public int getCatSize()
    {
        return cats.size();
    }

    /**
    * This is a method to get the foxes collection
    * 
    * @return      The foxes arraylist of the Location.
    */
    public ArrayList<Predator> getFoxes()
    {
        return foxes;
    }

    /**
    * This is a method to get the size of foxes collection
    * 
    * @return      The size of the foxes arraylist of the Location.
    */
    public int getFoxSize()
    {
        return foxes.size();
    }

    /**
    * This is a method to get the hunted state of the Location
    * 
    * @return      The hunted state of the Location.
    */
    public boolean getHunted()
    {
        return hunted;
    }

    /**
    * This is a method to get the location number of the Location
    * 
    * @return      The location number of the Location.
    */
    public int getLocationNo()
    {
        return locationNo;
    }

    /**
    * This is a method to get the object variable of the class Population
    * 
    * @return      The object variable of the class Population.
    */
    public Population getPopulation()
    {
        return population;
    }

    /**
    * This is a method to get the specific element of the arraylist bilbies
    * 
    * @param   index  The index of the specific element
    * @return      The specific element of the arraylist bilbies.
    */
    public Bilby getSpecificBilby(int index)
    {
        return bilbies.get(index);
    }
    
    /**
    * This is a method to get the specific element of the arraylist cats
    * 
    * @param   index  The index of the specific element
    * @return      The specific element of the arraylist cats.
    */
    public Predator getSpecificCat(int index)
    {
        return cats.get(index);
    }

    /**
    * This is a method to get the specific element of the arraylist foxes
    * 
    * @param   index  The index of the specific element
    * @return      The specific element of the arraylist foxes.
    */
    public Predator getSpecificFox(int index)
    {
        return foxes.get(index);
    }
    
    /**
    * This is a method to get check if any bilby is alive in bilbies
    * 
    * @return      The alive state of the arraylist bilbies as boolean.
    */
    //
    public boolean isBilbiesAlive()
    {
        boolean flag = false;
        for(Bilby temp : bilbies)
        {
            if(temp.getAlive())
                flag = true;
        }

        return flag;
    }

    /**
    * This is a method to remove the specific element of the arraylist bilbies
    * 
    * @param   index  The index of the specific element.
    */
    public void removeSpecificBilby(int index)
    {
        bilbies.remove(index);
    }

    /**
    * This is a method to remove the specific element of the arraylist cats
    * 
    * @param   index  The index of the specific element.
    */
    public void removeSpecificCat(int index)
    {
        cats.remove(index);
    }

    /**
    * This is a method to remove the specific element of the arraylist foxes
    * 
    * @param   index  The index of the specific element.
    */
    public void removeSpecificFox(int index)
    {
        foxes.remove(index);
    }

    /**
    * Mutator method to set the collections of bilbies
    *
    * @param bilbiesList  The bilbies collection as an arraylist.
    */
    public void setBilbies(ArrayList<Bilby> bilbiesList)
    {
        bilbies = bilbiesList;
    }

    /**
    * Mutator method to set the collections of cats
    *
    * @param catsList  The cats collection as an arraylist.
    */
    public void setCats(ArrayList<Predator> catsList)
    {
        cats = catsList;
    }

    /**
    * Mutator method to set the collections of foxes
    *
    * @param foxesList  The foxes collection as an arraylist.
    */
    public void setFoxes(ArrayList<Predator> foxesList)
    {
        foxes = foxesList;
    }

    /**
    * Mutator method to set the hunted state of the location
    *
    * @param myHunted  The hunted state of the location as a boolean.
    */
    public void setHunted(boolean myHunted)
    {
        hunted = myHunted;
    }

    /**
    * Mutator method to set the location number of the location
    *
    * @param myLocationNo  The location number of the location as an integer.
    */
    public void setLocationNo(int myLocationNo)
    {
        locationNo = myLocationNo;
    }

    /**
    * Mutator method to set the object of the class Population
    *
    * @param myLocationNo  The object of the class Population.
    */
    public void setPopulation(Population myPopulation)
    {
        population = myPopulation;
    }

    /**
    * Mutator method to set the specific element of the arraylist bilbies
    *
    * @param index  The index of the specific element.
    * @param bilby  The specific element of the arraylist bilbies.
    */
    public void setSpecificBilby(int index, Bilby bilby)
    {
        bilbies.set(index, bilby);
    }

    /**
    * Mutator method to set the specific element of the arraylist bilbies
    *
    * @param index  The index of the specific element.
    * @param cat  The specific element of the arraylist cats.
    */
    public void setSpecificCat(int index, Predator cat)
    {
        cats.set(index, cat);
    }

    /**
    * Mutator method to set the specific element of the arraylist foxes
    *
    * @param index  The index of the specific element.
    * @param fox  The specific element of the arraylist foxes.
    */
    public void setSpecificFox(int index, Predator fox)
    {
        foxes.set(index, fox);
    }

    /**
    * This is a method to modify the format of the numeric part of the animal's code
    *
    * @param count  The index of the specific element.
    * @return       The numeric part of the animal's code.
    */
    public String turnCode(int count)
    {
        String code = "Unknown";
        if (count < 10)
            code = "00" + count;
        else if(count < 100)
            code = "0" + count;
        else if(count < 1000)
            code = "" + count;
        else
            System.out.println("Your Animal Code need to be extended. Please check it.");

        return code;   
    }
}
