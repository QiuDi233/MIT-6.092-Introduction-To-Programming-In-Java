import java.awt.Graphics;

public interface Mover {
    void setMovementVector(int xIncrement, int yIncrement);
    void draw(Graphics graphics);
}
