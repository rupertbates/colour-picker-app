package com.serendipity.colourPicker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import com.serendipity.colourPicker.R;

public class MyActivity extends SherlockActivity {

    private ColourAdapter mAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.list);
        mAdapter = new ColourAdapter(this, getColours());
        list.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.shareMenu){
            Log.d("ColourPicker", "share");
            StringBuilder sb = new StringBuilder();
            for(Integer i : mAdapter.getSelected()){
                sb.append(mAdapter.getItem(i).toString());
                sb.append("\n");
            }
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }
        return false;
    }

    protected List<Colours> getColours(){
        List<Colours> colours = new ArrayList<Colours>();
        for (int i = 0; i < 100; i++){
            colours.add(new Colours());
        }
        return colours;

    }


}
