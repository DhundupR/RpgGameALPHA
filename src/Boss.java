public class Boss extends Entity {
    private boolean phase2;
    public Boss(Events eve) {
        super(200, 20, 100, "reward?", "boss");
        phase2=false;
    }
    public boolean getPhase2(){
        return phase2;
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
        System.out.println("Boss used debuff");
    }

    public void regen() {
        setHealth(getHealth() + (getMaxHealth() - getHealth() / 2));
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }
    public void regenV2(){
        System.out.println("Boss regened " + getHealth()/2 + " hp");
        setHealth(getHealth() + (getMaxHealth() - getHealth() / 2));
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }
    public void counter(Player player) {
        int counterChance = 50;
        if (counterChance < ((int) (Math.random() * 100) + 1)) {
            int atk = player.baseAttack();
            setHealth(getHealth() + atk);
            player.damageTaken(atk);
            System.out.println("Boss Countered and dealt " + atk+ "damage");
        }
        else{
            System.out.println("Boss Counter Attempt Failed");
        }
    }
    public void lifesteal(Player player){
        int atk = baseAttack();
        System.out.println("Boss used Lifesteal and healed for "+ atk +"hp");
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
            int atk = baseAttack();
            System.out.println("Boss attacked and dealt" + atk + "damage");
            player.damageTaken(atk);
        }
        else{
            regen();
        }
    }
    public void bossBattle(Player player){
        if(player.getAtk()>=4500){
            debuffAtk(player);

        }
        else if((getHealth()>getMaxHealth()*0.8)&&(getMaxHealth()<5000)){
            buffV2();
            if(getMaxHealth()>5000){
                setMaxHealth(5000);
            }
            System.out.println("Boss Buffed");
        }
        else if(getHealth()>getMaxHealth()*0.4){
            lifesteal(player);
        }
        else if(getHealth()>getMaxHealth()*0.2){
            debuffAtk(player);
        }
        else{
            regenV2();
        }

    }




}
