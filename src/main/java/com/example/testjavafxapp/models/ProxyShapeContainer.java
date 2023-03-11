package com.example.testjavafxapp.models;

import com.example.testjavafxapp.models.shapes.ShapeTypes;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.List;
import java.util.stream.Collectors;

public class ProxyShapeContainer implements Container{
    private Container container = new ShapeContainer();
    private final Pane paintField;

    public ProxyShapeContainer(Pane paintField){
        container = new ShapeContainer();
        this.paintField = paintField;
    }

    @Override
    public Shape addOrSelect(Point2D point2D, ShapeTypes types) {
        return container.addOrSelect(point2D, types);
    }

    @Override
    public List<com.example.testjavafxapp.models.shapes.Shape> deleteAllActiveShapes() {
        List<com.example.testjavafxapp.models.shapes.Shape> removed = container.deleteAllActiveShapes();
        paintField.getChildren()
                .removeAll(removed.stream().map(com.example.testjavafxapp.models.shapes.Shape::getInstance).toList());
        return removed;
    }
}
