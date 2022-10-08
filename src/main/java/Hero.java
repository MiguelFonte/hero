import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position = new Position(0,0) ;

    public Hero (int a,int b){
        position.setX(a);
        position.setY(b);
    }
    public Position  getPosition(){
        return position;
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
