package vg.sales.gui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import vg.sales.model.CSVSheet;
import vg.sales.model.VGSale;
import vg.sales.reader.CSVReader;
import vg.sales.writer.WriteToFile;

/**
 *
 * @author Konstantinos Raptis
 */
public abstract class JavaFXSupportApplication extends Application {

    private static final String TITLE = "Video Game Sales CSV Parser";
    private static final int WIDTH = 550;
    private static final int HEIGHT = WIDTH / 12 * 9;
    
    private final String GREEN_HEX = "86FF82";
    private final String GRAY_HEX = "C0C0C0";
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

        final StackPane layout = new StackPane();
        layout.setBackground(new Background(new BackgroundFill(Paint.valueOf(GRAY_HEX), CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().add(new Label("Drop CSV File Here"));
        
        Scene scene = new Scene(layout, WIDTH, HEIGHT);

        layout.setOnDragOver((DragEvent event) -> {

            Dragboard db = event.getDragboard();

            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        });

        layout.setOnDragEntered((DragEvent event) -> {
            layout.setBackground(new Background(new BackgroundFill(Paint.valueOf(GREEN_HEX), CornerRadii.EMPTY, Insets.EMPTY)));
            event.consume();
        });
        
        layout.setOnDragExited((DragEvent event) -> {
            layout.setBackground(new Background(new BackgroundFill(Paint.valueOf(GRAY_HEX), CornerRadii.EMPTY, Insets.EMPTY)));
            event.consume();
        });
        
        // Dropping over surface
        layout.setOnDragDropped((DragEvent event) -> {

            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasFiles()) {

                success = true;
                String filePath;

                for (File file : db.getFiles()) {
                    filePath = file.getAbsolutePath();

                    try {
                        CSVReader reader = new CSVReader();
                        CSVSheet sheet = reader.read(file, true, VGSale.class);
                        WriteToFile writer = new WriteToFile();
                        writer.write(filePath, sheet);
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFXSupportApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

            event.setDropCompleted(success);
            event.consume();
        });

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
