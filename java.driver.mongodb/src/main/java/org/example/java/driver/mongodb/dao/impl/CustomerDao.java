package org.example.java.driver.mongodb.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.example.java.driver.mongodb.dao.ICustomerDao;
import org.example.java.driver.mongodb.entity.Address;
import org.example.java.driver.mongodb.entity.Customer;

public class CustomerDao extends BaseDao<Customer>implements ICustomerDao {

    public CustomerDao() {
        super(Customer.class);
    }

    public List<Customer> findByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findTop2ByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findTop2ByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByAddressCity(String city) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByCustomersLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByAddressBuildingNumberGreaterThan(Integer builingNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Customer> findByAgeBetween(int ageFrom, int ageTo) {
        // TODO Auto-generated method stub
        return null;
    }

    public Customer findOneByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public Customer findOneByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return null;
    }

    public Customer findOneByFirstNameAndLastName(String firstName, String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    public long countByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return 0;
    }

    public long countByLastName(String lastName) {
        // TODO Auto-generated method stub
        return 0;
    }

    public long countByLastNameIgnoreCase(String lastName) {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getCollectionName() {
        return "customers";
    }

    public Customer parseDocument(Document document) {
        if (document == null) {
            return null;
        }
        final Customer customer = new Customer();
        customer.setId(document.getObjectId("_id"));

        if (StringUtils.isNotEmpty(document.getString("firstName"))) {
            customer.setFirstName(document.getString("firstName"));
        }
        if (StringUtils.isNotEmpty(document.getString("lastName"))) {
            customer.setLastName(document.getString("lastName"));
        }
        if (document.getInteger("age") != null) {
            customer.setAge(document.getInteger("age"));
        }
        if (document.get("address") == null) {
            return customer;
        }
        Document addressDoc = document.get("address", Document.class);
        final Address address = new Address();
        if (StringUtils.isNotEmpty(addressDoc.getString("street"))) {
            address.setStreet(addressDoc.getString("street"));
        }
        if (StringUtils.isNotEmpty(addressDoc.getString("zipCode"))) {
            address.setZipCode(addressDoc.getString("zipCode"));
        }
        if (StringUtils.isNotEmpty(addressDoc.getString("city"))) {
            address.setCity(addressDoc.getString("city"));
        }
        if (addressDoc.getInteger("buildingNumber") != null) {
            address.setBuildingNumber(addressDoc.getInteger("buildingNumber"));
        }
        customer.setAddress(address);
        return customer;
    }

}

/*
 * $Log$
 */
