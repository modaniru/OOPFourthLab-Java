package com.example.testjavafxapp;

import com.example.testjavafxapp.models.Container;
import com.example.testjavafxapp.models.ProxyShapeContainer;
import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Controller {
    @FXML
    private Pane paintField;
    @FXML
    private CheckBox command;
    @FXML
    private Text countOfDelete;
    private Container shapeContainer;

    @FXML
    public void initialize() {
        Canvas canvas = new Canvas(paintField.getPrefWidth(), paintField.getPrefHeight());
        shapeContainer = new ProxyShapeContainer(canvas);
        paintField.getChildren().add(canvas);
        command.selectedProperty().addListener(this::checkBoxChanged);
    }

    public void paintFieldMouseClick(MouseEvent event) {
        shapeContainer.addOrSelect(new Point2D(event.getX(), event.getY()), ShapeTypes.CIRCLE);
    }

    public void formButtonDown(KeyEvent event) {
        if (event.getCode().equals(KeyCode.COMMAND)) {
            command.setSelected(true);
        } else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
            int count = shapeContainer.deleteAllActiveShapes();
            countOfDelete.setVisible(true);
            countOfDelete.setText(count + " фигур, было удалено");
        }
    }

    public void formButtonUp(KeyEvent event) {
        if (event.getCode().equals(KeyCode.COMMAND)) {
            command.setSelected(false);
        }
    }

    public void checkBoxSelectType(ActionEvent event) {
        shapeContainer.changeSelectType();
    }

    public void checkBoxChanged(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        shapeContainer.changeManySelectionType();
    }

    public void btnClearField(ActionEvent actionEvent) {
        int count = shapeContainer.deleteAll();
        countOfDelete.setVisible(true);
        countOfDelete.setText(count + " фигур, было удалено");
    }
}
