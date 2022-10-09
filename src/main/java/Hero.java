import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element {

    public Hero (int a,int b){
        super(a,b);
    }

    @Override
    public void draw(String cor, String chara, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(cor));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), chara);
    }



    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());
    }

    public void setPosition(Position position) {
        this.position = position;
    };
}
