public class DrawTriangleofStar {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int line = 1;
        while (line <= n) {
            System.out.println("*".repeat(line));
            line += 1;
        }
    }
}
