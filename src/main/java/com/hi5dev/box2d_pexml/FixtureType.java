package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "FixtureType")
@XmlEnum
public enum FixtureType {
  POLYGON,
  CIRCLE;

  public String value() {
    return name();
  }

  public static FixtureType fromValue(String v) {
    return valueOf(v);
  }
}