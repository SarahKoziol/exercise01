public class Coordinate {
    private int coordinateNr;
    private String coordinateName;
    private double x;
    private double y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(int coordinateNr, String coordinateName, double x, double y){
        this.coordinateName = coordinateName;
        this.coordinateNr = coordinateNr;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Coordinate sumUp(Coordinate coordinate) {
        this.x += coordinate.x;
        this.y += coordinate.y;
        return this;
    }

    public Coordinate multiply(double scalar){
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }
}
