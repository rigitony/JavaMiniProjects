

/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 9, Exercise 7 (p. 485)
*/

import java.util.*;

public class Purchase
{
   int invoiceNumber;
   double amountOfSale;
   double salesTax;
   
   public int getInvoice()
   {
      return invoiceNumber;
   }
   
   public double getAmountOfSale()
   {
      return amountOfSale;
   }

   public double getSalesTax()
   {
      return salesTax;
   }

   public void setInvoice(int i)
   {
      invoiceNumber = i;
   }
   
   public void setAmountOfSale(double a)
   {
      amountOfSale = a;
   }
   
   public void setSalesTax(double s)
   {
      salesTax = s;
   }
}