//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            displayList();
            String choice = SafeInput.getRegExString(scanner, "\nChoose an option (A - Add, D - Delete, I - Insert, P - Print, Q - Quit): ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(scanner, "Are you sure you want to quit (Y/N)? ");
                    break;
            }
        }
        System.out.println("Goodbye!");
    }

    private static void displayList() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        list.add(item);
        System.out.println("Item added to the list.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        displayList();
        int index = SafeInput.getRangedInt(scanner, "Enter item number to delete", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted from the list.");
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty. Adding item at the start.");
            addItem();
            return;
        }
        displayList();
        int index = SafeInput.getRangedInt(scanner, "Enter position to insert item", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to insert");
        list.add(index, item);
        System.out.println("Item inserted in the list.");
    }

    private static void printList() {
        displayList();
    }
}
