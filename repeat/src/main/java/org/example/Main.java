package org.example;
import java.util.*;

// Import the User class
import user.User;
import user.ResidentialUser;

//import for admin_name variable
import static admin.Admin.admin_name;

//imports for exception handling
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//imports for json
import org.json.JSONArray;
import org.json.JSONObject;

//imports for gui
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static float calculateTotalUnitsConsumed(ArrayList<User> user_list) {
        float totalUnitsConsumed = 0.0f;

        // Iterate through the user_list and sum up the units consumed by each user
        for (User user : user_list) {
            totalUnitsConsumed += user.getNoOfUnits();
        }
        return totalUnitsConsumed;
    }

    // Method to calculate total bill for all users
    public static float calculateTotalBill(ArrayList<User> user_list) {
        float totalBill = 0.0f;

        // Iterate through the user_list and sum up the bills for each user
        for (User user : user_list) {
            totalBill += user.billed_amount_domestic();
        }
        return totalBill;
    }

    public static void main(String[] args) throws IOException {

        // Call the method to create and display the GUI
//        createAndShowGUI();

        //read in String
        String data = new String(Files.readAllBytes(Paths.get("./demo.json")));

        //read in json array
        JSONArray jsonArray = new JSONArray(data);
        for (int i=0 ; i < jsonArray.length() ; i++){
            //parse in json objects
            //JSONObject object = jsonArray.getJSONObject(i);
            //or
            String str = jsonArray.get(i).toString();
            JSONObject object1 = new JSONObject(str);

            String name = object1.getString("name");
            Long EYC = object1.getLong("EYC");
            String address = object1.getString("address");
            String email = object1.getString("email");
            Long aadharNo = object1.getLong("aadharNo");
            float noOfUnits = object1.getFloat("noOfUnits");

            System.out.println("Name: " + name);
            System.out.println("EYC: " + EYC);
            System.out.println("Address: " + address);
            System.out.println("Email ID: " + email);
            System.out.println("Aadhar No: " + aadharNo);
            System.out.println("No Of Units: " + noOfUnits);
        }

        Scanner in = new Scanner(System.in);

        ArrayList<User> user_list = new ArrayList<>();

        int choice;
        do {
            System.out.println("MENU: ");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.println("please select and enter one of the above options :");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("menu for user: ");
                    System.out.println("1. Add a user");
                    System.out.println("2. Display user information");
                    System.out.println("3. Calculate bill");
                    System.out.println("4. Payment");
                    System.out.println("5. Updation of user");
                    System.out.println("6. Deletion of user");
                    int choice_user = in.nextInt();

                    switch (choice_user) {
                        case 1: {
                            System.out.print("Enter the number of users you want to add: ");
                            int n = in.nextInt();
                            in.nextLine();

                            for (int i = 0; i < n; i++) {
                                System.out.println("Enter Information of " + (1 + i) + " user");

                                System.out.println("Enter type of user");
                                String Type_of_user = in.nextLine();

                                System.out.println("Enter user name: ");
                                String name = in.nextLine();

                                System.out.println("Enter 10 digit EYC number: ");
                                long EYC = in.nextLong();
                                String eyc = Long.toString(EYC);

                                //throw implementation
                                if (eyc.length() != 10) {
                                    throw new IllegalArgumentException("Invalid EYC; please enter a 9 or 10-digit EYC.");
                                }
                                in.nextLine();

                                System.out.println("Enter address: ");
                                String address = in.nextLine();

                                System.out.println("Enter email id: ");
                                String email = in.nextLine();

                                System.out.println("Enter 12 digit Aadhar number: ");
                                long aadharNo = in.nextLong();
                                in.nextLine();

                                System.out.println("Enter no. of units consumed: ");
                                float noOfUnits = in.nextFloat();
                                in.nextLine();

                                // Create ResidentialUser object with user input and Add the user to the list
                                ResidentialUser residentialUser = new ResidentialUser(name, EYC, address, email, aadharNo, noOfUnits, Type_of_user);
                                user_list.add(residentialUser);
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Following are the users:");
                            for (User user : user_list) {
                                System.out.println(user); //User class has a toString method
                            }
                            break;
                        }
                        case 3: {
                            for (User user : user_list) {
                                float billedAmount = user.billed_amount_domestic();
                                System.out.println("Billed amount for user: " + billedAmount);
                            }
                            break;
                        }
                        case 4: {
                            // Code for payment methods
                            break;
                        }
                        case 5: {
                            // Update user information
                            System.out.println("Enter the EYC number of the user to update: ");
                            int updateEYC = in.nextInt();
                            in.nextLine();
                            boolean found = false; // Find the user with the given EYC number

                            for (User user : user_list) {
                                if (user.getEYC() == updateEYC) {
                                    found = true;

                                    // Prompt user for updated information
                                    System.out.println("Enter updated user name: ");
                                    String updatedName = in.nextLine();

                                    System.out.println("Enter updated address: ");
                                    String updatedAddress = in.nextLine();

                                    System.out.println("Enter updated email id: ");
                                    String updatedEmail = in.nextLine();

                                    System.out.println("Enter updated 12 digit Aadhar number: ");
                                    long updatedAadharNo = in.nextLong();
                                    in.nextLine();

                                    System.out.println("Enter updated no. of units consumed: ");
                                    float updatedNoOfUnits = in.nextFloat();
                                    in.nextLine();

                                    // Update user information
                                    user.setName(updatedName);
                                    user.setAddress(updatedAddress);
                                    user.setEmail_id(updatedEmail);
                                    user.setAadhar_no(updatedAadharNo);
                                    user.setNo_of_units(updatedNoOfUnits);
                                    System.out.println("User information updated successfully.");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("User with EYC number " + updateEYC + " not found.");
                            }
                            break;
                        }
                        case 6: {
                            // Delete user
                            System.out.println("Enter the EYC number of the user to delete: ");
                            int deleteEYC = in.nextInt();
                            in.nextLine();
                            boolean found = false; // Find the user with the given EYC number
                            Iterator<User> iterator = user_list.iterator();
                            while (iterator.hasNext()) {
                                User user = iterator.next();
                                if (user.getEYC() == deleteEYC) {
                                    iterator.remove();
                                    found = true;
                                    System.out.println("User with EYC number " + deleteEYC + " deleted successfully.");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("User with EYC number " + deleteEYC + " not found.");
                            }
                            break;
                        }
                        default: {
                            System.out.println("Enter valid option");
                            break;
                        }
                    }
                    break;}

                    case 2: {
                    System.out.println("menu for Admin: ");
                    System.out.println("1.View Admin details");
                    System.out.println("2.View all Users");
                    System.out.println("3.View no of units consumed by all Users");
                    System.out.println("4.Calculate sum of bills of all Users");
                    System.out.println("5.Exit");

                    int choice_admin;

                    System.out.println("Enter your choice: ");
                    choice_admin = in.nextInt();
                    in.nextLine();

                    switch(choice_admin){
                        case 1 :
                            System.out.println(admin_name);
                            break;

                        case 2 :{
                            System.out.println("Following are the users:");
                            for (User user : user_list) {
                                System.out.println(user); //User class has a proper toString method
                            }
                            break;
                        }
                        case 3 :{
                            // Calculate total units consumed by all users
                            float totalUnitsConsumed = calculateTotalUnitsConsumed(user_list);
                            System.out.println("Total units consumed by all users: " + totalUnitsConsumed);
                            break;
                        }
                        case 4 :{
                            // Calculate total bill for all users
                            float totalBill = calculateTotalBill(user_list);
                            System.out.println("Total bill for all users: " + totalBill);
                            break;
                        }
                        default: {
                            System.out.println("Enter valid option");
                            break;
                        }
                    }
                    break;
                }
            }
        } while (choice != 3);
    }
}
