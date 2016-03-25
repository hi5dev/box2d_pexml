package com.hi5dev.box2d_pexml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PEXMLTest {
  private PEXML pexml;

  @Before
  public void beforeEach() throws Exception {
    pexml = Fixtures.loadPEXML("bugs");
  }

  @Test
  public void testIsLoaded() throws Exception {
    assertTrue(pexml.isLoaded());
  }

  @Test
  public void testCreateBody() {

  }

  @Test
  public void testLoadsAllBodies() throws Exception {
    assertTrue(pexml.contains("bug_0001"));
    assertTrue(pexml.contains("bug_0002"));
    assertTrue(pexml.contains("bug_0003"));
    assertTrue(pexml.contains("bug_0004"));
  }
}