package wms.support;

/**
 * Gera um numero sequencial de ID
 *
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-21
 */
public class IdGenerator {
    private static long counter = 0;

    // impede condições de corrida
    public synchronized static String nextId() {
        counter++;
        return String.valueOf(counter);
    }
}
