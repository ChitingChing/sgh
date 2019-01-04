
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilidades.FxDialogs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;




public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/sgm", "postgres",
                    "postgres");
            connection.close();
        } catch (SQLException e) {
            FxDialogs.showException("Error","No se ha podido conectar a la base de datos",e);

        }

        if(connection!=null) {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/Inicio.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setMaximized(true);
            primaryStage.setScene(scene);
            Properties prop = new Properties();
            InputStream in = getClass().getResourceAsStream("gradle.properties|");
            prop.load(in);
            String version = prop.getProperty("version");
            if(version!=null) {
                primaryStage.setTitle("HOSPITAL DEL DIA CALDERON " + version);
            }else {
                primaryStage.setTitle("HOSPITAL DEL DIA CALDERON - Development Version ");
            }

            primaryStage.show();
        }else{
            Platform.exit();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
