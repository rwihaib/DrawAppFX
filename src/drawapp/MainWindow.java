package drawapp;

import java.awt.Color;
import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Rasheed
 */
public class MainWindow {

    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 600;

    Scene scene;
    private Stage Pstage;
    ImagePanel imageRegion;
    ImagePanel buttonRegion = new ImagePanel(600,50);
    String cssDefault = "-fx-border-color: black;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 0;\n";
    
    private TextArea textarea = new TextArea();
    private Button closeButton = new Button("CloseWindow");
    Button nextButton = new Button("Next");
    Button completeButton = new Button("Complete");


    public MainWindow(Stage stage) 
    {
        this(stage, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public MainWindow(Stage primaryStage, int width, int height) {
        primaryStage.setTitle("DrawApp");
        Pstage=primaryStage;
        Group root = new Group();
        scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        GridPane gridpane = buildGUI();
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
    }

    private GridPane buildGUI() {
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(0);
        
        //Adding ImagePanel
        imageRegion = new ImagePanel(600,400);
        imageRegion.setStyle(cssDefault);
        //imageRegion.startTurtle(50, 20, 30);//TESTER
        
        
        gridpane.add(imageRegion, 0, 0);
        // Text area
        textarea.setWrapText(true);
        textarea.setPrefWidth(600);
        textarea.setPrefHeight(150);
        GridPane.setHalignment(textarea, HPos.CENTER);
        gridpane.add(textarea, 0, 1);
        postMessage("Drawing Completed!!");
        

        buttonRegion.setAlignment(Pos.CENTER);
        buttonRegion.setBackgroundColour("#E8E8E8");

        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        Button saveButton = new Button("Save");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WritableImage wim = new WritableImage(DEFAULT_WIDTH,DEFAULT_WIDTH );
                imageRegion.snapshot(null, wim);          
                File file = new File("Image.png");
                 try {
                    ImageIO.write(SwingFXUtils.fromFXImage(wim, null), "png", file);
                 } catch (Exception s) 
                 {
                     s.printStackTrace();
                }
            }
        });
        buttonRegion.add(completeButton);
        buttonRegion.add(nextButton);
        buttonRegion.add(closeButton);
        buttonRegion.add(saveButton);
        gridpane.add(buttonRegion, 0, 2);
        return gridpane;
    }
    
    public Button getNext()
    {
        return nextButton;
    }
    public Button getComplete()
    {
        return completeButton;
    }

    public ImagePanel getImagePanel() 
    {
        return imageRegion;
    }

    public void postMessage(final String s) 
    {
        textarea.setText(s);
    }
    
    public Stage getStage()
    {
        return Pstage;
    }
    
    public void changeSize(int width,int height){
      imageRegion.setPrefHeight(height-200);
      imageRegion.setPrefWidth(width);
      textarea.setPrefWidth(width);
      textarea.setPrefHeight(100);
      buttonRegion.setPrefWidth(width);
      buttonRegion.setPrefHeight(100);
  }
}
