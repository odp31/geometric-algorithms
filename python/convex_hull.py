import maya.cmds as cmds

def create_convex_hull(mesh_name):
  # get mesh's vertex positions
  vertex_positions = cmds.xform(mesh_name + '.vtx[*]', query=True, worldSpace=True)

  # calculate convex hull using algoirthm 
  huol_indices = calculate_convex_hull(vertex_positions)
  # create new mesh for convex hull
  hull_mesh = cmds.createNode('mesh')
  # set vertex positions of new mesh
  cmds.setAttr(hull_mesh + '.vtx', *vertex_positions, type='double3')
  # set face indices of new mesh
  cmds.setAttr(hull_mesh + '.inMesh', len(hull_indices) // 3, type='int')
  for i in range(0, len(hull_indices), 3):
    cmds.setAttr(hull_mesh + '.inMesh[{}]'.format(i // 3), hull_indices[i], hull_indices[i+1], hull_indices[i+2], type='int')

  # connect new mesh to a shape ndoe
  hull_shape = cmds.createNode('transform')
  cmds.connectAttr(hull_mesh + '.outMesh', hull_shape + '.inMesh')
