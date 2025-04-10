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
        Swap the elements at indices i and j.

        :param i: First index.
        :param j: Second index.
        """
        self.tree[i], self.tree[j] = self.tree[j], self.tree[i]

    def add(self, val):
        """
        Add a new value to the priority queue and restore the heap order by swimming.

        :param val: The value to add.
        """
        self.tree.append(val)
        self.swim(len(self))

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

        This method swaps the root with the last element, removes the last element,
        and then sinks the new root to restore the heap property.

        :return: The smallest element, or None if the priority queue is empty.
        """
        if self:
            self.swap(1, -1)
            res = self.tree.pop()
            if self:
                self.sink(1)
            return res

    def change_key(self, i, key):
        """
        Change the value (key) at a given index and restore the heap property.

        Both upward and downward adjustments are performed.

        :param i: The index at which to change the value.
        :param key: The new value.
        """
        self.tree[i] = key
        self.swim(i)
        self.sink(i)

if __name__ == '__main__':
    pq = PQ(3, 2, 1)
    print(len(pq))
    print(pq.get_smallest())
    print(pq.remove_smallest())
    pq.add(1)
