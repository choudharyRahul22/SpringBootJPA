package com.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {


}
