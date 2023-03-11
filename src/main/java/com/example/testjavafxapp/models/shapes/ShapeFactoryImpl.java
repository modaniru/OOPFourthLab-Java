package com.example.testjavafxapp.models.shapes;

import javafx.geometry.Point2D;

public class ShapeFactoryImpl implements ShapeFactory{

    @Override
    public Shape createShape(Point2D point2D, ShapeTypes type) {
        if(type.equals(ShapeTypes.CIRCLE)){
            return new CCircle(point2D);
        }
        throw new IllegalArgumentException("not supported shape");
    }
}
