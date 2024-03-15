public class Player extends Entity {
    int killCount;
    int level;
    public Player(){
        super(100,1);
        this.killCount=0;
        this.level = 1;
    }
    public void levelUpdater(){}
}
