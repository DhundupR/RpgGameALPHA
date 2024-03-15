public class Slime extends Entity{
    public Slime(){
        super(10,1,100);
    }
    public void buff(){
        setAtk(atk*2);
        setMaxHealth(maxHealth*2);
    }
    public void regen(){
        health+=(maxHealth-health)/2;
        if (health>maxHealth){
            health=maxHealth;
        }
    }
}
