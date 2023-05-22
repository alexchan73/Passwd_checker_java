import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;
public class passStrength{
    //implement a brute force algo. next
    //Global variable?
    static String usr_input;

    /**
     * Gets input from the user and stores it into usr_input
     */
    public static String getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        usr_input = input.nextLine();
        return usr_input;
    }

    /**
     * Checks the length of the password
     * @param res , stores the boolean value of the result
     * @return if the password length is >= 8 then will return true
     */
    public static Boolean checkLength(Boolean res){
        //res = false;
        if(usr_input.length() >= 8 ){
             res = true;
        }
        else{
            res = false;
        }
        return res;
    }

    /**
     * Checks if there is a lowercase, uppercase, number
     * and special character within the string
     * 
     * 1/13/2023 Revising to also check for common strings
     * Source: https://www.geeksforgeeks.org/check-if-a-string-contains-uppercase-lowercase-special-characters-and-numeric-values/
     */
    public static Boolean checkAll(Boolean res){
        String specialSymbols = "^(?=.*[a-z])(?=."
        + "*[A-Z])(?=.*\\d)"
        + "(?=.*[-+_!@#$%^&*., ?]).+$";

        //String commonWords = "alex";  //trying to implement commonly used passwords?
        Pattern p = Pattern.compile(specialSymbols);

        if(usr_input == null ){
            System.out.println("There is no string"); //If the string is empty then print no
        }

        Matcher m = p.matcher(usr_input);

        if(m.matches()){  //If the password matches any of the common words -> true , weak password   usr_input.contains(commonWords)
            res = true;
        }
        else{
            res = false;
        }
        return res;
    }


    /**
     * Will utilize a brute force algorithm to check HOW LONG
     * it will take to brute force the password.
     * @return
     */
    public static int bruteForce(){

    }

    /**
     *
     * @param psswdFound
     * @return
     * @throws IOException
     */
    public static Boolean checkFile(Boolean psswdFound) throws IOException{
        File txtFile = new File("D:\\Java Projects\\passwordStrength\\100000-most-common-passwords.txt");
        Scanner in = new Scanner(txtFile);
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        if(list.contains(getInput())){ //if the usrInput is found within the file, return true
            psswdFound = true;
        }
        else{
            psswdFound = false;
        }
        return psswdFound;
    }

    


    public static void main(String[] args) throws IOException{
        getInput();
        if(checkLength(false).equals(true) && checkAll(false).equals(true) && checkFile(false).equals(true)){  //readFile must be false in order for the password to be strong
            System.out.println("The password you entered is strong!");
        }
        else{
            System.out.println("The password you entered does not adhere to the secure password standard and was found in a list \nMake sure that the password is at least 8 Characters long, Contains both upper case and lower case letters \nIt also needs to contain special symbols");
        }
        Boolean reaskUser = false;
        Scanner thisInput = new Scanner(System.in);
        while(reaskUser = true){
            System.out.print("Do you want to enter another password? (y/n): ");
            String reInput = thisInput.nextLine();
            if(reInput.equals("y")){
                getInput();
                if(checkLength(false).equals(true) && checkAll(false).equals(true)){
                    System.out.println("The password you entered is strong!");
                }
                else{
                    System.out.println("The password you entered does not adhere to the secure password standard and was found in a list \nMake sure that the password is at least 8 Characters long, Contains both upper case and lower case letters \nIt also needs to contain special symbols");
                }

            }
            else{
                reaskUser = false;
                System.out.println("Thanks for using the program!");
                break;
            }

        }
    }
}
