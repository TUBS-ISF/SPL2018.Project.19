package de.tu_bs.cs.isf.spl.simplecad.core.builder;

import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

import java.util.Observable;

public class BuildShapeStrategy extends Observable {

    private ShapeBuilder shapeBuilder;
    private ShapeRepository repository;

    public BuildShapeStrategy(ShapeRepository repository) {
        this.repository = repository;
    }

    public void setShapeBuilder(ShapeBuilder builder) {
        this.shapeBuilder = builder;
    }

    public void addPoint(Point point) {
        if (!hasBuilder()) return;
        shapeBuilder.addPoint(point);
        if (shapeBuilder.isShapeFinished()) {
            repository.addShape(shapeBuilder.getShape());
            resetBuilder();
            setChangedAndNotify();
        }
    }

    public boolean hasBuilder() {
        return shapeBuilder != null;
    }

    private void setChangedAndNotify() {
        setChanged();
        notifyObservers();
    }

    private void resetBuilder() {
        shapeBuilder = null;
    }

}
