class Graph:
    def __init__(self):
        # 邻接表: 顶点 -> 列表[(邻接点, 权重)]
        self.adj = {}

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