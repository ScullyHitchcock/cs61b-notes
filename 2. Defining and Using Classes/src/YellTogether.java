public class YellTogether {
    public static void main(String[] args) {
        Dog smallDog = new Dog(5);
        Dog hugeDog = new Dog(150);
        hugeDog.makeNoise();
        smallDog.makeNoise();
        new Dog(20).makeNoise();
    }
}
