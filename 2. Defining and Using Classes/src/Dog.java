public class Dog {
    // weightInPounds 是一个 public 实例变量，存储 Dog 对象的体重。
    // 实例变量的特点：
    //    每个 Dog 对象都有自己的 weightInPounds 值。
    //    默认值为 0（如果未赋值）。
    public int weightInPounds;

    // 构造方法 Dog(int weight)：
    // 构造方法的名字必须和类名相同。
    // 没有返回值（不像普通方法）。
    // 当 new Dog(8) 被调用时，它会执行 Dog(int weight) 构造方法，并给 weightInPounds 赋值。
    public Dog(int weight) {
        weightInPounds = weight;
    }

//    non-static method
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark.");
        } else {
            System.out.println("woof!");
        }
    }

//    static method
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
}