import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Stage
{
    static int ROW_Y = 31;
    static int COL_X = 28;

    static int[][] cell = new int[ROW_Y][COL_X];
    public static int[][] readCSV()
    {
        try {
            File f = new File("stage.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));
 
            String[][] data = new String[ROW_Y][COL_X];
            String line = br.readLine();
            for (int row = 0; line != null; row++) {
                data[row] = line.split(",", 0);
                line = br.readLine();
            }
            br.close();
            
            for(int row = 0; row < ROW_Y; row++) {
                for(int col = 0; col < COL_X; col++) {
                    cell[row][col] = Integer.parseInt(data[row][col]); 
                }
            }
            return cell;
        } catch (IOException e) {
            System.out.println(e);
        }
        return cell;
    }

    public static int getCell(int col_x, int row_y)
    {
        if(row_y < 0 || row_y >= ROW_Y || col_x < 0 || col_x >= COL_X) return 0;
        return cell[row_y][col_x];
    }
}