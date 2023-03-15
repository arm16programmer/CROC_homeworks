import java.util.Locale;
import java.util.Scanner;

public class Bytes {

    public static void main(String[] args) {

        double bytes;
        String[] measureUnit = new String[] {"B", "KB", "MB", "GB", "TB"};
        System.out.print("Введите число байтов: ");
        Scanner sc = new Scanner(System.in);
        bytes = sc.nextDouble();

        int count = 0;
        while (bytes >= 1023.9) {
            bytes = bytes/1024;
            count++;
        }

        if (count<5) {
            System.out.println(String.format(Locale.ROOT,"%.1f", bytes) + " " + measureUnit[count]);       
        } else {
            System.out.println("Слишком большое число, введите меньшее значение!");
        }
    }
}
