import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
private Position position= new Position(10,10);
public Wall(int a,int b){
    position.setX(a);
    position.setY(b);

}
public void  draw(TextGraphics graphics){
    graphics.setForegroundColor(TextColor.Factory.fromString("#1F2453"));
    graphics.enableModifiers(SGR.BOLD);
    graphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");

}
public Position getPosition(){
    return position;

}
}

