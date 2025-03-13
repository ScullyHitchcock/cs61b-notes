import java.util.LinkedList;

public class WeightedQuickUnionWithPathCompressionDs extends QuickUnionDS{

    public WeightedQuickUnionWithPathCompressionDs(int N) {
        super(N);
    }

    public int root(int p) {
        LinkedList<Integer> temp = new LinkedList<>();
        int parent = parents[p];
        while (parent >= 0) {
            temp.addLast(p);
            p = parent;
            parent = parents[parent];
        }
        for (int i: temp) {
            if (i != p) {
                parents[i] = p;
            }
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        if (isConnected(p, q)) return;
        int rootP = root(p);
        int rootQ = root(q);
        if (parents[rootP] <= parents[rootQ]) {
            parents[rootP] += parents[rootQ];
            parents[rootQ] = rootP;
        } else {
            parents[rootQ] += parents[rootP];
            parents[rootP] = rootQ;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return super.isConnected(p, q);
    }
}
