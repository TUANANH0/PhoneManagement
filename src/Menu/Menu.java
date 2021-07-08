/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;
import phone.PhoneList;

/**
 *
 * @author Tuan
 */
public class Menu {

    public static void main(String[] args) {
        // TODO code application logic here

        String fName = "phone.txt";
        String filename = "phones.txt";
        System.out.println("Welcom HKT Stone - @2021");
        System.out.println("1. Add a phone\n" + "2. Search a phone by model\n"
                + "3. Remove the phone by model\n" + "4. Print the phone list in the descending order of model\n"
                + "5. Store phone list to text file\n" + "6.Quit");

        Scanner sc = new Scanner(System.in);
        int choice;
        PhoneList pl = new PhoneList();
        pl.loadFromFile(fName);

        do {

            System.out.print("Enter a number: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    pl.addPhones();
                    break;
                case 2: {
                    System.out.print("Model want to find: ");
                    String fModel = sc.nextLine();
                    pl.findPhone(fModel);
                    /*if (pl.findPhone(fModel) == null) {
                        System.out.println("No results were found");
                    } else {
                        System.out.println(pl.findPhone(fModel));
                    }*/
                    break;
                }
                case 3: {
                    System.out.print("Model want to remove: ");
                    String fModel = sc.nextLine();
                    pl.removePhone(fModel);
                    break;
                }
                case 4: {

                    pl.printPhone();
                    break;
                }
                case 5: {
                    pl.writeToFile(filename);
                    break;
                }

                default:
                    System.out.println("End game!");
            }
        } while (choice >= 1 && choice
                <= 5);
    }
}
