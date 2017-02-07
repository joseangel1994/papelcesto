package com.tommyrot.papelcesto.mappers;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.MatchEntity;
import com.tommyrot.papelcesto.dto.Match;
import com.tommyrot.papelcesto.dto.create.CreateMatch;

@Component
public class MatchMapper {

  DateTimeFormatter formatter =
      DateTimeFormatter.ISO_DATE_TIME.withLocale(Locale.UK).withZone(ZoneId.systemDefault());

  public Match toMatch(MatchEntity source) {

    Match target = new Match();

    target.setId(source.getId());

    String formatDate = formatter.format(source.getDate());
    target.setDate(formatDate);

    return target;
  }

  public MatchEntity toMatchEntity(CreateMatch source) {

    MatchEntity matchToCreate = new MatchEntity();

    matchToCreate.setDate(source.getDate());

    return matchToCreate;
  }

}
