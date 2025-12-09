package com.arte.artenamao.dtos;

public record EventoDiaHorarioRecordDto (
  Integer diaInicio,
  Integer diaFim,
  Integer horaInicio,
  Integer minutoInicio,
  Integer horaFim,
  Integer minutoFim
){}