package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixtureNodeTest {
  @Test
  public void getFixtureDef() throws Exception {
    FixtureNode fixtureNode = fakeFixtureNode();
    FixtureDef fixtureDef = fixtureNode.getFixtureDef();

    assertNotNull(fixtureDef);

    assertEquals(0.1f, fixtureDef.density, 0);
    assertEquals(0.2f, fixtureDef.friction, 0);
    assertEquals(0.3f, fixtureDef.restitution, 0);
    assertEquals(1, fixtureDef.filter.categoryBits);
    assertEquals(2, fixtureDef.filter.groupIndex);
    assertEquals(3, fixtureDef.filter.maskBits);

    assertTrue(fixtureDef.isSensor);

    assertEquals(fixtureDef, fixtureNode.getFixtureDef());

    fixtureNode = fakeFixtureNode();

    fixtureNode.isSensor = null;

    assertFalse(fixtureNode.getFixtureDef().isSensor);
  }

  private static FixtureNode fakeFixtureNode() {
    FixtureNode fixtureNode = new FixtureNode();

    fixtureNode.density = 0.1f;
    fixtureNode.friction = 0.2f;
    fixtureNode.restitution = 0.3f;
    fixtureNode.filterCategoryBits = 1;
    fixtureNode.filterGroupIndex = 2;
    fixtureNode.filterMaskBits = 3;
    fixtureNode.isSensor = new Object();

    return fixtureNode;
  }
}