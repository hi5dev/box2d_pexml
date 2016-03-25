package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import javax.xml.bind.annotation.*;
import java.util.List;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BodyNode")
public class BodyNode {
  @XmlElement(required = true)
  protected String anchorpoint;

  @XmlElement(required = true)
  protected List<FixturesNode> fixtures;

  @XmlAttribute(name = "name")
  protected String name;

  /**
   * Converts the XML into a Box2D {@link Body}.
   *
   * @param world The Box2D world to use to create the body.
   * @return A Box2D Body.
   */
  Body toBody(World world) {
    return null;
  }

  Vector2 getAnchorPoint() {
    float[] point = Utility.parseFloatsCSV(anchorpoint);

    return new Vector2(point[0], point[1]);
  }
}
