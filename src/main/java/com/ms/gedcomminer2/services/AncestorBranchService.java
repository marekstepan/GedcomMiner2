package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.AncestorBranch;
import com.ms.gedcomminer2.models.Individual;
import java.util.List;

public interface AncestorBranchService {
  void findAllAncestorsBranch();

  List<AncestorBranch> getAncestorBranches(String mhId);

  void addAncestorBranch(AncestorBranch ancestorBranch);

  void calculateOccurrences(int generationResolution) throws Exception;

  void deleteById(long id);

  Individual findById(long id);

}

