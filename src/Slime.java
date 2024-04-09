public class Slime extends Entity{
    public Events events;

    public Slime(Events eve){
        super(20,5,100,"Slime","slime");
        this.events = eve;
    }

    public void buff(){
        setAtk(getAtk()*2);
        setMaxHealth(getMaxHealth()*2);
    }
    public void regen(){
        System.out.println("Slime regened " + (getHealth()/2) + " hp");
        setHealth(getHealth()+(getHealth()/2));
        if (getHealth()>getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }
    @Override
    public void mobBattle(Player player){
        if((getHealth()>getHealth()/2)&&(getMaxHealth()<500)){
            buff();
            if (getHealth() > getMaxHealth()) {
                setHealth(getMaxHealth());
            }
            System.out.println("Slime buffed");
        }
        else if(getHealth()>getMaxHealth()/3){
            events.slimeAtk = true;
            this.events.gp.repaint();
            events.gp.paintComponent(events.gp.g);
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            player.damageTaken(baseAttack());
            System.out.println("Slime attack");
            events.slimeAtk = false;
        }
        else{
            regen();
        }
    }
}
