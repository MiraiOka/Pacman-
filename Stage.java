import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

//import javafx.scene.control.Cell;


public class Stage
{
    static int ROW = 31;
    static int COL = 28;

    static int[][] cell = new int[ROW][COL];
    public static int[][] readCSV()
    {
        try {
            File f = new File("stage.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));
 
            String[][] data = new String[ROW][COL];
            String line = br.readLine();
            for (int row = 0; line != null; row++) {
                data[row] = line.split(",", 0);
                line = br.readLine();
            }
            br.close();
            //CSVから読み込んだ配列の中身を表示
            for(int row = 0; row < ROW; row++) {
                for(int col = 0; col < COL; col++) {
                    cell[row][col] = Integer.parseInt(data[row][col]); 
                    //System.out.print(cell[row][col]);
                }
                //System.out.println();
            }
            
            return cell;
        } catch (IOException e) {
            System.out.println(e);
        }
        return cell;
    }

    public static int getCell(int row, int col)
    {
        if(row < 0 || row > ROW || col < 0 || col > COL) return 0;
        return cell[row][col];
    }
}