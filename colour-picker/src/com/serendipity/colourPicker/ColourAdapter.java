package com.serendipity.colourPicker;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColourAdapter extends ArrayAdapter<Colours> implements CompoundButton.OnCheckedChangeListener {
    List<Integer> selected = new ArrayList<Integer>();

    public ColourAdapter(Context context, List<Colours> objects) {
        super(context, R.layout.colour, R.id.text, objects);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = super.getView(position, view, parent);

        Colours colours = getItem(position);
        view.setBackgroundColor(colours.background);
        TextView txt = (TextView) view.findViewById(R.id.text);
        txt.setTextColor(colours.text);
        CheckBox check = (CheckBox) view.findViewById(R.id.checkbox);
        check.setOnCheckedChangeListener(null);
        check.setTag(position);
        check.setChecked(selected.contains(position));
        check.setOnCheckedChangeListener(this);
        Log.d("colour-picker", "position = " + position + " selected = " + selectedAsString() + " selected.contains(position) = " + selected.contains(position));
        return view;
    }

    private String selectedAsString() {
        String s = "";
        for (Integer i : selected) {
            s += i + ", ";
        }
        return s;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {
            Integer i = (Integer) compoundButton.getTag();
            selected.add(i);
        }
    }
}
