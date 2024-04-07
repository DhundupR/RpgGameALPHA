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
    Events event;
    String direction = " ";

    public Player(Movement move,Events eve) {
        super(100, 5, 10);
        this.pHealth = getMaxHealth();
        this.pAtk = getAtk();
        this.killCount = 0;
        this.level = 1;
        this.levelUpRequirement = 1;
        this.inventory = new ArrayList<String>();
        this.move=move;
        this.event = eve;
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
        event.battleOn = true;
        event.gp.repaint();
        System.out.println("Choose your move");
        System.out.println("1.Basic Attack");
        System.out.println("2.heal");
        System.out.println("3.buff");
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int choice = 0;
        if(move.basicAttack1 == true ){
             choice = 1;

        }
        else if(move.basicAttack2 == true ){
            choice = 2;
        }
        else if(move.basicAttack3== true ){
            choice = 3;
        }
        else{
            choice = 4;
        }

        try {
            Thread.sleep(1 * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (choice ==1) {
            event.playerAtk = true;
            event.gp.repaint();
            event.gp.paintComponent(event.gp.g);
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            entity.damageTaken(baseAttack());
            event.playerAtk = false;
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
        choice = 0;
        move.basicAttack1 = false; move.basicAttack4 = false; move.basicAttack2 = false;
        move.basicAttack4 = false;
    }




    public void encounter(Entity entity) {
        event.battleOn = true;
        event.gp.repaint();


        setpHealth(getMaxHealth());
        setpAtk(getAtk());
        int eHealth = entity.getMaxHealth();
        int eAttack = entity.getAtk();

        System.out.println("Meet Sir " + entity.getEntityType());
        System.out.println("Possible Drop:" + entity.getDrop());
        System.out.println(entity.getHealth() + " " + getpHealth());
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
        event.battleOn = false;
        if (entity.getHealth() <= 0) {
            event.battleOn = false;
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









