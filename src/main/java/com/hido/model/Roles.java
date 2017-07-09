package com.hido.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum Roles {

  ADMIN(1), USER(2);

  public final int value;

  Roles(int n) {
    value = n;
  }
}


