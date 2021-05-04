
/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 4, Game Zone 1-2 Exercises (p. 242-243)
*/

public class Die
{
   public int value;
   final static int HIGHEST_DIE_VALUE = 6;
   final static int LOWEST_DIE_VALUE = 1;
   
   public Die()
   {
      value = ((int)(Math.random() * 100) % HIGHEST_DIE_VALUE + LOWEST_DIE_VALUE);
   }
   
   public int getValue()
   {
      return value;
   }
}