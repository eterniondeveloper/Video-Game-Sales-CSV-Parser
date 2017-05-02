package vg.sales;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import vg.sales.model.CSVSheet;
import vg.sales.model.VGSale;
import vg.sales.reader.CSVReader;
import vg.sales.writer.WriteToFile;

public class App extends Application {

    /**
     * Note that this is configured in application.properties
     */
    private final String windowTitle = "Video Game Sales CSV Parser";

    @Override
    public void start(Stage stage) throws Exception {
        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

        Group root = new Group();
        Scene scene = new Scene(root, 551, 400);

        scene.setOnDragOver((DragEvent event) -> {

            Dragboard db = event.getDragboard();

            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        });

        // Dropping over surface
        scene.setOnDragDropped((DragEvent event) -> {

            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasFiles()) {

                success = true;
                String filePath;

                for (File file : db.getFiles()) {
                    filePath = file.getAbsolutePath();

                    try {
                        CSVReader reader = new CSVReader();
                        CSVSheet sheet = reader.read(filePath, true, VGSale.class);
                        WriteToFile writer = new WriteToFile();
                        writer.write(filePath, sheet);
                    } catch (IOException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

            event.setDropCompleted(success);
            event.consume();
        });

        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
