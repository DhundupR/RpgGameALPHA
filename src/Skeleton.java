public class Skeleton extends Entity{
    public Skeleton(Events eve){
        super(50,5,100,"bone","skeleton");
    }
    public void counter(Player player) {
        int counterChance = 50;
        if (counterChance < ((int)(Math.random() * 100) + 1)) {
            setHealth(getHealth() + player.baseAttack());
            player.damageTaken(player.baseAttack());
            System.out.println("countered");
        }
        else{
            System.out.println("counter Failed");
        }
    }
    public void mobBattle(Player player){
        if(getHealth()<(getMaxHealth()/10)) {
            counter(player);
        }
        else{
            player.damageTaken(baseAttack());
            System.out.println("Base attack");
        }
    }
}
