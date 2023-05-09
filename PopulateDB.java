import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileReader;
import java.io.BufferedReader;

public class PopulateDB {

    public static void main(String[] args) {
        PopulateDB pop = new PopulateDB();
        System.out.println("Populating database...");

        pop.loadData("create_tables.sql");
        pop.loadData("pokemon.sql");
        pop.loadData("ability.sql");
        pop.loadData("type.sql");
        pop.loadData("item.sql");
        pop.loadData("egggroup.sql");
        pop.loadData("move.sql");
        pop.loadData("status.sql");

        pop.loadData("pokemon_type.sql");
        pop.loadData("pokemon_egg.sql");
        pop.loadData("pokemon_evolution.sql");
        pop.loadData("pokemon_ability.sql");
        pop.loadData("pokemon_move_1_of_6.sql");
        pop.loadData("pokemon_move_2_of_6.sql");
        pop.loadData("pokemon_move_3_of_6.sql");
        pop.loadData("pokemon_move_4_of_6.sql");
        pop.loadData("pokemon_move_5_of_6.sql");
        pop.loadData("pokemon_move_6_of_6.sql");
        pop.loadData("pokemon_form.sql");
        pop.loadData("pokemon_item_form_change.sql");
        pop.loadData("pokemon_item_evolution.sql");
        pop.loadData("item_status_effects.sql");
        pop.loadData("move_status_effects.sql");
        pop.loadData("move_type.sql");
        pop.loadData("type_weakness_resist_immunity.sql");
        pop.loadData("type_status_immunity.sql");

        System.out.println("Done - Ready to run interface!");
    }

    private Connection connection;

    public PopulateDB() {
        Properties prop = new Properties();
        String fileName = "auth.cfg";
        try {
            FileInputStream configFile = new FileInputStream(fileName);
            prop.load(configFile);
            configFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find config file.");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Error reading config file.");
            System.exit(1);
        }
        String username = (prop.getProperty("username"));
        String password = (prop.getProperty("password"));

        if (username == null || password == null) {
            System.out.println("Username or password not provided.");
            System.exit(1);
        }

        String connectionUrl = "jdbc:sqlserver://uranium.cs.umanitoba.ca:1433;"
                + "database=cs3380;"
                + "user=" + username + ";"
                + "password=" + password + ";"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        try {
            // create a connection to the database
            connection = DriverManager.getConnection(connectionUrl);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void loadData(String script) {
        try {
            if (script != null) {
                BufferedReader reader = new BufferedReader(new FileReader(script));
                String line = reader.readLine();
                Statement stmt = this.connection.createStatement();

                // assumes each query is its own line
                System.out.println("Running script (" + script + ")...");
                while (line != null) {
                    // System.out.println(line);
                    stmt.addBatch(line);
                    line = reader.readLine();
                }
                stmt.executeBatch();
                reader.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        }
    }
}