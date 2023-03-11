package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.Shape;
import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.geometry.Point2D;

import java.util.List;

public interface Container {
    public javafx.scene.shape.Shape addOrSelect(Point2D point2D, ShapeTypes types);
    public List<Shape> deleteAllActiveShapes();
}
