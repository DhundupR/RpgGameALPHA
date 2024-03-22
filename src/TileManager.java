import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    public BufferedImage grass1;
    Tile [] tile ;


    public TileManager(GamePanel gp){
        this.gp = gp;

        getTileImage();
    }

    public void getTileImage(){
        try {
            grass1 =  ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/grass01.png")));

        } catch (IOException e) {
            e.printStackTrace(); //catches it if there's an error
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
            image = grass1;
            g2.drawImage(image,0,0, gp.tileSize, gp.tileSize,null);

        }
}
