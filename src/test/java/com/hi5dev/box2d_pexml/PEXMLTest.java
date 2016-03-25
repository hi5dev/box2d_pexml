package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Box2D;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PEXMLTest {
  private File xmlFile;
  private PEXML pexml;

  @BeforeClass
  public static void setUp() throws Exception {
    Box2D.init();
  }

  @Before
  public void beforeEach() throws Exception {
    xmlFile = new File("src/test/resources/bugs.xml");
    pexml = new PEXML(xmlFile);
  }

  @Test
  public void testIsLoaded() throws Exception {
    assertTrue(pexml.isLoaded());
  }



  @Test
  public void testLoadsAllBodies() throws Exception {
    assertTrue(pexml.contains("bug_0001"));
    assertTrue(pexml.contains("bug_0002"));
    assertTrue(pexml.contains("bug_0003"));
    assertTrue(pexml.contains("bug_0004"));
  }
}