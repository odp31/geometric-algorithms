import java.util.ArrayList;
import java.util.List;

public class PolygonTriangulation
  {
    public static List<Triangle> triangulate(List<Point> polygon)
    {
      List<Triangle> triangles = new ArrayList<>();
      // handle degenerate cases
      if(polygon.size() < 3)
      {
        return triangles;
      }
      // find ears and clip them until polygon is empty
      while (polygon.size() > 3)
        {
          for(int i = 0; i < polygon.size(); i++)
            {
              int j = (i+1) % polygon.size();
              int k = (i+2) % polygon.size();

              Point p = polygon.get(i);
              Point q = polygon.get(j);
              Point r = polygon.get(k);

              if(isEar(p, q, r, polygon))
              {
                triangles.add(new Triangle(p, q, r));
                polygon.remove(j);
                break;
              }
            }
        }
      return triangles;
    }
    private static boolean isEar(Point p, Point q, Point r, List<Point> polygon)
    {
      // check if triangle pqr is inside the polygon
      for(Point point: polygon)
        {
          if(point != p && point != q && point != r && isPointInTriangle(point, p, q, r))
          {
            return false;
          }
        }
      // check if triangle pqr is convex
      return orientation(p, q, r) == 1;
    }
    private static int orientation(Point p, Point q, Point r)
    {
      int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
      if(val == 0) return 0; // collinear
      return (val > 0) ? 1: 2;  //clockwise or counter clockwise\

    }
    //point and triangle class 
    static class Point
      {
        int x, y;
        public Point(int x, int y)
        {
          this.x = x;
          this.y = y;
        }
      }
    static class Triangle
      {
        Point p1, p2, p3;
        public Triangle(Point p1, Point p2, Point p3)
        {
          this.p1 = p1;
          this.p2 = p2;
          this.p3 = p3;
        }
      }
  }
