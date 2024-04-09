import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement  implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean basicAttack1;
    public boolean basicAttack2;
    public boolean basicAttack3;
    public boolean basicAttack4;


    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_X){
            //use item

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = true;

        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;

        }
        if(code == KeyEvent.VK_S){
            downPressed = true;

        }if(code == KeyEvent.VK_D){

            rightPressed = true;

        }
        if(code==KeyEvent.VK_1){
            basicAttack1=true;
        }
        if(code==KeyEvent.VK_2){
            basicAttack2=true;
        }
        if(code==KeyEvent.VK_3){
            basicAttack3=true;
        }
        if(code==KeyEvent.VK_4){
            basicAttack4=true;
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;

        }
        if(code == KeyEvent.VK_S){
            downPressed = false;

        }if(code == KeyEvent.VK_D){

            rightPressed = false;

        }




    }


    }

