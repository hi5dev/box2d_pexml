package com.hi5dev.box2d_pexml;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodiesNode")
class BodiesNode {
  List<BodyNode> body;

  @XmlAttribute(name = "numBodies")
  @SuppressWarnings("unused")
  Integer numBodies;
}
