import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class 0401CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<String> resultList = new ArrayList<String>();
        int min = -1;
        int minIndex = 0;
        int countNumNotZero = 0;
        while(true) {
            min = -1;
            Arrays.sort(arr);
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != 0) {
                    minIndex = i;
                    min = arr[i];
                    break;
                }
            }
            if(min == -1)
                break;
                
            countNumNotZero = arr.length - minIndex;
            resultList.add(countNumNotZero + "");
            for(int i = minIndex; i < arr.length; i++) {
                arr[i] -= min;
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = Integer.parseInt(resultList.get(i));
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
