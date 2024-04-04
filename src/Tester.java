
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Tester {
    public static JFrame window;

    public static void main(String[] args){






        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Rpg");

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);






        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGame();







    }
}
