import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class demonstrates a file reader and writer 
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class File
{
    /**
    * This method is to read a file
    * 
    * @return       The content of that file as an arraylist
    */
    public ArrayList<Integer> readFile()
    {
        ArrayList<Integer> outputList = new ArrayList<>(); 

        try
        {
            Scanner console = new Scanner(System.in);
            FileReader reader = new FileReader("population.txt");
            try
            {
                Scanner fileInput = new Scanner(reader);
                int counter = 0;
                while(fileInput.hasNextLine())
                {
                    //counter++;
                    String[] lineContents = fileInput.nextLine().split(",");
                    try
                    {
                        for(int j = 0; j < 3; j++)
                        {
                            outputList.add(Integer.parseInt(lineContents[j]));
                        //System.out.println(outputList.get(counter));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error in number of animal on Line " + counter + " .Skipping");
                    }
                }
            }
            finally
            {
                try
                {
                    reader.close();
                }
                catch(Exception e)
                {
                   System.out.println("Error in reading from file! Exiting..."); 
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in writing to file! Exiting...");
        }

        return outputList;
    }

    /**
    * This method is to write a file
    * 
    * @param    filename   The name of that file as a string
    * @param    list   The content of that file as an arraylist
    */
    public void creatFile(String filename, ArrayList<Location> list)
    {
        try
        {
            Scanner console = new Scanner(System.in);
            FileWriter writer = new FileWriter(filename);
            try
            {
                for(int i = 0; i < 10; i++)
                {
                    writer.append(list.get(i).getPopulation().getAliveBilby() + "," + list.get(i).getPopulation().getDeadBilby() + "," + list.get(i).getPopulation().getAliveFox()+ "," + list.get(i).getPopulation().getDeadFox()+ "," + list.get(i).getPopulation().getAliveCat()+ "," + list.get(i).getPopulation().getDeadCat() + "\n");
                }
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch(Exception e)
                {
                   System.out.println("Error in writing to file! Exiting..."); 
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in writing to file! Exiting...");
        }
    }
}
