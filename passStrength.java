import java.util.*;
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
            return false;
        }
        return res;
    }

    public static Boolean checkCase(Boolean res){
        return res;
    }


    public static void main(String[] args){
        getInput();
        if(checkLength(false).equals(true)){
            System.out.println("Password is strong");
        }
        else{
            System.out.println("Pass is weak");
        }
    }
}
