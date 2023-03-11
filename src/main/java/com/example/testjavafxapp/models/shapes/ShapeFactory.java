package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;

public interface ShapeFactory {
    public Shape createShape(Point2D point2D, ShapeTypes type);
}
