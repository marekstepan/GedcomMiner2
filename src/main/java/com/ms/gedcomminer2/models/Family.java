package com.ms.gedcomminer2.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Family implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String famc;
  private String fatherMhId;
  private String motherMhId;

  public Family() {
  }

  public Family(String famc) {
    this.famc = famc;
    this.fatherMhId = "";
    this.motherMhId = "";
  }

  public Family(String famc, String fatherMhId, String motherMhId) {
    this.famc = famc;
    this.fatherMhId = fatherMhId;
    this.motherMhId = motherMhId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFamc() {
    return famc;
  }

  public void setFamc(String famc) {
    this.famc = famc;
  }

  public String getFatherMhId() {
    return fatherMhId;
  }

  public void setFatherMhId(String fatherMhId) {
    this.fatherMhId = fatherMhId;
  }

  public String getMotherMhId() {
    return motherMhId;
  }

  public void setMotherMhId(String motherMhId) {
    this.motherMhId = motherMhId;
  }
}
