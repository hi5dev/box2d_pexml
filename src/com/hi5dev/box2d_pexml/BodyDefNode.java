package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "bodydef")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyDefNode")
public class BodyDefNode {
  @XmlElement(required = true)
  protected BodiesNode bodiesNode;

  protected MetadataNode metadataNode;

  @XmlAttribute(name = "version")
  protected String version;
}
