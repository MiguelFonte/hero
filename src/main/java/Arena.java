import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private Hero hero = new Hero(10, 10);

    public Arena (int a,int b){
        width=a;
        height=b;
        this.walls = createWalls();
        this.coins = createCoins();

    }

    public void processKey(KeyStroke key,Screen screen) throws IOException {
        if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
            retrieveCoins();
        }
        else if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
            retrieveCoins();
        }
        else if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
            retrieveCoins();
        }
        else if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
            retrieveCoins();

        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter()
                == 'q'){
            screen.close();
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public boolean canHeroMove(Position position){
        if(position.getX()<width && position.getX()>=0){
            if(position.getY()<height && position.getY()>=0){
                for (Wall wall : walls){
                    if (position.equals(wall.getPosition())){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;

    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        Position newPosition;
        boolean canadd;
        for (int i = 0; i < 5;) {
            newPosition= new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            canadd=true;
            for(Coin coin : coins ){
                if(coin.getPosition().equals(newPosition)){
                    canadd=false;
                    break;
                }

            }
            if(hero.getPosition().equals(newPosition)){
                canadd=false;
            }
            if (canadd){
                coins.add(new Coin(newPosition.getX(), newPosition.getY()));
                i++;
            }

        }
        return coins;
    }
    public void retrieveCoins(){
        for(Coin coin : coins){
            if(coin.getPosition().equals(hero.getPosition())){
                coins.remove(coin);
                break;
            }
        }
    }

    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
                graphics.fillRectangle(new TerminalPosition(0, 0), new
                        TerminalSize(width, height), ' ');
                hero.draw("#222222", "X",graphics);
        for (Wall wall : walls)
            wall.draw("#111111","O",graphics);
        for(Coin coin : coins){
            coin.draw("#444444","O",graphics);
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }



}
