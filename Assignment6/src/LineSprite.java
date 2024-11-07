import java.awt.Graphics;
import java.awt.Color;

public class LineSprite implements Sprite{
    /**
     * Draws this sprite on surface, with the coordinate (leftX, topY) as the
     * top left corner.
     */
    private int width;
    private int height;
    private Color color;

    public LineSprite(int width,int height,Color color){
        this.width=width;
        this.height=height;
        this.color=color;
    }
    public void draw(Graphics surface, int leftX, int topY){
        surface.setColor(color);
        if(width>=0)
            surface.drawLine(leftX, topY, leftX+width, topY+height);
        else{
            surface.drawLine(leftX-width, topY, leftX, topY+height);
        }
    }

    /** Returns the width of the sprite. */
    public int getWidth(){
        return Math.abs(width);
    }
    /** Returns the height of the sprite. */
    public int getHeight(){
        return height;
    }
}
