package com.hi5dev.box2d_pexml;

import org.junit.Test;

import static org.junit.Assert.*;

public class MetadataNodeTest {
  @Test
  public void testLoadsMetadata() {
    PEXML pexml = Fixtures.loadPEXML("bugs");

    assertEquals(1, pexml.getFormat());
    assertEquals(32, pexml.getPTM(), 1);
  }
}