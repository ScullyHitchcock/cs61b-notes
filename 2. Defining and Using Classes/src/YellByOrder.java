public class YellByOrder {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[2]; // Create an array of Dogs of size 2.
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);
        for (Dog dog: dogs) {
            dog.makeNoise();
        }
    }
}
