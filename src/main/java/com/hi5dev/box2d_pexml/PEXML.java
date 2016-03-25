package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Body;
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
   * Checks if the supplied name is present for one of the bodies described in
   * the XML file.
   *
   * @param name The name of the body.
   * @return Whether or not the name is present.
   */
  public boolean contains(String name) {
    List<BodyNode> bodies = bodyDefNode.bodies.body;

    int size = bodies.size();

    for (int i = 0; i < size; i++)
      if (bodies.get(i).name.equals(name))
        return true;

    return false;
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
