public class Entity {
    private int health;
    private int maxHealth;
    private int atk;
    private int criticalChance;
    public Entity(int maxHealth, int atk,int criticalChance){
        this.health=maxHealth;
        this.maxHealth=maxHealth;
        this.atk=atk;
        this.criticalChance=criticalChance;
    }
    public int getHealth(){
        return health;
    }
    public int getAtk(){
        return atk;
    }
    public void setHealth(int newHealth){
        health=newHealth;
    }
    public void setAtk(int newAtk){
        atk=newAtk;
    }
    public int getCriticalChance(){return criticalChance;}
    public void setCriticalChance(int newCriticalChance){criticalChance=newCriticalChance;}
    public int getMaxHealth(){return maxHealth;}
    public void setMaxHealth(int newMaxHealth){maxHealth=newMaxHealth;}
    public int baseAttack(){
        if(criticalChance<((int)(Math.random()*100)+1)){
            return getAtk()*2;
        }
        return getAtk();
    }
    public void stat(){
        System.out.println("Max Health: "+maxHealth);
        System.out.println("Health: "+health);
        System.out.println ("Attack:" + atk);
    }
    public void damageTaken(int damage){
        setHealth(health-damage);
        if(health<0){
            health=0;
        }
    }
    public void battle(Player player,Entity entity){
        if(entity instanceof Slime){
            player.battleMob(entity);
            ((Slime) entity).slimeBattle(player,(Slime)entity);
        }

    }




}




