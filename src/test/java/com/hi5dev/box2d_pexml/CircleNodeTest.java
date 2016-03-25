package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.CircleShape;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleNodeTest {
  CircleNode circleNode;

  @BeforeClass
  public static void beforeAll() throws Exception {
    Box2D.init();
  }

  @Before
  public void setUp() throws Exception {
    circleNode = new CircleNode();

    circleNode.r  = 10f;
    circleNode.x = 100f;
    circleNode.y = 200f;
  }

  @Test
  public void getCircleShape() throws Exception {
    CircleShape circleShape = circleNode.getCircleShape(0.5f);

    assertNotNull(circleShape);
    assertEquals(5f, circleShape.getRadius(), 0);
    assertEquals(50f, circleShape.getPosition().x, 0);
    assertEquals(100f, circleShape.getPosition().y, 0);
  }
}