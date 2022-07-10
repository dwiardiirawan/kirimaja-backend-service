package com.indico.kirimaja.datareference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.indico.kirimaja.datareference.entity.DeliveryFee;

@Repository
public interface DeliveryFeeRepository extends JpaRepository<DeliveryFee, Integer> {

	@Query("select u from DeliveryFee u where u.minDistance <= :distance AND u.maxDistance >= :distance")
	DeliveryFee findByMinDistanceAndMaxDistance(int distance);
}
