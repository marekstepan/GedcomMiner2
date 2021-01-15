package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Ancestor;
import com.ms.gedcomminer2.models.Individual;
import java.util.List;

public interface AncestorService {
  void findAllAncestors();

  List<Ancestor> findAncestorsByStringName(String string);

  void filterAncestors(String mhId) throws Exception;

  void add(Ancestor ancestor);

  void deleteById(long id);

  Ancestor editById(Ancestor ancestor);

  Individual findById(long id);

  void editSpatials(double latitude, double longitude);

}
