package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.*;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer extends Container {
    private ShapeFactory factory = new ShapeFactoryImpl();
    private List<Shape> list = new ArrayList<>();

    public ShapeContainer(Canvas canvas) {
        super(canvas);
    }


    @Override
    public void addOrSelect(Point2D point2D, ShapeTypes types) {
        if(!selectionType) unSelectAll();
        if (selectAll(point2D)) return;
        unSelectAll();
        Shape shape = factory.createShape(point2D, types);
        list.add(shape);
    }

    @Override
    public int deleteAllActiveShapes() {
        List<Shape> deletedShapes = new ArrayList<>();
        for (Shape shape : list) {
            if (shape.isActive()) {
                deletedShapes.add(shape);
            }
        }
        list.removeAll(deletedShapes);
        return deletedShapes.size();
    }

    private boolean selectAll(Point2D point2D) {
        boolean hasAny = false;
        for (Shape shape : list) {
            hasAny = shape.isSelect(point2D) || hasAny;
            if (hasAny && !selectType) return hasAny;
        }
        return hasAny;
    }

    private void unSelectAll() {
        for (Shape shape : list) {
            shape.disableActive();
        }
    }

    @Override
    public int deleteAll() {
        int size = list.size();
        list.clear();
        return size;
    }

    @Override
    public void drawAll() {
        for (Shape shape : list) {
            shape.draw(canvas.getGraphicsContext2D());
        }
    }

}
