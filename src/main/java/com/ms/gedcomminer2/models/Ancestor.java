package com.ms.gedcomminer2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ancestor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String mhId;
  private String name;
  private String sex;
  private String firstName;
  private String surname;
  private String birthYear;
  private String birthPlace;
  private String actualPlaceAddress;
  private String isPlaceExact;
  private double latitude;
  private double longitude;
  private String fatherId;
  private String motherId;
  private String famc;
  private int generation;
  private String descendentId;
  private String branchId;
  private int numberOfOccurrences;
  private String checked;
  private String notes;

  public Ancestor() {
  }

  public Ancestor(String mhId, String name, String sex, String firstname, String surname,
                  String birthYear, String birthPlace,
                  String famc, String fatherId, String motherId, int generation,
                  String descendentId) {
    this.mhId = mhId;
    this.name = name;
    this.sex = sex;
    this.firstName = firstname;
    this.surname = surname;
    this.birthYear = birthYear;
    this.birthPlace = birthPlace;
    this.latitude = 0;
    this.longitude = 0;
    this.famc = famc;
    this.fatherId = fatherId;
    this.motherId = motherId;
    this.generation = generation;
    this.descendentId = descendentId;


  }

  public Ancestor(String mhId, String name, String sex, String firstname, String surname,
                  String birthYear, String birthPlace, double latitude, double longitude,
                  String famc, String fatherId, String motherId, int generation,
                  String descendentId, String branchId, int numberOfOccurrences) {
    this.mhId = mhId;
    this.name = name;
    this.sex = sex;
    this.firstName = firstname;
    this.surname = surname;
    this.birthYear = birthYear;
    this.birthPlace = birthPlace;
    this.latitude = 0;
    this.longitude = 0;
    this.famc = famc;
    this.fatherId = fatherId;
    this.motherId = motherId;
    this.generation = generation;
    this.descendentId = descendentId;
    this.branchId = branchId;
    this.numberOfOccurrences = numberOfOccurrences;


  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getActualPlaceAddress() {
    return actualPlaceAddress;
  }

  public void setActualPlaceAddress(String actualPlaceAddress) {
    this.actualPlaceAddress = actualPlaceAddress;
  }

  public String getChecked() {
    return checked;
  }

  public void setChecked(String checked) {
    this.checked = checked;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getIsPlaceExact() {
    return isPlaceExact;
  }

  public void setIsPlaceExact(String isPlaceExact) {
    this.isPlaceExact = isPlaceExact;
  }
}

