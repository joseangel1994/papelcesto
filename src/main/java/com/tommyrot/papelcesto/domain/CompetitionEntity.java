package com.tommyrot.papelcesto.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Table(name = "competitions")
@Entity
public class CompetitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "competition_name")
  private String competitionName;
  @Column(name = "active")
  private boolean active;
  @OneToMany(mappedBy = "id")
  private List<MatchEntity> matches;
}
