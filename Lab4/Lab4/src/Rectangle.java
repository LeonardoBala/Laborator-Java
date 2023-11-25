public class Rectangle {

    // Dati
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double calculArie() {
        return width * length;
    }

    public double calculPerimetru() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle\n" +
                "length=" + length + "\n" +
                "width=" + width + "\n" +
                "Area=" + calculArie() + "\n" +
                "Perimetru=" + calculPerimetru() + "\n";
    }
}
