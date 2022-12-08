import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class demonstrates a bilby survival simulation
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class SaveTheBilby
{
    private String areaName;
    private NumberGenerator numberGenerator;
    private File file; 
    private int[] animalCode;
    private ArrayList<Location> locationList;
    private Validation validation;
    
    /**
    * Default constructor which creates the object of the class SaveTheBilby
    * 
    */
    public SaveTheBilby()
    {
        areaName = "Unknown";
        numberGenerator = new NumberGenerator();
        file = new File(); 
        animalCode = new int[3];
        locationList = new ArrayList<Location>();
        validation = new Validation();
    }

    /**
    * Non-Default constructor which creates the object of the class PrimeChallenge
    * 
    * @param currAreaName            Accept the area name as a string.
    * @param currNumGenerator        An object variable of class NumberGenerator.
    * @param currFile                An object variable of class File.
    * @param currAniCode             Accept the animals unique numbers as an array.
    * @param currLocationList        Accept the location objects as an arraylist.
    * @param currValidation          An object variable of class Validation.
    *
    */
    public SaveTheBilby(String currAreaName, NumberGenerator currNumGenerator, File currFile, int[] currAniCode, ArrayList<Location> currLocationList, Validation currValidation)
    {
        areaName = currAreaName;
        numberGenerator = currNumGenerator;
        file = currFile; 
        animalCode = currAniCode;
        locationList = currLocationList;
        validation = currValidation;
    }

    /**
    * This is a method to assign animal number
    * 
    */
    public void assignAnimalNum()
    {
        validation.isSpecialChar("\n ✎ Enter S to start initializing number of animals.", "S");
        System.out.println("\nInitial animals' population of 10 locations... ...");
        System.out.println("\n----Alive Population in 10 locations----");
        for (int i = 0; i < 11; i++)
        {
            Location locations = new Location(i + 1, new ArrayList<Bilby>(),  new ArrayList<Predator>(),  new ArrayList<Predator>(), false, new Population());
            Population population = locations.getPopulation();

            for(int j = 0; j < file.readFile().get(i * 3); j++)
            {
                locations.addBilby(new Bilby('B' + turnCode(++animalCode[0]), i + 1, true));
            }
            population.setAliveBilby(locations.getBilbies().size());
            
            for(int j = 0; j < file.readFile().get(i * 3 + 1); j++)
            {
                locations.addFox(new Predator('F' + turnCode(++animalCode[1]), i + 1, true, 3));
            }
            population.setAliveFox(locations.getFoxes().size());

            for(int j = 0; j < file.readFile().get(i * 3 + 2); j++)
            {
                locations.addCat(new Predator('C' + turnCode(++animalCode[2]), i + 1, true, 3));
            }
            population.setAliveCat(locations.getCats().size());
            locationList.add(locations);
            System.out.println("----------------------------------------");
            displayAlivePopulation(i);
        }
    }

    /**
    * This is method to born Bilby
    * @param   n            Accept possibilty of a specifix rate
    * @param   list         Accept arraylist of bilbies
    * @param   t            Accept first char of animal code 
    * @param   population   Accept population of class Population
    * @param   i            Accept location number as an integer
    *
    */
    public void bornB(int n, ArrayList<Bilby> list, char t, Population population, int i)
    {
        int max = list.size();
        for (int j = 0; j < max; j++)
        {
            if(list.get(j).getAlive())
            {
                if(generateRate(n))
                {
                    setSpecificAniCode(0,getSpecificAniCode(0) + 1);
                    list.add(new Bilby(t + turnCode(getSpecificAniCode(0)), i + 1, true));
                    population.setBornBilby(population.getBornBilby() + 1);
                    population.setAliveBilby(population.getAliveBilby() + 1);
                    System.out.println("#Location " + (i + 1) + " - Bilby " + locationList.get(i).getSpecificBilby(j).getBilbyNo() + " gave birth to Bilby B" + turnCode(getSpecificAniCode(0)) + ".");
                }
            }
            else
                continue;
        }
    }

    /**
    * This is method to born predator
    * @param   n            Accept possibilty of a specifix rate
    * @param   list         Accept arraylist of predator
    * @param   t            Accept first char of animal code 
    * @param   population   Accept population of class Population
    * @param   i            Accept location number as an integer
    *
    */
    public void bornP(int n, ArrayList<Predator> list, char t, Population population, int i, boolean isFox)
    {
        int max = list.size();
        for (int j = 0; j < max; j++)
        {
            if(list.get(j).getAlive())
            {
                if(generateRate(n))
                {
                    if( isFox == true)
                    {
                        setSpecificAniCode(1,getSpecificAniCode(1) + 1);
                        list.add(new Predator(t + turnCode(getSpecificAniCode(1)), i + 1, true, 3));
                        population.setBornFox(population.getBornFox() + 1);
                        population.setAliveFox(population.getAliveFox() + 1);
                        System.out.println("#Location " + (i + 1) + " - Fox " + locationList.get(i).getSpecificFox(j).getPredatorNo() + " gave birth to Fox F" + turnCode(getSpecificAniCode(1)) + ".");
                    }
                    else
                    {
                        setSpecificAniCode(2,getSpecificAniCode(2) + 1);
                        list.add(new Predator(t + turnCode(getSpecificAniCode(2)), i + 1, true, 3));
                        population.setBornCat(population.getBornCat() + 1);
                        population.setAliveCat(population.getAliveCat() + 1);
                        System.out.println("#Location " + (i + 1) + " - Cat " + locationList.get(i).getSpecificCat(j).getPredatorNo() + " gave birth to Cat C" + turnCode(getSpecificAniCode(2)) + ".");
                    }
                }                
            }
            else
                continue;
        }
    }

    /**
    * This is method to born
    *
    */
    public void born()
    {
        validation.isSpecialChar("\n ✎ Enter B to go to the borned part.", "B");
        System.out.println("\n ■ Welcome to the borned part of SaveTheBilby ■");
        System.out.println("\n ⏩ Update borned part... ...");
        System.out.println("-----------------------");
        for (int i = 0; i < 11; i++)
        { 
            bornB(3, locationList.get(i).getBilbies(), 'B', locationList.get(i).getPopulation(), i);
            bornP(2, locationList.get(i).getFoxes(), 'F', locationList.get(i).getPopulation(), i, true);
            bornP(4, locationList.get(i).getCats(), 'C', locationList.get(i).getPopulation(), i, false);
        }
    }

    /**
    * This is method to display alive population
    * @param   i    Accept location number as an integer
    *
    */
    public void displayAlivePopulation(int i)
    {
        System.out.println("#Location " + (i + 1) + "'s alive population:");
        locationList.get(i).getPopulation().displayAlive();
    }

    /**
    * This is method to display alive bilbies population
    * @param   i    Accept location number as an integer
    *
    */
    public void displayAliveBilby(int i)
    {
        System.out.println("#Location " + (i + 1));
        locationList.get(i).getPopulation().displayAliveBilby();
    }

    /**
    * This is method to display population
    * @param   i    Accept location number as an integer
    *
    */
    public void displayPopulation(int i)
    {
        System.out.println("#Location " + (i + 1) + "'s population:");
        locationList.get(i).getPopulation().display();
    }

    /**
    * This is method to generate possibility rate
    * @param   valueOfRate    Accept rate as an integer
    * @return    a required result for some accident as a boolean
    *
    */
    public boolean generateRate(int valueOfRate)
    {
        if(numberGenerator.generateNumber(0, 20) <= valueOfRate)
            return true;

        return false;
    }  

    /**
    * Accessor method to get animalCode
    * 
    * @return     The animalCode as an array.
    *
    */
    public int[] getAnimalCode()
    {
        return animalCode;
    }

    /**
    * Accessor method to get area name
    * 
    * @return      The area name as a string.
    *
    */
    public String getAreaName()
    {
        return areaName;
    }

    /**
    * Accessor method to get the object of the class File
    * 
    * @return      the object of the class File.
    *
    */
    public File getFile()
    {
        return file;
    }

    /**
    * Accessor method to get locationList
    * 
    * @return   The collection of location  as an arraylist.
    *
    */
    public ArrayList<Location> getLocationList()
    {
        return locationList;
    }

    /**
    * Accessor method to get numberGenerator
    * 
    * @return   the object of the class NumberGenerator.
    *
    */
    public NumberGenerator getNumberGenerator()
    {
        return numberGenerator;
    }

    /**
    * Accessor method to get a specific animalCode
    * 
    * @param     index    The index of array animalCode 
    * @return   The animal code as an integer.
    *
    */
    public int getSpecificAniCode(int index)
    {
        if(index >= 0 && index < animalCode.length)
            return animalCode[index];
        else
            return 0;
    }

    /**
    * Accessor method to get the sum of some integers
    * 
    * @param    g   The value of one specific number for only one data
    * @return   The sum of all of datas as a double.
    *
    */
    public double getStatisticsNumber(int g, int l)
    {
        int t = 0;
        for(l = 0; l < 11; l++)
        {
            t += g;
        }

        return t;
    }

    /**
    * This method is to get the area name
    * 
    */
    public void inputAreaName()
    {
        System.out.println("\n****🐱🦊🐁****Welcome to SaveTheBilby Stimulator****🐁🦊🐱****");
        boolean isNameValidate = true;
        do
        {
            System.out.println(" \n ✎ Please enter the name as stimulated area.(1 - 16 characters)");
            Scanner console = new Scanner(System.in);
            areaName = console.nextLine();
            if(areaName.trim().length() > 16)
            {
                isNameValidate = false;
                System.out.println(" ✘ Sorry. Your enter's length is invalid. Please try it again.\n");
            }
            else if(areaName.trim().length() == 0)
            {
                isNameValidate = false;
                System.out.println(" ✘ Sorry. Don't leave your area name empty. Please try it again.\n");
            }
            else
                isNameValidate = true;
        }while(!isNameValidate);
        System.out.println("\n---🌱---Stimulated Area Name: " + areaName + "---🌱---");
    } 

    /**
    * This method is to get the code
    * @param count  The positive number generated one ny one as an integer
    * @return  the code in a required format as a string
    *
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

    /**
    * This method is let specific predator to eat the bilbies
    * @param  the code as a string
    *
    */
    public void eatP(ArrayList<Predator> list, int rate, Population population, boolean isFox, int l)
    {
        if(locationList.get(l).isBilbiesAlive())
        {
            int max = list.size();
            for (int j = 0; j < max; j++)
            {
                if(isFox)
                {
                    if(!locationList.get(l).getSpecificFox(j).getAlive())
                        continue;
                }
                else if (!locationList.get(l).getSpecificCat(j).getAlive())
                        continue;

                if(generateRate(rate))
                {
                    int randomNo = 0;
                    boolean flagR = true;
                    do
                    {
                        if(locationList.get(l).isBilbiesAlive())
                        {
                            randomNo = numberGenerator.generateNumber(- 1, locationList.get(l).getBilbySize() - 1);
                            if(locationList.get(l).getSpecificBilby(randomNo).getAlive())
                            {
                                flagR = false;
                                locationList.get(l).getSpecificBilby(randomNo).setAlive(false);
                                population.setDeadBilby(population.getDeadBilby() + 1);
                                population.setAliveBilby(population.getAliveBilby() - 1);
                                System.out.println("#Location " + (l + 1) + " - Bilby " + locationList.get(l).getSpecificBilby(randomNo).getBilbyNo() + " has been ate.");
                            }
                            else
                                flagR = true;
                        }
                        else 
                            flagR = false; 
                    }while(flagR);
                }
                else
                {
                    list.get(j).setHealthStatus(list.get(j).getHealthStatus() - 1);
                    if(list.get(j).getHealthStatus() == 0)
                    {
                        list.get(j).setAlive(false);
                        if(isFox)
                        {
                            population.setDeadFox(population.getDeadFox() + 1);
                            population.setAliveFox(population.getAliveFox() - 1);
                            System.out.println("Fox " + locationList.get(l).getSpecificFox(j).getPredatorNo() + " has starved to death.");
                        }
                        else
                        {
                            population.setDeadCat(population.getDeadCat() + 1);
                            population.setAliveCat(population.getAliveCat() - 1);
                            System.out.println("Cat " + locationList.get(l).getSpecificCat(j).getPredatorNo() + " has starved to death.");
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("This location does not have live bilbies.");
        }
    }

    /**
    * This method is to eat the bilbies
    *
    */
    public void eat()
    {
        validation.isSpecialChar("\n ✎ Enter E to go to the eating part.", "E");
        System.out.println("\n ■ Welcome to the eating part of SaveTheBilby ■");
        System.out.println("\n ⏩ Update eating part... ...");
        System.out.println("-----------------------");

        for (int i = 0; i < 11; i++)
        { 
            eatP(locationList.get(i).getFoxes(), 8, locationList.get(i).getPopulation(), true, i);
            eatP(locationList.get(i).getCats(), 12, locationList.get(i).getPopulation(), false, i);
        }
    }

    /**
    * This method is to write the file
    *
    */
    public void fileWriter()
    {
        int i = 0;
        file.creatFile("populationFinal.txt", locationList);
    } 

    /**
    * This method is to hunt the predator
    * @param  the code as a string
    *
    */
    public void hunt()
    {
        validation.isSpecialChar("\n ✎ Enter H to go to the hunting part.", "H");
        System.out.println("\n ■ Welcome to the hunting part of SaveTheBilby ■ ");
        System.out.println("-----------------------");
        for (int i = 0; i < 11; i++)
        { 
            huntP(i);
        }

        validation.isSpecialChar("\n ✎ Enter H to get alive population detail after hunting.", "H");
        System.out.println("\n ⏩ Update animals' population of 10 locations... ...");
        System.out.println("\n----Alive Population in 10 locations----"); 
        for (int h = 0; h < 11; h++)
        {
            System.out.println("-----------------------");
            displayAlivePopulation(h);
        }
    }

    /**
    * This method is to hunt a specific kind of predator
    * @param  i   The locationNo as an integer
    */
    public void huntP(int i)
    {
        if(!locationList.get(i).getHunted())
        {
            String choiceS = "Unknown";
            boolean flagH = true;
            do
            {
                System.out.println(" ✎ Do you want to conduct an intervention (hunt) in location# " + (i + 1) + "? (Y / N)");
                Scanner console = new Scanner(System.in);
                choiceS = console.nextLine();
                if(validation.isBlank(choiceS))
                {
                    System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                    flagH = true;
                }
                else if (String.valueOf(choiceS.charAt(0)).equalsIgnoreCase("Y"))
                {   
                    System.out.println("\n ⏩ Update hunting part... ...");
                    System.out.println("-----------------------");
                    huntSpecificPredator(locationList.get(i).getFoxes(), locationList.get(i).getPopulation(), i, true);
                    huntSpecificPredator(locationList.get(i).getCats(), locationList.get(i).getPopulation(), i, false);
                    locationList.get(i).setHunted(true);
                    flagH = false;
                }
                else if(String.valueOf(choiceS.charAt(0)).equalsIgnoreCase("N"))
                    flagH = false;
                else
                {
                    System.out.println(" ✘ Sorry. Your input is invalid. Please try it again.");
                    flagH = true;
                }
            }while(flagH);
        }
    }

    /**
    * This method is to hunt a specific kind of predator in a specific location
    * @param  list    The arraylist of a specific knid of predatorthe
    * @param   population   The object of the class Population
    * @param   i  The index of locationNo
    * @param    isFox  The flag for this method is used for fox or not as a boolean
    */
    public void huntSpecificPredator(ArrayList<Predator> list, Population population, int i, boolean isFox)
    {
        int max =list.size();
        boolean anyHunted = false;
        for(int k = 0; k < max; k++)
        {
            if(list.get(k).getAlive())
            {
                    list.get(k).setAlive(false);
                    if( isFox)
                    {
                        if(generateRate(12))
                        {
                            anyHunted = true;
                            population.setDeadFox(population.getDeadFox() + 1);
                            population.setAliveFox(population.getAliveFox() - 1);
                            System.out.println("#Location " + (i + 1) + " Fox " + list.get(k).getPredatorNo() + " is hunted.");
                        }
                    }
                    else
                    {
                        if(generateRate(14))
                        {
                            anyHunted = true;
                            population.setDeadCat(population.getDeadCat() + 1);
                            population.setAliveCat(population.getAliveCat() - 1);
                            System.out.println("#Location " + (i + 1) + " Cat " + list.get(k).getPredatorNo() + " is hunted.");
                        }

                    }
            }
        }
        if(!anyHunted)
        {
            if(isFox)
                System.out.println("#Location " + (i + 1) + "No fox is hunted.");
            else
                System.out.println("#Location " + (i + 1) + "No cat is hunted.");
        }
    }

    /**
    * This method is to simulate for a month
    */
    public void monthSimulation()
    {
        for(int m = 0; m < 12; m++)
        {
            if (m != 0)    
                validation.isSpecialChar("\n ✎ Enter C to go to month " + (m + 1) + ".", "C");
            System.out.println("\n***🌏*** Welcome to month " + (m + 1) + " ***🌝***");
            born();
            eat();
            relocate();
            hunt();
        }
        System.out.println("12 months' simulation has been done.");
    }

    /**
    * This method is to get dead bilby number
    * @param  the code as a string
    *
    */
    public void naturalDeadBilby(int i)
    {
        if(locationList.get(i).getPopulation().getAliveBilby() > 20)
        {
            int naturalDeadNum = locationList.get(i).getPopulation().getAliveBilby() - 20;
            System.out.println("#Location " + (i + 1) + " has more than 20 bilbies, so " + naturalDeadNum + " random bilbies will dead now.");
            for(int k = 0; k < naturalDeadNum; k++)
            {
                System.out.println("Natural dead No." + (k + 1));
                int randomNo = 0;
                boolean flag = true;
                do
                {
                    if(locationList.get(i).getBilbySize() != 0)
                    {
                        randomNo = numberGenerator.generateNumber(- 1, (locationList.get(i).getBilbySize() - 1));
                        if(locationList.get(i).getSpecificBilby(randomNo).getAlive())
                            flag = false;
                        else
                            flag = true;
                    }
                    else
                        flag = false;
                }while(flag);
                locationList.get(i).getSpecificBilby(randomNo).setAlive(false);
                locationList.get(i).getPopulation().setDeadBilby(locationList.get(i).getPopulation().getDeadBilby() + 1);
                locationList.get(i).getPopulation().setAliveBilby(locationList.get(i).getPopulation().getAliveBilby() - 1);
                System.out.println("Bilby " + locationList.get(i).getSpecificBilby(randomNo).getBilbyNo() + " dead.");
            }
            System.out.println("\n***NEW*** Location " + (i + 1) + "'s bilbies' population:");
            System.out.println(locationList.get(i).getPopulation().getAliveBilby());
        }
        else
        {
            System.out.println("#Location " + (i + 1) + " - No bilby dies for this turn's relocating.");
        }
    }

    /**
    * This method is to get relocationNum
    * @param     i   Accept the locationNo as an integer
    * @return   The relocationNum as integer
    *
    */
    public int relocationNum(int i)
    {
        String inputN = "Unknown";
        int n = 0;
        
        boolean wrongInterval = true;
        do
        {
            System.out.println("How many bilbies you want to move from location# " + (i + 1) + "? (0 - " + locationList.get(i).getPopulation().getAliveBilby() + ")");
            Scanner console = new Scanner(System.in);
            inputN = console.nextLine();
            if(validation.isBlank(inputN))
            {
                System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                wrongInterval = true;
            }
            else if (!validation.isNumeric(inputN))
            {
                System.out.println(" ✘ Sorry. Your input has invalid character(s). Please input an integer.");
                wrongInterval = true;
                            
            }
            else
            {
                n = Integer.parseInt(inputN);
                if(n > locationList.get(i).getPopulation().getAliveBilby())
                {
                    System.out.println(" ✘ Sorry. You can't relocate more bilbies than location " + (i + 1) + " has."); 
                    wrongInterval = true;
                }
                else if(n < 0)
                {
                    System.out.println(" ✘ Sorry. Your input is a negative integer. Please input an integer from 0 - " + locationList.get(i).getPopulation().getAliveBilby() + "."); 
                    wrongInterval = true;
                } 
                else
                    wrongInterval = false;
            }
        }while(wrongInterval);

        return n;
    }    

    /**
    * This method is to collect relocation new location number
    * @param  i   The locationNo as an integer
    * @param  flag  The flag of relocate loop as a boolean
    * @return       The new locactionNo for reloactinng as an integer
    */
    public int reloLocNo(int i, boolean flag)
    {
        String inputNewLocNo = "Unknown";
        int newLocNo = 0;
                    
        boolean wrongLocation = true;
        do
        {
            System.out.println(" ✎ Where do you want to remove these bilbies to? (1 - 10 except " + (i + 1) + ")");
            Scanner console = new Scanner(System.in);
            inputNewLocNo = console.nextLine();
            if(validation.isBlank(inputNewLocNo))
            {
                System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                wrongLocation = true;
            }
            else if (!validation.isNumeric(inputNewLocNo))
            {
                System.out.println(" ✘ Sorry. Your input has invalid character(s). Please input an integer.");
                wrongLocation = true;
            }
            else if (Integer.parseInt(inputNewLocNo) > 10)
            {
                System.out.println(" ✘ Sorry. Your input number is more than 10. Please input an integer (1 - 10 except " + (i + 1) + ").");
                wrongLocation = true;
            }
            else
            {
                newLocNo = Integer.parseInt(inputNewLocNo);
                if(newLocNo == (i + 1))
                {
                    System.out.println("You can't relocate bilbies to their old location.");
                    wrongLocation = true;
                }
                else
                {
                    wrongLocation = false;
                    flag = false;
                }
            }
        }while(wrongLocation);

        return newLocNo;
    }

    /**
    * This method is to judge if user want to do another relocation
    * @param   flag   The flag of relocate loop as a boolean
    * @return     The flag of relocate loop as a boolean
    */
    public boolean reloAgain(boolean flag)
    {
        String relocateAgainS = "Unknown";
        boolean flagAgain = true;
        do
        {
            System.out.println(" ✎ Do you want to do more relocate here? (Y / N)");
            Scanner console = new Scanner(System.in);
            relocateAgainS = console.nextLine();
            if(validation.isBlank(relocateAgainS))
            {
                System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                flagAgain = true;
            }
            else if(String.valueOf(relocateAgainS.charAt(0)).equalsIgnoreCase("Y"))
            {
                flag = true;
                flagAgain =false;
            }
            else if(String.valueOf(relocateAgainS.charAt(0)).equalsIgnoreCase("N"))
            {
                flag = false;
                flagAgain =false;
            }
            else
            {
                System.out.println(" ✘ Sorry. Your input is invalid. Please try it again.");
                flagAgain = true;
            }
        }while(flagAgain);

        return flag;
    }

    /**
    * This method is to relocate the bilbies
    *
    */
    public void relocate()
    {
        validation.isSpecialChar("\n ✎ Enter R to go to the relocated part.", "R");
        System.out.println("\n ■ Welcome to the relocated part of SaveTheBilby ■");
        
        for (int i = 0; i < 11; i++)
        { 
            relocateB(i);
        }

        validation.isSpecialChar("\n ✎ Enter N to update natural dying of bilbies.", "N");
        System.out.println("\n ⏩ Update natural dying of bilbies part... ...");
        System.out.println("-----------------------");
        for(int i = 0; i < 11; i++)
        {
            naturalDeadBilby(i);
        }
    }  

    /**
    * This method is to relocation bilbies in a specific location
    * @param  i   The locationNo as an integer
    * 
    */               
    public void relocateB(int i)
    {
        if(locationList.get(i).getPopulation().getAliveBilby() <= 20)
            System.out.println("#Location " + (i + 1) + " has less than 20 bilbies. Don't need to relocate this location's bilbies.");
        else 
        {
            String choiceS = "Unknown"; 
            boolean flag = true;
            do
            {
                System.out.println("\n----Alive Bilby in 10 locations----"); 
                for (int h = 0; h < 11; h++)
                {
                    System.out.println("-----------------------");
                    displayAliveBilby(h);
                }
                System.out.println(" ✎ Do you want to relocate the bilbies from location# " + (i + 1) + "? (Y / N)");
                Scanner console = new Scanner(System.in);
                choiceS = console.nextLine();
                if(validation.isBlank(choiceS))
                {
                    System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                    flag = true;
                }
                else if (String.valueOf(choiceS.charAt(0)).equalsIgnoreCase("Y"))
                {  
                    int n = relocationNum(i);
                    int newLocNo = reloLocNo(i, flag);
                    System.out.println("\n ⏩ Update relocated part... ...");
                    System.out.println("-----------------------");
                    for(int k = 0; k < n; k++)
                    {
                        int randomNo = 0;
                        boolean flagR = true;
                        do
                        {
                            if(locationList.get(i).isBilbiesAlive())
                            {
                                randomNo = numberGenerator.generateNumber(- 1, (locationList.get(i).getBilbySize() - 1));
                                if(locationList.get(i).getSpecificBilby(randomNo).getAlive())
                                    flagR = false;
                                else
                                    flagR = true;
                            }
                            else
                                flagR = false;
                        }while(flagR);

                        String transCode = locationList.get(i).getSpecificBilby(randomNo).getBilbyNo();
                        System.out.println("#Relocate" + (k + 1) +" - Move Bilby " + transCode + " from Location " + (i + 1) + " to Location " +(newLocNo) + ".");
                        locationList.get(i).removeSpecificBilby(randomNo);
                        locationList.get(i).getPopulation().setAliveBilby(locationList.get(i).getPopulation().getAliveBilby() - 1);
                                
                        locationList.get(newLocNo - 1).addBilby(new Bilby(transCode, newLocNo - 1, true));
                        locationList.get(newLocNo - 1).getPopulation().setAliveBilby(locationList.get(newLocNo - 1).getPopulation().getAliveBilby() + 1);
                    }
                    flag = reloAgain(flag);
                }
                else if(String.valueOf(choiceS.charAt(0)).equalsIgnoreCase("N"))
                    flag = false;
                else
                {
                    System.out.println(" ✘ Sorry. Your input is invalid. Please try it again.");
                    flag = true;
                }
            }while(flag);
        }
    }

    /**
    * Mutator method to set the animal's code
    * 
    * @param myAnimalCode      The animal's code as an integer arraylist.
    *
    */
    public void setAnimalCode(int[] myAnimalCode)
    {
        animalCode = myAnimalCode;
    }

    /**
    * Mutator method to set the area name
    * 
    * @param myAreaName      The area name as a string.
    *
    */
    public void setAreaName(String myAreaName)
    {
        areaName = myAreaName;
    }

    /**
    * Mutator method to set the object of the class File
    * 
    * @param myFile      The object of the class File
    *
    */
    public void setFile(File myFile)
    {
        file = myFile;
    }

    /**
    * Mutator method to set the location list
    * 
    * @param myLocationList      The location collection as an arraylist.
    *
    */
    public void setLocationList(ArrayList<Location> myLocationList)
    {
        locationList = myLocationList;
    }

    /**
    * Mutator method to set the object of the class NumberGenerator.
    * 
    * @param myNumberGenerator      The object of the class NumberGenerator.
    *
    */
    public void setNumberGenerator(NumberGenerator myNumberGenerator)
    {
        numberGenerator = myNumberGenerator;
    }

    /**
    * Mutator method to set the specific animal code
    * 
    * @param  index    The index of the specific animal code of the array
    * @param   newCode      The animal code collection as an array.
    *
    */
    public void setSpecificAniCode(int index, int newCode)
    {
        animalCode[index] = newCode;
    }  

    /**
    * This method is to display the final summary to user
    *
    */
    public void summaryDisplay()
    {
        validation.isSpecialChar("\n ✎ Enter C to display summary.", "C");
        System.out.println("\n-----Summary-----");
        System.out.println("\n#1. Population details at each location:");
        for(int i = 0; i < 11; i++)
        {
            System.out.println("-----------------");
            displayPopulation(i);
        }
        int i = 0;
        System.out.println("\n#2. Bilby population change:");
        System.out.printf("%.2f%n", (getStatisticsNumber(locationList.get(i).getPopulation().getAliveBilby(), i) - getStatisticsNumber(file.readFile().get(i * 3), i)) * 100 / getStatisticsNumber(file.readFile().get(i * 3), i));
        System.out.println("\n#3. Bilby population stability factor: ");
        System.out.printf("%.2f%n", (getStatisticsNumber(locationList.get(i).getPopulation().getBornBilby(), i) - getStatisticsNumber(locationList.get(i).getPopulation().getDeadBilby(), i))/ getStatisticsNumber(file.readFile().get(i * 3), i));
        System.out.println("\n#4. Predator population change:");
        double nowAliFox = getStatisticsNumber(locationList.get(i).getPopulation().getAliveFox(), i);
        double nowAliCat = getStatisticsNumber(locationList.get(i).getPopulation().getAliveCat(), i);
        double staAliFox = getStatisticsNumber(file.readFile().get(i * 3 + 1), i);
        double staAliCat = getStatisticsNumber(file.readFile().get(i * 3 + 2), i);
        double temp = ((nowAliFox + nowAliCat) - (staAliFox + staAliCat)) * 100 / (staAliFox + staAliCat);
        System.out.printf("%.2f%n",temp);
    }

    /**
    * This is a method to being the program
    * 
    * @param args       An array of Strings representing command line arguments.
    */
    public static void main(String[] args)
    {
        SaveTheBilby sav = new SaveTheBilby();
        sav.inputAreaName();
        sav.assignAnimalNum();
        sav.monthSimulation();
        sav.fileWriter();
        sav.summaryDisplay();
    }
}
