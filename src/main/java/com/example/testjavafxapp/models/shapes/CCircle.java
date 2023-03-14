package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CCircle implements Shape {
    private final Point2D position;
    private boolean isActive;
    private final javafx.scene.shape.Shape instance;

    private final int radius = 30;

    public CCircle(Point2D position) {
        this.position = position;
        isActive = true;
        instance = createInstance();
        setColor();
    }

    private javafx.scene.shape.Shape createInstance(){
        Circle circle = new Circle();
        circle.setFill(Color.rgb(0, 0, 0, 0));
        circle.setCenterX(position.getX());
        circle.setCenterY(position.getY());
        circle.setStrokeWidth(2);
        circle.setRadius(radius);
        return circle;
    }

    private void setColor(){
        if(isActive){
            instance.setStroke(Color.BLUE);
        }else {
            instance.setStroke(Color.BLACK);
        }
    }

    private Paint getColor(){
        if(isActive){
            return Color.BLUE;
        }else {
            return Color.BLACK;
        }
    }

    @Override
    public javafx.scene.shape.Shape getInstance(){
        return instance;
    }

    @Override
    public void changeActive() {
        isActive = !isActive;
        setColor();
    }

    @Override
    public void disableActive() {
        isActive = false;
        setColor();
    }

    @Override
    public boolean isSelect(Point2D point2D) {
        double len = point2D.distance(position);
        if(len < radius){
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
