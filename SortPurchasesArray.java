

/*
Anthony Griego
CIS163AA - Class # 28716
FINAL PROJECT
Chapter 9, Exercise 7 (p. 485)
*/

import java.util.*;

public class SortPurchasesArray
{
      public static void main(String[] args)
   {
      Scanner InputDevice = new Scanner(System.in);
      Purchase[] invoiceList = new Purchase[5]; // Declare array of 5 Purchase objects
      int menuStatus = 0;
      String userSelection;
      int userInt = 0;
      final double SALES_TAX_RATE = .086;
      
      for(int x = 0; x < invoiceList.length; ++x) // for loop initializes each element of the array using default constructor
         invoiceList[x] = new Purchase();
         
      // Populate each element in the invoiceList array
      
      for(int x = 0; x < invoiceList.length; ++x)
      {
         try {
            if (x == 0)
               System.out.println("Please enter info for 5 invoices.");
            System.out.println("Please enter invoice number for invoice #" + (x + 1) + ":");
            invoiceList[x].setInvoice(Integer.parseInt(InputDevice.nextLine()));
            System.out.println("Invoice number " + invoiceList[x].getInvoice() + " is accepted.");
            System.out.println("Please enter amount of sale for invoice #" + (x + 1) + ":");
            invoiceList[x].setAmountOfSale(Double.parseDouble(InputDevice.nextLine()));
            System.out.println("Amount of sale " + invoiceList[x].getAmountOfSale() + " is accepted.");
            invoiceList[x].setSalesTax(invoiceList[x].getAmountOfSale() * SALES_TAX_RATE);
            System.out.println("Sales Tax for invoice #" + (x + 1) + ": " + invoiceList[x].getSalesTax());
         } 
         catch (Exception e) {
            System.out.println("INVALID INPUT -- Please try again");
            x = -1;
         }
      }
      
      printInvoiceList(invoiceList);
      
      while (userInt < 1 || userInt > 4)
      {
         System.out.println("Please choose from the following options:");
         System.out.println("[1] Sort by invoice number");
         System.out.println("[2] Sort by amount of sale");
         System.out.println("[3] Sort by sales tax");
         System.out.println("[4] Exit Program");
         userSelection = InputDevice.nextLine();
         try {
            userInt = Integer.parseInt(userSelection);
         }
         catch (NumberFormatException e) {
            System.out.println("INVALID INPUT -- Please enter a valid integer!!");
            continue;
         }
         if (userInt < 1 || userInt > 4)
            System.out.println("Invalid integer selection, please try again");
      
         switch (userInt)
         {
            case 1:
               System.out.println("Sorting by invoice number...");
               invoiceSort(invoiceList);
               userInt = 0;
               break;
            case 2:
               System.out.println("Sorting by amount of sale...");
               amountOfSaleSort(invoiceList);
               userInt = 0;
               break;
            case 3:
               System.out.println("Sorting by sales tax...");
               salesTaxSort(invoiceList);
               userInt = 0;
               break;
            case 4:
               System.out.println("Exiting program");
               System.exit(0);
               break;
            default:
               break;
         }
      }
   }


   public static void printInvoiceList(Purchase[] arr)
   {
      System.out.println("Invoice List:");
      System.out.println("INVOICE # --- AMOUNT OF SALE --- SALES TAX");
      for (int x = 0; x < arr.length; ++x)
      {
         System.out.print(arr[x].getInvoice() + " --- ");
         System.out.printf("$%,.2f --- ", arr[x].getAmountOfSale());
         System.out.printf("$%,.2f", arr[x].getSalesTax());
         System.out.println();
      }
   }
   
   public static void invoiceSort(Purchase[] arr)
   {
      Purchase[] outputArr = new Purchase[arr.length];
      for (int i = 0; i < arr.length; i++) // transfer objects from old array to the new one
         outputArr[i] = arr[i];
      Arrays.sort(outputArr, new InvoiceNumberComparator()); // array sort using my custom comparator
      printInvoiceList(outputArr);
   }
   
   public static void salesTaxSort(Purchase[] arr)
   {
      Purchase[] outputArr = new Purchase[arr.length];
      for (int i = 0; i < arr.length; i++)
         outputArr[i] = arr[i];
      Arrays.sort(outputArr, new SalesTaxComparator());
      printInvoiceList(outputArr);
   }
   
   public static void amountOfSaleSort(Purchase[] arr)
   {
      ArrayList<Purchase> purchaseList = new ArrayList<Purchase>(arr.length);
      for (int i = 0; i < arr.length; i++) // transfer objects from old array to the arraylist
         purchaseList.add(arr[i]);
         
      Collections.sort(purchaseList, new AmountOfSaleComparator()); // array list collections sort using my custom comparator
      
      System.out.println("INVOICE # --- AMOUNT OF SALE --- SALES TAX");
      
      for (int x = 0; x < arr.length; ++x) // print each item from the arraylist
      {
         System.out.print(purchaseList.get(x).getInvoice() + " --- ");
         System.out.printf("$%,.2f --- ", purchaseList.get(x).getAmountOfSale());
         System.out.printf("$%,.2f", purchaseList.get(x).getSalesTax());
         System.out.println();
      }
   }
   
   
}

// Below are comparators to change how java compares each object
class SalesTaxComparator implements Comparator<Purchase> // compares based on SalesTax
{
    @Override
    public int compare(Purchase purch1, Purchase purch2) 
    {
        return Double.compare(purch1.getSalesTax(), purch2.getSalesTax());
    }
}

class AmountOfSaleComparator implements Comparator<Purchase> // compares based on AmountOfSale
{
    @Override
    public int compare(Purchase purch1, Purchase purch2) 
    {
        return Double.compare(purch1.getAmountOfSale(), purch2.getAmountOfSale());
    }
}

class InvoiceNumberComparator implements Comparator<Purchase> // compares based on InvoiceNumber
{
    @Override
    public int compare(Purchase purch1, Purchase purch2) 
    {
        return Integer.compare(purch1.getInvoice(), purch2.getInvoice());
    }
}