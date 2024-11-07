package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;


import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl {


    public void draw(Shape shape) {
       shape.draw();
    }

    public void drawCircle(Circle circle) {
        // Draw Circle
    }

    public void drawRectangle(Rectangle rectangle) {
        // Draw Rectangle
    }
}
