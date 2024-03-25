import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CoffeeShop3 {
    public static abstract class Beverage {
        protected String name;
        protected double price;

        public Beverage(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void prepare(){
            System.out.println("Preparing " + name + " coffee ");
        }
    }

    public static class Coffee extends Beverage {
        private String origin;

        public Coffee(String name, double price, String origin) {
            super(name, price);
            this.origin = origin;
        }

        public String getOrigin() {
            return origin;
        }

        public void prepare() {
            System.out.println("Preparing " + name + " coffee from " + origin);
        }
    }

    public static class Customer {
        private String name;
        private boolean isMember;
        private List<Beverage> beverages;

        public Customer(String name, boolean isMember) {
            this.name = name;
            this.isMember = isMember;
            beverages = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public boolean isMember() {
            return isMember;
        }

        public void addBeverage(Beverage beverage) {
            beverages.add(beverage);
        }

        public List<Beverage> getBeverages() {
            return beverages;
        }

        public double getTotalPrice() {
            double totalPrice = 0;
            for (Beverage beverage : beverages) {
                totalPrice += beverage.getPrice();
            }
            return totalPrice;
        }
    }


    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        System.out.println("\n=====================================================================");
        System.out.println(String.format("%43s", "JOY COFFEE SDN BHD"));
        System.out.println(String.format("%48s", "NO. 22, LEVEL 2, PARADIGM MALL"));
        System.out.println(String.format("%46s", "81200, JOHOR BAHRU, JOHOR"));
        System.out.println("=====================================================================\n");
        System.out.println("  -= Welcome to Joy Coffee Sdn Bhd Business Management System =-  \n");
        Scanner scanner = new Scanner(System.in);

        System.out.print(String.format("%35s", "Cashier Name: "));
        String cashierName = scanner.nextLine();

        System.out.print(String.format("%35s", "Cashier ID: "));
        int cashierId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("\nWelcome, " + cashierName + " (ID: " + cashierId + ")!");

        List<Customer> customers = new ArrayList<>();
        String nextCustomer = "y";
        double totalSales = 0;
        double totalDiscount = 0;
        double totalBeforeDiscount = 0;
        int totalCustomers = 0;

        for (int a = 1; a <= 10; a++) {
            while (nextCustomer.equalsIgnoreCase("y")) {
                System.out.print("\nCustomer Name: ");;
                String customerName = scanner.nextLine();

                System.out.print("Is the customer a member? (y/n): ");
                String memberStatus = scanner.nextLine();
                boolean isMember = memberStatus.equalsIgnoreCase("y");

                Customer customer = new Customer(customerName, isMember);

                System.out.println("-------------------------------------------------------");
                System.out.println("\n=====================================================================");
                System.out.println(String.format("%43s", "JOY COFEE SDN BHD"));
                System.out.println(String.format("%48s", "NO. 22, LEVEL 2, PARADIGM MALL"));
                System.out.println(String.format("%46s", "81200, JOHOR BAHRU, JOHOR"));
                System.out.println("=====================================================================\n");
                System.out.println("                       -= JOY COFFEE ITEMS =-                \n");
                System.out.println("=====================================================================");
                System.out.println("    Item Code   Item Name                                  Price");
                System.out.println("=====================================================================");
                System.out.println("       (1)      Americano                                 RM 9.50");
                System.out.println("       (2)      Iced Americano                            RM 10.50");
                System.out.println("       (3)      Cappuccino                                RM 12.00");
                System.out.println("       (4)      Hot Caffe Latte                           RM 10.50");
                System.out.println("       (5)      Iced Caffe Latte                          RM 11.50");
                System.out.println("       (6)      Hot Caramel Macchiato                     RM 13.50");
                System.out.println("       (7)      Iced Caramel Macchiato                    RM 14.50");
                System.out.println("       (8)      Iced Vanilla Latte                        RM 12.50");
                System.out.println("");



                System.out.print("Enter the number of beverages the customer wants to order: ");
                int numBeverages = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                for (int i = 0; i < numBeverages; i++) {
                    System.out.print("Enter the beverage choice (1-8): ");
                    int beverageChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Beverage beverage;
                    switch (beverageChoice) {
                        case 1:
                            beverage = new Coffee("Americano", 9.50, "Colombia");
                            break;
                        case 2:
                            beverage = new Coffee("Iced Americano", 10.50, "Colombia");
                            break;
                        case 3:
                            beverage = new Coffee("Cappuccino", 12.00, "Italy");
                            break;
                        case 4:
                            beverage = new Coffee("Hot Caffe Latte", 10.50, "Brazil");
                            break;
                        case 5:
                            beverage = new Coffee("Iced Caffe Latte", 11.50, "Brazil");
                            break;
                        case 6:
                            beverage = new Coffee("Hot Caramel Macchiato", 13.50, "Spain");
                            break;
                        case 7:
                            beverage = new Coffee("Iced Caramel Macchiato", 14.50, "Spain");
                            break;
                        case 8:
                            beverage = new Coffee("Iced Vanilla Latte", 12.50, "France");
                            break;
                        default:
                            System.out.println("Invalid beverage choice. Skipping...");
                            continue;
                    }

                    customer.addBeverage(beverage);
                    beverage.prepare();
                }

                double totalAmount = customer.getTotalPrice();

                double discount = 0;
                if (customer.isMember()) {
                    discount = totalAmount * 0.1;
                }
                double amountAfterDiscount = totalAmount - discount;

                System.out.println("\n=========================================================");
                System.out.println("   Customer Name       : " + customer.getName());
                System.out.println("   Total Item          : " + numBeverages);
                System.out.println("   Total Price Before  : RM " + String.format("%.2f", totalAmount));
                System.out.println("   Discount            : RM " + String.format("%.2f", discount));
                System.out.println("=========================================================");
                System.out.println("   Total Price         : RM " + String.format("%.2f", amountAfterDiscount));
                System.out.println("=========================================================");


                System.out.print("\nYour Cash              : RM ");
                double paymentAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character

                while (paymentAmount < amountAfterDiscount) {
                    System.out.println("");
                    System.out.println("Insufficient payment amount.");
                    System.out.println("Please enter the correct amount.");
                    System.out.print("\nYour Cash              : RM ");
                    paymentAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                }

                double change = paymentAmount - amountAfterDiscount;

                System.out.println("Balance                : RM " + df.format(change));;
                System.out.println("Enjoy your coffee, " + customer.getName() + "!\n");

                customers.add(customer);
                totalSales += amountAfterDiscount;
                totalDiscount += discount;
                totalBeforeDiscount = totalDiscount + totalSales;

                totalCustomers++;

                System.out.print("Next customer? (y/n): ");
                nextCustomer = scanner.nextLine();
            }
        }

        System.out.print("\nDo you want to view total customers and sales? (y/n): ");
        String viewOption = scanner.nextLine();
        if (viewOption.equalsIgnoreCase("y")) {
            System.out.println("\n=====================================================================");
            System.out.println(String.format("%43s", "JOY COFEE SDN BHD"));
            System.out.println(String.format("%48s", "NO. 22, LEVEL 2, PARADIGM MALL"));
            System.out.println(String.format("%46s", "81200, JOHOR BAHRU, JOHOR"));
            System.out.println("=====================================================================\n");
            System.out.println("                       -= JOY COFFEE SALES =-                \n");
            System.out.println("=====================================================================");
            System.out.println("   Total Customers:    : " + totalCustomers);
            System.out.println("   Total Sales         : RM " + df.format(totalSales));
            System.out.println("   Total Discount      : RM " + df.format(totalDiscount));
            System.out.println("   Gross Sales         : RM " + df.format(totalBeforeDiscount));
            System.out.println("=====================================================================\n");


            System.out.println("=====================================================================\n");
            System.out.println("                       -= Customer Orders =-                \n");
            System.out.println("=====================================================================");

            if (customers.isEmpty()) {
                System.out.println("No customers.");
            } else {
                for (Customer customer : customers) {
                    System.out.println("");
                    System.out.println("=========================================================");
                    System.out.println("   Customer Name       : " + customer.getName());
                    System.out.println("   Membership          : " + (customer.isMember() ? "Member" : "Non-Member"));
                    System.out.println("=========================================================");
                    System.out.println("   Orders               ");
                    List<Beverage> beverages = customer.getBeverages();
                    if (beverages.isEmpty()) {
                        System.out.println("No orders.");
                    } else {
                        for (Beverage beverage : beverages) {
                            System.out.println("- " + beverage.getName() + " (" + beverage.getClass().getSimpleName() + ")");
                        }
                    }
                    System.out.println("=========================================================");
                    System.out.println("   Total Price         : RM " + String.format("%.2f",customer.getTotalPrice()));
                    System.out.println("=========================================================");

                }
            }
        }

        System.out.println("\nProgram terminated. Thank you for purchasing with Joy Coffee Sdn Bhd Business Management System.");

        scanner.close();
    }
}

//IZZAT HAQEEMI BIN HAIRUDIN
//MUHAMMAD HARITH HAKIM BIN OTHMAN
//ALIEYA ZAWANIE BINTI A ZAINI
//UMAR HAZIQ BIN MUHAMAD NORHISHAM  
