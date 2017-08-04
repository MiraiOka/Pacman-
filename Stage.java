public class Stage
{
    public void readCSV()
    {
        try {
            File f = new File("stage.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));
 
            String line;
            // 1行ずつCSVファイルを読み込む
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換

                for (String elem : data) {
                    System.out.println(elem);
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}