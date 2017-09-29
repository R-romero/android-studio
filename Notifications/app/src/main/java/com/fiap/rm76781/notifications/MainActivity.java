package com.fiap.rm76781.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificacao(View v){
            //--Notification Builder
        //Construtor de Notificações NotificationCompat.Builder
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        //Construção de Notificações
        mBuilder.setContentTitle("Bem vindo!");
        mBuilder.setContentText("Seja Bem Vindo ao Android");
        mBuilder.setSmallIcon(android.R.drawable.btn_star);

            //--Intent para Notificação
        //Declarando um Intent
        Intent toWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiap.com.br"));
        //Declaração de PendingIntent
        PendingIntent intent = PendingIntent.getActivity(this, 0, toWeb, PendingIntent.FLAG_UPDATE_CURRENT);
        //Vinculando o Intent a sua Notificação
        mBuilder.setContentIntent(intent);


            //--Progress Bar
        //Construindo a ProgressBar no Notification Builder
        mBuilder.setProgress(100,50,false);

            //--Notification Manager
        //Serviço de Envio de Notificações NotificationManager
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //Envio da Notificação
        nm.notify(0, mBuilder.build());
    }

    public void dialogo(View v){
            //--AlertDialog
        //Declarando um AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Construção de Diálogo
        builder.setTitle("Fist of the North Star");
        //builder.setMessage("Omae wa mou Shindeiru");
        builder.setIcon(android.R.drawable.btn_dialog);

        //Construção de Botão para o Diálogo
        builder.setPositiveButton("NANI!!?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //Construção de uma Lista para exibir no Diálogo
        builder.setItems(R.array.lstPresente, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Item: " + which, Toast.LENGTH_SHORT).show();
            }
        } );

        AlertDialog alert = builder.create();
        alert.show();


        builder.show();
    }
}
