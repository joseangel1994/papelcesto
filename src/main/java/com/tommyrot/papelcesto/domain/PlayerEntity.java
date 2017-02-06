package com.tommyrot.papelcesto.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "player")
@Data
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class PlayerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "player_id")
  private Long playerId;

  @Column(name = "nombre")
  private String name;

  @Column(name = "performance_id")
  private String performanceId;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "playerId")
  private List<PerformanceEntity> performances;

}
