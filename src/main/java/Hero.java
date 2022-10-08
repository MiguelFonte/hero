import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x;
    private int y;
    public Hero (int a,int b){
        x=a;
        y=b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp(){
        y-=1;
    }
    public void moveRight(){
        x+=1;

    }
    public void moveDown(){
        y+=1;
    }
    public void moveLeft(){
        x-=1;
    }
    public void draw(){

    }

    public void draw(Screen screen) {
        screen.setCharacter(x,y, TextCharacter.fromCharacter('X')[0]);
    }
}
