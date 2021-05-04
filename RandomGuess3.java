

/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 6, Game Zone 2 Exercise (p. 350-351)
*/

import java.util.*;

public class RandomGuess3
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int MAX_VALUE = 1000;
      int MIN_VALUE = 1;
      int menuStatus = 0;
      int counter = 0;
      int randomNumber = (int)(Math.random() * MAX_VALUE + MIN_VALUE);
      
      while (menuStatus == 0)
      {
         counter++;
         if (counter <= 1)
            System.out.println("Please guess a number between 1 and 1000 to see if you are a winner!");
         int userSelection = keyboard.nextInt();
         
         if (userSelection < randomNumber)
         {
            System.out.println("Guess is too low, please try again");
            continue;
         }
            
         else if (userSelection > randomNumber)
         {
            System.out.println("Guess is too high, please try again");
            continue;
         }
            
         else if (userSelection == randomNumber)
         {
            System.out.println("You are correct! Good job!");
            System.out.println("Number of attempts: " + counter);
         }
      
         System.out.println("Would you like to play again?");
         System.out.println("(1) Yes");
         System.out.println("(2) No");
         userSelection = keyboard.nextInt();

         if (userSelection == 1)
         {
            randomNumber = (int)(Math.random() * MAX_VALUE + MIN_VALUE);
            counter = 0;
         }
         
         else if (userSelection == 2)
         {
            menuStatus = 1;
         }
      }
      
      System.out.println("Thanks for playing! Goodbye");
   }
}