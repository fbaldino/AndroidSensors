package com.felipebaldino.firstsensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {


        private SensorManager mSensorManager;
        private Sensor mLight;
        private TextView TvSensordata;
        @Override
        public final void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TvSensordata = (TextView) findViewById(R.id.TvSensordata);
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }

        @Override
        public final void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Do something here if sensor accuracy changes.
        }

        @Override
        public final void onSensorChanged(SensorEvent event) {
            // The light sensor returns a single value.
            // Many sensors return 3 values, one for each axis.
            float lux = event.values[0];
            TvSensordata.setText(" lux = " +lux);
            // Do something with this sensor value.
        }

        @Override
        protected void onResume() {
            super.onResume();
            mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        }

        @Override
        protected void onPause() {
            super.onPause();
            mSensorManager.unregisterListener(this);
        }
    }


