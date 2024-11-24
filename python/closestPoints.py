import math

def distance(p1, p2):
  """ calcs euclideandistance between 2 points """
  return math.sqrt((p1[0] - p2[0])**2 + (p1[1] - p2[1]) **2)

def closest_pair(points):
  if len(points) <= 3:
    return brute_force(points)

  mid = len(points) // 2 
  left_points = points[:mid]
  right_points = points[mid:]

  left_closest= closest_pair(left_points)
  right_closest = closest_pair(right_points)

  d = min(left_closest[1], right_closest[1])
  mid_x = (left_points[-1][0] + right_points[0][0]) / 2

  strip = []
  for point in points:
    if abs(point[0] - mid x) < d:
      strip.append(point)

  strip.sort(key=lambda point: point[1])

  min_dist = d
  for i in range(len(strip) - 1):
    j = i + 1
    while j < len(strip) and (strip[j][1] - strip[i][i]) < d:
      min_dist = min(min_dist, distance(strip[i], strip[j])))
      j += 1

  return min(left_closest, right_closest, (strip[i], strip[j]), key=lambda x: x[1])


def brute_force(points):
  min_dist = float('inf')
  closest_pair = None
  for i in range(len(points - 1):
    for j in range(i + 1, len(points)):
      dist = distance(points[i], points[j])
      if dist < min_dist:
        min_dist = dist
        closet_pair = (points[i], points[j])
  return closest_pair 
