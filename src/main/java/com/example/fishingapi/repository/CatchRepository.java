package com.example.fishingapi.repository;

import com.example.fishingapi.entity.Catch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatchRepository extends JpaRepository<Catch, Integer> {

}
