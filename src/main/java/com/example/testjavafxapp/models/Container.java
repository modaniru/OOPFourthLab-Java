package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.Shape;
import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Container {
    protected Canvas canvas;
    protected boolean selectType = false;
    protected boolean selectionType = false;

    public Container(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void addOrSelect(Point2D point2D, ShapeTypes types);

    public abstract int deleteAllActiveShapes();

    public abstract void drawAll();

    public void changeSelectType() {
        selectType = !selectType;
    }

    public void changeManySelectionType() {
        selectionType = !selectionType;
    }

    public abstract int deleteAll();
}
