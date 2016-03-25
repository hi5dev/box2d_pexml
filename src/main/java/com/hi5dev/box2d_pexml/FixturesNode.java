package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Body;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fixtures")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixturesNode")
class FixturesNode {
  List<FixtureNode> fixture;

  /**
   * Adds all of the fixtures in this node to the supplied {@link Body}.
   *
   * @param body   The {@link Body} to add the fixtures to.
   * @param scaleX Scalar for the fixture widths.
   * @param scaleY Scalar for the fixture heights - ignored for circles.
   * @apiNote Scalar values affect both positions and sizes of the fixtures.
   */
  @SuppressWarnings("ForLoopReplaceableByForEach")
  void addFixturesToBody(Body body, float scaleX, float scaleY) {
    int size = fixture.size();

    for (int i = 0; i < size; i++)
      fixture.get(i).addToBody(body, scaleX, scaleY);
  }
}
