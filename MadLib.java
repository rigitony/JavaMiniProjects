
/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 2, GameZone 1 Exercise (p. 117)
*/

import javax.swing.JOptionPane;
import java.awt.*;

public class MadLib
{

   public static void main(String[] args)
   {
      int selection;
      do
      {
      String noun1 = JOptionPane.showInputDialog(null, "Please enter a noun", "MadLib", JOptionPane.QUESTION_MESSAGE);
      String noun2 = JOptionPane.showInputDialog(null, "Please enter another noun", "MadLib", JOptionPane.QUESTION_MESSAGE);
      String adj = JOptionPane.showInputDialog(null, "Please enter an adjective", "MadLib", JOptionPane.QUESTION_MESSAGE);
      String adj2 = JOptionPane.showInputDialog(null, "Please enter another adjective", "MadLib", JOptionPane.QUESTION_MESSAGE);
      String verb= JOptionPane.showInputDialog(null, "Please enter a verb", "MadLib", JOptionPane.QUESTION_MESSAGE);
      String pastVerb = JOptionPane.showInputDialog(null, "Please enter a past-tense verb", "MadLib", JOptionPane.QUESTION_MESSAGE);
      
      JOptionPane.showMessageDialog(null, "James loved to " + verb + "! He had the fastest " + noun1 + " and the heaviest " + noun2 + " too.\n It was a never a surprise with his " + adj + " eyes and he " + pastVerb + " them both in two.");
      selection = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
      } while (selection == JOptionPane.YES_OPTION);
   }
}