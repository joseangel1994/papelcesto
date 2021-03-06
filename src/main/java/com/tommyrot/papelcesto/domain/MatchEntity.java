package com.tommyrot.papelcesto.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "matches")
@Data
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class MatchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "date")
  private Instant date;

  @ManyToOne
  private CompetitionEntity competition;

  @OneToMany(mappedBy = "id")
  private List<PerformanceEntity> performance;

}
