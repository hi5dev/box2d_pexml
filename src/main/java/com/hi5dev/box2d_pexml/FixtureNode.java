package com.hi5dev.box2d_pexml;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fixture")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixtureNode")
class FixtureNode {
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

  protected List<CircleNode> circleNode;
}
