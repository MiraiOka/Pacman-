import java.awt.event.*;

import javax.naming.directory.DirContext;

public class Pacman
{
    private int positionX = 14, positionY = 24, direction;
    private boolean isInvincible;
    

    public void move()
    {
        switch (direction){
            case 0:
            positionY++;
            break;
            case 1:
            positionY--;
            break;
            case 2:
            positionX++;
            break;
            case 3:
            positionX--;
        }
    }

    public void changeDirection(int direction)
    {
        this.direction = direction;
        System.out.println(direction);
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