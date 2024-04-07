import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player extends Entity {
    private int killCount;
    private int levelUpRequirement;
    private int level;
    private int pHealth;
    private int pAtk;
    Scanner scan = new Scanner(System.in);
    private ArrayList<String> inventory;
    Movement move;

    public Player(Movement move) {
        super(100, 5, 10);
        this.pHealth = getMaxHealth();
        this.pAtk = getAtk();
        this.killCount = 0;
        this.level = 1;
        this.levelUpRequirement = 1;
        this.inventory = new ArrayList<String>();
        this.move=move;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public int getpAtk() {
        return pAtk;
    }

    public int getpHealth() {
        return pHealth;
    }

    public void setpHealth(int newPHealth) {
        pHealth = newPHealth;
    }

    public void setpAtk(int newPAtk) {
        pAtk = newPAtk;
    }

    public void levelUpdater() {
        if (levelUpRequirement <= killCount) {
            setMaxHealth((getMaxHealth()) + level * 10);
            setHealth(getMaxHealth());
            setAtk((getAtk()) + level * 5);
            level++;
            levelUpRequirement *= 2;
        }
    }

    public void killCountIncrease() {
        killCount++;
    }
    public void cleanse(){
        setMaxHealth(getpHealth());
        setpAtk(getpAtk());
    }
    public void buff(){
        setHealth(getMaxHealth()*2);
        setAtk(getAtk()*2);
    }
    public void heal(){
        setHealth(getHealth()+getMaxHealth()/2);
        if(getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());

        }    }

    public void battleMob(Entity entity) {
        System.out.println("Choose your move");
        System.out.println("1.Basic Attack");
        int choice = scan.nextInt();
        if (move.basicAttack1) {
            entity.damageTaken(baseAttack());
        }
        if (choice == 2) {
            heal();
        }
        if(choice==3){
            buff();
        }
        if(choice==4){
            cleanse();
        }
    }




    public void encounter(Entity entity) {
        setpHealth(getMaxHealth());
        setpAtk(getAtk());
        int eHealth = entity.getMaxHealth();
        int eAttack = entity.getAtk();

        System.out.println("Meet Sir " + entity.getEntityType());
        System.out.println("Possible Drop:" + entity.getDrop());
        int turn = 1;
        while ((entity.getHealth() > 0) && (getHealth() > 0)) {
            System.out.println("Turn:" + turn);
            System.out.println("-------");
            battleMob(entity);
            System.out.println(entity.getEntityType() + "'s stat:");
            entity.stat();
            System.out.println("-------");
            if (entity.getHealth() <= 0) {
                break;
            }
            entity.mobBattle(this);
            System.out.println("Player's stat:");
            stat();
            System.out.println("----");
            turn++;
        }
        if (entity.getHealth() <= 0) {
            System.out.println("You won");
            setMaxHealth(getpHealth());
            setHealth(getMaxHealth());
            setAtk(getpAtk());
            killCountIncrease();
            levelUpdater();
            entity.setAtk(eAttack);
            entity.setMaxHealth(eHealth);
            entity.setHealth(eHealth);
            mobDrop(this, entity);

        }
    }
}









