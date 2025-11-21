package wms.support;

public class OrderNumberGenerator {
    private static long counter = 0;

    // impede condições de corrida
    public synchronized static String nextId() {
        counter++;
        return String.valueOf(counter);
    }
}
