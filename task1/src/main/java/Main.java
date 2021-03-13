import exception.IllegalArgs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    static String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        List<String> file = Files.readAllLines(Paths.get(args[0]));
        int nb = Integer.parseInt(file.get(0));
        String base = file.get(1);
        try {
            if ((!alphabet.startsWith(base)) || (nb < 0) || (base.length() <= 1)) {
                throw new IllegalArgs();
            }
            String result = BaseTransfer.itoBase(nb, base);
            System.out.println(result);
        } catch (IllegalArgs illegalArgs) {
            illegalArgs.printStackTrace();
        }

    }

}
