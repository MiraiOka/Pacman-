import java.util.Arrays;

//import java.awt.event.*;

//import javax.naming.directory.DirContext;

//import jdk.nashorn.internal.ir.BreakableNode;

public class Pacman
{
    private int positionX = 14, positionY = 24, direction;
    private boolean isInvincible;
    private boolean[][] existPosition = new boolean[Stage.ROW_Y][Stage.COL_X];
    
    public Pacman()
    {
        //Arrays.fill(existPosition, false);
        existPosition[positionY][positionX] = true;
    }

    public void move()
    {
        switch (direction){
            case 0:
            if(positionY <= 0 || Stage.getCell(positionX, positionY-1) == 0) return;
            existPosition[positionY][positionX] = false;
            positionY--;
            existPosition[positionY][positionX] = true;
            break;

            case 1:
            if(positionY >= Stage.ROW_Y || Stage.getCell(positionX, positionY+1) == 0) return;
            existPosition[positionY][positionX] = false;
            positionY++;
            existPosition[positionY][positionX] = true;
            break;

            case 2:
            if(positionX <= 0 || Stage.getCell(positionX-1, positionY) == 0) return;
            existPosition[positionY][positionX] = false;
            positionX--;
            existPosition[positionY][positionX] = true;
            break;

            case 3:
            if(positionX >= Stage.COL_X || Stage.getCell(positionX+1, positionY) == 0) return;
            existPosition[positionY][positionX] = false;
            positionX++;
            existPosition[positionY][positionX] = true;
            break;
        }
    }

    public void changeDirection(int direction)
    {
        this.direction = direction;
    }

    public boolean[][] getPosition()
    {
        return existPosition;
    }

    
//これ↓いる？
    public void eatGhost()//パックマンが無敵状態の時かつゴーストと衝突した時
    {

    }
}