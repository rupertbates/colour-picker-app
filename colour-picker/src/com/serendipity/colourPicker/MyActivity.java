package com.serendipity.colourPicker;

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

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ColourAdapter(this, getColours()));
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
