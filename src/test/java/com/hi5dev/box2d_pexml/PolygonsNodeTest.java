package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PolygonsNodeTest {
  PolygonsNode polygonsNode = new PolygonsNode();

  @BeforeClass
  public static void beforeAll() throws Exception {
    Box2D.init();
  }

  @Before
  public void setUp() throws Exception {
    polygonsNode.polygon = new ArrayList<>();

    polygonsNode.polygon.add("  1.0000, 6.0000  ,  19.0000, 6.0000  ,  16.0000, 19.0000  ,  4.0000, 19.0000 ");
  }

  @Test
  public void getPolygons() throws Exception {
    float floats[][] = polygonsNode.getPolygons();

    assertEquals(1, floats.length);
    assertEquals(8, floats[0].length);
    assertEquals(1.0f, floats[0][0], 0);
    assertEquals(6.0f, floats[0][1], 0);
    assertEquals(19.0f, floats[0][2], 0);
  }

  @Test
  public void testGetPolygonShapes() throws Exception {
    PolygonShape[] polygonShapes = polygonsNode.getPolygonShapes(1, 1);

    assertEquals(1, polygonShapes.length);
    assertNotNull(polygonShapes[0]);

    assertEquals(4, polygonShapes[0].getVertexCount());

    Vector2 vertex = new Vector2();

    polygonShapes[0].getVertex(0, vertex);
    assertEquals(19f, vertex.x, 0);
    assertEquals(6f, vertex.y, 0);

    polygonShapes[0].getVertex(1, vertex);
    assertEquals(16f, vertex.x, 0);
    assertEquals(19f, vertex.y, 0);

    polygonShapes[0].getVertex(2, vertex);
    assertEquals(4f, vertex.x, 0);
    assertEquals(19f, vertex.y, 0);

    polygonShapes[0].getVertex(3, vertex);
    assertEquals(1f, vertex.x, 0);
    assertEquals(6f, vertex.y, 0);

    polygonShapes = polygonsNode.getPolygonShapes(0.5f, 0.25f);

    polygonShapes[0].getVertex(0, vertex);
    assertEquals(19f * 0.5f, vertex.x, 0);
    assertEquals(6f * 0.25f, vertex.y, 0);
  }
}