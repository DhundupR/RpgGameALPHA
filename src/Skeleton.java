public class Skeleton extends Entity{
    public Events events;
    public Skeleton(Events eve){
        super(150,20,100,"Bone","skeleton");
        this.events = eve;
    }
    public void counter(Player player) {
        int counterChance = 50;
        if (counterChance < ((int)(Math.random() * 100) + 1)) {
            int atk = player.baseAttack();
            setHealth(getHealth() + atk);
            player.damageTaken(atk);
            System.out.println("Skeleton countered and dealt " + atk +" damage");
        }
        else{
            System.out.println("Skeleton counter attempt failed");
        }
    }
    @Override
    public void mobBattle(Player player){
        if(getHealth()<(getMaxHealth()/5)) {
            counter(player);
        }
        else{
            events.skeleAtk = true;
            this.events.gp.repaint();
            try {
                Thread.sleep(2 * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int atk = baseAttack();
            player.damageTaken(atk);
            System.out.println("Skeleton used basic attack and dealt" + atk + "damage");
            events.skeleAtk = false;
        }
    }
}
