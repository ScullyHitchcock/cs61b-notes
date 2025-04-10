from PQ import PQ
from WeightedGraph import WeightedGraph

def eager_prim_mst(graph, start=None):
    """
    Implements the eager version of Prim's algorithm to compute the Minimum Spanning Tree (MST)
    of a given weighted undirected graph.

    :param graph: An instance of WeightedGraph.
    :param start: The starting vertex for the MST. If None, defaults to vertex 0.
    :return: A tuple containing:
             - total_weight: The total weight of the MST.
             - edge_to: A list where edge_to[v] is the parent of vertex v in the MST.
    """
    # dist_to[v] records the minimum known weight to connect vertex v to the growing MST
    dist_to = [float('inf')] * graph.V()
    if start is None:
        start = 0
    dist_to[start] = 0
    # edge_to[v] records the parent of vertex v in the MST
    edge_to = [None] * graph.V()
    fringe = PQ()
    # Initialize the priority queue with all vertices and their initial distances
    for i in range(len(dist_to)):
        fringe.add((dist_to[i], i))
    total_weight = 0

    # Main loop: expand the MST by selecting the closest fringe vertex
    while fringe:
        dist_to_tree, v = fringe.remove_smallest()
        total_weight += dist_to_tree
        dist_to[v] = 0
        # Relax edges: if a cheaper connection to w is found, update it
        for w, weight in graph.adj(v):
            if weight < dist_to[w]:
                dist_to[w] = weight
                edge_to[w] = v
                fringe.change_key(weight, w)

    return total_weight, edge_to

if __name__ == '__main__':
    # Test graph from Prim’s Demo image (7 vertices, indexed 0 to 6)
    # From https://cs61b-2.gitbook.io/cs61b-textbook/25.-minimum-spanning-trees/25.2-prims-algorithm
    g = WeightedGraph(7)
    g.add_edge(0, 1, 2)
    g.add_edge(0, 2, 1)
    g.add_edge(1, 2, 5)
    g.add_edge(1, 3, 11)
    g.add_edge(1, 4, 3)
    g.add_edge(2, 4, 1)
    g.add_edge(2, 5, 15)
    g.add_edge(3, 4, 2)
    g.add_edge(3, 6, 1)
    g.add_edge(4, 5, 4)
    g.add_edge(4, 6, 3)
    g.add_edge(5, 6, 1)

    total_weight, edge_to = eager_prim_mst(g, start=0)
    print("Total weight of MST:", total_weight)
    print("Edge to array:", edge_to)
