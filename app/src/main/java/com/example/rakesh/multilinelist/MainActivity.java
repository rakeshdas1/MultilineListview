package com.example.rakesh.multilinelist;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] names = new String[]{"Title"};
    String[] lastmessage = new String[]{"message"};
    private ListView messages_list;
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages_list = (ListView) findViewById(R.id.listView);
        simpleArray();
        onListClicked();
    }

    private void onListClicked() {
        messages_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_LONG).show();
                Log.i("INFO",messages_list.getItemAtPosition(position).toString());
            }
        });
    }

    private void simpleArray() {
        String[] from = new String[]{"rowid", "col_1"};
        int[] to = new int[]{R.id.message_tv, R.id.time_tv};

        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("rowid", "" + names[0]);
            map.put("col_1", "" + lastmessage[0]);
            fillMaps.add(map);
        }
        adapter = new SimpleAdapter(this, fillMaps, R.layout.list_item, from, to);
        messages_list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
