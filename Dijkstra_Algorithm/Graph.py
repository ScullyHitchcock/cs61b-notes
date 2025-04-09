#
#
# class UndirectedGraph:
#     def __init__(self):
#         self.adj = {}  # 邻接表: 顶点 -> 邻接点列表
#
#     def add_edge(self, v1, v2):
#         """添加一条无向边 v1 - v2"""
#         if v1 not in self.adj:
#             self.adj[v1] = []
#         if v2 not in self.adj:
#             self.adj[v2] = []
#         self.adj[v1].append(v2)
#         self.adj[v2].append(v1)  # 无向图：反向边也要加
#
#     def vertices(self):
#         return self.adj.keys()
#
#     def neighbors(self, v):
#         return self.adj[v]