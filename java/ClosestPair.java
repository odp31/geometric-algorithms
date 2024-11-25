// finds two points in a set of points that are closet to eachother
// divide and conquer approach; divide points into equal sized subsets based on their x coordinates
// recursively find closest pair of points in each subset
// combine; find min distance between two closest pairs w/ recusrive calls
// create a strip of width 2(min distance) around dividing line
// sort points by y coordinates
// for each point in strip, check dsitane to next 7 points in sorted list; if any distance < mindistance,
// update min distance 

import java.util.Arrays;
public class ClosestPair
  {
    public static class Point
      {
        double x, y;
        public Point(double x, double y)
        {
          this.x = x;
          this.y = y;
        }
        public double distance(Point p)
        {
          return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
        }
      }
    public static double closestPairDistance(Point[] points)
    {
      int n = points.length;
      if(n <= 3)
      {
        // brute force for small number of points
        double minDist = Double.MAX_VALUE;
        for(int i = 0; i < n - 1; i ++)
          {
            for(int j = i + 1; j < n; j++)
              {
                minDist = Math.min(minDist, points[i].distance(points[j]));
              }
          }
        return minDist;
      }
      // sort points by x coordinate
      Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));
      // divide and conquer
      int mid = n / 2;
      Point[] left = Arrays.copyOfRange(points, 0, mid);
      Point[] right = Arrays.copyOfRange(points, mind, n);

      double d1 = closestPairDistance(left);
      double dr = closestPairDistance(right);
      double d = Math.min(d1, dr);

      // create strip of width 2d
      Point[] strip = new Point[n];
      int j = 0;
      for(int i - 0; i < n; i++)
        {
        if(Math.abs(points[i].x - points[mid].x) < d)
        {
          strip[j++] = points[i];
        }
      }
      // sort strip by y coordinate
      Arrays.sort(strip, 0, j, (p1, p2) -> Double.compare(p1.y, p2.y));
      // check distances within strip
      for(int i = 0; i < j - 1; i++)
        {
          for(int k = i + 1; k < j && (strip[k].y - strip[i].y) < d; k++)
            {
              d = Math.min(d, strip[i].distance(strip[k]));
            }
        }
      return d;
    }
  }
