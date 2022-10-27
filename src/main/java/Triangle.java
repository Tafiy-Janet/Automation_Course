public class Triangle {

    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateSquare() {
        double pp = (a + b + c) / 2.0;
        return Math.floor(Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)));
    }

    @Override
    public String toString() {
        return "Triangle: a:" + a + " b:" + b + " c:" + c + ";";
    }
}
