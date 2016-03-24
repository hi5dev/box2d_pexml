package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataNode")
class MetadataNode {
  protected int format;

  @XmlElement(name = "ptm_ratio")
  protected float ptmRatio;
}
