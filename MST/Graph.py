class Graph:
    def __init__(self):
        # 使用字典存储图的邻接表：键为顶点，值为 (邻接顶点, 边权) 的列表
        self.adj = {}

    def add_edge(self, u, v, weight):
        # 添加无向边，即 u 到 v 和 v 到 u 的边都要添加
        if u not in self.adj:
            self.adj[u] = []
        if v not in self.adj:
            self.adj[v] = []
        self.adj[u].append((v, weight))
        self.adj[v].append((u, weight))

    def vertices(self):
        # 获取图中的所有顶点
        return self.adj.keys()

    def neighbors_of(self, v):
        """
        获取顶点的所有邻边
        :param v: 顶点
        :return: 邻边元组: (终点, 边权)
        """
        return self.adj[v]