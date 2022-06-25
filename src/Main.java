import java.util.*;
import java.util.stream.Collectors;

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
                HashmapAdd(records);
            }
            else if (menuOption == 2) {
                //Delete
                HashDelete(records);
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
                HashmapEdit(records);
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
        Map<String, String> sorteArr = records.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, String> entry: sorteArr.entrySet()) {
            System.out.println("Name " + entry.getKey());
            System.out.println("Tel no " + entry.getValue());
        }

        if (records.isEmpty()) {
            System.out.println("No records yet");
        }
    }

    public static void displayPerson(HashMap<String, String> records) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the person ");
        String name = input.nextLine();

        if (records.get(name) == null) {
            System.out.println("The record is not existing");
        }
        else {
        System.out.println("The telephone number is " + records.get(name));}
    }

    public static void HashmapAdd(HashMap<String, String> person){
        String name = "";
        String tel = "";
        Scanner ac = new Scanner(System.in);

        System.out.println("Enter the name of the person");
        name = ac.nextLine();

        if(person.containsKey(name)){
            System.out.println("The record is existing");
        }
        else {
            System.out.println("Enter the tel number");
            tel = ac.nextLine();

            person.put(name, tel);

            System.out.println("One record added");
        }
    }

    public static void HashDelete(HashMap<String, String> person){
        String name = "";
        String tel = "";
        Scanner ac = new Scanner(System.in);
        System.out.println("Enter the name of the person you want to delete");
        name = ac.nextLine();

        if(!person.containsKey(name)){
            System.out.println("The record is not existing");
        }
        else {
            person.remove(name);

            System.out.println("The record is deleted");
        }
    }

    public static void HashmapEdit(HashMap<String, String> person){
        String name = "";
        String tel = "";
        Scanner ac = new Scanner(System.in);

        System.out.println("Enter the name of the person");
        name = ac.nextLine();

        if(!person.containsKey(name)){
            System.out.println("The record is not existing");
        }
        else {
            System.out.println("Enter the tel number");
            tel = ac.nextLine();

            person.replace(name, tel);

            System.out.println("One record edit");
        }
    }
}