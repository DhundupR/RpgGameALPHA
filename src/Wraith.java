public class Wraith extends Entity{
    public Events events;
    public Wraith(Events eve){super(50,2,10,"dark spirit","wraith"); this.events = eve;}
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
            events.ghostAtk = true;
            this.events.gp.repaint();
            events.gp.paintComponent(events.gp.g);
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Attacked Player");
            events.ghostAtk = false;
        }
        else{
            lifesteal(player);
            System.out.println("Lifesteal");
        }
    }


}