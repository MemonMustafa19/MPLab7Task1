package com.example.mustafa.mplab7task1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> pairedDevices;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    }


    public void turnOn(View view) {
        Intent turnOnIn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(turnOnIn, 0);
    }

    public void getVisible(View view) {
        Intent getVisibleIn = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisibleIn,1);

    }

    public void showPairedDevices(View view) {

        pairedDevices = bluetoothAdapter.getBondedDevices();

        List <String> devices = new ArrayList<String>();
        for(BluetoothDevice btd: pairedDevices){
            devices.add(btd.getName());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,devices);
        listView.setAdapter(adapter);
        
    }

    public void turnOff(View view) {
        bluetoothAdapter.disable();

    }


}