# function PrimMST(Graph G):
#     选择任意起点 s
#     初始化 distTo[v] = ∞ 对所有顶点 v
#     distTo[s] = 0
#
#     初始化 edgeTo[v] = None 对所有顶点 v
#
#     fringe = 优先队列（小根堆），元素为 (distTo[v], v)
#     将所有顶点加入 fringe（或用支持 decrease-key 的结构）
#
#     初始化 visited = 空集（记录已加入 MST 的顶点）
#
#     while fringe 不为空:
#         弹出权重最小的顶点 v
#         加入 visited
#
#         for 每条边 (v → w, weight):
#             if w not in visited and weight < distTo[w]:
#                 distTo[w] = weight
#                 edgeTo[w] = v
#                 更新 fringe 中 (w, distTo[w])（decrease-key）
#
#     返回 edgeTo（构成 MST 的边），distTo（用于计算总权重）
from Graph import Graph
from PQ import PQ
from WeightedGraph import WeightedGraph


def eager_prim_mst(graph, start=None):
    dist_to = [float('inf')] * graph.V()
    if start:
        dist_to[start] = 0
    edge_to = [None] * graph.V()
    fringe = PQ()
    for i in range(len(dist_to)):
        fringe.add((dist_to[i], i))
    total_weight = 0

    while fringe:
        dist_to_tree, v = fringe.remove_smallest()
        if dist_to_tree != float('inf'):
            total_weight += dist_to_tree
        dist_to[v] = 0
        for w, weight in graph.adj(v):
            if weight < dist_to[w]:
                dist_to[w] = weight
                edge_to[w] = v
                fringe.change_key(w, (weight, w))

    return total_weight, edge_to

if __name__ == '__main__':
    g = WeightedGraph(3)
    g.add_edge(0, 1, 5)
    g.add_edge(0, 2, 3)
    g.add_edge(1, 2, 1)
    d, e = eager_prim_mst(g)
    print(d)
    print(e)

# function LazyPrimMST(Graph G):
#     选择任意起点 s
#     visited = 空集合           // 标记已加入 MST 的顶点
#     mst_edges = 空集合          // 用于记录 MST 边
#     total_weight = 0           // MST 总权重
#
#     fringe = 最小堆（小根堆）   // 存储跨越 MST 的候选边 (weight, v, w)
#
#     function visit(v):
#         标记 v 为已访问
#         for 每条边 (v, w, weight):
#             if w 未被访问:
#                 将 (weight, v, w) 加入 fringe
#
#     visit(s)
#
#     while fringe 不为空 且 mst_edges 边数 < V - 1:
#         弹出 fringe 中最小的边 (weight, v, w)
#         if v 和 w 都已被访问:
#             continue  // 忽略这条过时边
#
#         将 (v, w) 加入 mst_edges
#         total_weight += weight
#
#         如果 w 未被访问:
#             visit(w)
#         否则:
#             visit(v)
#
#     返回 mst_edges, total_weight