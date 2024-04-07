public class TestingTurnBased {
    public static void main(String[]args){
        Player player = new Player(new Movement(), new Events(new GamePanel()));
        Slime slime = new Slime(new Events(new GamePanel()));
        Skeleton skeleton = new Skeleton(new Events(new GamePanel()));
        Wraith wraith = new Wraith(new Events(new GamePanel()));
        Boss boss = new Boss(new Events(new GamePanel()));
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
