package task1;

import java.util.Scanner;
import java.util.function.Consumer;

// variant 13
public class Task1 implements Consumer<String> {

    private static final Scanner reader = new Scanner(System.in);

    @Override
    public void accept(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char resultSymbol = i % 3 == 0 ? Character.toUpperCase(str.charAt(i)) : str.charAt(i);
            builder.append(resultSymbol);
        }
        System.out.println(builder);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = new Task1();
        consumer.accept(reader.nextLine());
    }
}
