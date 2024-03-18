
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale*origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    TileManager manager = new TileManager(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);


    }

    public void paintingComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        manager.draw(g2);
        g2.dispose();

    }



}
