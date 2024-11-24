import numpy as np
import matplotlib.pyplot as plot
from scipy.spatial import Delauany 

# generate random points 
points = np.random.rand(100,2)

# create delaunay traingulation
tri = Delaunay(points)

# plot triangulation
plt.triplot(points[:,0], points[:1], tri.simplices)
plt.plot(points[:,0], points[:1], 'o')
pl.show()

