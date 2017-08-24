package br.com.fiap.rm76781.onibus;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.TimerTask;

/**
 * Created by logonrm on 24/08/2017.
 */

public class AvisoOnibusTask extends TimerTask{

    private String distancia;
    private String linha;

    public AvisoOnibusTask(String distancia, String linha){
        this.distancia = distancia;
        this.linha = linha;
    }
    @Override
    public void run(){
        Log.i("ONIBUS", "CHECANDO DISTANCIA..." + OnibusServer.getDistancia());

        try {
            JSONArray linhas = new JSONArray(OnibusServer.getDistancia());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
