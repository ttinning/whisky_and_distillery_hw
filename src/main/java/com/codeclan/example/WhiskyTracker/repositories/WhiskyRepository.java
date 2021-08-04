package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);
    List<Whisky> findWhiskyByDistilleryIdAndAgeGreaterThan(long distilleryId, int age);
    List<Whisky> findWhiskyByDistilleryRegion(String region);

}
