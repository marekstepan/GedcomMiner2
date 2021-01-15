package com.ms.gedcomminer2.repositories;

import com.ms.gedcomminer2.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
  public Family findByFamc(String famc);
}
