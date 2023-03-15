package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public interface Shape {
    public void changeActive();
    public void disableActive();
    public boolean isSelect(Point2D point2D);
    public boolean isActive();
    public void draw(GraphicsContext graphicsContext);
}
