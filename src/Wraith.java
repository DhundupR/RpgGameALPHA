public class Wraith extends Entity{
    public Wraith(){super(50,2,10,"dark spirit","wraith");}
    public void debuffAtk(Player player){
        player.setAtk(player.getAtk()/2);
    }
    public void lifesteal(Player player){
        int atk =baseAttack();
        player.damageTaken(atk);
        setHealth(getHealth()+atk);
        if(getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }
    public void mobBattle(Player player){
        if((getHealth()>getHealth()/2)){
            debuffAtk(player);
            System.out.println("Debuffed Player");
        }
        else if(getHealth()<getMaxHealth()/4){
            player.damageTaken(baseAttack());
            System.out.println("Attacked Player");
        }
        else{
            lifesteal(player);
            System.out.println("Lifesteal");
        }
    }


}