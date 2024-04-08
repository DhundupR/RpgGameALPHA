public class Entity {
    private int health;
    private int maxHealth;
    private int atk;
    private int criticalChance;
    private String drop;
    private String entityType;
    private boolean phase2;

    public Entity(int maxHealth, int atk,int criticalChance){
        this.health=maxHealth;
        this.maxHealth=maxHealth;
        this.atk=atk;
        this.criticalChance=criticalChance;

    }

    public Entity(int maxHealth, int atk,int criticalChance,String drop,String entityType) {
        this.health=maxHealth;
        this.maxHealth=maxHealth;
        this.atk=atk;
        this.criticalChance=criticalChance;
        this.drop=drop;
        this.entityType=entityType;

    }
    public Entity(int maxHealth, int atk,int criticalChance,String drop,String entityType,boolean phase2) {
        this.health=maxHealth;
        this.maxHealth=maxHealth;
        this.atk=atk;
        this.criticalChance=criticalChance;
        this.drop=drop;
        this.entityType=entityType;
        this.phase2=phase2;
    }

    public boolean getPhase2(){
        return phase2;

    }


    public String getDrop(){
        return drop;
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
    public String getEntityType(){
        return entityType;
    }
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

    public void mobBattle(Player player){}
    public void bossBattle(Player player){}
    public void mobDrop(Player player,Entity entity){
        if((Math.random()*100)+1>=20){
            player.getInventory().add(entity.getDrop());
        }
    }




}




