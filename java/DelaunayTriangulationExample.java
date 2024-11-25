// technique used to divide a 2D space into triangles such that no point in any triangle is inside
// the circumcircle of any other triangle; ensures that the triangles are as equiangular as possible, 
// making it a valuable tool in various fields iincluding computer graphics (surface reconsutrution
// and mesh generation), geographic information systems (GIS) (for interpolation and analysis of spatial data)
// and computational geometry, for various algorithms and data structures

// java doesn't have a built in class for delauney triangulation but JTS topology suite can be levereged 

import org.locationtech.jts.geom.*;
import org.locationtech.jts.triangulate.DelaunayTriangulator;

public class DelaunayTriangulationExample 
{
  public static void main(String[] args)
  {
    // create list of points
    Coordinate[] points = new Coordinate[]
      {
        new Coordinate(0, 0),
        new Coordinate(1, 1),
        new Coordinate(2, 0),
        new Coordinate(1, 2)
      };
    // create geometry factory
    GeometryFactory geometryFactory = new GeometryFactory();
    // create a delanuay triangulator
    DelaunayTriangulator dt = new DelaunayTriangulator();
    // triangulate the points
    Geometry triangulatedGeometry = dt.getDelaunayTriangulation();

    // print triangualted geometry
    System.out.println(triangulatedGeometry.toText());
  }
}
