import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    public Monster(int a, int b) {
        super(a, b);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#222222"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "K");
    }

    public Position move(){
        Random random = new Random();
        switch(random.nextInt(4)){
            case 0:return new Position(position.getX(), position.getY()-1 );
            case 1:return new Position(position.getX(), position.getY()+1 );
            case 2:return new Position(position.getX()-1, position.getY() );
            default:return new Position(position.getX()+1, position.getY() );
        }
    }
}
