package com.hi5dev.box2d_pexml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fixtures")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixturesNode")
class FixturesNode {
  List<FixtureNode> fixture;
}
