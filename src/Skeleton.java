public class Skeleton extends Entity{
    public Skeleton(){
        super(50,5,100);
    }
    public int counter() {
        int counterChance = 50;
        if (counterChance < ((int)(Math.random() * 100) + 1)){
            return baseAttack();
        }
        return 0;
    }
    public void skeletonBattle(Player player, Skeleton skeleton){
        if(skeleton.getHealth()<(skeleton.getMaxHealth()/10)){
            int counter = counter();
            if (counter>0){
                skeleton.setHealth(getHealth()+player.baseAttack());
                player.damageTaken(counter);
                System.out.println("countered");
            }
            else{
                System.out.println("counter Failed");
            }
        }
        else{
            player.damageTaken(baseAttack());
            System.out.println("Base attack");
        }
    }
}
