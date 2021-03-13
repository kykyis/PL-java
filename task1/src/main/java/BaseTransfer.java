public class BaseTransfer {
    static String itoBase(int nb, String base) {
        int bs = base.length();
        String res = "";
        while (nb > 0) {
            int rem = nb % bs;
            if (rem <= 9) {
                res = rem + res;
            } else {
                res = ((char) ((rem - 10) + (int) 'A')) + res;
            }
            nb /= bs;
        }
        return res;
    }
}
