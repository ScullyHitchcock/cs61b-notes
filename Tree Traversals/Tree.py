class Tree:
    def __init__(self, value, children=None):
        self.value = value
        self.children = children if children is not None else []

    def add_child(self, child_node):
        self.children.append(child_node)

    def print_tree(self, level=0):
        print('  ' * level + str(self.value))
        for child in self.children:
            child.print_tree(level + 1)
