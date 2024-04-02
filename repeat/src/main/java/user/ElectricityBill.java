package user;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ElectricityBill extends Bill {
    // Constructor
    public ElectricityBill(User user, float amount, LocalDate dueDate) {
        super(user, amount, dueDate);
    }

    // Implementation of calculateLateFee method specific to electricity bills
    @Override
    public float calculateLateFee() {
        // Implementation for calculating late fee for electricity bills
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the number of days overdue
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);

        // Late fee rate per day (adjust as needed)
        float lateFeeRatePerDay = 0.50f;

        // Calculate the late fee
        float lateFee = Math.max(0, daysOverdue) * lateFeeRatePerDay;

        return lateFee;
//        In this implementation:
//
//        We first calculate the number of days overdue by subtracting the due date from the current date using ChronoUnit.DAYS.between.
//        We define a late fee rate per day (e.g., $0.50) using the lateFeeRatePerDay variable.
//        We calculate the late fee by multiplying the number of days overdue by the late fee rate per day.
//        The Math.max(0, daysOverdue) ensures that the late fee is not negative.
//        The calculateLateFee method is overridden in the ElectricityBill class, providing a specific implementation for electricity bills.
//        Similar implementations can be provided for other types of bills, adjusting the late fee rate or logic as needed.

    }

}