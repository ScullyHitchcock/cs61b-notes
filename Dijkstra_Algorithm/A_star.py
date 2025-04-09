"""
Dijkstra 算法可以被视为 A* 的一个特例，其启发函数 h(v, goal) 恒为常数或 0，不携带任何目标方向的信息。
优秀的 A* 算法应使用一个与 v 到 goal 距离正相关的启发函数，从而优先探索更接近目标的路径。
反之，启发函数与目标距离无关甚至负相关，则会降低搜索效率，甚至误导搜索。
"""

import heapq
from Graph import Graph
def a_star(graph: Graph, start, goal, heuristic):
    """
    A* 算法，使用启发式函数 h(v, goal) 引导搜索，寻找 start 到 goal 的最短路径。

    A* 与 Dijkstra 算法的相同点：
    - 都维护 dist_to[v] 记录从起点 start 到当前顶点 v 的最短已知距离 g(v)
    - 都使用优先队列（堆）来按当前路径估价排序弹出待处理顶点
    - 都通过松弛邻边更新 dist_to 和 edge_to，最终构建最短路径

    不同点：
    - Dijkstra 使用的优先级是 g(v)，即当前已知路径长度
    - A* 使用的优先级是 f(v) = g(v) + h(v, goal)，即路径估价 + 启发式预估
    - A* 一旦弹出目标点 goal 就可以终止，Dijkstra 直到堆为空才结束
    - 如果 h ≡ 0，A* 退化为 Dijkstra；如果 h 设计得好，A* 可更快到达目标

    :param graph: 图结构
    :param start: 起点
    :param goal: 终点
    :param heuristic: 启发式函数 h(v, goal)，估计 v 到 goal 的距离
    :return: dist_to: 最短路径长度，edge_to: 前驱记录（用于还原路径）
    """

    # 1，dist_to: 记录从 start 到各点的实际路径代价 g(v)，初始化为 ∞
    dist_to = {v: float('inf') for v in graph.vertices()}
    dist_to[start] = 0
    # 2，edge_to: 记录每个顶点的前驱，用于路径还原
    edge_to = {}
    # 3，visited: 已确定最短路径的顶点集合
    visited = set()
    # 4，优先队列：元素为 (f(v), 顶点)，其中 f(v) = g(v) + h(v, goal)
    heap = [(heuristic(start, goal), start)]

    # 主循环：每次取出估价函数最小的顶点 v，进行扩展
    while heap:
        _, v = heapq.heappop(heap)
        if v in visited:
            continue
        visited.add(v)

        if v == goal:
            break  # 找到目标，提前终止

        for w, weight in graph.neighbors(v):
            g_new = dist_to[v] + weight
            if g_new < dist_to[w]:
                dist_to[w] = g_new
                edge_to[w] = v
                f_new = g_new + heuristic(w, goal)
                heapq.heappush(heap, (f_new, w))

    return dist_to, edge_to
