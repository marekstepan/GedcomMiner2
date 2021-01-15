package com.ms.gedcomminer2.repositories;

import com.ms.gedcomminer2.models.Ancestor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncestorRepository extends JpaRepository<Ancestor, Long> {
  public Ancestor findByMhId(String mhId);

  public List<Ancestor> findAllByGeneration(int generationResolution);

  public List<Ancestor> findAllByNameContainsIgnoreCase(String string);

  public void deleteAllByGenerationGreaterThan(int generation);

  public Ancestor findFirstByGeneration(int generation);
}
