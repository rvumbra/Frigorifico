package com.rvumbra.frigorifico.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rvumbra.frigorifico.R;

/**
 * Esta es la Activity principal que será la primera en ejecutar, indicandose con el filtro
 * de launcher en el Manifest.xml
 */
public class MainAlmacen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_almacen);
    }
}