package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;


public class ProxyShapeContainer extends Container{
    private final Container container;

    public ProxyShapeContainer(Canvas canvas){
        super(canvas);
        container = new ShapeContainer(canvas);
    }

    @Override
    public void addOrSelect(Point2D point2D, ShapeTypes types) {
        container.addOrSelect(point2D, types);
        drawAll();
    }

    @Override
    public int deleteAllActiveShapes() {
        int removed = container.deleteAllActiveShapes();
        drawAll();
        return removed;
    }

    @Override
    public void drawAll() {
        clearCanvas();
        container.drawAll();
    }

    @Override
    public void changeSelectType() {
        super.changeSelectType();
        container.changeSelectType();
    }

    @Override
    public void changeManySelectionType() {
        super.changeManySelectionType();
        container.changeManySelectionType();
    }

    @Override
    public int deleteAll() {
        int res = container.deleteAll();
        drawAll();
        return res;
    }

    private void clearCanvas(){
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
}
