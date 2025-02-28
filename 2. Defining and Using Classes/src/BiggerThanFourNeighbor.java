public class BiggerThanFourNeighbor {

    public static boolean isBiggestOfFourNeighbors(Dog[] dogs, int index) {
        int left_i = Math.max(index - 2, 0);
        int right_i = Math.min(index + 2, dogs.length - 1);
        for (int j = left_i; j <= right_i; j++) {
            if (dogs[j].weightInPounds > dogs[index].weightInPounds) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 15, 10, 5, 10, 15, 22, 20};
        Dog[] dogs = new Dog[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dogs[i] = new Dog(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (isBiggestOfFourNeighbors(dogs, i)) {
                System.out.print(dogs[i].weightInPounds + " ");
            }
        }
    }
}
