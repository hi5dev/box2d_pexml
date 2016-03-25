package com.hi5dev.box2d_pexml;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PolygonsNodeTest {
  PolygonsNode polygonsNode = new PolygonsNode();

  @Before
  public void setUp() throws Exception {
    polygonsNode.polygon = new ArrayList<>();

    polygonsNode.polygon.add("  1.0000, 6.0000  ,  19.0000");
    polygonsNode.polygon.add("  12.5000, 16.0080  ,  16.2500, 4, 5, 6");
  }

  @Test
  public void getPolygons() throws Exception {
    float floats[][] = polygonsNode.getPolygons();

    assertEquals(2, floats.length);
    assertEquals(3, floats[0].length);
    assertEquals(6, floats[1].length);

    assertEquals(1.0f, floats[0][0], 0);
    assertEquals(6.0f, floats[0][1], 0);
    assertEquals(19.0f, floats[0][2], 0);

    assertEquals(12.5f, floats[1][0], 0);
    assertEquals(16.008f, floats[1][1], 0);
    assertEquals(16.25f, floats[1][2], 0);
    assertEquals(4f, floats[1][3], 0);
    assertEquals(5f, floats[1][4], 0);
    assertEquals(6f, floats[1][5], 0);
  }
}