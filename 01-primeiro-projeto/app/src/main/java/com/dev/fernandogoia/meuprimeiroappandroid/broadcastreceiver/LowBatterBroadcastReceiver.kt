package com.dev.fernandogoia.meuprimeiroappandroid.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LowBatterBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Evento de bateria baixa recebida!!!", Toast.LENGTH_LONG).show()
    }
}