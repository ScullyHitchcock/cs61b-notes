from Tree import Tree


def make_tree():
    # 使用ABCD英文字母为节点构造一个满二叉树
    # 构建叶子节点
    D = Tree('D')
    E = Tree('E')
    F = Tree('F')
    G = Tree('G')
    # 构建中间层
    B = Tree('B', [D, E])
    C = Tree('C', [F, G])
    # 构建根节点
    A = Tree('A', [B, C])

    return A


def pre_order(tree):
    print(tree.value)
    for child in tree.children:
        pre_order(child)

def in_order(tree):
    for child in tree.children:
        in_order(child)
    print(tree.value)

if __name__ == "__main__":
    A = make_tree()
    pre_order(A)
    print()
    in_order(A)
    print()
    A.print_tree()

