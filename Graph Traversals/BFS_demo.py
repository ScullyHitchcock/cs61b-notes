from collections import deque
import Graph
def bfs(graph: Graph, start: int) -> tuple:
    queue = deque([start])
    marked = {start}
    edge_to = [None] * len(graph)
    dist_to = [None] * len(graph)
    dist_to[start] = 0
    while queue:
        u = queue.popleft()
        for v in graph.nodes[u].neighbors:
            if v.val not in marked:
                queue.append(v.val)
                marked.add(v.val)
                dist_to[v.val] = dist_to[u] + 1
                edge_to[v.val] = u

    return dist_to, edge_to

if __name__ == '__main__':
    g = Graph.make_demo_graph()
    res = bfs(g, 0)
    print(res)
