public class Boss extends Entity {
    public Boss(Events eve) {
        super(200, 20, 100, "reward?", "boss");
    }

    public void buff() {
        setAtk(getAtk()*2);
        setMaxHealth(getMaxHealth() * 2);
    }
    public void buffV2(){
        setAtk(getAtk()*4);
        setMaxHealth(getMaxHealth() * 4);
    }
    public void debuffAtk(Player player){
        player.setAtk(player.getAtk()/2);
    }

    public void regen() {
        setHealth(getHealth() + (getMaxHealth() - getHealth() / 2));
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }
    public void regenV2(){
        setHealth(getHealth() + (getMaxHealth() - getHealth() / 2));
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }
    public void counter(Player player) {
        int counterChance = 50;
        if (counterChance < ((int) (Math.random() * 100) + 1)) {
            setHealth(getHealth() + player.baseAttack());
            player.damageTaken(player.baseAttack());
            System.out.println("countered");
        }
        else{
            System.out.println("counter Failed");
        }
    }
    public void lifesteal(Player player){
        int atk = baseAttack();
        player.damageTaken(atk);
        setHealth(getHealth()+atk);
        if(getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }
    public void mobBattle(Player player){
        if((getHealth()>getMaxHealth()*0.8)&&(getMaxHealth()<2500)){
            buff();
            if(getMaxHealth()>2500){
                setMaxHealth(2500);
            }
            System.out.println("Boss Buffed");
        }
        else if(getHealth()>getMaxHealth()*0.6){
            counter(player);


        }
        else if(getHealth()>getMaxHealth()*0.5){
            player.damageTaken(baseAttack());
        }
        else{
            regen();
        }
    }




}
