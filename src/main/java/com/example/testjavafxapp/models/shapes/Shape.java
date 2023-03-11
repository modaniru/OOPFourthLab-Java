package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;

import java.util.List;

public interface Shape {
    public javafx.scene.shape.Shape getInstance();
    public void changeActive();
    public void disableActive();
    public boolean isSelect(Point2D point2D);
    public boolean isActive();
}
