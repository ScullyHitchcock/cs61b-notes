import Graph

def dfp(graph: Graph, start: int) -> list:
    marked = [False] * len(graph)
    edge_to = [None] * len(graph)
    def dfs(node):
        marked[node] = True
        for adj in graph.nodes[node].neighbors:
            if not marked[adj.val]:
                edge_to[adj.val] = node
                dfs(adj.val)
    dfs(start)
    return edge_to

if __name__ == '__main__':
    g = Graph.make_demo_graph()
    e = dfp(g, 0)
    print(e)