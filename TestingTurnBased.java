public class TestingTurnBased {
    public static void main(String[]args){
        Player player = new Player();
        Slime slime = new Slime();
        System.out.println("Old Stat");
        player.stat();
        System.out.println("New Stat");
        player.stat();

        slime.stat();
        while((slime.getHealth()>0)&&(player.getHealth()>0)){
            slime.damageTaken(player.baseAttack());
            slime.buff();
            slime.buff();
            slime.buff();
            slime.regen();
            System.out.println("Slime's Health: " + slime.getHealth());
            player.damageTaken(slime.baseAttack());
            System.out.println("Player's Health:"+ player.getHealth());
        }


    }
}
