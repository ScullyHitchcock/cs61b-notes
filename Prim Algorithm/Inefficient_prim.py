import heapq
from Graph import Graph


def prim_mst(graph, start=None):
    """
    使用 Prim 算法求最小生成树
    :param graph: 连通无向有权图
    :param start: 指定起始顶点，如果未指定则随机选择一个
    :return: (mst_edges, total_weight)
             mst_edges 是一个包含 (u, v, weight) 的列表，表示 MST 中的边
             total_weight 是 MST 的总权重
    """
    vertices = graph.vertices()
    if start is None:
        start = next(iter(vertices))  # 随机选择一个顶点作为起点

    mst_edges = []  # 存储 MST 中的边
    total_weight = 0  # 记录 MST 的总权重
    visited = set([start])
    # 候选边集合：存储 (边权, u, v)，其中 u 是已访问顶点，v 是未访问顶点
    candidate_edges = []

    # 初始化：将起点的所有边加入候选边集合
    for (v, weight) in graph.neighbors_of(start):
        heapq.heappush(candidate_edges, (weight, start, v))

    # 当已访问的顶点数未覆盖所有顶点时，继续扩展 MST
    while candidate_edges and len(visited) < len(vertices):
        # 将 u 点的所有邻边中权重最低的那一条加入 MST 中
        weight, u, v = heapq.heappop(candidate_edges)
        if v in visited:
            continue  # 如果 v 已经在 MST 中，则跳过
        mst_edges.append((u, v, weight))
        total_weight += weight
        visited.add(v)

        # 将 v 的所有边（连接到未访问顶点的）加入候选边集合
        for (w, w_weight) in graph.neighbors_of(v):
            if w not in visited:
                heapq.heappush(candidate_edges, (w_weight, v, w))

    return mst_edges, total_weight

if __name__ == '__main__':
    # -------------------------
    # 示例：构造一个图并求最小生成树
    # 顶点：A, B, C, D
    # 边及权重：
    #   A - B: 3
    #   A - C: 1
    #   A - D: 4
    #   B - C: 2
    #   C - D: 5
    # -------------------------

    # 实例化图
    g = Graph()
    g.add_edge('0', '1', 2)
    g.add_edge('0', '2', 1)
    g.add_edge('1', '3', 11)
    g.add_edge('1', '4', 3)
    g.add_edge('1', '2', 5)
    g.add_edge('2', '4', 1)
    g.add_edge('2', '5', 15)
    g.add_edge('3', '4', 2)
    g.add_edge('3', '6', 1)
    g.add_edge('4', '5', 4)
    g.add_edge('4', '6', 3)
    g.add_edge('5', '6', 1)

    # 使用 Prim 算法求 MST，从顶点 'A' 开始
    mst, total_weight = prim_mst(g)

    # 输出结果
    print("Minimum Spanning Tree edges:")
    for u, v, weight in mst:
        print(f"{u} - {v}, weight: {weight}")
    print("Total weight:", total_weight)