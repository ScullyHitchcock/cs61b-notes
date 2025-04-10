class PQ:
    """
    A priority queue (min-heap) implementation.

    The heap is stored in a list 'tree' with index 0 unused.
    Elements are arranged so that the smallest element is at the root (index 1).
    """

    def __init__(self, *keys):
        """
        Initialize the priority queue with optional initial keys.

        :param keys: Initial values to be added to the priority queue.
        """
        # The heap list starts with a placeholder at index 0.
        self.tree = [None]
        self.position_map = {}  # vertex -> index in tree
        for key in keys:
            self.add(key)

    def __len__(self):
        """
        Return the number of elements in the priority queue.
        (Excludes the placeholder None at index 0.)
        """
        return len(self.tree) - 1

    def __bool__(self):
        """
        Return True if the priority queue is not empty, False otherwise.
        """
        return len(self) > 0

    def __str__(self):
        return str(self.tree[1:])

    def parent_index(self, i):
        """
        Get the index of the parent node of the node at index i.

        :param i: Index of the current node.
        :return: Index of the parent node or None if i is the root.
        """
        res = i // 2
        return res if res >= 1 else None

    def l_child_index(self, i):
        """
        Get the index of the left child of the node at index i.

        :param i: Index of the current node.
        :return: Index of the left child, or None if it does not exist.
        """
        res = i * 2
        return res if res <= len(self) else None

    def r_child_index(self, i):
        """
        Get the index of the right child of the node at index i.

        :param i: Index of the current node.
        :return: Index of the right child, or None if it does not exist.
        """
        res = i * 2 + 1
        return res if res <= len(self) else None

    def sink(self, i):
        """
        Sink the element at index i downwards to restore the heap property.

        :param i: Index of the element to sink.
        """
        # Get left and right child indices; use current index if child doesn't exist.
        l_child_i = self.l_child_index(i) or i
        r_child_i = self.r_child_index(i) or i

        # Determine the index of the smallest value between the current node and its children.
        small_i = min(l_child_i, r_child_i, key=lambda x: self.tree[x])

        # If a child is smaller than the current node, swap them and continue sinking.
        if self.tree[small_i] < self.tree[i]:
            self.swap(i, small_i)
            self.sink(small_i)

    def swim(self, i):
        """
        Swim the element at index i upwards to restore the heap property.

        :param i: Index of the element to swim.
        """
        # Get parent index; if None, current node is root.
        parent_i = self.parent_index(i) or i

        # If the parent's value is greater, swap and continue swimming.
        if self.tree[parent_i] > self.tree[i]:
            self.swap(parent_i, i)
            self.swim(parent_i)

    def swap(self, i, j):
        """
        Swap the elements at indices i and j and update position_map accordingly.

        :param i: First index.
        :param j: Second index.
        """
        ele_i = self.tree[i][1]
        ele_j = self.tree[j][1]
        self.position_map[ele_i], self.position_map[ele_j] =\
            self.position_map[ele_j], self.position_map[ele_i]
        self.tree[i], self.tree[j] = self.tree[j], self.tree[i]

    def add(self, val):
        """
        Add a new value to the priority queue and restore the heap order by swimming.

        :param val: The value to add (expected to be a tuple (key, vertex)).
        """
        self.tree.append(val)
        index = len(self)
        self.position_map[val[1]] = index
        self.swim(index)

    def get_smallest(self):
        """
        Retrieve the smallest element (at the root) without removing it.

        :return: The smallest element, or None if the priority queue is empty.
        """
        if self:
            return self.tree[1]

    def remove_smallest(self):
        """
        Remove and return the smallest element from the priority queue.

        :return: The smallest element, or None if the priority queue is empty.
        """
        if self:
            self.swap(1, -1)
            key = self.tree.pop()
            del self.position_map[key[1]]
            if self:
                self.sink(1)
            return key

    def change_key(self, k1, k2):
        """
        Update the key of the element identified by vertex k2 to a new key k1.

        This method uses the position_map to find the current index of the vertex in the heap,
        updates its associated key, and then restores the heap property.

        :param k1: The new priority value (key).
        :param k2: The vertex whose key is to be updated.
        """
        i = self.position_map[k2]
        self.tree[i] = (k1, k2)
        self.swim(i)
        self.sink(i)
