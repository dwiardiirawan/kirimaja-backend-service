package com.indico.kirimaja.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indico.kirimaja.order.entity.DeliveryOrder;

@Repository
public interface OrderRepository extends JpaRepository<DeliveryOrder, Integer> {

}
