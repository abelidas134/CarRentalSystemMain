package billing;

import java.util.*;

/**
 * Car Rental Billing System - COMPLETE FIXED VERSION
 * @author Mickey (Fixed by AI Assistant)
 */
public class BillingSystemOOP {
    static Scanner scan = new Scanner(System.in);
    
    // Rental inputs
    static int daysRented, pickUp, dropOff, year;
    static String reservationNo, pickUpMonth, dropOffMonth;
    
    // Billing constants
    static int ratePerDay = 2000;
    static int penaltyRate = 600;
    static int cleaningFee = 400;
    static double damageFee = ratePerDay * 0.50; // 50% of daily rate
    
    // Billing variables
    static double finalTotal, tax, subTotal;
    static int actualReturnDate = 0, expectedReturnDate = 0;
    static String paymentStatus = "paid";
    
    // Month validation
    static int daysOfMonthPick = 0, daysOfMonthDrop = 0;
    
    public static void main(String[] args) {
        System.out.print("Enter reservation number: ");
        reservationNo = scan.nextLine();
        
        if (reservationNo.equals("0000")) { // Demo reservation
            getRentalDates();
            int rentalDays = monthsPick(pickUpMonth, dropOffMonth);
            System.out.println("Rental Days: " + rentalDays);
            
            reservationStatus();
        } else {
            System.out.println("❌ Reservation number not found. Try again!");
        }
        scan.close();
    }
    
    /**
     * Get pick-up and drop-off dates from user
     */
    public static void getRentalDates() {
        System.out.print("Pick-up Month: ");
        pickUpMonth = scan.nextLine().toLowerCase();
        System.out.print("Pick-up Day: ");
        pickUp = scan.nextInt();
        scan.nextLine(); // Clear buffer
        
        System.out.print("Drop-off Month: ");
        dropOffMonth = scan.nextLine().toLowerCase();
        System.out.print("Drop-off Day: ");
        dropOff = scan.nextInt();
    }
    
    /**
     * Validate months and calculate rental days
     * @return total rental days
     */
    public static int monthsPick(String monthPick, String monthDrop) {
        // ✅ VALIDATE PICK-UP MONTH & DAY
        daysOfMonthPick = getDaysInMonth(monthPick);
        if (pickUp < 1 || pickUp > daysOfMonthPick) {
            System.out.println("❌ Invalid pick-up day for " + monthPick + "!");
            System.exit(1);
        }
        
        // ✅ VALIDATE DROP-OFF MONTH & DAY  
        daysOfMonthDrop = getDaysInMonth(monthDrop);
        if (dropOff < 1 || dropOff > daysOfMonthDrop) {
            System.out.println("❌ Invalid drop-off day for " + monthDrop + "!");
            System.exit(1);
        }
        
        // ✅ CORRECT RENTAL DAYS: dropOff - pickUp + 1 (inclusive)
        daysRented = dropOff - pickUp + 1;
        
        if (daysRented < 1) {
            System.out.println("❌ Drop-off must be after pick-up!");
            System.exit(1);
        }
        
        System.out.println("✅ Valid rental: " + pickUp + "-" + dropOff + " (" + daysRented + " days)");
        return daysRented;
    }
    
    /**
     * Get number of days in a month (handles leap year)
     */
    public static int getDaysInMonth(String month) {
        switch (month) {
            case "january": case "march": case "may": case "july":
            case "august": case "october": case "december":
                return 31;
            case "april": case "june": case "september": case "november":
                return 30;
            case "february":
                System.out.print("Year for February: ");
                year = scan.nextInt();
                return isLeapYear(year) ? 29 : 28;
            default:
                System.out.println("❌ Invalid month: " + month);
                System.exit(1);
                return 0; // Unreachable
        }
    }
    
    /**
     * Check if year is leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Process reservation based on status
     */
    public static void reservationStatus() {
        String rStatus = "active"; // From reservation database
        
        switch (rStatus) {
            case "active":
            case "completed":
                System.out.println("\n📋 Reservation Status: " + rStatus.toUpperCase());
                calculateBill();
                generateInvoice();
                break;
            case "cancelled":
                System.out.println("❌ Reservation Status: Cancelled");
                System.out.println("Thank you for trying with us!");
                break;
            default:
                System.out.println("❓ Unknown reservation status");
                break;
        }
    }
    
    /**
     * Calculate complete bill with all fees
     */
    public static void calculateBill() {
        // ✅ DAILY RENTAL COST
        int rentalCost = ratePerDay * daysRented;
        
        // ✅ LATE RETURN PENALTY (if applicable)
        int extraDays = Math.max(0, actualReturnDate - expectedReturnDate);
        int latePenalty = extraDays * penaltyRate;
        
        // ✅ FIXED FEES
        double extraFees = cleaningFee + damageFee;
        
        // ✅ TOTALS
        subTotal = rentalCost + latePenalty + extraFees;
        tax = subTotal * 0.12;  // 12% tax
        finalTotal = subTotal + tax;
    }
    
    /**
     * Print professional invoice
     */
    public static void generateInvoice() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("                    CAR RENTAL INVOICE");
        System.out.println("═".repeat(50));
        System.out.println("Reservation #: " + reservationNo);
        System.out.println("Pick-up: " + pickUp + " " + pickUpMonth);
        System.out.println("Drop-off: " + dropOff + " " + dropOffMonth);
        System.out.println("Days Rented: " + daysRented);
        System.out.println();
        System.out.println("BREAKDOWN:");
        System.out.printf("  Rental Cost (%d days × ₱%,-8d): ₱%,-10.2f%n", 
                         daysRented, ratePerDay, (double)ratePerDay * daysRented);
        System.out.printf("  Cleaning Fee:                  ₱%,-10.2f%n", (double)cleaningFee);
        System.out.printf("  Damage Fee:                    ₱%,-10.2f%n", damageFee);
        System.out.printf("  Late Penalty:                  ₱%,-10.2f%n", (double)(actualReturnDate - expectedReturnDate) * penaltyRate);
        System.out.println("─".repeat(50));
        System.out.printf("  SUBTOTAL:                      ₱%,-10.2f%n", subTotal);
        System.out.printf("  TAX (12%%):                     ₱%,-10.2f%n", tax);
        System.out.println("═".repeat(50));
        System.out.printf("  TOTAL AMOUNT:                  ₱%,-10.2f%n", finalTotal);
        System.out.println("═".repeat(50));
        System.out.println("Payment Status: " + paymentStatus.toUpperCase());
    }
}