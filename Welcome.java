//The package where the project falls into
package BANK;

//Welcome class which only consists a single method which would be used in the Main class
public class Welcome {
    
    //This method first clears the output screen then prints the message
    public void WelcomeMsg(){
        //Built in function to clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //Welcome message to the user
        System.out.println("\n\t\t\t\tWelcome To Banking Application\t\t\t\n\n");
    }
}
