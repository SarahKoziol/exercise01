import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;


public class CoordsImportCsv implements CoordsImport {

    private String fileName;

    public CoordsImportCsv(String csvFile) {
        this.fileName = csvFile;
    }

    public Collection<Coordinate> load() {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        Collection<Coordinate> coordinateCollection = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';', '\'', 1)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                try {
                    int coordinateNr = Integer.parseInt(nextLine[0]);
                    String coordinateName = nextLine[1];
                    Number numberX = nf.parse(nextLine[2]);
                    Number numberY = nf.parse(nextLine[3]);
                    Coordinate coordinate = new Coordinate(coordinateNr,coordinateName,numberX.doubleValue(), numberY.doubleValue());
                    coordinateCollection.add(coordinate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                System.out.println(nextLine[0] + nextLine[1] + "etc...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinateCollection;
    }
}
