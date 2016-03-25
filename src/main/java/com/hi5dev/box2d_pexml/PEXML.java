package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class PEXML {
  private BodyDefNode bodyDefNode;

  /**
   * Creates a new instance of PEXML.
   *
   * @param file The physicseditor.de XML file to parse.
   */
  public PEXML(File file) {
    try {
      loadXML(file);
    } catch (JAXBException e) {
      e.printStackTrace();

      throw new RuntimeException("failed to parse XML");
    }
  }

  /**
   * Creates a Box2D body.
   *
   * @param name    The name of the body exactly as it appears in the XML file.
   * @param world   The Box2D world to use to create the body.
   * @param bodyDef The body's attributes.
   * @param scaleX  Scalar for the fixture widths.
   * @param scaleY  Scalar for the fixture heights - ignored for circles.
   * @return A Box2D Body.
   * @apiNote Scalar values affect both positions and sizes of the fixtures.
   */
  public Body createBody(String name, World world, BodyDef bodyDef, float scaleX, float scaleY) {
    BodyNode bodyNode = getBodyNode(name);

    return bodyNode == null ? null : bodyNode.createBody(world, bodyDef, scaleX, scaleY);
  }

  /**
   * Checks if the supplied name is present for one of the bodies described in
   * the XML file.
   *
   * @param name The name of the body.
   * @return Whether or not the name is present.
   */
  public boolean contains(String name) {
    return getBodyNode(name) != null;
  }

  /**
   * Gets the {@link BodyNode} for the supplied name.
   *
   * @param name The name of the body exactly as it appears in the XML file.
   * @return The {@link BodyNode} or null if it wasn't found.
   */
  private BodyNode getBodyNode(String name) {
    List<BodyNode> bodies = bodyDefNode.bodies.body;

    int size = bodies.size();

    for (int i = 0; i < size; i++) {
      BodyNode body = bodies.get(i);

      if (body.name.equals(name))
        return body;
    }

    return null;
  }

  /**
   * Gets the format.
   *
   * @return Format.
   */
  public int getFormat() {
    return bodyDefNode.metadata.format;
  }

  /**
   * Gets the number of bodies contained in the XML file.
   *
   * @return Number of bodies.
   */
  public int getNumBodies() {
    return bodyDefNode.bodies.body.size();
  }

  /**
   * Gets the pixels-per-meter ratio.
   *
   * @return PTM
   */
  public float getPTM() {
    return bodyDefNode.metadata.ptmRatio;
  }

  /**
   * Checks if the XML file hsa been loaded into memory.
   *
   * @return True if the XML file is ready.
   */
  public boolean isLoaded() {
    return bodyDefNode != null;
  }

  /**
   * Loads the XML file into {@link #bodyDefNode}.
   *
   * @param file The file to load.
   * @throws JAXBException
   */
  private void loadXML(File file) throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(BodyDefNode.class);

    Unmarshaller unmarshaller = context.createUnmarshaller();

    bodyDefNode = (BodyDefNode) unmarshaller.unmarshal(file);
  }
}
