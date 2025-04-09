class Graph:

    def __init__(self):
        self.nodes = {}  # 字典：node_id -> GraphNode 实例

    def __len__(self):
        return len(self.nodes)

    def add_node(self, node_id):
        if node_id not in self.nodes:
            self.nodes[node_id] = GraphNode(node_id)

    def get_node(self, node_id):
        return self.nodes.get(node_id, None)

    def is_connected(self, node1, node2, visited=None):
        if visited is None:
            visited = set()

        if node1 not in self.nodes or node2 not in self.nodes:
            return False

        if node1 == node2:
            return True

        visited.add(node1)
        for neighbor in self.get_node(node1).neighbors:
            if neighbor.val not in visited:
                if self.is_connected(neighbor.val, node2, visited):
                    return True
        return False


    def add_edge(self, a, b):
        self.add_node(a)
        self.add_node(b)
        self.nodes[a].add_neighbor(self.nodes[b])

    def print_graph(self):
        for node in self.nodes.values():
            print(node)

class GraphNode:
    def __init__(self, val):
        self.val = val
        self.neighbors = []

    def add_neighbor(self, neighbor_node):
        if neighbor_node not in self.neighbors:
            self.neighbors.append(neighbor_node)
            neighbor_node.neighbors.append(self)  # 无向图：互相连接

    def __eq__(self, other):
        return self.val == other.val

    def __repr__(self):
        neighbor_vals = [n.val for n in self.neighbors]
        return f"{self.val}: {neighbor_vals}"

def make_demo_graph():

    g = Graph()
    edges = [
        (0, 1),
        (1, 2),
        (1, 4),
        (2, 5),
        (4, 3),
        (4, 5),
        (5, 6),
        (5, 8),
        (6, 7),
    ]
    for a, b in edges:
        g.add_edge(a, b)
    return g