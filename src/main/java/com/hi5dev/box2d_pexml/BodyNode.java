package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
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
class BodyNode {
  @XmlElement(required = true)
  String anchorpoint;

  @XmlElement(required = true)
  List<FixturesNode> fixtures;

  @XmlAttribute(name = "name")
  String name;

  /**
   * Used to cache the vector for {@link #anchorpoint} for improved
   * performance on slower devices.
   */
  private Vector2 anchorPointVector;

  /**
   * Converts the XML into a Box2D {@link Body}.
   *
   * @param world   The Box2D world to use to create the body.
   * @param bodyDef The body's attributes.
   * @param scaleX  Scalar for the fixture widths.
   * @param scaleY  Scalar for the fixture heights - ignored for circles.
   * @return A Box2D Body.
   * @apiNote Scalar values affect both positions and sizes of the fixtures.
   */
  @SuppressWarnings("ForLoopReplaceableByForEach")
  Body createBody(World world, BodyDef bodyDef, float scaleX, float scaleY) {
    Body body = world.createBody(bodyDef);

    int size = fixtures.size();

    for (int i = 0; i < size; i++)
      fixtures.get(i).addFixturesToBody(body, scaleX, scaleY);

    return body;
  }

  /**
   * Gets the anchor point as a vector.
   *
   * @return A {@link Vector2} representation for {@link #anchorpoint}.
   */
  Vector2 getAnchorPoint() {
    if (anchorPointVector == null) {
      float[] point = Utility.parseFloatsCSV(anchorpoint);

      anchorPointVector = new Vector2(point[0], point[1]);
    }

    return anchorPointVector;
  }
}
