package com.jpa.One_To_One;

import java.util.List;
import jakarta.persistence.*;

public class CustomerDAOImpl {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("One_To_One");

    // Insert customer with order
    public void insertCustomer(Customer customer) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(customer);
        tx.commit();

        em.close();
    }

    // Update customer
    public void updateCustomer(int id, String name) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            customer.setCustomerName(name);
        }

        tx.commit();
        em.close();
    }

    // Delete customer
    public void deleteCustomer(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            em.remove(customer);
        }

        tx.commit();
        em.close();
    }

    // Fetch customer by id
    public Customer getCustomerById(int id) {

        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();

        return customer;
    }

    // Fetch all customers
    public List<Customer> getAllCustomers() {

        EntityManager em = emf.createEntityManager();

        List<Customer> list =
                em.createQuery("from Customer1", Customer.class)
                        .getResultList();

        em.close();

        return list;
    }
    
    //JPQL Query to fetch customers by email
    public Customer getCustomerByEmail(String email) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email",
                Customer.class);

        query.setParameter("email", email);

        Customer customer = query.getSingleResult();

        em.close();

        return customer;
    }
}