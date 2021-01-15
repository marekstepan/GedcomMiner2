package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Individual;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface IndividualService {
  List<Individual> findAll();

  List<Individual> parseIndividuals(Path path) throws IOException;

  void add(String mhId, String name, String sex, String birthYear, String birthPlace);

  void deleteById(long id);

  Individual findById(long id);
}
