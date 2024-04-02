import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Entity {
    private int killCount;
    private int levelUpRequirement;
    private int level;
    Scanner scan = new Scanner(System.in);
    private ArrayList<String> inventory;

    public Player(){
        super(100,5,10);
        this.killCount=0;
        this.level = 1;
        this.levelUpRequirement=1;
        this.inventory=new ArrayList<String>();
    }
    public ArrayList<String> getInventory(){
        return inventory;
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
    public void encounter(Entity entity){
        System.out.println("Meet Sir Entity" );
        int turn = 1;
        while((entity.getHealth()>0)&&(getHealth()>0)){
            System.out.println("Turn:" + turn);
            battleMob(entity);
            System.out.println("slime's Health:" + entity.getHealth());
            entity.stat();
            if(entity.getHealth()<=0){
                break;
            }
            entity.mobBattle(this);
            System.out.println("Player's Health:" + getHealth());
            stat();
            turn++;
        }
        if(entity.getHealth()<=0){
            System.out.println("You won");
            killCountIncrease();
            levelUpdater();
            setHealth(getMaxHealth());
            mobDrop(this,entity);
        }
    }







}

