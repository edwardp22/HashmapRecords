import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> records = new HashMap<String, String>();
        int menuOption = 0;

        while (menuOption != 6) {
            printMenu();

            while (!input.hasNextInt()) {
                System.out.println("Invalid option");
                input.next();
            }

            menuOption = input.nextInt();
            input.nextLine();

            if (menuOption == 1) {
                //Add method
            }
            else if (menuOption == 2) {
                //Delete
            }
            else if (menuOption == 3) {
                //Display person
                displayPerson(records);
            }
            else if (menuOption == 4) {
                //Display all
                viewAll(records);
            }
            else if (menuOption == 5) {
                //Edit
            }
        }
    }

    public static void printMenu() {
        System.out.println("Choose from the following option by entering the number");
        System.out.println("1: Add a person");
        System.out.println("2: Delete a person");
        System.out.println("3: Display a person tel no");
        System.out.println("4: View all");
        System.out.println("5: Edit a person tel number");
        System.out.println("6: Exit");
    }

    public static void viewAll(HashMap<String, String> records) {
        for (Map.Entry<String, String> entry: records.entrySet()) {
            System.out.print("Name " + entry.getKey());
            System.out.print("Tel no " + entry.getValue());
        }
    }

    public static void displayPerson(HashMap<String, String> records) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the person ");
        String name = input.nextLine();

        System.out.println("The telefone number is " + records.get(name));
    }
}