/**
 * 
 */
package com.sivalabs.demo.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.demo.orders.entities.Order;

/**
 * @author Siva
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
