
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.regex.Pattern;

public class MyScreen extends Scene {

    public MyScreen(StackPane stackPane, double width, double height) {

        super(stackPane, width, height);


        HBox hbox = new HBox();
        Label label = new Label("Kaynak: ");
        label.setMinWidth(190);
        label.setPadding(new Insets(0,0,0,100));


        TextField textField1=new TextField();
        textField1.setPrefWidth(width);
        textField1.setMinWidth(490);

        Label label1=new Label("Anahtar Kelime: ");
        label1.setMinWidth(190);
        label1.setPadding(new Insets(0,0,0,50));


        TextField textField2=new TextField();
        textField2.setMinWidth(270);
        textField2.setPrefWidth(width);


        Button button=new Button("Sorgula");

        button.setMinWidth(100);
        hbox.setStyle("-fx-padding: 15 0 0 0;");
       // HBox.setHgrow(pane, Priority.ALWAYS);
        hbox.setAlignment(Pos.BASELINE_LEFT);


        hbox.getChildren().add(label);
        hbox.getChildren().add(textField1);
        hbox.getChildren().add(label1);
        hbox.getChildren().add(textField2);
        hbox.getChildren().add(button);
        hbox.setSpacing(10);
        hbox.setPrefWidth(width);

        VBox vbox = new VBox();
        TextArea textArea=new TextArea();
        textArea.setEditable(false);
        //textArea.setMaxHeight(820);
        //textArea.setPadding(new Insets(0,50,0,50));





        vbox.getChildren().addAll(hbox,textArea);
        vbox.setSpacing(30);
        vbox.setMargin(textArea,new Insets(0,25,25,25));

        stackPane.getChildren().add(vbox);
        stackPane.setCenterShape(true);


        String successStyle = String.format("-fx-text-box-border: transparent; -fx-focus-color: transparent; -fx-box-sizing: border-box; ");
        textArea.setStyle(successStyle);
        textArea.setPrefHeight(height);
        textArea.setPrefWidth(width);



        button.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String modified = Pattern.compile(textField2.getText(), Pattern.CASE_INSENSITIVE).matcher(textField1.getText()).replaceAll(textField2.getText());
                String[] line = modified.split(textField2.getText());
                //String[] line = textField1.getText().split(textField2.getText());
                textArea.setText("");
                textField2.setStyle(" -fx-font-size: 16px;  -fx-text-inner-color: blue;");
                for (int i = 0; i < line.length; i++) {
                    textArea.setText(textArea.getText()+"\n"+textField2.getText()+":\t"+line[i]);
                }
            }}); } }
