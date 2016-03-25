package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "circle")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CircleNode")
public class CircleNode {
  @XmlAttribute(name = "r")
  protected Float r;

  @XmlAttribute(name = "x")
  protected Float x;

  @XmlAttribute(name = "y")
  protected Float y;

  /**
   * Used to position {@link CircleShape} instances without having to create
   * a new {@link Vector2} for every time one needs to be moved. Using a
   * constant like this saves memory GC runs, increasing performance on mobile
   * devices.
   */
  private static final Vector2 POSITION = new Vector2();

  /**
   * Creates a {@link CircleShape} from the node.
   *
   * @param scale How much to scale the circle.
   * @return A {@link CircleShape}.
   */
  public CircleShape getCircleShape(float scale) {
    POSITION.set(x * scale, y * scale);

    CircleShape circleShape = new CircleShape();

    circleShape.setRadius(r * scale);
    circleShape.setPosition(POSITION);

    return circleShape;
  }
}

