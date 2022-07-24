import java.util.Scanner;
import java.util.*;

public class javaPracticalTest{
    public static void main(String[] args){
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>();
        Hashtable<Integer, Double> ht3 = new Hashtable<>();
        Hashtable<Integer, Double> ht4 = new Hashtable<>();

        Product firstProduct = new Product();
        firstProduct.data(726378, "Laptop", 1750.99);
        ht1.put(726378, "Laptop");
        ht4.put(726378,1750.99);

        Product secondProduct = new Product();
        secondProduct.data(726389, "Headphones", 49.99);
        ht1.put(726389, "Headphones");
        ht4.put(726389,49.99);

        Product thirdProduct = new Product();
        thirdProduct.data(726397, "Phone", 990.99);
        ht1.put(726397, "Phone");
        ht4.put(726397,990.99);

        User firstUser = new User();
        firstUser.data(135791, "Ann", "Brown", 2500);
        ht2.put(135791, "Ann");
        ht3.put(135791, 2500.0);

        User secondUser = new User();
        secondUser.data(135745, "Bob", "Winston", 75);
        ht2.put(135745, "Bob");
        ht3.put(135745, 75.5);

        User thirdUser = new User();
        thirdUser.data(135769, "Katherine", "Walker", 2000);
        ht2.put(135769, "Katherine");
        ht3.put(135769, 2000.0);

        Hashtable<Integer, String> ht5 = new Hashtable<>();
        Hashtable<Integer, String> ht6 = new Hashtable<>();

        Scanner in = new Scanner(System.in);
        int num;
        do {
            System.out.println("\nMENU (enter number)\n 1 - Display list of all users\n 2 - Display list of all products\n 3 - Buy product\n 4 - Display list of user products by user id\n 5 - Display list of users that bought product by product id");
            num = in.nextInt();
            switch (num) {
                case 1:
                    firstUser.displayData();
                    secondUser.displayData();
                    thirdUser.displayData();
                    break;
                case 2:
                    firstProduct.displayData();
                    secondProduct.displayData();
                    thirdProduct.displayData();
                    break;
                case 3:
                    System.out.print("Enter user id: ");
                    int userIdCase3 = in.nextInt();
                    double amountOfMoney = ht3.get(userIdCase3);
                    System.out.print("\nEnter id of product you want to buy: ");
                    int productIdCase3 = in.nextInt();
                    double productPrice = ht4.get(productIdCase3);
                    if (productPrice <= amountOfMoney) {
                        amountOfMoney -= productPrice;
                        System.out.println("Successfully bought " + ht1.get(productIdCase3) + ". " + ht2.get(userIdCase3) + "`s balance is now " + amountOfMoney + ".");
                        ht5.put(userIdCase3,ht1.get(productIdCase3));
                        ht6.put(productIdCase3, ht2.get(userIdCase3));
                    } else
                        System.out.println("Not enough money.");
                    break;
                case 4:
                    System.out.print("Enter user id: ");
                    int userIdCase4 = in.nextInt();
                    if (ht5.containsKey(userIdCase4)){
                        System.out.println(userIdCase4 + "`s products: " + ht5.get(userIdCase4));
                    }
                    else{
                        System.out.println("No products found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter product id: ");
                    int productIdCase5 = in.nextInt();
                    if(ht6.containsKey(productIdCase5)){
                        System.out.println(productIdCase5 + " was bought by " + ht6.get(productIdCase5));
                    }
                    else
                        System.out.println("No users found.");
                    break;
                default:
                    System.out.println("Wrong option.");
                    break;
            }
        } while (num >= 1 && num <= 5);
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    public void data(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void displayData() {
        System.out.println("\nId: " + getId() + "\nName: " + getName() + "\nPrice: " + getPrice() );
    }
}

class User{
    private int id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;
    public void data(int id, String firstName, String lastName, double amountOfMoney){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getAmountOfMoney() { return amountOfMoney; }

    public void displayData() {
        System.out.println("\nId: "+getId()+"\nFirst name: "+getFirstName()+"\nLast name: "+getLastName()+"\nAmount of money: "+getAmountOfMoney() );
    }
}
