package com.sarb.uptimeRadar.repository;

import com.sarb.uptimeRadar.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint, Long> {
    List<Endpoint> findAllByIsUp(boolean isUp);
}

