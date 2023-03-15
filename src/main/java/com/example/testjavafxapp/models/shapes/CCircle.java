package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CCircle implements Shape {
    private final Point2D position;
    private boolean isActive;
    private final int radius = 30;

    public CCircle(Point2D position) {
        this.position = position;
        isActive = true;
    }

    private Paint getColor() {
        if (isActive) {
            return Color.BLUE;
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public void changeActive() {
        isActive = !isActive;
    }

    @Override
    public void disableActive() {
        isActive = false;
    }

    @Override
    public boolean isSelect(Point2D point2D) {
        double len = point2D.distance(position);
        if (len < radius) {
            changeActive();
            return true;
        }
        return false;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getColor());
        graphicsContext.setLineWidth(2);
        graphicsContext.strokeOval(position.getX() - radius, position.getY() - radius, radius * 2, radius * 2);
    }
}
