package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyNodeTest {
  private BodyNode bodyNode;

  @Before
  public void setUp() throws Exception {
    bodyNode = new BodyNode();
  }

  @Test
  public void getAnchorPoint() throws Exception {
    bodyNode.anchorpoint = "1.23, 4.567";

    Vector2 anchorPoint = bodyNode.getAnchorPoint();

    assertNotNull(anchorPoint);
    assertEquals(1.23f, anchorPoint.x, 0);
    assertEquals(4.567f, anchorPoint.y, 0);
  }
}