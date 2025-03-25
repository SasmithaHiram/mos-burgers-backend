package edu.icet.ecom.repository;

import edu.icet.ecom.dto.Order;
import edu.icet.ecom.entity.OrderEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
