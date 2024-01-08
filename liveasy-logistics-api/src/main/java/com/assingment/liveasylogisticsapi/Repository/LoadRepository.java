package com.assingment.liveasylogisticsapi.Repository;

import com.assingment.liveasylogisticsapi.entity.LoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<LoadEntity,Long> {



    Optional<LoadEntity> findByShipperId(UUID shipperId);
}
