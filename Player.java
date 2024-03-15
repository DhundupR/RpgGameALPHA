public class Player extends Entity {
    int killCount;
    int levelUpRequirement;
    int level;

    public Player(){
        super(100,5,10);
        this.killCount=0;
        this.level = 1;
        this.levelUpRequirement=1;
    }
    public void levelUpdater(){
        if(levelUpRequirement<=killCount){
            setHealth(getHealth()+10*level);
            setAtk(getAtk()+5*level);
            level++;
            levelUpRequirement*=2;
        }
    }
    public void killCountIncrease(){
        killCount++;
    }







}

