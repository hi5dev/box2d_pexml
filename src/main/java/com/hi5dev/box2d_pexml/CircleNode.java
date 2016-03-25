package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "circle")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleNode")
public class CircleNode {
  @XmlAttribute(name = "r")
  protected Float r;

  @XmlAttribute(name = "x")
  protected Float x;

  @XmlAttribute(name = "y")
  protected Float y;
}

