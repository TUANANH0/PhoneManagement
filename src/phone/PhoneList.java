/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Tuan
 */
public class PhoneList {

    ArrayList<Phones> list;
    Scanner sc = new Scanner(System.in);

    public PhoneList() {
        list = new ArrayList();
    }

    public ArrayList<Phones> getList() {
        return list;
    }

    public void setList(ArrayList<Phones> list) {
        this.list = list;
    }

    public void addPhones() {
        String model, cpu, color, brand;
        int ram;
        double primaryCamera, screenSize, price;
        boolean duplicated;
        do {
            System.out.print("Model: ");
            model = sc.nextLine();

            model = model.trim().toUpperCase();
            duplicated = (this.findPhone(model) != null);
            if (duplicated) {
                System.out.println("Model is duplicated");
            }
        } while (duplicated);
        System.out.print("CPU: ");
        cpu = sc.nextLine().trim().toUpperCase();

        System.out.print("Color: ");
        color = sc.nextLine().trim().toUpperCase();

        System.out.print("Brand: ");
        brand = sc.nextLine().trim().toUpperCase();

        System.out.print("Ram: ");
        ram = Integer.parseInt(sc.nextLine());

        System.out.print("Primary Camera: ");
        primaryCamera = sc.nextDouble();

        System.out.print("Screen Size: ");
        screenSize = sc.nextDouble();

        System.out.print("Price: ");
        price = sc.nextDouble();
        sc.nextLine();
        Phones newPhone;
        newPhone = new Phones(model, cpu, color, brand, ram, primaryCamera, screenSize, price);

        if (newPhone != null) {
            list.add(newPhone);
            System.out.println("Add successed");
        }

    }

    /* public Phones findPhone(String model) {
        model = model.trim().toUpperCase();
        for (Phones phone : list) {
            if (phone.getModel().equals(model)) {
                return phone;
            }
        }
        return null;
    }*/
    public Phones findPhone(String model) {
        model = model.trim().toUpperCase();
       // List<Phones> ls = new ArrayList();
        for (Phones phone : list) {
            if (phone.getModel().contains(model)) {
                System.out.println(phone);
            } 
        }
        return null;
    }

    public boolean removePhone(String model) {
        Phones phone = findPhone(model);
        if (phone != null) {
            System.out.println("Are you sure you want to remove? ");
            char x = sc.next().charAt(0);
            if (x == 'y') {
                list.remove(phone);
                System.out.println("Delete successfully");
            } else {
                System.out.println("Phone has not been removed");
            }
        } else {
            System.out.println("delete not successfully");
        }
        sc.nextLine();
        return false;
    }

    public void printPhone() {
        Collections.sort(list, (Phones p1, Phones p2) -> p1.getModel().compareTo(p2.getModel()));
        for (Phones phone : list) {
            System.out.println(phone);
        }
    }

    public boolean writeToFile(String fName) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(fName);
            pw = new PrintWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i));
                pw.flush();
            }
            System.out.println("Writing file: DONE.");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void loadFromFile(String fName) {
        FileReader fr = null;
        BufferedReader bf = null;
        String line = "";
        StringTokenizer stk = null;
        try {
            fr = new FileReader(fName);
            bf = new BufferedReader(fr);
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0 && !line.startsWith("//")) {
                    stk = new StringTokenizer(line, ";");
                    String model = stk.nextToken();
                    String cpu = stk.nextToken();
                    String color = stk.nextToken();
                    String brand = stk.nextToken();
                    int ram = Integer.parseInt(stk.nextToken());
                    double primaryCamera = Double.parseDouble(stk.nextToken());
                    double screenSize = Double.parseDouble(stk.nextToken());
                    double price = Double.parseDouble(stk.nextToken());
                    Phones phone = new Phones(model, cpu, color, brand, ram, primaryCamera, screenSize, price);
                    list.add(phone);
                }
            }

            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
