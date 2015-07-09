package org.example.java.driver.mongodb;

import org.example.java.driver.mongodb.dao.ICustomerDao;
import org.example.java.driver.mongodb.dao.impl.CustomerDao;
import org.example.java.driver.mongodb.entity.Address;
import org.example.java.driver.mongodb.entity.Customer;

/**
 * Hello world!
 *
 */
public class MongoJavaDriverSampleApp {

    private static final ICustomerDao customerDao = new CustomerDao();

    public static void main(String[] args) {
        customerDao.deleteAll();

        customerDao.save(new Customer("Alice", "Smith", null, 19));
        customerDao.save(new Customer("Alice", "Jones", null, 26));
        customerDao.save(new Customer("Bob", "Smith", new Address("Zlota", 22, "00-020", "Warszawa"), 30));
        customerDao.save(new Customer("Alice", "Brown", null, 80));
        customerDao.save(new Customer("Alice", "Smedley", null, 52));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerDao.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        customerDao.close();
    }
}
