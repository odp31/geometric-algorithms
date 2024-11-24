# generatl technique used to solve gemoetric problems by sweeping a vertical
# line across the plane 

def line_sweep(segments):
  """
  performs a line sweep algorithm on a set of line segments
  args:
    segments: list of line segments, each represented as a tuple of two points 
  returns:
    list of intersection points
  """
  event_queue = []
  for segment in segments:
    p1, p2 = segment
    event_queue.append((min(p1[0], p2[0]), 'start', segment))
    event_queue.append((max(p1[0], p2[0]), 'end', segment))

  event_queue.sort()
  active_segments = []
  intersections = []

  for event in event_queue:
    x, event_type, segment = event

    if event_type == 'start':
      active_segments.append(segment)
      for other_segment in active_segments:
        if segments_intersect(segment, other_segment):
          intersections.append(intersection_point(segment, other_segment))

    else:
      active_segments.remove(segment)

  return intersections 
