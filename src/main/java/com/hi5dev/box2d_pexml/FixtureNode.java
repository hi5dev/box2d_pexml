package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.util.List;
import javax.xml.bind.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fixture")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixtureNode")
class FixtureNode {
  float density;

  float friction;

  float restitution;

  @XmlElement(name = "filter_categoryBits")
  short filterCategoryBits;

  @XmlElement(name = "filter_groupIndex")
  short filterGroupIndex;

  @XmlElement(name = "filter_maskBits")
  short filterMaskBits;

  @XmlElement(name = "fixture_type", required = true)
  @XmlSchemaType(name = "string")
  private FixtureType fixtureType;

  List<PolygonsNode> polygons;

  Object isSensor;

  List<CircleNode> circle;

  /**
   * Stores the fixture definition used to create the fixtures for the node.
   */
  private FixtureDef fixtureDef;

  /**
   * Creates Box2D fixtures from {@link #polygons} or {@link #circle},
   * depending on the value of {@link #fixtureType}, and attaches them to the
   * supplied {@link Body}.
   * <p>
   * The name "fixture" can be a little misleading in this context, because the
   * fixtures in the XML can contain multiple shapes. With Box2D each fixture
   * can only have one shape, which means that multiple fixtures will be added
   * to the body if there is more than one polygon or circle.
   *
   * @param body   The body to attach the fixtures to.
   * @param scaleX Scalar for the width of {@link #polygons} or radius of
   *               {@link #circle}.
   * @param scaleY Scalar for the height of {@link #polygons}. This is ignored
   *               when {@code fixtureType == FixtureType.CIRCLE}.
   */
  public void addToBody(Body body, float scaleX, float scaleY) {
    switch (fixtureType) {
      case CIRCLE:
        addCirclesToBody(body, scaleX);
        break;
      case POLYGON:
        addPolygonsToBody(body, scaleX, scaleY);
        break;
      default:
        throw new UnsupportedOperationException("invalid fixture type");
    }
  }

  /**
   * Adds the shapes in {@link #circle} to the supplied {@link Body}.
   *
   * @param body  The Box2D body to add the circles to.
   * @param scale How much to scale the fixtures.
   */
  @SuppressWarnings("ForLoopReplaceableByForEach")
  private void addCirclesToBody(Body body, float scale) {
    FixtureDef fixtureDef = getFixtureDef();

    int size = circle.size();

    for (int i = 0; i < size; i++) {
      CircleNode circleNode = circle.get(i);

      CircleShape circleShape = circleNode.getCircleShape(scale);

      fixtureDef.shape = circleShape;

      body.createFixture(fixtureDef);

      circleShape.dispose();
    }
  }

  /**
   * Adds polygons defined in {@link #polygons} to the supplied {@link Body}.
   *
   * @param body   The body to add the polygon fixtures to.
   * @param scaleX Scalar for the width of the polygons.
   * @param scaleY Scalar for the height of the polygons.
   */
  @SuppressWarnings("ForLoopReplaceableByForEach")
  private void addPolygonsToBody(Body body, float scaleX, float scaleY) {
    FixtureDef fixtureDef = getFixtureDef();

    int size = polygons.size();

    for (int x = 0; x < size; x++) {
      PolygonsNode polygonsNode = polygons.get(x);

      PolygonShape[] polygons = polygonsNode.getPolygonShapes(scaleX, scaleY);

      int count = polygons.length;

      for (int y = 0; y < count; y++) {
        fixtureDef.shape = polygons[y];

        body.createFixture(fixtureDef);

        polygons[y].dispose();
      }
    }
  }

  /**
   * Creates and caches a {@link FixtureDef} from the values in this node.
   * The same {@link FixtureDef} can be used for all the shapes generated for
   * the fixture this node describes.
   *
   * @return The {@link FixtureDef} used to create the fixtures.
   */
  FixtureDef getFixtureDef() {
    if (fixtureDef == null) {
      fixtureDef = new FixtureDef();

      fixtureDef.density = density;
      fixtureDef.friction = friction;
      fixtureDef.restitution = restitution;
      fixtureDef.filter.categoryBits = filterCategoryBits;
      fixtureDef.filter.groupIndex = filterGroupIndex;
      fixtureDef.filter.maskBits = filterMaskBits;
      fixtureDef.isSensor = isSensor != null;
    }

    return fixtureDef;
  }
}
