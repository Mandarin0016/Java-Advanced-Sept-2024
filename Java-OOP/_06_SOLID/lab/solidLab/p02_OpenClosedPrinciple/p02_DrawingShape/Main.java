package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Triangle triangle = new Triangle();

        DrawingManagerImpl drawingManager = new DrawingManagerImpl();
        drawingManager.draw(triangle);
    }
}
