package Soda_Machine;

import java.util.Scanner;

public class SodaMachine {

    // data members
    private double balance;
    private Product[] stock;
    private Scanner scan;

    //constructor
    public SodaMachine() {

        this.scan = new Scanner(System.in);

        this.stock = new Product[3];
        this.balance = 0;
        this.stock[0] = new Product("Dr Pepper", 5, 1.29);
        this.stock[1] = new Product("Snapple", 5, 1.49);
        this.stock[2] = new Product("Water", 5, 0.99);

    }

    public void insertCoin() {

        while (true) {
            System.out.print("Please enter amount deposited:");
            double x = this.scan.nextDouble();
            if (x > 0) {
                this.balance += x;
                return;
            } else {
                System.out.println("Invalid input ammount.");
            }
        }

    }

    public boolean buy() {

        for (int i = 0; i < this.stock.length; i++) {
            if (this.stock[i].getQuantity() > 0)
                System.out.print(" " + i + ") ");
            System.out.println(this.stock[i]);
        }
        System.out.print("Please select item (1-" + this.stock.length + "):");
        int x = this.scan.nextInt();

        if (this.stock[x].getQuantity() <= 0) {
            System.out.println("Sorry, we do not have any more "
                    + this.stock[x].getName() + ".");
            return false;
        }
        if (this.stock[x].getPrice() > this.balance) {
            System.out.println("Sorry, you do not have enoough money. "
                    + this.stock[x].getName() + ".");
            return false;
        }

        System.out.println("Enjoy your " + this.stock[x].getName() + "!\n");
        this.stock[x].purchase();
        this.balance = this.balance - this.stock[x].getPrice();
        return true;
    }

    public void getChange() {
        System.out.printf("Please find %5.2f in the coin return.\n", this.balance);
        System.out.println("\nWelcome to Soda Macine 2.0");
        this.balance = 0;

    }

    public int getMenuOption() {
        System.out.println(" 1) Deposit Coin");
        System.out.println(" 2) Buy Drink");
        System.out.println(" 3) Get Change");
        System.out.println(" 4) Print Inventory");
        System.out.printf("Your balance is $%5.2f\n", this.balance);
        System.out.print("What would you like to do? (1-4):");
        int x = this.scan.nextInt();
        return x;
    }

    public String toString() {
        String s = "Soda Machine:\n";
        for (int i = 0; i < this.stock.length; i++) {
            s += "  " + this.stock[i].toString() + "\n";
        }
        return s;
    }

    public void run() {
        System.out.println("\nWelcome to Soda Machine 2.0");

        while (true) {
            int option = this.getMenuOption();
            if (option == 1) {
                this.insertCoin();
            } else if (option == 2) {
                this.buy();
            } else if (option == 3) {
                this.getChange();
            } else if (option == 4) {
                System.out.print(this);
            } else if (option == -1) {
                System.out.println("*** Shutting Down Soda Machine ***");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    public static void main(String[] args) {

        SodaMachine sm = new SodaMachine();
        sm.run();

    }

}