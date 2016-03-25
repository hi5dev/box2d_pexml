package com.hi5dev.box2d_pexml;

import org.junit.Test;

import static org.junit.Assert.*;

public class BodiesNodeTest {
  @Test
  public void testNumberOfBodies() {
    PEXML pexml = Fixtures.loadPEXML("bugs");

    assertEquals(4, pexml.getNumBodies());
  }
}