package de.tu_bs.cs.isf.spl.simplecad.plugins.node; 

import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape; 


public  class  NodeBuilder  extends ShapeBuilder {
	
    private int pointsAdded;

	
    private Node node;

	

    public void addPoint(Point point) {
        pointsAdded++;
        if (node == null)
            node = (Node) makeShape();
        node.setPoint(point);
    }

	

    public boolean isShapeFinished() {
        return pointsAdded > 0;
    }

	

    public Shape getShape() {
        if (node == null)
            node = (Node) makeShape();
        return node;
    }

	

    protected Shape makeShape() {
        return new Node();
    }


}
