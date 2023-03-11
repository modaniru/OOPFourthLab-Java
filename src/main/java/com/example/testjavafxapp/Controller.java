package com.example.testjavafxapp;

import com.example.testjavafxapp.models.ShapeContainer;
import com.example.testjavafxapp.models.shapes.ShapeFactory;
import com.example.testjavafxapp.models.shapes.ShapeFactoryImpl;
import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


public class Controller {

    @FXML
    Pane paintField;
    @FXML
    CheckBox command;
    ShapeContainer shapeContainer = new ShapeContainer();
    public void paintFieldMouseClick(MouseEvent event){
        Shape shape = shapeContainer.addOrSelect(new Point2D(event.getX(), event.getY()), ShapeTypes.CIRCLE);
        if(shape != null){
            paintField.getChildren().add(shape);
        }
    }

    public void formButtonDown(KeyEvent event){
        if(event.getCode().equals(KeyCode.COMMAND)){
            command.setSelected(true);
        }
    }

    public void formButtonUp(KeyEvent event){
        if(event.getCode().equals(KeyCode.COMMAND)){
            command.setSelected(false);
        }
    }
}
