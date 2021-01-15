package com.ms.gedcomminer2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Individual {
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
  private double latitude;
  private double longitude;
  private String fatherId;
  private String motherId;
  private String famc;
  private int generation;
  private String descendentId;

  public Individual() {
  }

  public Individual(String mhId) {
    this.mhId = mhId;
    this.name = "";
    this.sex = "";
    this.birthYear = "";
    this.birthPlace = "";
    this.latitude = 0;
    this.longitude = 0;
    this.famc = "";
    this.fatherId = "";
    this.motherId = "";
    this.generation = 0;
    this.descendentId = "";

  }

  public Individual(String mhId, String name, String sex, String birthYear, String birthPlace,
                    String famc, String fatherId, String motherId, int generation,
                    String descendentId) {
    this.mhId = mhId;
    this.name = name;
    this.sex = sex;
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMhId() {
    return mhId;
  }

  public void setMh_id(String mhId) {
    this.mhId = mhId;
  }

  public String getName() throws Exception {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() throws Exception {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getFirstName() throws Exception {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() throws Exception {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getBirthYear() throws Exception {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getBirthPlace() throws Exception {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public double getLatitude() throws Exception {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() throws Exception {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getFamc() throws Exception {
    return famc;
  }

  public void setFamc(String famc) {
    this.famc = famc;
  }

  public String getFatherId() throws Exception {
    return fatherId;
  }

  public void setFatherId(String fatherId) {
    this.fatherId = fatherId;
  }

  public String getMotherId() throws Exception {
    return motherId;
  }

  public void setMotherId(String motherId) {
    this.motherId = motherId;
  }

  public int getGeneration() throws Exception {
    return generation;
  }

  public void setGeneration(int generation) {
    this.generation = generation;
  }

  public String getDescendentId() throws Exception {
    return descendentId;
  }

  public void setDescendentId(String descendentId) {
    this.descendentId = descendentId;
  }
}
