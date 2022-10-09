import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.print.DocFlavor;

public abstract class  Element {
    protected Position position= new Position(10,10);
    public Element(int a, int b){
        position.setX(a);
        position.setY(b);
    }

    public Position getPosition(){
        return position;

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract  void draw(TextGraphics graphics);



}
