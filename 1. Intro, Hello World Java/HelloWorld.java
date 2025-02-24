public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
/*
1. public class HelloWorld
	public：访问修饰符，表示这个类是公共的，其他类可以访问它。
	class：声明一个类，Java 是一种面向对象编程语言，所有的代码都必须写在类中。
	HelloWorld：类的名称，习惯上首字母大写，符合 Java 的类命名规范。

2. public static void main(String[] args)
	这是 Java 程序的主方法（Main Method），是 Java 程序的入口点。
	public：表示该方法是公共的，Java 虚拟机（JVM）可以调用它。
	static：表示这个方法是静态的，不需要创建类的实例就能调用。
	void：表示这个方法没有返回值。
	main：方法的名称，Java 规定 main 方法的名称必须是 main，否则 JVM 无法识别。
	(String[] args)：
	    String[]：表示这是一个字符串数组，用来接收命令行参数（如果有的话）。
	    args：变量名，通常写作 args，但可以改成其他名称，比如 myArgs，只要类型不变就行。

3. {} and ;
	Java 代码块的标志，表示类或方法的开始和结束。
	语句必须以分号结尾。

4. System.out.println("Hello World");
	这一行代码的作用是向控制台输出 “Hello World”，并换行。
	System：Java 的标准类，代表系统。
	out：表示标准输出流（指向控制台）。
	println("Hello World")：
	print：输出内容，但不换行。
	println：输出内容，并换行。
	("Hello World")：双引号内的内容是字符串，会被原样打印出来。

5. 运行程序（终端）
    javac HelloWorld.java
    	javac：是 Java 的编译器命令，用于将 .java 源代码文件编译成 .class 字节码文件。
        HelloWorld.java：这是你要编译的 Java 源文件。
        这条命令会生成一个 HelloWorld.class 文件，包含已编译的字节码。
    java HelloWorld
        java：这是 Java 的运行时命令，用来运行已编译的 Java 程序。
        HelloWorld：这是你要运行的类的名称（必须是包含 main 方法的类）。
        输出：程序执行后，控制台输出了 "Hello World"，表示 main 方法内的 System.out.println("Hello World"); 被成功执行。
 */