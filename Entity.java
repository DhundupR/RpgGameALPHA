public class Entity {
    public int health;
    public int atk;
    public Entity(int health, int atk){
        this.health=health;
        this.atk=atk;
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
}


