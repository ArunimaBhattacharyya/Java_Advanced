package com.jpa.One_To_One;

import jakarta.persistence.*;

public class OrderDAOImpl {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("One_To_One");

    // Update order
    public void updateOrder(int id, double price) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Order order = em.find(Order.class, id);

        if (order != null) {
            order.setPrice(price);
        }

        tx.commit();
        em.close();
    }

    // Fetch order by id
    public Order getOrderById(int id) {

        EntityManager em = emf.createEntityManager();

        Order order = em.find(Order.class, id);

        em.close();

        return order;
    }
}