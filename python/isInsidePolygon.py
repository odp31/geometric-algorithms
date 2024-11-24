def is_inside_polygon(polygon, point):
  """ determines whether a point is inside a polygon.
  Args:
    polygon: list of tuples reprsenting polygons vertices
    point: tuple representing point to check
  returns:
    true if point is inside polygon, false otherwise
  """
  x, y = point
  inside = False
  for(i in range(len(polygon)):
      x1, y1 = polygon[i]
      x2, y2 = polygon[(i+1) % len(polygon)]

      if(y > min(y1, y2)) and (y <= max(y1, y2)) and (x <= max(x1, x2)):
        if y1 != y2:
          xinters = (y - y1) * (x2 - x1) / (y2 - y1) + x1
          if x < xinters:
            inside = not inside
  return inside 
