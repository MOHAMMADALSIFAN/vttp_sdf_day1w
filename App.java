

import java.io.Console;
import java.util.*;

// 1. compiling (slide 8)
// javac --source-path src -d bin src/*
//
// 2. running the compiled classes (slide 9)
// java -cp bin App
//
// 3. packing to jar (slide 12)
// jar -c -v -f day01.jar -e App . (Do inside bin folder)
//
// 4. run the jar package (slide 12)
// java -cp bin/day01.jar App
// java -cp day01.jar App (run inside bin folder)

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to your shopping cart");
        System.out.println("===============================");
        

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();
        String input = "";

        while (!input.equals("quit")) {
            input = cons.readLine(">");
            input = input.toLowerCase();

            if (input.equals("list")) {

                if (cartItems.size() > 0) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        // System.out.println((i+1) + cartItems.get(i));
                        System.out.printf("%d. %s\n", (i + 1), cartItems.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty");
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(',', ' ');

                Scanner scan = new Scanner(input.substring(4));
                String stringVal = "";
                while (scan.hasNext()) {
                    stringVal = scan.next();
                    cartItems.add(stringVal);
                }
                scan.close();
            }

            if (input.startsWith("delete")) {
                Scanner scan = new Scanner(input.substring(6));
                String stringVal = "";

                while (scan.hasNext()) {
                    stringVal = scan.next();

                    int cartPosition = Integer.parseInt(stringVal);
                    cartPosition = cartPosition - 1;

                    if (cartPosition < cartItems.size()) {
                        // delete the item from cart
                        cartItems.remove(cartPosition);

                    } else {
                        System.err.println("Incorrect item index");
                    }
                }
                scan.close();
            }

        }

        System.out.println("Bye! Bye! See you again...");

    }
}