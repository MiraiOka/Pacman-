public class Ghost
{
    private int positionX = 14, positionY = 13, direction = 2;
    private boolean[][] existPosition = new boolean[Stage.ROW_Y][Stage.COL_X];
    private boolean isGameOver = false;

    public Ghost()
    {
        existPosition[positionY][positionX] = true;
    }
    public void move()
    {
        if(!isGameOver){
            if((direction == Direction.UP || direction == Direction.DOWN) && (Stage.cell[positionY][positionX+1] != 0 || Stage.cell[positionY][positionX-1] != 0))
            {
                direction = (int)(Math.random()*4);
            }

            if((direction == Direction.LEFT || direction == Direction.RIGHT) && (Stage.cell[positionY+1][positionX] != 0 || Stage.cell[positionY-1][positionX] != 0))
            {
                direction = (int)(Math.random()*4);
            }

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
