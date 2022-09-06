import java.util.*;
import java.util.regex.*;
public class passStrength{

    //Global variable?
    static String usr_input;

    /**
     * Gets input from the user and stores it into usr_input
     */
    public static void getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        usr_input = input.nextLine();
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
     * Source: https://www.geeksforgeeks.org/check-if-a-string-contains-uppercase-lowercase-special-characters-and-numeric-values/
     */
    public static Boolean checkAll(Boolean res){
        String specialSymbols = "^(?=.*[a-z])(?=."
        + "*[A-Z])(?=.*\\d)"
        + "(?=.*[-+_!@#$%^&*., ?]).+$";

        Pattern p = Pattern.compile(specialSymbols);

        if(usr_input == null ){
            System.out.println("There is no string"); //If the string is empty then print no
        }

        Matcher m = p.matcher(usr_input);

        if(m.matches()){
            res = true;
        }
        else{
            res = false;
        }
        return res;
    }

    


    public static void main(String[] args){
        getInput();
        if(checkLength(false).equals(true) && checkAll(false).equals(true)){
            System.out.println("The password you entered is strong!");
        }
        else{
            System.out.println("The password you entered does not adhere to the secure password standard \nMake sure that the password is at least 8 Characters long, Contains both upper case and lower case letters \nIt also needs to contain special symbols");  
         
        }
    }
}
