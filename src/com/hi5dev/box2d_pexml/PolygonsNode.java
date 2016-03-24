package com.hi5dev.box2d_pexml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "polygons")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolygonsNode")
class PolygonsNode {
  protected List<String> polygon;
}
