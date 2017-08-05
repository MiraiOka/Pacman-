public class Pacman
{
    private int positionX = 14, positionY = 24, direction;
    private boolean[][] existPosition = new boolean[Stage.ROW_Y][Stage.COL_X];
    boolean isGameOver = false;
    
    public Pacman()
    {
        existPosition[positionY][positionX] = true;
    }

    public void move()
    {
        if(!isGameOver){
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

            if(positionX == 0 && positionY == 14){ 
                existPosition[positionY][positionX] = false;
                positionX = 27;
                return;
            }

            if(positionX == 27 && positionY == 14){
                existPosition[positionY][positionX] = false; 
                positionX = 0;
                return;
            }
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

    public int getPositionX()
    {
        return positionX;
    } 

    public int getPositionY()
    {
        return positionY;
    }

    public void gameOver()
    {
        isGameOver = true;
        existPosition[positionY][positionX] = false;
    }
}