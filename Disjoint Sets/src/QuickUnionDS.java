import java.util.Arrays;

public class QuickUnionDS implements DisjointSets{
    int[] parents;

    public QuickUnionDS(int N) {
        parents = new int[N];
        Arrays.fill(parents, -1);
    }

    public int root(int p) {
        int r = p;
        while (parents[r] >= 0) {
            r = parents[r];
        }
        return r;
    }

    /** O(N)
     */
    @Override
    public void connect(int p, int q) {
        int rootOfp = root(p);
        int rootOfq = root(q);
        parents[rootOfp] = rootOfq;
    }

    /** O(N)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
