package com.ms.gedcomminer2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AncestorBranch {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id2;
  private String mhId;
  private String name;
  private String sex;
  private String firstName;
  private String surname;
  private String birthYear;
  private String birthPlace;
  private double latitude;
  private double longitude;
  private String fatherId;
  private String motherId;
  private String famc;
  private int generation;
  private String descendentId;
  private String branchId;
  private int numberOfOccurrences;


  public AncestorBranch() {
  }

  public AncestorBranch(String mhId, String name, String sex, String firstName,
                        String surname, String birthYear, String birthPlace, double latitude,
                        double longitude, String fatherId, String motherId, String famc,
                        int generation, String descendentId, String branchId,
                        int numberOfOccurrences) {
    this.mhId = mhId;
    this.name = name;
    this.sex = sex;
    this.firstName = firstName;
    this.surname = surname;
    this.birthYear = birthYear;
    this.birthPlace = birthPlace;
    this.latitude = latitude;
    this.longitude = longitude;
    this.fatherId = fatherId;
    this.motherId = motherId;
    this.famc = famc;
    this.generation = generation;
    this.descendentId = descendentId;
    this.branchId = branchId;
    this.numberOfOccurrences = numberOfOccurrences;
  }

  public Long getId2() {
    return id2;
  }

  public void setId2(Long id2) {
    this.id2 = id2;
  }

  public String getMhId() {
    return mhId;
  }

  public void setMhId(String mhId) {
    this.mhId = mhId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getFatherId() {
    return fatherId;
  }

  public void setFatherId(String fatherId) {
    this.fatherId = fatherId;
  }

  public String getMotherId() {
    return motherId;
  }

  public void setMotherId(String motherId) {
    this.motherId = motherId;
  }

  public String getFamc() {
    return famc;
  }

  public void setFamc(String famc) {
    this.famc = famc;
  }

  public int getGeneration() {
    return generation;
  }

  public void setGeneration(int generation) {
    this.generation = generation;
  }

  public String getDescendentId() {
    return descendentId;
  }

  public void setDescendentId(String descendentId) {
    this.descendentId = descendentId;
  }

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public int getNumberOfOccurrences() {
    return numberOfOccurrences;
  }

  public void setNumberOfOccurrences(int numberOfOccurrences) {
    this.numberOfOccurrences = numberOfOccurrences;
  }
}


