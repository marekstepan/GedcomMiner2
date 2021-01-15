package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Individual;
import com.ms.gedcomminer2.repositories.FamilyRepository;
import com.ms.gedcomminer2.repositories.IndividualRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndividualServiceImpl implements IndividualService {

  private final IndividualRepository individualRepository;
  private final FamilyRepository familyRepository;

  @Autowired
  public IndividualServiceImpl(IndividualRepository individualRepository,
                               FamilyRepository familyRepository) {
    this.individualRepository = individualRepository;
    this.familyRepository = familyRepository;
  }

  String url;

  @Override
  public List<Individual> parseIndividuals(Path path) throws IOException {
    List<String> lines = Files.readAllLines(path);
    List<Individual> individuals = new ArrayList<>();
    String mhId = "";
    String name = "";
    String sex = "";
    String birthYear = "";
    String birthPlace = "";
    String firstName;
    String surname;
    String famc = "";
    String fatherId = "";
    String motherId = "";
    Long id;
    Long count = Long.valueOf(0);

    for (int i = 0; i < lines.size(); i++) {

      if (lines.get(i).startsWith("0 @I")) {
        count = count + 1;
        mhId = lines.get(i).substring(3, lines.get(i).length() - 6);
        individualRepository.save(new Individual(mhId));
      }


      if (lines.get(i).startsWith("1 NAME")) {
        String line = lines.get(i).substring(2).replace("/", "");
        name = line.replace("NAME ", "");
        individualRepository.findById(count).orElse(null).setName(name);
        if (lines.get(i + 1).startsWith("2 GIVN")) {
          firstName = lines.get(i + 1).trim().substring(7);
          individualRepository.findById(count).orElse(null).setFirstName(firstName);
        } else if (lines.get(i + 1).startsWith("2 SURN")) {
          surname = lines.get(i + 1).substring(7).trim();
          individualRepository.findById(count).orElse(null).setSurname(surname);
        }
        if (lines.get(i + 2).startsWith("2 SURN")) {
          surname = lines.get(i + 2).substring(7).trim();
          individualRepository.findById(count).orElse(null).setSurname(surname);
        }
      }

      if (lines.get(i).startsWith("1 SEX")) {
        sex = lines.get(i).substring(lines.get(i).length() - 1);
        individualRepository.findById(count).orElse(null).setSex(sex);
      }


      if (lines.get(i).startsWith("1 BIRT")) {
        if (lines.get(i + 1).startsWith("2 DATE")) {
          birthYear = lines.get(i + 1).trim().substring(lines.get(i + 1).length() - 4);
          individualRepository.findById(count).orElse(null).setBirthYear(birthYear);
        } else if (lines.get(i + 1).startsWith("2 PLAC")) {
          birthPlace = lines.get(i + 1).substring(7).trim();
          individualRepository.findById(count).orElse(null).setBirthPlace(birthPlace);
        }
        if (lines.get(i + 2).startsWith("2 PLAC")) {
          birthPlace = lines.get(i + 2).substring(7).trim();
          individualRepository.findById(count).orElse(null).setBirthPlace(birthPlace);
        }
      }

      if (lines.get(i).startsWith("1 FAMC")) {
        famc = lines.get(i).substring(7);
        fatherId = familyRepository.findByFamc(famc).getFatherMhId();
        motherId = familyRepository.findByFamc(famc).getMotherMhId();
        individualRepository.findById(count).orElse(null).setFamc(famc);
        individualRepository.findById(count).orElse(null).setFatherId(fatherId);
        individualRepository.findById(count).orElse(null).setMotherId(motherId);
      }
    }
    return individuals;
  }

  @Override
  public List<Individual> findAll() {
    return null;
  }

  @Override
  public void add(String mhId, String name, String sex, String birthYear, String birthPlace) {

  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public Individual findById(long id) {
    return null;
  }

}
