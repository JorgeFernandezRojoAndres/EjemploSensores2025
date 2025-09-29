package com.softulp.ejemplosensores2025;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.ejemplosensores2025.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel mv;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
       binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv.getMDatos().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMostrar.setText(s);
            }
        });

       // mv.accederASensores();

        mv.activarLecturas();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mv.desactivarLecturas();
    }
}