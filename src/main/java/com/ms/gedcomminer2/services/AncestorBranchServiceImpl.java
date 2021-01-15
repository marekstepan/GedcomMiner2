package com.ms.gedcomminer2.services;

import com.ms.gedcomminer2.models.Ancestor;
import com.ms.gedcomminer2.models.AncestorBranch;
import com.ms.gedcomminer2.models.Individual;
import com.ms.gedcomminer2.repositories.AncestorBranchRepository;
import com.ms.gedcomminer2.repositories.AncestorRepository;
import com.ms.gedcomminer2.repositories.IndividualRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AncestorBranchServiceImpl implements AncestorService, AncestorBranchService {
  private final IndividualRepository individualRepository;
  private final AncestorRepository ancestorRepository;
  private final AncestorBranchRepository ancestorBranchRepository;

  @Autowired
  public AncestorBranchServiceImpl(IndividualRepository individualRepository,
                                   AncestorRepository ancestorRepository,
                                   AncestorBranchRepository ancestorBranchRepository) {
    this.individualRepository = individualRepository;
    this.ancestorRepository = ancestorRepository;
    this.ancestorBranchRepository = ancestorBranchRepository;
  }

  int generationResolution;

  @Override
  public void findAllAncestorsBranch() {

  }

  @Override
  public List<AncestorBranch> getAncestorBranches(String mhId) {
    return null;
  }

  @Override
  public void addAncestorBranch(AncestorBranch ancestorBranch) {

  }

  @Override
  @Transactional
  public void calculateOccurrences(int generationResolution) throws Exception {
    ancestorBranchRepository.deleteAll();

    List<Ancestor> defaultAncestors = new ArrayList<Ancestor>();
    List<String> defaultParentsIds = new ArrayList<String>();
    List<String> parentsIds = new ArrayList<String>();
    List<String> parentsIds2 = new ArrayList<String>();
    List<AncestorBranch> ancestorBranchCollector = new ArrayList<AncestorBranch>();

    defaultAncestors = ancestorRepository.findAllByGeneration(generationResolution);

    for (int i = 0; i < defaultAncestors.size(); i++) {
      defaultParentsIds.add(defaultAncestors.get(i).getMhId());
    }

    for (int i = 0; i < defaultParentsIds.size(); i++) {

      parentsIds.add(defaultParentsIds.get(i));

      int generation = generationResolution;

      while (parentsIds.size() > 0) {

        for (int j = 0; j < parentsIds.size(); j++) {
          String tMhId = parentsIds.get(j);
          String descendentId = ancestorRepository.findFirstByGeneration(0).getMhId();
          ancestorBranchCollector.add(new AncestorBranch(tMhId,
              individualRepository.findByMhId(tMhId).getName(),
              individualRepository.findByMhId(tMhId).getSex(),
              individualRepository.findByMhId(tMhId).getFirstName(),
              individualRepository.findByMhId(tMhId).getSurname(),
              individualRepository.findByMhId(tMhId).getBirthYear(),
              individualRepository.findByMhId(tMhId).getBirthPlace(),
              individualRepository.findByMhId(tMhId).getLatitude(),
              individualRepository.findByMhId(tMhId).getLongitude(),
              individualRepository.findByMhId(tMhId).getFatherId(),
              individualRepository.findByMhId(tMhId).getMotherId(),
              individualRepository.findByMhId(tMhId).getFamc(),
              generation,
              descendentId,
              defaultParentsIds.get(i),
              ancestorBranchRepository.countByMhId(tMhId) + 1));
        }
        for (int j = 0; j < ancestorBranchCollector.size(); j++) {
          if (!(ancestorBranchCollector.get(j).getFatherId().isEmpty()) &&
              !(ancestorBranchCollector.get(j).getFatherId() == null)) {
            parentsIds2.add(ancestorBranchCollector.get(j).getFatherId());
          }
          if (!(ancestorBranchCollector.get(j).getMotherId().isEmpty()) &&
              !(ancestorBranchCollector.get(j).getMotherId() == null)) {
            parentsIds2.add(ancestorBranchCollector.get(j).getMotherId());
          }
        }
        parentsIds.clear();
        parentsIds.addAll(parentsIds2);
        parentsIds2.clear();
        generation += 1;
        ancestorBranchRepository.saveAll(ancestorBranchCollector);
        ancestorBranchCollector.clear();
      }
    }
    ancestorRepository.deleteAllByGenerationGreaterThan(generationResolution - 1);
    List<AncestorBranch> transferAncestors = new ArrayList<>();
    transferAncestors = ancestorBranchRepository.findAll();
    for (int i = 0; i < transferAncestors.size(); i++) {
      ancestorRepository.save(new Ancestor(
          transferAncestors.get(i).getMhId(),
          transferAncestors.get(i).getName(),
          transferAncestors.get(i).getSex(),
          transferAncestors.get(i).getFirstName(),
          transferAncestors.get(i).getSurname(),
          transferAncestors.get(i).getBirthYear(),
          transferAncestors.get(i).getBirthPlace(),
          transferAncestors.get(i).getLatitude(),
          transferAncestors.get(i).getLongitude(),
          transferAncestors.get(i).getFamc(),
          transferAncestors.get(i).getFatherId(),
          transferAncestors.get(i).getMotherId(),
          transferAncestors.get(i).getGeneration(),
          transferAncestors.get(i).getDescendentId(),
          transferAncestors.get(i).getBranchId(),
          transferAncestors.get(i).getNumberOfOccurrences()));
    }
    ancestorBranchRepository.deleteAll();
  }


  @Override
  public void findAllAncestors() {

  }

  @Override
  public List<Ancestor> findAncestorsByStringName(String string) {
    return null;
  }

  @Override
  public void filterAncestors(String mhId) throws Exception {

  }

  @Override
  public void add(Ancestor ancestor) {

  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public Ancestor editById(Ancestor ancestor) {
    return null;

  }

  @Override
  public Individual findById(long id) {
    return null;
  }

  @Override
  public void editSpatials(double latitude, double longitude) {

  }
}

