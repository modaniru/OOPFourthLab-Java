package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.*;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer implements Container{
    ShapeFactory factory = new ShapeFactoryImpl();

    List<Shape> list = new ArrayList<>();
    @Override
    public javafx.scene.shape.Shape addOrSelect(Point2D point2D, ShapeTypes types){
        if(selectAll(point2D)) return null;
        unSelectAll();
        Shape shape = factory.createShape(point2D, types);
        list.add(shape);
        return shape.getInstance();
    }
    @Override
    public List<Shape> deleteAllActiveShapes(){
        List<Shape> deletedShapes = new ArrayList<>();
        for (Shape shape : list) {
            if(shape.isActive()){
                deletedShapes.add(shape);
            }
        }
        list.removeAll(deletedShapes);
        return deletedShapes;
    }

    private boolean selectAll(Point2D point2D){
        boolean hasAny = false;
        for (Shape shape : list) {
            hasAny = shape.isSelect(point2D) || hasAny;
        }
        return hasAny;
    }

    private void unSelectAll(){
        for (Shape shape : list) {
            shape.disableActive();
        }
    }


}
