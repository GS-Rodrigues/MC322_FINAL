package wms.support;

public class IdGenerator {
    private static long counter = 0;

    // impede condições de corrida
    public synchronized static String nextId() {
        counter++;
        return String.valueOf(counter);
    }
}
