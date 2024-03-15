public class TestingTurnBased {
    public static void main(String[]args){
        Player player = new Player();
        Slime slime = new Slime();
        System.out.println("Old Stat");
        player.stat();
        System.out.println("New Stat");
        player.stat();
        Skeleton skeleton= new Skeleton();

        slime.stat();
        int turn = 1;
        while((skeleton.getHealth()>0)&&(player.getHealth()>0)){
            System.out.println("Turn:" + turn);
            skeleton.damageTaken(player.baseAttack());
            System.out.println("Skeleton's Health:" + skeleton.getHealth());
            skeleton.stat();
            skeleton.skeletonBattle(player,skeleton);
            System.out.println("Player's Health:" + player.getHealth());
            player.stat();
            turn++;
        }


    }
}
