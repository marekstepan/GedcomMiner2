package com.ms.gedcomminer2.repositories;

import com.ms.gedcomminer2.models.Ancestor;
import com.ms.gedcomminer2.models.AncestorBranch;
import com.ms.gedcomminer2.models.Individual;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncestorBranchRepository extends JpaRepository<AncestorBranch, Long> {
  public Individual findByMhId(String mhId);

  public List<AncestorBranch> findAllByGeneration(int generationResolution);

  public int countByMhId(String MhId);

}
