public class BuildIntList {
    public static IntList convert(int[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        return new IntList(arr[i], convert(arr, i + 1));
    }

    public static void main(String[] args) {
       int[] arr = new int[]{1, 2, 3, 4, 5};
       IntList list = convert(arr, 0);
       System.out.println(list);
    }
}
