public class Slime extends Entity{
    public Slime(){
        super(10,1,100);
    }
    public void buff(){
        setAtk(getAtk()*2);
        setMaxHealth(getMaxHealth()*2);
    }
    public void regen(){
        setHealth(getHealth()+(getMaxHealth()-getHealth()/2));
        if (getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }
    public void mobBattle(Player player){
        if((getHealth()>getHealth()/2)&&(getMaxHealth()<500)){
            buff();
            System.out.println("Slime buffed");
        }
        else if(getHealth()<getMaxHealth()/4){
            regen();
            System.out.println("Slime regen");
        }
        else{
            player.damageTaken(baseAttack());
            System.out.println("Slime attack");
        }
    }
}
