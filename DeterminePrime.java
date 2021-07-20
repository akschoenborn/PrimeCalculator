import java.util.InputMismatchException;
import java.util.Scanner;
public class DeterminePrime {

static Scanner scan = new Scanner(System.in);
static String response;
static int tryPrime;

public boolean isPrime(int number){
    if(number < 2){
      return false;
    }
    else if (number == 2){
      return true;
    }
    else{
        for(int i = 2; i < number; i++){
            if(number % i == 0) {
            return false;
            }//end if
        }//end for
    }//end else
    return true;
}

public static void greeting(){
    System.out.println("Please enter the number you would like to ascertain is prime: "); 
    tryPrime = scan.nextInt();
}

public static String contOrStop() {
    System.out.println("Would you like to enter another number?\nPlease type 'Continue' or 'Quit.'");
    String reply = scan.next();
    if (reply.equalsIgnoreCase("continue")){
        return reply;
    }
    else {
        System.out.println("That is not a valid answer, please try again.\nPlease type 'Continue' or 'Quit.'");
        reply = scan.next();
        return reply;
    }
}

  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    response = "continue";
    
    while (response.equalsIgnoreCase("continue")) {
        try {
            DeterminePrime.greeting();
            pd.isPrime(tryPrime);
        
            if (pd.isPrime(tryPrime) == true) {
                System.out.println(tryPrime + " is a prime number.");
            }
            else if (pd.isPrime(tryPrime) == false) {
                System.out.println(tryPrime + " is not a prime number.");
            }
            else {
                System.out.println("Unrecognized input. Please try again.");
                response = "continue";
            }
        }//end try
        catch (InputMismatchException e) {
            System.out.println("Unrecognized input. Please try again.");
            scan.next();
        }
        response = DeterminePrime.contOrStop();
    } //end while

    System.out.println("Thank you for using the prime number calculator!");

    scan.close();
}//end main  


}//end class 

