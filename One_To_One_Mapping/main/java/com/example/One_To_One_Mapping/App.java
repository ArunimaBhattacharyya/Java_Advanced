package com.example.One_To_One_Mapping;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("One_To_One_Mapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Customer1 c = new Customer1(2, "Arunima", "arunima04@gmail.com", "Female", 9999999999L, LocalDate.of(2022, 7,4));
        Order1 o = new Order1(102, "12A43", "Phone", 10, 50000.0, LocalDate.of(2025, 10, 5));
        
        c.setOrder(o);
        o.setCustomer(c);
        em.persist(c);
        
        et.commit();
        
        System.out.println("User added");
    }
}
