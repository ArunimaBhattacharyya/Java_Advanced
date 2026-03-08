package com.jpa.One_To_One;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("One_To_One");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        CustomerDAOImpl dao = new CustomerDAOImpl();
        
        Customer c = new Customer(1, "Arunima", "arunima04@gmail.com", "Female", 9999999999L, LocalDate.of(2022, 7,4));
        Order o = new Order(101, "12A43", "Phone", 10, 50000.0, LocalDate.of(2025, 10, 5));
        
        c.setOrder(o);
        o.setCustomer(c);
        
        dao.insertCustomer(c);
        
        //fetch
        Customer c2 = dao.getCustomerById(2);
        System.out.println(c2.getCustomerName());
        
        //list customer
        List<Customer> list = dao.getAllCustomers();

        for(Customer c3 : list){
            System.out.println(c3.getCustomerName());
        }
        
        //customer by email
        Customer c4 = dao.getCustomerByEmail("arunima04@gmail.com");

        System.out.println(c4.getCustomerName());
        em.persist(c);
        
        
        
        
        et.commit();
        
        System.out.println("User added");
    }
}
