package com.hi5dev.box2d_pexml;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "polygons")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolygonsNode")
public class PolygonsNode {
  protected List<String> polygon;

  /**
   * Converts the polygons into {@link PolygonShape} objects that can be used
   * to create Box2D fixtures.
   *
   * @param scaleX Scalar for the width of the polygon.
   * @param scaleY Scalar for the height of the polygon.
   * @return An array of {@link PolygonShape}.
   */
  public PolygonShape[] getPolygonShapes(float scaleX, float scaleY) {
    Polygon polygon = new Polygon();

    float[][] vertices = getPolygons();

    PolygonShape polygonShapes[] = new PolygonShape[vertices.length];

    for (int i = 0; i < vertices.length; i++) {
      polygon.setVertices(vertices[i]);
      polygon.setScale(scaleX, scaleY);

      polygonShapes[i] = new PolygonShape();
      polygonShapes[i].set(polygon.getTransformedVertices());
    }

    return polygonShapes;
  }

  /**
   * Each string in {@link #polygon} contains sets of vertices that are used to
   * create polygons. This function converts those strings into arrays of
   * floats. For example, if these two strings were in the list:
   * {@code "1,1,2,2,3,3"} and {@code "4,4,5,5,6,6"}, they would be converted
   * into {@code new float[][]{1,1,2,2,3,3},{4,4,5,5,6,6}}.
   *
   * @return A two-dimensional array of floats.
   */
  public float[][] getPolygons() {
    int size = polygon.size();

    float[][] polygons = new float[size][];

    for (int i = 0; i < size; i++)
      polygons[i] = Utility.parseFloatsCSV(polygon.get(i));

    return polygons;
  }
}
