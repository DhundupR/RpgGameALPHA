public class Skeleton extends Entity{
    public Skeleton(Events eve){
        super(50,5,100,"Bone","skeleton");
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
    public void mobBattle(Player player){
        if(getHealth()<(getMaxHealth()/5)) {
            counter(player);
        }
        else{
            int atk = baseAttack();
            player.damageTaken(atk);
            System.out.println("Skeleton used basic attack and dealt" + atk + "damage");
        }
    }
}
