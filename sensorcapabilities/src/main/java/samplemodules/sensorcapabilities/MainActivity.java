package samplemodules.sensorcapabilities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView TvDisplayData;
    private SensorManager mSensorManager;
    private ListView namesListView;
    private ArrayList<String> names;
    private ArrayAdapter<String> namesAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TvDisplayData = (TextView) findViewById(R.id.TVDisplayData);
        ((Button)findViewById(R.id.btnCheckSensors) ).setOnClickListener(this);
        ((Button)findViewById(R.id.btnlistSersor) ).setOnClickListener(this);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        namesListView = (ListView)findViewById(R.id.listView1);





        }


@Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.btnCheckSensors: TvDisplayData.setText(" teste ");
                    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                    if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
                        TvDisplayData.setText(" Have Magnetometer ");
                    }
                    else {
                        TvDisplayData.setText(" Do not Have Magnetometer ");
                    }
                    break;
                case R.id.btnlistSersor:

                        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

                        names = new ArrayList<String>();
                        names.clear();
                        for(int i=0; i<deviceSensors.size(); i++) {
                            Log.d("Sensors",deviceSensors.get(i).getName());
                            names.add(i, deviceSensors.get(i).getName());
                    }
                    namesAA = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1, android.R.id.text1, names );
                    namesListView.setAdapter(namesAA);

            }
        }

}
