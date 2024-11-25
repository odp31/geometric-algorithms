// fundamental technique in computational geometry used to solve various problems like intersection detection,
// finding closest pairs, and more; involves sweeping a vertical line across the plane, processing events (line
// segment endpoints) as they are encountered


public class LineSweep
  {
    private PriorityQueue<EventPoint> eventQueue;
    private SweepLineStatus sweepLineStatus;

    public LineSweep(List<LineSegment> lineSegments)
    {
      // initialize event queue and sweep line status
      eventQueue = new PriorityQueue<>(Comparator.comparingDouble(p->p.x));
      sweepLineStatus = new SweepLineStatus();

      // populate event queue with left and right endpoints of line segments
      for(LineSegment segment: lineSegments)
        {
          eventQueue.offer(new EventPoint(segment.p1.x, segment.p1.y, true, segment));
          eventQueue.offer(new EventPoint(segment.p2.x, segment.p2.y, false, segment)):
        }
    }
    public void processEvents()
    {
      while(!eventQueue.isEmpty())
        {
          EventPoint event = eventQueue.poll();
          if(event.isLeftEndpoint)
          {
            sweepLineStatus.insert(event.lineSegment);
          }
          else
          {
            sweepLineStatus.delete(event.lineSegment);
          }
        }
    }
  }

    
