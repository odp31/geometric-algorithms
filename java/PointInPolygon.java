// determines whether a given point lies inside, outside or on boundary of polygon
// one of most common algorithms to solve this is the ray casting algorithm 
// draws a ray from point to infinity in any direction and coutns number of times the ray intersects
// the polygon's edges
// if number of intersections is odd the point is inside the polygon; else its outside

public class PointInPolyGon
  {
    public static boolean isPointInsidepolygon(Point point, Point[] polygon)
    {
      int n = polygon.length;
      int count = 0;
      for(int i = 0; i < n; i++)
        {
          int j = (i + 1) % n;
          if(isIntersect(point, polygon[i], polygon[j]))
          {
            if(orientatin(polygon[i], point, polygon[j]) == 0)
            {
              // handle points on edges of polygon
              return onSegment(point, polygon[i], polygon[j]);
          }
          count++;
        }
    }
    return count % 2 == 1;
}

    private static boolean isIntersect(Point p, Point q, Point r)
    // check if q is on line segment pr
    {
      if(orientation(p, q, r) == 0 && onSegment(q, p, r))
      {
        return true;
      }
      // check if line segments pq and pr intersect
      if(orientation(p, q, r) != orientation(p, r, q) && 
         orientation(q, p, r) != orientation(q, r, p))
      {
        return true;
      }
      return false;
    }

    private static int orientation(Point p, Point q, Point r)
    {
      // calculate orientation of an ordered triplet
      int val = (int)((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
      if(val == 0) return 0; // collinear
      return(val>0)? 1: 2; // clock or counter clockwise
    }
    private static boolean onSegment(Point p, Point q, Point r)
    {
      // check if point q lies on line segment pr
      return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
              q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }
  }

