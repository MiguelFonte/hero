import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int x = 10;
    private int y = 10;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

    }
    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    public void run() throws IOException {

        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(KeyType.EOF==key.getKeyType()) break;

        }
    }
    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp){
            y-=1;
        }
        else if (key.getKeyType() == KeyType.ArrowDown){
            y+=1;
        }
        else if (key.getKeyType() == KeyType.ArrowLeft){
            x-=1;
        }
        else if (key.getKeyType() == KeyType.ArrowRight){
            x+=1;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter()
                == 'q'){
            screen.close();
        }
    }

}
