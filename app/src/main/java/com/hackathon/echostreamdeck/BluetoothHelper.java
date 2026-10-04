package com.hackathon.echostreamdeck;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BluetoothHelper {

    public static Set<BluetoothDevice> getConnectedDevices(Context context) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Log.d("DBG", "2");

        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        Log.d("DBG", String.valueOf(pairedDevices.size()));

        for (BluetoothDevice device : pairedDevices) {
            Log.d("BT_Device", "Name: " + device.getName() + ", Address: " + device.getAddress());
        }

        return  bluetoothAdapter.getBondedDevices();
    }
}
