package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;
import java.util.List;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyNode", propOrder = {
    "anchorpoint",
    "fixtures"
})
public class BodyNode {
  @XmlElement(required = true)
  protected String anchorpoint;

  @XmlElement(required = true)
  protected List<FixturesNode> fixtures;

  @XmlAttribute(name = "name")
  protected String name;
}
