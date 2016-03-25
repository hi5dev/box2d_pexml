package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "bodydef")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyDefNode")
class BodyDefNode {
  @XmlElement(required = true)
  BodiesNode bodies;

  MetadataNode metadata;

  @XmlAttribute(name = "version")
  @SuppressWarnings("unused")
  String version;
}
