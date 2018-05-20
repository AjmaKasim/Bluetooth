package com.ajmakasim.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button on,off,visible;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on=(Button)findViewById(R.id.on);
        off=(Button)findViewById(R.id.off);
        visible=(Button)findViewById(R.id.visible);
        BA=BluetoothAdapter.getDefaultAdapter();


    }

    public void on(View view) {

        if (!BA.isEnabled()) {

            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(this, "Turned On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Already On", Toast.LENGTH_SHORT).show();
        }
    }

    public void off(View view){

        BA.disable();
        Toast.makeText(this, "Turned off", Toast.LENGTH_SHORT).show();


    }

    public void visible(View view){

        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);


    }

}
