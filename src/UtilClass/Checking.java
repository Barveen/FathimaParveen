package UtilClass;
import static DataSource.Main.sc;
import static DataSource.StudentFunction1.str;


public  class Checking {

    public  String isValidName(String name) {
        while (!name.matches("^[a-zA-Z\\s]{3,20}")) {
            System.out.println("invalid name");
            name = str.nextLine();
        }
        return name;
    }

    public String checkPhoneNumber(String ph_Num) {
        //Matching the given phone number with the expression
        while (!ph_Num.matches("(0/91)?[6-9][0-9]{9}")) {
            System.out.println("Invalid Phone Number");
            System.out.println("Enter the phone number(Ex: 10- digit, Start's with 7 to 9)");
            ph_Num = sc.next();

        }
        return ph_Num;
    }
//^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|[3][01])/\\d{4}$
    public String checkDOB(String dateOfBirth) {
        if (dateOfBirth.matches("^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\\\d{4}$")) {
            System.out.println("Invalid Date of Birth.. Please Enter this ( dd/mm/yyyy ) format");
            return dateOfBirth;
        }
        else
            System.out.println("Invalid Date of Birth.. Please Enter this ( dd/mm/yyyy ) format");
            dateOfBirth = sc.next();

        return dateOfBirth;
    }


    public String checkMailId(String eMailId) {
        while (!eMailId.matches("[A-Za-z0-9]+@[a-zA-Z]+.[a-z]+.*[a-z]*")) {
            System.out.println("Invalid E-MailId");
            eMailId = sc.nextLine();
        }
        return eMailId;
    }

    public String isValidPassWord(String password) {
        while (!password.matches("[a-z A-Z0-9\\\\d+!@#$%^&*()_-]{8}+")) {
            System.out.println("invalid password");
            password = sc.nextLine();
        }
        return password;
    }

    public int inputChoice(){
        String userInput;
        while(true) {
            userInput = sc.next();
            if(!(validateUserChoice(userInput))) {
                System.out.println("Invalid input");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }


    public boolean validateUserChoice(String userInput)
    {
        return userInput.matches("\\d+");
    }

}
