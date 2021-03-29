package com.butterchicken.UberAssistant.repo;

import com.butterchicken.UberAssistant.entity.Ride;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepo extends JpaRepository<Ride, Integer> {

    List<Ride> findByUserId(Integer userId, Pageable pageable);
}
