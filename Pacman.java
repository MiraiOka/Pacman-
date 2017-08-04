import java.awt.event.*;

import javax.naming.directory.DirContext;

import jdk.nashorn.internal.ir.BreakableNode;

public class Pacman
{
    private int positionX = 14, positionY = 24, direction;
    private boolean isInvincible;

    public void go()
    {
        while(true)
        {
            move();
        }
    }
    

    public void move()
    {
        switch (direction){
            case 0:
            if(positionY <= 0) return;
            positionY--;
            System.out.println("aaaaaaaaaaaaaaaa");
            break;
            case 1:
            if(positionY > 31) return;
            positionY++;
            break;
            case 2:
            if(positionX <= 0) return;
            positionX--;
            break;
            case 3:
            if(positionX > 28) return;
            positionX++;
            break;
        }
    }

    public void changeDirection(int direction)
    {
        this.direction = direction;
    }

    public int getPositionX()
    {
        return positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }
//これ↓いる？
    public void eatGhost()//パックマンが無敵状態の時かつゴーストと衝突した時
    {

    }
}