import java.util.Scanner;

/**
 * This class demonstrates a validation 
 * @author Wendi Zhu
 * @version ver 1.0.0
 */
public class Validation
{

    /**
    * This method is to get the input is blank or not
    * 
    * @return       The input's blank as a boolean.
    */
    public boolean isBlank(String input)
    {
        if(input == null || input.trim().isEmpty())
            return true;
        else
            return false;
    }

    /**
    * This method is to get the input's character is all numeric or not
    * 
    * @return       The validation result of input's numeric as a boolean.
    */
    public boolean isNumeric(String input)
    {
        String inputStr = input.trim();

        for(int i = 0; i < inputStr.length(); i++)
        {
            if(inputStr.charAt(i) < '0' || inputStr.charAt(i) > '9')
                return false;
        }
        return true;
    }

    /**
    * This method is to get the input is equal to c or not
    * 
    * @return       The input's validation result as a boolean.
    */
    public void isSpecialChar(String question,String c)
    {
        char answer;
        String answerS;
        boolean isCorrect = true;
        do{
            System.out.println(question);
            Scanner console = new Scanner(System.in);
            answerS = console.nextLine();
            if(isBlank(answerS))
            {
                System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                isCorrect = true; 
            }
            else if(String.valueOf(answerS.charAt(0)).equalsIgnoreCase(c))
                isCorrect = false;
            else
            {
                System.out.println(" ✘ Sorry. Your input is invalid. Please try it again.");
                isCorrect = true;
            }
        }while(isCorrect);
    }

    /**
    * This method is to get the input is equal to Y or N
    * 
    * @return       The input's validation result as a boolean.
    */
    public boolean isYesOrNo(String question,String y, String n, int i)
    {
        char answer;
        String answerS;
        boolean isCorrect = true;
        boolean isYes = true;
        do{
            System.out.println(question);
            Scanner console = new Scanner(System.in);
            answerS = console.nextLine();
            if(isBlank(answerS))
            {
                System.out.println(" ✘ Sorry. Don't leave your input empty. Please try it again.");
                isCorrect = true; 
            }
            else if(String.valueOf(answerS.charAt(0)).equalsIgnoreCase(y))
            {
                isYes = true;
                isCorrect = false;
            }
            else if(String.valueOf(answerS.charAt(0)).equalsIgnoreCase(n))
            {
                isYes = false;
                isCorrect = false;
            }
            else
            {
                System.out.println(" ✘ Sorry. Your input is invalid. Please try it again.");
                isCorrect = true;
            }
        }while(isCorrect);

        return isYes;
    }

    /**
    * This method is to get the input's length is between min and max or not
    * 
    * @return       The validation result of input's length as a boolean.
    */
    public boolean stringLengthInRange(String input, int min, int max)
    {
        if(input.length() >= min && input.length() <= max)
            return true;
        else
            return false;
    }
}
