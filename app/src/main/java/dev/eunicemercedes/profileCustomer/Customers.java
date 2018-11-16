package dev.eunicemercedes.profileCustomer;

import java.util.ArrayList;

final class Customers {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

   /* public static Customer getCustomer(int index) {
        return customers.get(index);
    }
    */

    /*   public static void addCustomer(Customer  customer) {
           customers.add(customer);
       }
       */
    //String email, String password, String nombre, String telefono, String foto
    static void initCustomer() {
        customers.add(new Customer("willgarner@gmail.com", "will", "Will Garner", "809-512-8523", "will.jpg"));
        customers.add(new Customer("derek@gmail.com", "derek", "Derek Shepherd", "809-321-7436", "derek.jpg"));
        customers.add(new Customer("mariamercedes@gmail.com", "maria", "Maria Mercedes", "809-654-9578", "maria.jpg"));
        customers.add(new Customer("teresamendoza@gmail.com", "teresa", "Teresa Mendoza", "809-987-8465", "teresa.jpg"));
        customers.add(new Customer("ethanhunt@gmail.com", "ethan", "Ethan Hunt", "809-213-5132", "ethan.jpg"));
    }

    static Customer validateCustomer(String email, String password) {
        for (Customer c : customers) {
            if (c.validateCustomer(email, password)) {
                return c;
            }
        }
        return new Customer();
    }

    static boolean existsEmail(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
