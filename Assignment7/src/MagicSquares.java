import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));

        boolean isMagic = true;
        int lastSum = -1;
        
        int[][] matrix = new int[10][10];

        // For each line in the file ...
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            if(line.isEmpty()){
                continue;
            }
            String[] parts = line.split("\t");
        
            int sum = 0;
            int j = 0;
            for (String part : parts) {
                sum += Integer.parseInt(part);
                matrix[i][j] = Integer.parseInt(part);
                j++;
            }

            if (lastSum == -1) {
                // If this is the first row, remember the sum
                lastSum = sum;
            } else if (lastSum != sum) {
                // if the sums don't match, it isn't magic, so stop reading
                isMagic = false;
                break;
            }
            i++;
        }
        int columnSum=-1;
        for(int jj=0;jj<matrix[0].length;jj++){
            int sum=0;
            for(int ii=0;ii<matrix.length;ii++){
                sum+=matrix[ii][jj];
            }
            if(columnSum==-1){
                columnSum=sum;
            }
            else if(columnSum!=sum){
                isMagic=false;
                break;
            }
        }
        int diagSum1=0;
        int diagSum2=0;
        for(int ii=0;ii<matrix.length;ii++){
            diagSum1+=matrix[ii][ii];
            diagSum2+=matrix[ii][matrix[0].length-1-ii];
        }
        if(diagSum1!=diagSum2){
            isMagic=false;
        }
        // System.out.println(Arrays.deepToString(matrix));
        reader.close();
        return isMagic;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}
