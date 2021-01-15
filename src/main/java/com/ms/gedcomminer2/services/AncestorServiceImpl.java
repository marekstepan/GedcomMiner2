package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Ancestor;
import com.ms.gedcomminer2.models.Individual;
import com.ms.gedcomminer2.repositories.AncestorRepository;
import com.ms.gedcomminer2.repositories.IndividualRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AncestorServiceImpl implements AncestorService {
  private final AncestorRepository ancestorRepository;
  private final IndividualRepository individualRepository;

  @Autowired
  public AncestorServiceImpl(AncestorRepository ancestorRepository,
                             IndividualRepository individualRepository) {
    this.ancestorRepository = ancestorRepository;
    this.individualRepository = individualRepository;
  }

  String mhId;
  int generationResolution;

  @Override
  public void findAllAncestors() {

  }

  @Override
  public void add(Ancestor ancestor) {

  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public Ancestor editById(Ancestor ancestor) {
    return ancestorRepository.save(ancestor);
  }

  @Override
  public Individual findById(long id) {
    return null;
  }

  @Override
  public void editSpatials(double latitude, double longitude) {

  }

  @Override
  public List<Ancestor> findAncestorsByStringName(String string) {
    List<Ancestor> searchedAncestors = new ArrayList<>();
    searchedAncestors = ancestorRepository.findAllByNameContainsIgnoreCase(string);
    return searchedAncestors;
  }

  @Override
  public void filterAncestors(String mhId) throws Exception {
    ancestorRepository.deleteAll();
    List<Individual> sourceIndividuals = individualRepository.findAll();
    List<Ancestor> ancestorCollector = new ArrayList<Ancestor>();
    List<String> parentsIds = new ArrayList<String>();
    List<String> parentsIds2 = new ArrayList<String>();
    parentsIds.add(mhId);
    List<Ancestor> ancestors = new ArrayList<Ancestor>();
    int generation = 0;

    while (parentsIds.size() > 0) {

      for (int i = 0; i < parentsIds.size(); i++) {
        String tMhId = parentsIds.get(i);
        ancestorCollector.add(new Ancestor(tMhId,
            individualRepository.findByMhId(tMhId).getName(),
            individualRepository.findByMhId(tMhId).getSex(),
            individualRepository.findByMhId(tMhId).getFirstName(),
            individualRepository.findByMhId(tMhId).getSurname(),
            individualRepository.findByMhId(tMhId).getBirthYear(),
            individualRepository.findByMhId(tMhId).getBirthPlace(),
            individualRepository.findByMhId(tMhId).getFamc(),
            individualRepository.findByMhId(tMhId).getFatherId(),
            individualRepository.findByMhId(tMhId).getMotherId(),
            generation, mhId));
      }

      for (int i = 0; i < ancestorCollector.size(); i++) {
        if (!(ancestorCollector.get(i).getFatherId().isEmpty()) &&
            !(ancestorCollector.get(i).getFatherId() == null)) {
          parentsIds2.add(ancestorCollector.get(i).getFatherId());
        }
        if (!(ancestorCollector.get(i).getMotherId().isEmpty()) &&
            !(ancestorCollector.get(i).getMotherId() == null)) {
          parentsIds2.add(ancestorCollector.get(i).getMotherId());
        }
      }
      parentsIds.clear();
      parentsIds.addAll(parentsIds2);
      parentsIds2.clear();

      generation += 1;
      ancestorRepository.saveAll(ancestorCollector);
      ancestorCollector.clear();
    }
  }
}
