package user;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Bill {
    public User user;
    public float amount;
    public LocalDate dueDate;

    //setter method
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Getter method for due date
    public LocalDate getDueDate() {
        return dueDate;
    }


    // Constructor
    public Bill(User user, float amount, LocalDate dueDate) {
        this.user = user;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // Prompt user for late fee and display
    public static void promptForLateFee(Bill bill) {
        float lateFee = bill.calculateLateFee();
        long daysOverdue = bill.calculateDaysOverdue();

        System.out.println("This bill is " + daysOverdue + " days overdue.");
        System.out.println("Late fee for this bill is: $" + lateFee);
    }

    // Calculate number of days overdue
    public long calculateDaysOverdue() {
        LocalDate currentDate = LocalDate.now();
        return ChronoUnit.DAYS.between(dueDate, currentDate);
    }

    // Abstract method to calculate the late fee
    public abstract float calculateLateFee();
}