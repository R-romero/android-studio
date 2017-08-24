package br.com.fiap.rm76781.onibus;

public class OnibusServer {

    private static int distancia1 = 500;
    private static int distancia2 = 500;

    public static String getDistancia() {

        if (distancia1 <= 0)
            distancia1 = 500;

        if (distancia2 <= 0)
            distancia2 = 500;

        String ret = "[";

        ret += "{\"linha\":\"477P\", \"distancia\":" + distancia1 + "}";
        ret += ",";
        ret += "{\"linha\":\"488X\", \"distancia\":" + distancia2 + "}";

        ret += "]";

        distancia1 -= 100;
        distancia2 -= 50;

        return ret;

    }
}