package com.hackathon.echostreamdeck;

// "Call requires permission that may be rejected by user" only affects Android 12+, which we don't care about.
// We would change the gradle config to have a compileSdk of 30, but it complains about other things that actually stop us from working when we do that.
// The code still compiles with the errors, so they're basically warnings, and warnings don't matter :D

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hackathon.echostreamdeck.databinding.ActivityMainBinding;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    BluetoothHelper bluetoothHelper;
    private static final String TAG = "BluetoothChatFragment";
    private BluetoothAdapter bluetoothAdapter = null;

    private ArrayList<ImageButton> macroButtons;
    private ArrayList<ImageButton> upButtons;
    private ArrayList<ImageButton> downButtons;
    private ArrayList<ImageButton> syncButtons;

    InputStream inputStream;
    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        macroButtons = new ArrayList<>(Arrays.asList(new ImageButton[]{
                binding.layout1Button1,
                binding.layout1Button2,
                binding.layout1Button3,
                binding.layout1Button4,
                binding.layout1Button5,
                binding.layout1Button6,
                binding.layout1Button7,
                binding.layout1Button8,
        }));

        upButtons = new ArrayList<>(Arrays.asList(new ImageButton[]{

        }));

        downButtons = new ArrayList<>(Arrays.asList(new ImageButton[]{

        }));

        syncButtons = new ArrayList<>(Arrays.asList(new ImageButton[]{

        }));

        WindowInsetsControllerCompat windowInsetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );



        BluetoothSocket tmp = null;
        UUID MY_UUID = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66"); // Standard SPP UUID

        BluetoothDevice device = BluetoothHelper.getConnectedDevices(this).iterator().next();

        try {
            // Get a BluetoothSocket to connect with the given BluetoothDevice
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }
        BluetoothSocket mmSocket = tmp;

// Cancel discovery because it slows down connection
        bluetoothAdapter.cancelDiscovery();
        Log.d("BT", "1");
        try {
            // Connect the device through the socket. This will block until it succeeds or throws an exception
            mmSocket.connect();
            Log.d("BT", "2");

            // If successful, proceed to manage the connection (send/receive data streams)
            inputStream = mmSocket.getInputStream();
            outputStream = mmSocket.getOutputStream();

            Log.d("BT", "3");
        } catch (IOException connectException) {
            // Unable to connect; close the socket and get out
            try {
                mmSocket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }
            Log.e("BT", "fuck", connectException);
            Log.d("BT", "4");
        }

        try {
            outputStream.write(42);
        } catch (IOException e) {
            Log.e("BT", "fuck", e);
        }


        setupButtons();

    }

    private void setupButtons() {
        Log.d(TAG, "setupButtons()");


        // Init buttons
        for (ImageButton b : macroButtons) {
            b.setOnClickListener(v -> {
                try {
                    outputStream.write(69);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for (ImageButton b : upButtons) {
            b.setOnClickListener(v -> {

            });
        }
        for (ImageButton b : downButtons) {
            b.setOnClickListener(v -> {

            });
        }
        for (ImageButton b : syncButtons) {
            b.setOnClickListener(v -> {

            });
        }
    }

}