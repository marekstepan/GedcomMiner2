package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Family;
import com.ms.gedcomminer2.repositories.FamilyRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {

  private final FamilyRepository familyRepository;

  @Autowired
  public FamilyServiceImpl(FamilyRepository familyRepository) {
    this.familyRepository = familyRepository;
  }

  @Override
  public List<Family> parseFamilies(Path path) throws IOException {
    List<String> lines = Files.readAllLines(path);
    List<Family> families = new ArrayList<>();
    String famc = "";
    String fatherMhId = "";
    String motherMhId = "";
    Long count = Long.valueOf(0);

    for (int i = 0; i < lines.size(); i++) {

      if (lines.get(i).startsWith("0 @F")) {
        count = count + 1;
        famc = lines.get(i).substring(2, lines.get(i).length() - 4);

        familyRepository.save(new Family(famc));
      }


      if (lines.get(i).startsWith("1 HUSB")) {
        fatherMhId = lines.get(i).substring(8, lines.get(i).length() - 1);
        familyRepository.findByFamc(famc).setFatherMhId(fatherMhId);
      }

      if (lines.get(i).startsWith("1 WIFE")) {
        motherMhId = lines.get(i).substring(8, lines.get(i).length() - 1);
        familyRepository.findByFamc(famc).setMotherMhId(motherMhId);
      }

    }
    return families;
  }

  @Override
  public List<Family> findAll() {
    return null;
  }

  @Override
  public void add(String famc, String fatherMhId, String motherMhId) {

  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public Family findById(long id) {
    return null;
  }

}
