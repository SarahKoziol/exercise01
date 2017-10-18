import java.util.Collection;
import java.sql.*;
import java.util.Properties;

public class CoordsImportPostgreSQL implements CoordsImport {

    public CoordsImportPostgreSQL() {

    }

    public Collection<Coordinate> load() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost/test";
        Properties props = new Properties();
        props.setProperty("user","");
        props.setProperty("password","");
        props.setProperty("ssl","true");
        try(Connection conn = DriverManager.getConnection(url, props);) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mytable WHERE columnfoo = 500");
            while (rs.next()) {
                System.out.print("Column 1 returned");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
