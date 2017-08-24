package br.com.fiap.rm76781.onibus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;

public class OnibusService extends Service {

    private Timer timer;
    private AvisoOnibusTask task;


    public OnibusService() {
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("SERVICO", "SERVICO INICIADO!");
        timer = new Timer();
    }

    @Override
    public void onDestroy(){
        Log.i("SERVICO", "SERVICO FINALIZADO!");
        timer.cancel();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("SERVICO", "PROCESSANDO!");

        String distancia = intent.getExtras().getString("distancia");
        String linha = intent.getExtras().getString("linha");
        task = new AvisoOnibusTask(distancia, linha);
        timer.schedule(task, 0,5*1000);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
