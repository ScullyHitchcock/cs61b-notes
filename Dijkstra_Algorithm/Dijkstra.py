import heapq
from Graph import Graph


def dijkstra(graph: Graph, start):
    """
    Dijkstra 算法，计算一张图中 start 顶点到其余所有顶点的最短距离和相应路径
    :param graph: 图结构
    :param start: 初始顶点
    :return: dist_to: 最短路径距离 edge_to: 前驱记录（用于还原最短路径本身）
    """
    dist_to = {v: float('inf') for v in graph.vertices()}
    dist_to[start] = 0
    edge_to = {}
    visited = set()
    heap = [(0, start)]

    while heap:
        cur_dist, v = heapq.heappop(heap)
        if v in visited:
            continue
        visited.add(v)

        for w, weight in graph.neighbors(v):
            if w in visited:
                continue

            potential = dist_to[v] + weight
            if potential < dist_to[w]:
                dist_to[w] = potential
                edge_to[w] = v
                heapq.heappush(heap, (potential, w))

    return dist_to, edge_to

def reconstruct_path(edge_to, start, end):
    """
    通过前驱记录还原路径
    :param edge_to: 前驱记录字典
    :param start: 起点
    :param end: 终点
    :return: 起点到终点的路径列表
    """
    path = []
    at = end
    while at != start:
        path.append(at)
        at = edge_to[at]
    path.append(start)
    path.reverse()
    return path

if __name__ == '__main__':
    g = Graph()
    g.add_edge("A", "B", 4)
    g.add_edge("A", "C", 1)
    g.add_edge("C", "B", 2)
    g.add_edge("B", "D", 1)
    g.add_edge("C", "D", 5)

    dist, edge_to = dijkstra(g, "A")
    print("最短路径距离:", dist)
    print("前驱记录:", edge_to)
    path = reconstruct_path(edge_to, "A", "D")
    print(f"从 A 到 D 的路径", path)