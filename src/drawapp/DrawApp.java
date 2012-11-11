package drawapp;

import drawapp.Parser;
import java.io.InputStreamReader;
import java.io.Reader;
import javafx.application.Application;
import javafx.stage.Stage;
import drawapp.ImagePanel;

public class DrawApp extends Application {
    public static void main(String[] args) { 
        launch(args); 
    }

    @Override
    public void start(Stage stage)
    {
        MainWindow mw=new MainWindow(stage);
        ImagePanel imagePanel = mw.getImagePanel();
        Reader reader = new InputStreamReader(System.in);
        Parser parser = new Parser(reader,imagePanel,mw);
        parser.parse();
        stage.show();
    }
    
}
