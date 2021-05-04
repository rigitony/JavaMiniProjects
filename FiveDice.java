
/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 4, Game Zone 1-2 Exercises (p. 242-243)
*/

public class FiveDice
{
   public static void main(String[] args)
   {
      Die[] computerDice = new Die[5];
      Die[] playerDice = new Die[5];
      System.out.print("Computer dice roll: ");
      printDiceRoll(computerDice);
      System.out.println();
      System.out.print("Player dice roll: ");
      printDiceRoll(playerDice);
   }
   
   public static void printDiceRoll(Die[] d) // method to initialize and print array of Die objects 
   {
      System.out.print("{");
      int counter = 1;
      for (Die die : d)
      {
         die = new Die();
         if (counter < d.length)
         {
            System.out.print(die.getValue() + ", ");
            counter++;
         }
         else
            System.out.print(die.getValue() + "}");
      }
   }
}