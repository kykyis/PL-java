import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        String file = Files.readAllLines(Paths.get(args[0])).toString();
        List<String> expList = new ArrayList<>();
        Pattern pattern = Pattern.compile("-*\\d+\\.*\\d+|\\w+");
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            expList.add(matcher.group());
        }

        double t1, t2;
        int l = expList.indexOf("line");
        int cen = expList.indexOf("center");
        int rad = expList.indexOf("radius");
        double x0 = Double.parseDouble(expList.get(l + 1));
        double y0 = Double.parseDouble(expList.get(l + 2));
        double z0 = Double.parseDouble(expList.get(l + 3));
        double x1 = Double.parseDouble(expList.get(l + 4));
        double y1 = Double.parseDouble(expList.get(l + 5));
        double z1 = Double.parseDouble(expList.get(l + 6));
        double xc = Double.parseDouble(expList.get(cen + 1));
        double yc = Double.parseDouble(expList.get(cen + 2));
        double zc = Double.parseDouble(expList.get(cen + 3));
        double r = Double.parseDouble(expList.get(rad + 1));
        double a = Math.pow((x0 - xc), 2) + Math.pow((y0 - yc), 2) + Math.pow((z0 - zc), 2) - Math.pow(r, 2);
        double c = Math.pow((x0 - x1), 2) + Math.pow((y0 - y1), 2) + Math.pow((z0 - z1), 2);
        double b = Math.pow((x1 - xc), 2) + Math.pow((y1 - yc), 2) + Math.pow((z1 - zc), 2) - a - c - Math.pow(r, 2);
        double d = Math.pow(b, 2) - (4 * a * c);

        if (d < 0) {
            System.out.println("Коллиизий не обнаружено");
        } else if (d == 0) {
            t1 = -b / (2 * c);
            double[] mark1 = {x0 * (1 - t1) + t1 * x1, y0 * (1 - t1) + t1 * y1, z0 * (1 - t1) + t1 * z1};
            System.out.println(Arrays.toString(mark1));

        } else {
            t1 = (-b + Math.sqrt(d)) / (2 * c);
            t2 = (-b - Math.sqrt(d)) / (2 * c);
            double[] mark1 = {x0 * (1 - t1) + t1 * x1, y0 * (1 - t1) + t1 * y1, z0 * (1 - t1) + t1 * z1};
            double[] mark2 = {x0 * (1 - t2) + t2 * x1, y0 * (1 - t2) + t2 * y1, z0 * (1 - t2) + t2 * z1};
            System.out.println(Arrays.toString(mark1) + "\n" + Arrays.toString(mark2));
        }
    }
}
