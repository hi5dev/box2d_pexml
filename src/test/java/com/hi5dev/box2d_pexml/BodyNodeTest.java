package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyNodeTest {
  private BodyDef bodyDef = new BodyDef();
  private BodyNode bodyNode;
  private World world = new World(new Vector2(0, 0), true);

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

  @Test
  public void testCreateBody() throws Exception {
    PEXML pexml = Fixtures.loadPEXML("bugs");

    Body body = pexml.createBody("bug_0001", world, bodyDef, 1, 1);

    Array<Fixture> fixtures = body.getFixtureList();

    assertEquals(3, fixtures.size);
  }

  /**
   * This test just makes sure that all of the bodies can be created through
   * {@link PEXML} without raising any exceptions.
   *
   * @throws Exception
   */
  @Test
  public void testCreateAllBodies() throws Exception {
    PEXML pexml = Fixtures.loadPEXML("bugs");

    pexml.createBody("bug_0001", world, bodyDef, 1, 1);
    pexml.createBody("bug_0002", world, bodyDef, 1, 1);
    pexml.createBody("bug_0003", world, bodyDef, 1, 1);
    pexml.createBody("bug_0004", world, bodyDef, 1, 1);
  }
}