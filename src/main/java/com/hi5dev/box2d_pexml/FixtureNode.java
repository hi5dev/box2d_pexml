package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.FixtureDef;

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
@XmlType(name = "FixtureNode")
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

  /**
   * Stores the fixture definition used to create the fixtures for the node.
   */
  FixtureDef fixtureDef;

  /**
   * Creates and caches a {@link FixtureDef} from the values in this node.
   * The same {@link FixtureDef} can be used for all the shapes generated for
   * the fixture this node describes.
   *
   * @return The {@link FixtureDef} used to create the fixtures.
   */
  FixtureDef getFixtureDef() {
    if (fixtureDef == null) {
      fixtureDef = new FixtureDef();

      fixtureDef.density = density;
      fixtureDef.friction = friction;
      fixtureDef.restitution = restitution;
      fixtureDef.filter.categoryBits = filterCategoryBits;
      fixtureDef.filter.groupIndex = filterGroupIndex;
      fixtureDef.filter.maskBits = filterMaskBits;
    }

    return fixtureDef;
  }
}
