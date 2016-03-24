package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyNode")
class BodyNode {
  @XmlElement(required = true)
  protected String anchorpoint;

  @XmlElement(required = true)
  protected List<FixturesNode> fixtures;

  @XmlAttribute(name = "name")
  protected String name;
}
