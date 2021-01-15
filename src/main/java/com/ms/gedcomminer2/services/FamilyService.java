package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Family;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FamilyService {
  List<Family> findAll();

  List<Family> parseFamilies(Path path) throws IOException;

  void add(String famc, String fatherMhId, String motherMhId);

  void deleteById(long id);

  Family findById(long id);
}
