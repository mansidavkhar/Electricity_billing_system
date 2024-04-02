package user;
import java.util.Scanner;

public class ResidentialUser extends User {
    // Additional attributes of type of user


    public ResidentialUser(String name, long EYC, String address, String email, long aadharNo, float noOfUnits, String Type_of_user) {
        super(name, EYC, address, email, aadharNo, noOfUnits);
    }

    Scanner in = new Scanner(System.in);

    String Type_of_user = in.nextLine();

    //setter
    public void setType_of_user(String Type_of_user) {
        this.Type_of_user = Type_of_user;
    }

    //getter
    public String getType_of_user() {
        return Type_of_user;
    }


    @Override
    public float billed_amount_domestic() {

        return super.billed_amount_domestic();
    }

}