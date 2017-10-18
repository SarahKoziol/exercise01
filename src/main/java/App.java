public class App {
    public static void main(String[] args) {
        CoordsImport gLoader = new CoordsImportCsv("_public___poi_.csv");
        CoordsProcess gProcess = new CoordsProcessImpl(gLoader.load());
        Coordinate center = gProcess.getCenter();
        System.out.println("Coordinate: x: " + center.getX() + "|y: " + center.getY());
        System.out.println(gProcess.getSize());
    }
}
