import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.ArrayList;

public class TileManager {
    GamePanel gp;
    public BufferedImage grass1;
    Tile [] tile ;
    ArrayList x = new ArrayList<ImageIO>() ;


    public TileManager(GamePanel gp){
        this.gp = gp;
        tile =  new Tile[1];




        getTileImage();
    }

    public void getTileImage(){
        try {



                tile[0] = new Tile();
                tile[0].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/grass01.png"))));





        } catch (IOException e) {
            e.printStackTrace(); //catches it if there's an error
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
            image = grass1;


            for(int i = 0; i < gp.screenWidth; i += gp.tileSize){
                for (int k = 0; k < gp.screenHeight * gp.tileSize; k += gp.tileSize) {

                    g2.drawImage(tile[0].image,i,k, gp.tileSize, gp.tileSize,null);


                }
            }






        }
}
