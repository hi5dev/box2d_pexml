package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataNode")
class MetadataNode {
  int format;

  @XmlElement(name = "ptm_ratio")
  float ptmRatio;
}
