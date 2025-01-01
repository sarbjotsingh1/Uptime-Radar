package com.sarb.uptimeRadar.repository;

import com.sarb.uptimeRadar.entity.Alert;
import com.sarb.uptimeRadar.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findAllByEndpointId(Long endpointId);
    Alert findTopByEndpointOrderByTimestampDesc(Endpoint endpoint);


}
