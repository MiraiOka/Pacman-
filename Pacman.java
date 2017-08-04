import java.awt.event.*;

import javax.naming.directory.DirContext;

import jdk.nashorn.internal.ir.BreakableNode;

public class Pacman
{
    private int positionX = 14, positionY = 24, direction;
    private boolean isInvincible;
    

    public void move()
    {
        switch (direction){
            case 0:
            if(positionY <= 0 * Report15.N + Report15.N/2) return;
            positionY -= 2;
            break;
            case 1:
            if(positionY > 31 * Report15.N - Report15.N/2) return;
            positionY += 2;
            break;
            case 2:
            if(positionX <= 0 * Report15.N + Report15.N/2) return;
            positionX -= 2;
            break;
            case 3:
            if(positionX > 28 * Report15.N - Report15.N/2) return;
            positionX += 2;
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