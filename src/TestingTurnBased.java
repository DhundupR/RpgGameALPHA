public class TestingTurnBased {
    public static void main(String[]args){
        Player player = new Player();
        Slime slime = new Slime();
        Skeleton skeleton = new Skeleton();
        int x =0;
        while(x<5) {
            player.encounter(skeleton);
            x++;
            player.stat();
        }
        System.out.println(player.getInventory());


    }


}
