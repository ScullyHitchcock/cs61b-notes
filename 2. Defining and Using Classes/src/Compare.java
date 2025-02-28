public class Compare {
    public static void main(String[] args) {
        Dog a = new Dog(5);
        Dog b = new Dog(30);
        Dog bigger = Dog.maxDog(a, b);
        bigger.makeNoise();
    }
}
