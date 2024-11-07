import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    // Bouncer movingSprite;
    // ArrayList<Bouncer> movingSprites = new ArrayList<>();
    // ArrayList<StraightMover> straightMovers = new ArrayList<>();;
    ArrayList<Mover> movers = new ArrayList<>();;


    /** Initializes this class for drawing. */
    public DrawGraphics() {
        // Rectangle box = new Rectangle(15, 20, Color.RED);
        // movingSprite = new Bouncer(100, 170, box);
        // movingSprite.setMovementVector(3, 1);

        movers.add(new Bouncer(100, 170, new Rectangle(15, 20, Color.RED)));
        movers.get(0).setMovementVector(3, 1);
        movers.add(new Bouncer(70, 90, new LineSprite(-20,40,Color.BLUE)));
        movers.get(1).setMovementVector(5, 10);
        
        movers.add(new StraightMover(50, 100, new Rectangle(35, 25, Color.GREEN)));
        movers.get(2).setMovementVector(2, 6);
        movers.add(new StraightMover(170, 130, new LineSprite(-20,40,Color.BLACK)));
        movers.get(3).setMovementVector(1, 4);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        // for(Bouncer movingSprite:movingSprites){
        //     movingSprite.draw(surface);
        // }
        // for(StraightMover straightMover:straightMovers){
        //     straightMover.draw(surface);
        // }
        for(Mover mover:movers){
            mover.draw(surface);
        }
    }
}
