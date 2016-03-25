package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "bodydef")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyDefNode", propOrder = {
    "bodies",
    "metadata"
})
public class BodyDefNode {
  @XmlElement(required = true)
  protected BodiesNode bodies;

  protected MetadataNode metadata;

  @XmlAttribute(name = "version")
  protected String version;
}
