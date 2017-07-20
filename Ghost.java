public class Ghost
{
    private int up = 0, down = 1, right = 2, left = 3;
    private int positionX = 14, positionY = 13, direction = left;

    private void go()
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
}
