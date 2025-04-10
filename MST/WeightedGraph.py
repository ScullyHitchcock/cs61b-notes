class WeightedGraph:
    def __init__(self, V, directed=False):
        """
        创建一个含有 V 个顶点的加权图。

        :param V: 顶点总数（默认顶点编号为 0 到 V-1）
        :param directed: 是否为有向图（默认无向图）
        """
        self.V_count = V
        self.E_count = 0
        self.directed = directed
        self.adj_list = [[] for _ in range(V)]  # 每个顶点的邻接表

    def add_edge(self, v, w, weight):
        """
        添加一条边 v-w（带权重），如果是无向图，也添加 w-v。
        """
        self.adj_list[v].append((w, weight))
        if not self.directed:
            self.adj_list[w].append((v, weight))
        self.E_count += 1

    def adj(self, v):
        """
        返回与顶点 v 相邻的所有边（邻接点和权重的元组）
        """
        return self.adj_list[v]

    def V(self):
        """返回顶点数量"""
        return self.V_count

    def E(self):
        """返回边数量"""
        return self.E_count

    def __str__(self):
        result = []
        for v in range(self.V()):
            neighbors = ', '.join(f"{w}({weight})" for w, weight in self.adj(v))
            result.append(f"{v}: {neighbors}")
        return '\n'.join(result)