//import java.awt.event.*;

//import javax.naming.directory.DirContext;

//import jdk.nashorn.internal.ir.BreakableNode;

public class Pacman
{
    private int positionX = 14 * Report15.N, positionY = 24 * Report15.N, direction;
    private boolean isInvincible;
    

    public void move()
    {
        switch (direction){
            case 0:
            int cell = Stage.getCell(positionY/Report15.N - 1, positionX/Report15.N);
            System.out.println(cell);
            if(/*positionY <= 0 * Report15.N + Report15.N/2 &&*/ cell == 0) return;
            positionY -= 2;
            break;
            case 1:
            cell = Stage.getCell(positionY/Report15.N + 1, positionX/Report15.N);
            System.out.println(cell);
            if(/*positionY > 31 * Report15.N - Report15.N/2 &&*/ cell == 0) return;
            positionY += 2;
            break;
            case 2:
            cell = Stage.getCell(positionY/Report15.N, positionX/Report15.N - 1);
            System.out.println(cell);
            if(/*positionX <= 0 * Report15.N + Report15.N/2 &&*/ cell == 0) return;
            positionX -= 2;
            break;
            case 3:
            cell = Stage.getCell(positionY/Report15.N, positionX/Report15.N + 1);
            System.out.println(cell);
            if(/*positionX > 28 * Report15.N - Report15.N/2 &&*/ cell == 0) return;
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