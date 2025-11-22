package wms.support;


/**
 * Classe trunca uma string para 27 caracteres + "..."
 * 
 * @author Guilherme Rodrigues
 * @version 1.0
 * @since 2025-11-22
 */
public class Truncar {
/**
 * Trunca uma string para 27 caracteres + "..."
 * 
 * @return string Truncada
 */
    public static String truncar(String texto, int limite) {
        if (texto == null)
            return "";
        if (texto.length() <= limite)
            return texto;
        return texto.substring(0, limite - 3) + "...";
    }
}