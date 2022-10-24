public class Triangle {

    public double calculateSquare(int a, int b, int c) {
        double pp = (a + b + c) / 2.0;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }
}
