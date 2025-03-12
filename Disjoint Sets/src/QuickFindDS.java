public class QuickFindDS implements DisjointSets{

    int[] id;

    /* need to iterate through the array => Θ(N) */
    @Override
    public void connect(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[q]) {
                id[i] = id[p];
            }
        }
    }

    /* Θ(N) */
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
