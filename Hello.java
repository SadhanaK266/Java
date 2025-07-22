public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int base = 2;
        int exponent = 3;
        int result = getPower(base, exponent);
        System.out.println("The result of " + base + " raised to the power of " + exponent + " is: " + result);
    }
    private static int getPower(int base, int exponent) {
        return (int) Math.pow(base, exponent);
    }
}