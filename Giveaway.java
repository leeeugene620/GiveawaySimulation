//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

/**
 * Does a simulation of a giveaway
 *
 * @author Eugene Lee
 * @version 11.0.4
 */
public class Giveaway {
    private static String[][] inventory = new String[5][5];

    /**
     * Checks if the inventory is empty
     *
     * @return if the inventory is empty or not
     */
    public static boolean inventoryCheck() {
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                if (inventory[i][j].equals("x")) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints out the inventory
     *
     * @return prints out the inventory
     */
    public static String inventoryPrint() {
        String newLine = "\n|";
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                newLine += inventory[i][j] + "|";
            }
            if (i < inventory.length - 1) {
                newLine += "\n|";
            }
        }
        newLine += "\n";
        return newLine;
    }

    public static void main(String[] args) {
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory.length; j++) {
                if (i == 0 && j == 2) {
                    inventory[i][j] = "StuffedPython";
                } else if (i == 0 && j == 4) {
                    inventory[i][j] = "CSalt";
                } else if (i == 1 && j == 0) {
                    inventory[i][j] = "hAIrspray";
                } else if (i == 2 && j == 3) {
                    inventory[i][j] = "JavaBeans";
                } else if (i == 3 && j == 1) {
                    inventory[i][j] = "RustedMetal";
                } else if (i == 3 && j == 2) {
                    inventory[i][j] = "SwiftShoes";
                } else if (i == 4 && j == 0) {
                    inventory[i][j] = "FuRniture";
                } else if (i == 4 && j == 3) {
                    inventory[i][j] = "GroovyGear";
                } else if (i == 4 && j == 4) {
                    inventory[i][j] = "RadiantRuby";
                } else {
                    inventory[i][j] = "x";
                }
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the 1331 Giveaway!");
        while (inventoryCheck()) {
            System.out.println("\nWould you like to take an item? [Y]es, [N]o, or [E]xit");
            String userChoice = input.nextLine();
            if (userChoice.equals("N")) {
                System.out.println("Next person in line!");
                continue;
            } else if (userChoice.toLowerCase().equals("y")) {
                System.out.println(inventoryPrint());
                Boolean j = false;
                while (!j) {
                    System.out.println("What item are you interested in taking?");
                    String itemChoice = input.nextLine();
                    String[] itemChoiceArr = itemChoice.split(" ");
                    int arr1 = Integer.parseInt(itemChoiceArr[0]);
                    int arr2 = Integer.parseInt(itemChoiceArr[1]);
                    Boolean i = false;
                    while (!i) {
                        try {
                            String itemName = inventory[arr1][arr2];
                            if (inventory[arr1][arr2].equals("x")) {
                                System.out.println("\nThere is no item in this location.\n");
                                i = true;
                            } else if (inventory[arr1][arr2].equals(itemName)) {
                                System.out.printf("\nYou successfully took the %s!%n", itemName);
                                inventory[arr1][arr2] = "x";
                                System.out.print(inventoryPrint());
                                i = true;
                                j = true;

                            }
                        } catch (Exception indexOutOfRangeException) {
                            System.out.println("\nLocation does not exist.\n");
                            i = true;
                        }
                    }
                }
            } else if (userChoice.equals("E")) {
                System.out.println("Have a good day!");
                break;
            } else {
                System.out.println("\nPlease input 'Y', 'N', or 'E'.");
            }
        }
        if (!inventoryCheck()) {
            System.out.print("\nSorry, we have no more items!");
        }
    }

}