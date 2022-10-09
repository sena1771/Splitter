import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public  class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception  {

        primaryStage.setTitle("Splitter");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        //primaryStage.setScene(new MyScreen(new StackPane(),screenBounds.getWidth(), screenBounds.getHeight()));
        primaryStage.setScene(new MyScreen(new StackPane(),1400, 950));
        primaryStage.show();
    }
    public static  void main(String[] args) { launch(args);}
}
