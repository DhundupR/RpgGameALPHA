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

        player.encounter(slime);


    }


}
