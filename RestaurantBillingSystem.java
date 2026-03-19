import java.util.*;

public class RestaurantBillingSystem 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Pizza", 200));
        menu.add(new MenuItem("Burger", 120));
        menu.add(new MenuItem("Pasta", 150));
        menu.add(new MenuItem("Coffee", 80));

        ArrayList<OrderItem> orderList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n----- RESTAURANT MENU -----");
            for (int i = 0; i < menu.size(); i++) 
            {
                System.out.println((i + 1) + ". " + menu.get(i).name + " - ₹" + menu.get(i).price);
            }
            System.out.println((menu.size() + 1) + ". Generate Bill");
            System.out.println((menu.size() + 2) + ". Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= menu.size()) 
            {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                orderList.add(new OrderItem(menu.get(choice - 1), qty));
                System.out.println("Item added successfully!");
            }

            else if (choice == menu.size() + 1) 
            {
                generateBill(orderList);
            }

        } while (choice != menu.size() + 2);

        System.out.println("Thank you! Visit again 😊");
        sc.close();
    }

    public static void generateBill(ArrayList<OrderItem> orderList) 
    {

        double subtotal = 0;

        System.out.println("\n--------- BILL RECEIPT ---------");
        System.out.println("Item\tQty\tPrice");

        for (OrderItem order : orderList) 
        {
            double total = order.getTotal();
            subtotal += total;

            System.out.println(order.item.name + "\t" + order.quantity + "\t" + total);
        }

        double gst = subtotal * 0.05;
        double finalTotal = subtotal + gst;

        System.out.println("-------------------------------");
        System.out.println("Subtotal: ₹" + (int)subtotal);
        System.out.println("GST (5%): ₹" + (int)gst);
        System.out.println("Total: ₹" + finalTotal);
        System.out.println("-------------------------------");
    }
}