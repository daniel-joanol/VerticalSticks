import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> y = Arrays.asList( new Integer[] {3, 3, 4, 7, 6, 4, 1, 4, 10, 5, 3, 9, 8, 9});
        List<Integer> x = Arrays.asList( new Integer[] {

                6,
                3,
                1, 2, 3,
                3,
                3, 3, 3,
                3,
                2, 2, 3,
                4,
                10, 2, 4, 4,
                5,
                10, 10, 10, 5, 10,
                6,
                1, 2, 3, 4, 5, 6});

        List<Double> result = solve(x);

        for (Double n : result)
            System.out.println(n);
    }

    public static List<Double> solve(List<Integer> y){

        final DecimalFormat df = new DecimalFormat("#.##");
        List<Double> result = new ArrayList<>();

        //Starts in 1 cause the position 0 has the value of the size of list with the response,
        //  but we don't need it  in Java
        for (int i = 1; i < y.size(); i++){

            double sum = 0.00;

            // i will have the lenght of the next array
            // j will run through i + 1 + the value in i
            //   In case we have i = 1 and the value in the index 1 is 3, we will read the indexes from 2 to 4
            for (int j = i + 1; j <= i + y.get(i); j++){

                //TODO: debug
                sum += (double) (y.get(i)+1) / (1 + y.get(j));
            }

            i += y.get(i);

            //Saves with only 2 decimals houses
            result.add( Math.floor(sum * 100) / 100);
        }

        return result;
    }
}
