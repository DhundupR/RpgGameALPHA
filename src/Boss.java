public class Boss extends Entity {
    private boolean phase2;
    public Events events;
    public Boss(Events eve) {
        super(200, 20, 99, "reward?", "boss",false);
        this.events = eve;
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
        System.out.println("Boss regened " + (getMaxHealth() - getHealth() / 2)+ "hp");
        setHealth(getHealth() + (getMaxHealth() - getHealth() / 2));
        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }
    public void regenV2(){
        System.out.println("Boss regened " + (getMaxHealth() - getHealth()) + " hp");
        setHealth(getHealth() + (getMaxHealth() - getHealth()));
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
    @Override
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
            if(this.getPhase2()){
                events.phase2Atk = true;

            } else {
                events.phase1Atk = true;
            }
            events.gp.repaint();
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int atk = baseAttack();
            System.out.println("Boss attacked and dealt" + atk + "damage");
            player.damageTaken(atk);

            events.phase1Atk = false;
            events.phase2Atk = false;
        }
        else{
            if(this.getPhase2()){
                events.phase2Regen = true;

            } else {
                events.phase1Regen = true;
            }
            events.gp.repaint();

            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            regen();

            events.phase1Regen = false;
            events.phase2Regen = false;
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
        else if(getHealth()>getMaxHealth()*0.6){
            if(this.getPhase2()){
                events.phase2Blood = true;
            } else {
                events.phase1Blood = true;
            }

            events.gp.repaint();
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lifesteal(player);
        }
        else if(getHealth()>getMaxHealth()*0.4){
            debuffAtk(player);
        }
        else{
            regenV2();
        }

    }




}
