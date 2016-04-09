package Soda_Machine;

public class Product {

    private String name;
    private int quantity;
    private double price;

    // Constructors
    public Product(String n, int q, double p) {
        this.name = n;
        this.quantity = q;
        this.price = p;
    }

    // Accessors
    public String getName() {return this.name;}
    public int getQuantity() {return this.quantity;}
    public double getPrice() {return this.price;}

    // Mutators
    public void increaseQuantity(int amt){
        if (amt > 0){
            this.quantity += amt;
        }
    }

    public void changePrice(double newPrice){
        this.price = newPrice;
    }

    // Crucial Functions
    public boolean purchase(){
        if (this.quantity > 0){
            this.quantity--;
            return true;
        }
        return false;
    }

    // Print
    public String toString(){
        return this.name + " - $" + this.price + " (" + this.quantity + " left)";
    }

    public static void main(String[] args) {
        Product b1 = new Product("Dr. Pepper", 5, 1.25);
        b1.purchase();
        System.out.println(b1);
    }
}
