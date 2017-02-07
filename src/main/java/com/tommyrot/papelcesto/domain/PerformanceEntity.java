package com.tommyrot.papelcesto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "performances")
@Data
public class PerformanceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "score")
  private Integer score;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(columnDefinition = "id")
  private PlayerEntity player;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(columnDefinition = "id")
  private MatchEntity match;


}
