public class TestingTurnBased {
    public static void main(String[]args){
        Player player = new Player(new Movement(), new Events(new GamePanel()));
        Slime slime = new Slime();
        Skeleton skeleton = new Skeleton();
        Wraith wraith = new Wraith();
        Boss boss = new Boss();
        int x =0;
        while(x<10) {
            player.encounter(slime);
            x++;
            player.stat();
        }

        player.encounter(boss);
        System.out.println(player.getInventory());


    }


}
