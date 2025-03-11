public class Main {
    public static void main(String[] args) {
        Person n = new Person("Neil", 12);
        Person a = new Grandma("Ada", 60);
        Grandma v = new Grandma("Vidya", 80);

        /* 编译阶段：
        1. 实例n的静态类型是Person，参数a的静态类型是Person，实例方法名为greet。
        2. 编译器首先根据实例n的静态类型，找到其对应的Person类中存在名为greet的方法。
        3. 接下来继续判断方法内部的形参类型是否与实参的静态类型是否一致：greet(Person other) -> greet(a)，由于a的静态类型是Person，所以能够通过编译。
        解释阶段：
        1. 实例n的动态类型是Person，解释器根据其动态类型定位进入Person类，最后成功运行Person.greet(Person other)方法。
         */
        n.greet(a); // Hello Ada!

        /* 编译阶段：
        1. 实例n的静态类型是Person，参数v的静态类型是Grandma，实例方法名为greet。
        2. 编译器首先根据实例n的静态类型，找到其对应的Person类中存在名为greet的方法。
        3. 接下来继续判断方法内部的形参类型是否与实参的静态类型是否一致：greet(Person other) -> greet(v)，由于v的静态类型是Grandma，与Person不相符。
        4. 但编译器检测到Grandma extends Person，所以能够通过编译。
        解释阶段：
        1. n的动态类型是Person，解释器根据其动态类型定位进入Person类，最后成功运行Person.greet(Person other)方法。
         */
        n.greet(v); // Hello Vidya!

        /* 编译阶段：
        1. 实例v的静态类型是Grandma，参数a的静态类型是Person，实例方法名为greet。
        2. 编译器首先根据实例n的静态类型，找到其对应的Grandma类中存在两个名称同为greet但参数类型不同的方法，一个参数为(Person other)，另一个为(Grandma other)。
        3. 对比判断实参a的静态类型后发现greet(Person other)匹配，通过编译。
        解释阶段：
        1. v的动态类型是Grandma，解释器根据其动态类型定位进入Grandma类，最后成功运行Grandma.greet(Person other)方法。
         */
        v.greet(a); // Hello young fella.

        /* 编译阶段：
        1. 实例v的静态类型是Grandma，参数a的静态类型是Person，实例方法名为greet。
        2. 代码对a进行casting，临时将其静态类型转换为Grandma。
        3. 根据实例n的静态类型，编译器进入Grandma类匹配到greet(Grandma other)方法，编译成功。
        解释阶段：
        1. v的动态类型是Grandma，解释器根据其动态类型定位进入Grandma类，最后成功运行Grandma.greet(Grandma other)方法。
         */
        v.greet((Grandma) a); // How was bingo Ada?

        /* 编译阶段：
        1. 实例a的静态类型是Person，参数n的静态类型是person，实例方法名为greet。
        2. 根据实例n的静态类型，编译器进入Person类匹配到greet(Person other)方法，通过编译。
        解释阶段：
        1. a的动态类型是Grandma，解释其根据此进入Grandma类，运行其中的Grandma.greet(Person other)方法。
         */
        a.greet(n); // Hello young fella.

        /* 编译阶段：
        1. 实例a的静态类型是Person，参数v的静态类型是Grandma，实例方法名为greet。
        2. 编译器首先根据实例a的静态类型，找到其对应的Person类中存在名为greet的方法。
        3. 接下来继续判断方法内部的形参类型是否与实参的静态类型是否一致：greet(Person other) -> greet(v)，由于v的静态类型是Grandma，与Person不相符。
        4. 但编译器检测到Grandma extends Person，所以能够通过编译。
        解释阶段：
        1. a的动态类型是Grandma，解释其根据此进入Grandma类，运行其中的Grandma.greet(Person other)方法。
         */
        a.greet(v); // Hello young fella.

        /* 编译阶段：
        1. 实例a的静态类型是Person，参数v的静态类型是Grandma，实例方法名为greet。
        2. 代码对a进行casting，a的静态类型被暂时转换为Grandma。
        3. 编译器首先根据实例a的静态类型，找到其对应的Grandma类中存在名为greet的方法。
        4. 然后进行参数匹配，成功匹配greet(Grandma other)方法。
        解释阶段：
        1. a的动态类型是Grandma，解释其根据此进入Grandma类，运行其中的Grandma.greet(Grandma other)方法。
         */
        ((Grandma) a).greet(v); // How was bingo Vidya?
    }
}
