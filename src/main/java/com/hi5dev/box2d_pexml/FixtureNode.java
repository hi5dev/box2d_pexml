package com.hi5dev.box2d_pexml;

import java.util.List;
import javax.xml.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fixture")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixtureNode", propOrder = {
    "density",
    "friction",
    "restitution",
    "filterCategoryBits",
    "filterGroupIndex",
    "filterMaskBits",
    "fixtureType",
    "polygons",
    "isSensor",
    "circle"
})
public class FixtureNode {
  protected float density;

  protected float friction;

  protected float restitution;

  @XmlElement(name = "filter_categoryBits")
  protected short filterCategoryBits;

  @XmlElement(name = "filter_groupIndex")
  protected short filterGroupIndex;

  @XmlElement(name = "filter_maskBits")
  protected short filterMaskBits;

  @XmlElement(name = "fixture_type", required = true)
  @XmlSchemaType(name = "string")
  protected FixtureType fixtureType;

  protected List<PolygonsNode> polygons;

  protected Object isSensor;

  protected List<CircleNode> circle;
}
