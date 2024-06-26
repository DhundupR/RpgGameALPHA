import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.ArrayList;


public class TileManager {
    GamePanel gp;
    public BufferedImage grass1;
    public Tile [] tile ;
    int mapTile[][];






    public TileManager(GamePanel gp){
        this.gp = gp;
        tile =  new Tile[16];
        mapTile = new int[gp.maxScreenCol][gp.maxScreenRow];
        loadMap();
        getTileImage();
    }


    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("src/map.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int row = 0; int col = 0;
            while(row < gp.maxScreenRow  && col < gp.maxScreenCol){
                String line = reader.readLine();
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);


                    mapTile[col][row] = num;
                    col ++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        }catch (Exception e){


        }
    }

    public void loadNewMap(String x){
        try {
            InputStream is = getClass().getResourceAsStream(x);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int row = 0; int col = 0;
            while(row < gp.maxScreenRow  && col < gp.maxScreenCol){
                String line = reader.readLine();
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);


                    mapTile[col][row] = num;
                    col ++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        }catch (Exception e){


        }
    }


    public void getTileImage(){
        try {






            tile[0] = new Tile();
            tile[0].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/grass01.png"))));
            tile[0].collision = false;
            tile[1] = new Tile();
            tile[1].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/tree.png"))));
            tile[1].collision = true;
            tile[2] = new Tile();
            tile[2].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/grass02.png"))));
            tile[2].collision = false;
            tile[3] = new Tile();
            tile[3].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tiles/tree02.png"))));
            tile[3].collision = true;
            tile[4] = new Tile();
            tile[4].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/grass03.png"))));
            tile[4].collision = false;
            tile[5] = new Tile();
            tile[5].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/slimeTile.png"))));
            tile[5].collision = false;
            tile[6] = new Tile();
            tile[6].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/wayPoint01.png"))));
            tile[6].collision = true;
            tile[7] = new Tile();
            tile[7].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/wayPoint2.png"))));
            tile[7].collision = true;
            tile[8] = new Tile();
            tile[8].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/ghost.png"))));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/skele.png"))));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneWall.png"))));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneFloor.png"))));
            tile[11].collision = false;

            tile[12] = new Tile();
            tile[12].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneFloor02.png"))));
            tile[12].collision = false;

            tile[13] = new Tile();
            tile[13].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneFloor03.png"))));
            tile[13].collision = false;

            tile[14] = new Tile();
            tile[14].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneFloor04.png"))));
            tile[14].collision = false;

            tile[15] = new Tile();
            tile[15].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("src/tiles/stoneFloor05.png"))));
            tile[15].collision = true;










        } catch (IOException e) {
            e.printStackTrace(); //catches it if there's an error
        }
    }






    public void draw(Graphics2D g2) {
        int col =0;
        int row =0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            int num = mapTile[col][row];
            g2.drawImage(tile[num].image, x, y, gp.tileSize,gp.tileSize,null);
            col++;
            x+= gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+= gp.tileSize;
            }
        }
















    }
}

