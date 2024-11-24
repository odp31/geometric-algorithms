def triangulate_polygon(polygon):
  """
  triangulates a simple polygon
  args:
  polygon: list of tuples representing the polygons vertices
  returns:
  list of tuples reprsenting the triangles, each tuple containing three vertex indices
  """
  triangles = []
  while len(polygon) > 3:
    for i in range(len(polygon)):
      p1, p2, p3 = polygon[i - 1], polygon[i], polygon[(i + 1) % len(polygon)]
      if is_ear(polygon, p1, p2, p3):
        triangles.append((i - 1, i, (i + 1) % len(polygon)))
        polygon.pop(i)
        break

  triangles.append((0, 1, 2))
  return triangles


def is_ear(polygon, p1, p2, p3):
  """
  checks if triangle is an ear 
  """
  if orientation(p1, p2, p3) != 2:
    return False

  for p in polygon:
    if p not in (p1, p2, p3) and is_point_inside_triangle(p, p1, p2, p3):
      return False

  return True

def orientation(p, q, r):
  val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    if val == 0:
        return 0  # Colinear
    return 1 if val > 0 else 2  # Clockwise or Counterclockwise




