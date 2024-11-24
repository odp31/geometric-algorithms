public class LineSegment
  {
    private final Point p1, p2;

    public LineSegment(Point p1, Point p2)
    {
      this.p1 = p1;
      this.p2 = p2;
    }
    public Point getP1()
    {
      return p1;
    }
    public Point getP2()
    {
      return p2;
    }
    public boolean intersects(LineSegment other)
    {
      Point intersectionPoint = intersectionPoint(this, other);
      return intersectionPoint != null && isPointOnSegment(intersectionPoint, this) && isPointOnSegment(intersectionPoint, other);
    }
    // helper method to find intersection point of two line segments
    private static Point intersectionPoint(LineSegment l1, LineSegment l2)
    {
      double x1 = l1.p1.x;
      double y1 = l1.p1.y;
      double x2 = l1.p2.x;
      double y2 = l1.p2.y;

      double x3 = l2.p1.x;
      double y3 = l2.p1.y;
      double x4 = l2.p2.x;
      double y4 = l2.p2.y;

      double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
      // if denominator is 0 lines are parallel or adjacent 
      if (denominator == 0)
      {
        return null;
      }
      double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator;
      double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / denominator;

      if(0 <= t && t <= 1 && 0 <= u && u <= 1)
      {
        return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
      }
      return null;
    }

    // helper method to check if point lies on a line segment
    private static boolean isPointOnSegment(Point p, LineSegment 1)
    {
      double x = p.x;
      double y = p.y;
      double x1 = 1.p1.x;
      double y1 = 1.p1.y;
      double x2 = 1.p2.x;
      double y2 = 1.p2.y;

      return x1 <= x && x <= x2 && y1 <= y && y <= y2 || 
        x2 <= x && x <= x1 && y2 <= y && y <= y1;
    }
  }

