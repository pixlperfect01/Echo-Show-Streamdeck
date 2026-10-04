package com.hackathon.echostreamdeck;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.hackathon.echostreamdeck.databinding.ActivityMainBinding;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

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
        WindowInsetsControllerCompat windowInsetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );

        binding.layout1Button1.setOnClickListener(v -> {
            Set<BluetoothDevice> devices = BluetoothHelper.getConnectedDevices(this);
            for(BluetoothDevice d : devices) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // OH GOD WE SOMEHOW DON'T HAVE BLUETOOTH (again)
                    return;
                }
                Toast.makeText(this, d.getName(), Toast.LENGTH_SHORT).show();
            }
            Log.i("DBG", "hi");

        });

        binding.layout1Button2.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_2!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button3.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_3!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button4.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_4!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button5.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_5!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button6.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_6!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button7.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_7!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1Button8.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_8!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1ButtonUp.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_up!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1ButtonDown.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_down!", Toast.LENGTH_SHORT).show();
        });
        binding.layout1ButtonSync.setOnClickListener(v -> {
            Toast.makeText(this, "layout_1_button_sync!", Toast.LENGTH_SHORT).show();
        });

    }
}