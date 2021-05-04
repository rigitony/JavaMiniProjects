
/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 5, Exercise 6 (p. 295-296)
*/

import javax.swing.*;

public class Pay
{

   public static void main(String[] args)
   {
   
      double hoursWorked, regularHoursWorked, overtimeHoursWorked, hourlyRate, pay, overtimePay, totalPay, deductions, netPay;
      hoursWorked = hourlyRate = pay = overtimePay = totalPay = deductions = netPay = 0;
      final double LEVEL_1_HOURLY_RATE = 17;
      final double LEVEL_2_HOURLY_RATE = 20;
      final double LEVEL_3_HOURLY_RATE = 22;
      final double MEDICAL_WEEKLY_COST = 32.50;
      final double DENTAL_WEEKLY_COST = 20;
      final double DISABILITY_WEEKLY_COST = 10;
      int skillLevel, medicalSelection, dentalSelection, disabilitySelection, retirementSelection;
      skillLevel = medicalSelection = dentalSelection =  disabilitySelection = retirementSelection = 0;
      boolean validInput = false;
      
      while (validInput == false)
      {
         try
         {
            hoursWorked = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter hours worked:"));
            validInput = true;
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            validInput = false;
         }
      }
      
      validInput = false;
      do
      {
         try
         {
            skillLevel = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter skill level:"));
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Please enter a valid number!");
         }
         
         switch (skillLevel)
         {
            case 1:
               hourlyRate = LEVEL_1_HOURLY_RATE;
               validInput = true;
               break;
            case 2:
               hourlyRate = LEVEL_2_HOURLY_RATE;
               validInput = true;
               break;
            case 3:
               hourlyRate = LEVEL_3_HOURLY_RATE;
               validInput = true;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Please enter a number beween 1 and 3");
               break;
         }
      } while (validInput == false);
      
      if (skillLevel == 2 || skillLevel == 3)
      {
         medicalSelection = JOptionPane.showConfirmDialog(null, "Would you like to elect for medical insurance? (added weekly cost of $" + MEDICAL_WEEKLY_COST + ")", "Medical Selection", JOptionPane.YES_NO_OPTION);
         dentalSelection = JOptionPane.showConfirmDialog(null, "Would you like to elect for dental insurance? (added weekly cost of $" + DENTAL_WEEKLY_COST + ")", "Dental Selection", JOptionPane.YES_NO_OPTION);
         disabilitySelection = JOptionPane.showConfirmDialog(null, "Would you like to elect for long-term disability insurance? (added weekly cost of $" + DISABILITY_WEEKLY_COST + ")", "Medical Selection", JOptionPane.YES_NO_OPTION);
      }
      
      if (skillLevel == 3)
         retirementSelection = JOptionPane.showConfirmDialog(null, "Would you like to elect for retirement plan? (3% of gross pay)", "Medical Selection", JOptionPane.YES_NO_OPTION);
      
      if (hoursWorked >= 40)
      {
         regularHoursWorked = 40;
         overtimeHoursWorked = hoursWorked - 40;
      }
      else
      {
         regularHoursWorked = hoursWorked;
         overtimeHoursWorked = 0;
      }
      
      // sets user selections to a binary value
      if (medicalSelection == JOptionPane.YES_OPTION)
         medicalSelection = 1;
      else
         medicalSelection = 0;
         
      if (dentalSelection == JOptionPane.YES_OPTION)
         dentalSelection = 1;
      else
         dentalSelection = 0;
      
      if (disabilitySelection == JOptionPane.YES_OPTION)
         disabilitySelection = 1;
      else
         disabilitySelection = 0;
      
      if (retirementSelection == JOptionPane.YES_OPTION)
         retirementSelection = 1;
      else
         retirementSelection = 0;
      
      pay = regularHoursWorked * hourlyRate;
      overtimePay = overtimeHoursWorked * hourlyRate * 1.5;
      totalPay = pay + overtimePay;
      // deductions use binary values for calculation
      deductions = (medicalSelection * MEDICAL_WEEKLY_COST) + (dentalSelection * DENTAL_WEEKLY_COST) + (disabilitySelection * DISABILITY_WEEKLY_COST) + (retirementSelection * totalPay * .03);
      netPay = totalPay - deductions;
      
      JOptionPane.showMessageDialog(null, 
      "(1) Hours worked: " + hoursWorked + " hours" +
      "\n(2)Hourly Pay Rate: $" + hourlyRate +
      "\n(3)Regular pay: $" + pay +
      "\n(4)Overtime pay: $" + overtimePay +
      "\n(5)Total pay (Gross): $" + totalPay +
      "\n(6)Total itemized deductions: $" + deductions +
      "\n(7)Net pay: $" + netPay
      );
      
   }

}