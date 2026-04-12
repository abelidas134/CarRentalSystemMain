package billingsystemoop;

import java.util.*;

public class BillingSystemOOP {
    static Scanner scan = new Scanner(System.in);
    static int daysRented, pickUp,dropOff, year,daysForPickUp, daysForDropOff,
                ratePerDay=2000,
                penaltyRate=600, 
                actualReturnDate=0, 
                expectedReturnDate=0,
                cleaningFee=400, 
                daysOfMonthPick=0,
                daysOfMonthDrop=0;
    static double finalTotal, tax, subTotal,
            damageFee=ratePerDay*0.50;
    static String reservationNo, 
                pickUpMonth, 
                dropOffMonth, 
                paymentStatus="paid";
    
    public static void main (String [] args){
        System.out.print("Enter reservation number: ");
        reservationNo = scan.nextLine(); //Connect with Manu
        
            if (reservationNo.equals("0000")){
                System.out.print("Month (Pick Up): ");
                pickUpMonth=scan.nextLine().toLowerCase();
                System.out.print("Day (Pick Up):");
                pickUp = scan.nextInt();
                
                scan.nextLine();
                System.out.print("Month (Drop Off): ");
                dropOffMonth=scan.nextLine().toLowerCase();
                System.out.print("Day (Drop Off):");
                dropOff = scan.nextInt();
                
                //record active/cancelled/completed
                monthsPick (pickUpMonth, dropOffMonth);
                reservationStatus ();
                
            } else {
                System.out.println("Reservation number is not recorded. Try again!");
            }
    }
    
    public static void reservationStatus (){
        String rStatus = "active";//Sample Only: The status would be from the class of Manu (Reseravtion)
        
        switch (rStatus){
            case "active":
                System.out.println("Reservation Status: Active");
                calculateBill(ratePerDay, penaltyRate, paymentStatus,
                actualReturnDate, expectedReturnDate, cleaningFee, damageFee);
                generateInvoice ();
                break;
            case "cancelled":
                System.out.println("Reservation Status: Cancelled");
                System.out.println("Thank you for trying with us!");
                break;
            case "completed":
                System.out.println("Reservation Status: Completed");
                calculateBill(ratePerDay, penaltyRate, paymentStatus,
                    actualReturnDate, expectedReturnDate, cleaningFee, damageFee);
                generateInvoice ();
                break;
            default:
                System.out.println("Reservation Stauts: Unknown");
                break;
        }
        
    }
    
    public static void calculateBill ( int dailyRate, int penRate, String statusPaid, int actualReturn, int expectedReturn, int cleanFee, double damFee){
        int cost, extraDays, latePenalty;
        double extraCharge;
        //Formulas
        cost = dailyRate*daysRented;
        extraDays = actualReturn - expectedReturn;
        latePenalty = extraDays*penRate;
        extraCharge = damFee + cleanFee;
        subTotal = cost + latePenalty + extraCharge;
        tax = subTotal*0.12;
        finalTotal = subTotal + tax;
    }
    
    public static void generateInvoice (){
        System.out.println("Reservation Number: "+reservationNo);
        System.out.println("Customer Name: ");
        System.out.println("Vehicle: ");
        System.out.println("Days Rented: " + daysRented);
        System.out.println("Daily Rate: " + ratePerDay);
        System.out.println("Extra Fees: " + (cleaningFee + damageFee));
        System.out.println("Initial Amount: " + subTotal);
        System.out.println("Tax: " + tax);
        System.out.println("Total Amount: " + finalTotal);
    }
    
    public static int monthsPick (String monthPick, String monthDrop){
        
        //Pick Up
        if (monthPick.equals("january") || monthPick.equals("march") || monthPick.equals("may") ||
            monthPick.equals("july") ||  monthPick.equals("august") || monthPick.equals("october") ||  monthPick.equals("december") ){
            
            daysOfMonthPick = 31;
            daysForPickUp = daysOfMonthPick - pickUp;
            monthsDrop ( monthPick, monthDrop);
        } else if (monthPick.equals("february")){
                System.out.print("Year: ");
                year = scan.nextInt();
                
                if ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0)){
                    daysOfMonthPick = 29;
                } else {
                    daysOfMonthPick = 28;
                }
                daysForPickUp = daysOfMonthPick - pickUp;
                monthsDrop ( monthPick, monthDrop);
        } else if (monthPick.equals("april") || monthPick.equals("june") || monthPick.equals("september") ||
            monthPick.equals("november")){
                daysOfMonthPick = 30;
                daysForPickUp = daysOfMonthPick - pickUp;
                monthsDrop ( monthPick, monthDrop);
        } else {
            System.out.println("Invalid month. Please try again!");
        }
        daysRented = daysForPickUp + daysForDropOff;
        return daysRented;
    }
    
    public static void monthsDrop (String monthPick, String monthDrop){
        //drop off
        if (monthDrop.equals("january") || monthDrop.equals("march") || monthDrop.equals("may") ||
            monthDrop.equals("july") ||  monthDrop.equals("august") || monthDrop.equals("october") ||  monthDrop.equals("december") ){
            
            daysOfMonthDrop = 31;
            daysForDropOff = dropOff;
        } else if (monthDrop.equals("february")){
                System.out.print("Year: ");
                year = scan.nextInt();
                
                if ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0)){
                    daysOfMonthDrop = 29;
                } else {
                    daysOfMonthDrop = 28;
                }
                daysForDropOff = dropOff;
        } else if (monthDrop.equals("april") || monthDrop.equals("june") || monthDrop.equals("september") ||
            monthDrop.equals("november")){
                daysOfMonthDrop = 30;
                daysForDropOff = dropOff;
            }
    }
}
//    
//    public static void main(String[] args) {
////    • Store payment transaction history for reporting.
//
    
//     
//    System.out.println("Enter reservation number:");
//    reservationNo = scan.nextLine(); //Connect with Manu
//     if ("0000".equals(reservationNo)/*Manu*/){
//         //Present the reservtion details from Manu's code. or call method
//         //this are just a sample code, the final code for this section is from manu
//        System.out.println("Enter Month:");
//        month = scan.nextLine().toLowerCase();
//        System.out.println("Enter Pick Up Date:");
//        pickupDate = scan.nextInt();
//        System.out.println("Enter Drop Off Date:");
//        dropOffDate = scan.nextInt();
//        months (month);
//        
//        System.out.println("Confirmed (y/n):");
//         
//        if ("active".equalsIgnoreCase(reservationStatus)){
//             generateInvoice(ratePerDay, penaltyRate, paymentStatus, dropOffDate, pickupDate,
//                     actualReturnDate, expectedReturnDate, cleaningFee, damageFee);
//             
//            System.out.println("Reservation Number: "+reservationNo);
//            System.out.println("Customer Name: ");
//            System.out.println("Vehicle: ");
//            System.out.println("Days Rented: "+daysRented);
//            System.out.println("Daily Rate: "+ratePerDay);
//            System.out.println("Extra Fees: "+(cleaningFee+damageFee));
//            System.out.println("Initial Amount: "+subTotal);
//            System.out.println("Tax: "+tax);
//            System.out.println("Total Amount: "+finalTotal);
//        } else {
//             System.out.println("Exit.");
//        }
//     } else {
//         System.out.println("Reservation number is not recorded. Please try again!");
//     }
//    
//    }
//    
//    
//    public static void generateInvoice ( int dailyRate, int penRate, String statusPaid, 
//            int dropOff, int pickup, int actualReturn, int expectedReturn, int cleanFee, double damFee){
//        int cost, extraDays, latePenalty;
//        double extraCharge;
//        //Formulas
//        cost = dailyRate*daysRented;
//        extraDays = actualReturn - expectedReturn;
//        latePenalty = extraDays*penRate;
//        extraCharge = damFee + cleanFee;
//        subTotal = cost + latePenalty + extraCharge;
//        tax = subTotal*0.12;
//        finalTotal = subTotal + taxf;
//    }    

