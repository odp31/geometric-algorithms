import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvexHull
  {
    public static List<Point> convexHull(Point[] points)
    {
      int n = points.length;
      // find point with lowest y coordinate
      int minIndex = 0;
      for(int i = 1; i < n; i++)
        {
          if(points[i].y < points[minIndex].y || (points[i].y == points[minIndex].y && points[i].x < points[minIndex].x))
          {
            minIndex = i;
          }
        }
      // sort points by polar angle relative to point w/ lowest y coordinate
      Point p0 = points[minIndex];
      Arrays.sort(points, (p1, p2) -> {
        double angle1 = Math.atan2(p1.y - p0.y, p1.x - p0.x);
        double angle2 = Math.atan2(p2.y - p0.y, p2.x - p0.x);
        return Double.compare(angle1, angle2);
      });
      // create stack to store points of convex hull
      List<Point> hull = new ArrayList<>();
      hull.add(p0);
      hull.add(points[1]);
      // iterate thru sorted points 
      for(int i = 2; i < n; i++)
        {
          while(hull.size() > 1 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i] <= 0)
                {
                  hull.remove(hull.size() - 1);
          }
          hull.add(points[i]);
        }
      return hull;
    }
    // helper method to determine orientation of three points 
    private static int orientation(Point p, Point q, Point r)
    {
      int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
      if (val == 0) return 0;   // collinear
      return(val>0)?1:2;   // clockwise or counterclockwise
    }
  }
class Point
  {
    int x, y;

    public Point(int x, int y)
    {
      this.x = x;
      this.y = y;
    }
  }

            
