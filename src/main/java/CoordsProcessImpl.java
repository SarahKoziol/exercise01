import java.util.Collection;

public class CoordsProcessImpl implements CoordsProcess {

    private Collection<Coordinate> coordinateCollection;

    public CoordsProcessImpl(Collection<Coordinate> coordinateCollection){
        this.coordinateCollection = coordinateCollection;
    }

    public Coordinate getCenter() {
        Coordinate center = new Coordinate(0,0);
        for (Coordinate coordinate : coordinateCollection) {
            center.sumUp(coordinate);
        }
        return center.multiply(1.0/this.coordinateCollection.size());
    }

    public int getSize() {
        return this.coordinateCollection.size();
    }
}
