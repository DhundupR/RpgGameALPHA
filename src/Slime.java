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
    public void slimeBattle(Player player, Slime slime){
        if((slime.getHealth()>slime.getHealth()/2)&&(slime.getMaxHealth()<500)){
            slime.buff();
            System.out.println("Slime buffed");
        }
        else if(slime.getHealth()< slime.getMaxHealth()/4){
            slime.regen();
            System.out.println("Slime regen");
        }
        else{
            player.damageTaken(slime.baseAttack());
            System.out.println("Slime attack");
        }
    }
}
