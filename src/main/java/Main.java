import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> y = Arrays.asList( new Integer[] {3, 3, 4, 7, 6, 4, 1, 4, 10, 5, 3, 9, 8, 9});
        List<Integer> x = Arrays.asList( new Integer[] {6, 3, 1, 2, 3, 3, 3, 3, 3, 3, 2, 2, 3, 4, 10, 2, 4, 4, 5, 10, 10, 10, 5, 10, 6, 1, 2, 3, 4, 5, 6});

        List<Double> result = solve(x);

        for (Double n : result)
            System.out.println(n);
    }

    public static List<Double> solve(List<Integer> originalList){

        final DecimalFormat df = new DecimalFormat("#.##");
        List<Double> result = new ArrayList<>();

        //Starts in 1 cause the position 0 has the value of the size of list with the response,
        //  but we don't need it  in Java
        for (int i = 1; i < originalList.size(); i++){

            double sum = 0.00;
            int newValue = 0;
            List<Integer> newArray = new ArrayList<>();

            // i will have the length of the next array
            // j and m will run through i + 1 + the value in i
            //   In case we have i = 1 and the value in the index 1 is 3, we will read the indexes from 2 to 4
            // In this loop we create an array with the new values
            for (int m = i + 1; m <= i + originalList.get(i); m++){

                for (int k = i + 1; k <= i + originalList.get(i); k++){

                    if (originalList.get(m) <= originalList.get(k)) newValue ++;
                }

                newArray.add(newValue);
                newValue = 0;
            }

            for (int j = i + 1, m = 0; j <= i + originalList.get(i); j++, m++){

                //sum += (double) (originalList.get(i)+1) / (1 + originalList.get(j));

                /*if (newArray.get(m) == 1){
                    sum++;
                } else {
                    sum += (double) (originalList.get(i)+1) / newArray.get(m) + 1 ;
                }*/

                sum += (double) (originalList.get(i)+1) / (newArray.get(m) + 1);

                System.out.println((originalList.get(i)+1) + " --- " + newArray.get(m));
            }

            System.out.println("Fin de for. Sum = " + sum);

            i += originalList.get(i);

            //Saves with only 2 decimals houses
            result.add( Math.floor(sum * 100) / 100);
        }

        return result;
    }
}
