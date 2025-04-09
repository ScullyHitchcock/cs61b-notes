import Graph

if __name__ == '__main__':
    g = Graph.make_demo_graph()
    node = g.get_node("6")
    print(node)
    res = g.is_connected("1", "10")
    print(res)
