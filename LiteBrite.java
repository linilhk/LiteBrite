/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litebrite;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

/**
 *
 * @author narayan
 */
public class LiteBrite extends Application {
    
    @Override
    public void start(final Stage stage) throws Exception {
        int rows = 50;
        int columns = 50;

        stage.setTitle("Enjoy your game");

        GridPane grid = new GridPane();
        grid.getStyleClass().add("game-grid");

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(10);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(10);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane();
                pane.setOnMouseReleased(e -> {
                    pane.getChildren().add(Anims.getAtoms(1));
                });
                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }


        Scene scene = new Scene(grid, (columns * 10)+20, (rows * 10)+20);
        scene.getStylesheets().add(LiteBrite.class.getResource("resources/game.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static class Anims {

        public static Node getAtoms(final int number) {
            //TODO: Add code to create a colored
        	Stage stage = new Stage();
        	stage.setTitle("ColorPicker");
            Scene scene = new Scene(new VBox(20), 250, 130);
            scene.setFill(Color.web("#ccffcc"));
            VBox box = (VBox) scene.getRoot();   
                 
            final ColorPicker colorPicker = new ColorPicker();
            colorPicker.setValue(Color.CORAL);
            
            final Text text = new Text("Choose your color and press OK");
            text.setFont(Font.font ("Verdana", 15));
            
            Rectangle r = new Rectangle();
            r.setX(0);
            r.setY(0);
            r.setWidth(9);
            r.setHeight(9);
            
            Button btn = new Button("OK");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                	stage.close();
                }
            });
            
            colorPicker.setOnAction(new EventHandler() {
                public void handle(Event t) {
                	r.setFill(colorPicker.getValue());             
                }
            });
     
            box.getChildren().add(text);
            box.getChildren().add(colorPicker);
            box.getChildren().add(btn);
     
            stage.setScene(scene);
            stage.show();
            
            return r;
        }
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }
    
}
