package com.ms.gedcomminer2.repositories;

import com.ms.gedcomminer2.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {
  public Individual findByMhId(String mhId);
}
