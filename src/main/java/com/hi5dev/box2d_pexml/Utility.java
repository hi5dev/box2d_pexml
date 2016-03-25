package com.hi5dev.box2d_pexml;

/**
 * Utility class for static helper methods.
 */
public final class Utility {
  /**
   * Converts a CSV string of floats into an array of floats. Example:
   * {@code "1.2, 3.4"} to {@code new float[]{1.2f, 3.4f}}.
   *
   * @param csv The CSV string to parse.
   * @return An array of floats.
   */
  public static float[] parseFloatsCSV(String csv) {
    String[] strings = csv.split("\\s*,\\s*");

    int length = strings.length;

    float[] floats = new float[length];

    for (int i = 0; i < length; i++)
      floats[i] = Float.parseFloat(strings[i].trim());

    return floats;
  }
}
