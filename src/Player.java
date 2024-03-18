import java.util.Scanner;
public class Player extends Entity {
    int killCount;
    int levelUpRequirement;
    int level;
    Scanner scan = new Scanner(System.in);

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
    public void battleMob(Entity entity){
        System.out.println("Choose your move");
        System.out.println("1.Basic Attack");
        int choice = scan.nextInt();
        if(choice == 1){
            entity.damageTaken(baseAttack());
        }
        if(choice ==2){
            entity.damageTaken(100000);
        }
    }







}

