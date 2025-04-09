import heapq
from Graph import Graph

def dijkstra_prim(graph, start):
    """
    使用 Dijkstra 算法思路改进 prim 算法
    :param graph: 连通无向有权图
    :param start: 指定起始顶点，如果未指定则随机选择一个
    :return: (mst_edges, total_weight)
             mst_edges 是一个包含 (u, v, weight) 的列表，表示 MST 中的边
             total_weight 是 MST 的总权重
    """
    vertices = graph.vertices()
    if start is None:
        start = next(iter(vertices))  # 随机选择一个顶点作为起点

    visited = set()
    edge_to = {}

    # dist_to 为每个顶点 v 到 MST 的距离，初始化：将 start 点到 MST 的距离为 0
    dist_to = {v: float('inf') for v in vertices}
    dist_to[start] = 0

    # fringe 为候选边集合
    fringe = [(0, start)] + [(float('inf'), v) for v in vertices if v != start]
    while fringe:
        cur_dist, v = heapq.heappop(fringe)
        if v in visited:
            continue
        visited.add(v)

        for w, weight in graph.neighbors_of(v):
            if w not in visited:
                potential = dist_to[v] + weight
                if potential < dist_to[w]:
                    dist_to[w] = potential
                    edge_to[w] = v
                    relax