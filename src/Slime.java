public class Slime extends Entity{
    public Events events;

    public Slime(Events eve){
        super(50,1,100,"slime","slime");
        this.events = eve;
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
            System.out.println("Slime regen");
        }
    }
}
