class Graph:
    def __init__(self):
        self.adj = {}  # 邻接表: 顶点 -> 列表[(邻接点, 权重)]

    def add_edge(self, vertex_1, vertex_2, weight):
        """添加一条边 vertex_1 -> vertex_2，权重为 weight"""
        if vertex_1 not in self.adj:
            self.adj[vertex_1] = []
        if vertex_2 not in self.adj:
            self.adj[vertex_2] = []  # 保证所有点都初始化了
        self.adj[vertex_1].append((vertex_2, weight))

    def vertices(self):
        return self.adj.keys()

    def neighbors(self, v):
        return self.adj[v]


class UndirectedGraph:
    def __init__(self):
        self.adj = {}  # 邻接表: 顶点 -> 邻接点列表

    def add_edge(self, v1, v2):
        """添加一条无向边 v1 - v2"""
        if v1 not in self.adj:
            self.adj[v1] = []
        if v2 not in self.adj:
            self.adj[v2] = []
        self.adj[v1].append(v2)
        self.adj[v2].append(v1)  # 无向图：反向边也要加

    def vertices(self):
        return self.adj.keys()

    def neighbors(self, v):
        return self.adj[v]