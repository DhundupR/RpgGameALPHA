import java.util.ArrayList;
import java.util.Locale;
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
            System.out.println("You leveled up to level" + level);
            stat();
        }
    }

    public void killCountIncrease() {
        killCount++;
    }
    public void cleanse(){
        setMaxHealth(getpHealth());
        setpAtk(getpAtk());
        System.out.println("You cleansed");
    }
    public void buff(){
        setHealth(getMaxHealth()*2);
        setAtk(getAtk()*2);
        System.out.println("You buffed");
    }
    public void heal(){
        System.out.println("You healed for"+getMaxHealth()/2);
        setHealth(getHealth()+getMaxHealth()/2);
        if(getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
            System.out.println("Your health point  is at it's limit");

        }
    }

    public void battleMob(Entity entity) {
        boolean canHeal=moveRequirementChecker("Slime");
        boolean canBuff = moveRequirementChecker("Bone");
        boolean canCleanse = moveRequirementChecker("Dark Spirit");
        if(entity.getEntityType().equals("slime")) {
            event.battleOn = true;
        }else if(entity.getEntityType().equals("wraith")) {
            event.battleOn2 = true;

        }else if(entity.getEntityType().equals("skeleton")) {
            event.battleOn3 = true;

        }


        event.gp.repaint();
        System.out.println("Choose your move");
        System.out.println("1)Basic Attack");
        if(canHeal){
            System.out.println("2)Healing");
        }
        if(canBuff){
            System.out.println("3)buff");
        }
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int choice = 0;
        if(move.basicAttack1 == true){
            if(entity.getEntityType().equals("slime")) {
                event.playerAtk = true;
            }
            if(entity.getEntityType().equals("wraith")) {
                event.playerAtkGhost = true;
            }
            if(entity.getEntityType().equals("skeleton")) {
                event.playerAtkSkele = true;
            }


            event.gp.repaint();
            //event.gp.paintComponent(event.gp.g);
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int atk = baseAttack();
            System.out.println("You dealt " + atk +" damage");
            entity.damageTaken(atk);
            event.playerAtk = false;
            event.playerAtkGhost = false;
            event.playerAtkSkele = false;

        }
        else if(move.basicAttack2 == true){
            if(canHeal){
                if(entity.getEntityType().equals("slime")) {
                    event.slimePlayerHeal = true;
                }
            if(entity.getEntityType().equals("wraith")) {
                event.ghostPlayerHeal = true;
            }
            if(entity.getEntityType().equals("skeleton")) {
                event.skelePlayerHeal = true;
            }
                event.gp.repaint();


                try {
                    Thread.sleep(2 * 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                heal();

                event.slimePlayerHeal = false;
                 event.ghostPlayerHeal = false;
                 event.skelePlayerHeal = false;
           }
            else{
                System.out.println("You haven't unlocked this move yet");
                battleMob(entity);
            }
        }
        else if(move.basicAttack3== true ){
            if(canBuff){
                buff();
            }
            else{
                System.out.println("You haven't unlocked this move yet");
                battleMob(entity);
            }
        }
        else if(move.basicAttack4){
            choice = 4;
        }

        try {
            Thread.sleep(1 * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        if(choice==4){
            cleanse();
        }
        choice = 0;
        move.basicAttack1 = false; move.basicAttack4 = false; move.basicAttack2 = false;
        move.basicAttack4 = false;
    }




    public void encounter(Entity entity) {
        if(entity.getEntityType().equals("slime")) {
            event.battleOn = true;
        }  else if(entity.getEntityType().equals("wraith")) {
            event.battleOn2 = true;
        } else if (entity.getEntityType().equals("skeleton")) {
            event.battleOn3 = true;
        }
        setpHealth(getMaxHealth());
        setpAtk(getAtk());
        int eHealth = entity.getMaxHealth();
        int eAttack = entity.getAtk();

        System.out.println("Meet Sir " + nameUppercase(entity.getEntityType()));
        System.out.println("Possible Drop:" + entity.getDrop());

        int turn = 1;
        while ((entity.getHealth() > 0) && (getHealth() > 0)) {
            entity.mobBattle(this);
            System.out.println("Turn:" + turn);
            System.out.println("--------------");
            battleMob(entity);
            System.out.println(nameUppercase(entity.getEntityType()) + "'s stat:");
            entity.stat();
            System.out.println("--------------");
            if (entity.getHealth() <= 0) {
                break;
            }
            System.out.println("Player's stat:");
            stat();
            System.out.println("-----------");
            turn++;
        }
        event.battleOn = false;
        event.battleOn2 = false;
        event.battleOn3 = false;
        if(entity.getHealth()<=0&&entity.getEntityType().equals("boss")&&entity.getPhase2()){
            System.out.println("The boss has awaken its true power");
            System.out.println("Phase 2 beginning");
            entity.setMaxHealth(500);
            entity.setAtk(50);
            entity.setHealth(500);
            while ((entity.getHealth() > 0) && (getHealth() > 0)) {
                entity.bossBattle(this);
                System.out.println("Turn:" + turn);
                System.out.println("--------------");
                battleMob(entity);
                System.out.println(nameUppercase(entity.getEntityType()) + "'s stat:");
                entity.stat();
                System.out.println("--------------");
                if (entity.getHealth() <= 0) {
                    break;
                }
                System.out.println("Player's stat:");
                stat();
                System.out.println("-----------");
                turn++;
            }
        }
        if (entity.getHealth() <= 0) {
            event.battleOn = false;
            event.battleOn2 = false;
            event.battleOn3 = false;
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
    public boolean moveRequirementChecker(String drop){
        for(int i =0;i<inventory.size();i++){
            if(inventory.get(i).equals(drop)){
                return true;
            }
        }
        return false;
    }
    public String nameUppercase(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }
}









