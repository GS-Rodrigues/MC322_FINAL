package wms.support;

public class Truncar {

    public static String truncar(String texto, int limite) {
        if (texto == null)
            return "";
        if (texto.length() <= limite)
            return texto;
        return texto.substring(0, limite - 3) + "...";
    }
}