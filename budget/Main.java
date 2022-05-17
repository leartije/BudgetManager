package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        double sum = 0;
        while (scanner.hasNextLine()) {
            String current = scanner.nextLine();
            input.add(current);
            String[] split = current.split("\\$");
            sum += Double.parseDouble(split[1]);
        }

        input.forEach(System.out::println);

        System.out.println("Total: $" + sum);



    }
}
