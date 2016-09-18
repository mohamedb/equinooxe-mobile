package com.equinooxe.component.location;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.equinooxe.main.R;
import com.equinooxe.domain.Location;

import java.util.List;


/**
 * Created by mboullouz on 31/07/2016.
 */
public class LocationViewFragment extends Fragment {
    private OnItemSelectedListener listener;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    this.view = inflater.inflate(R.layout.content_main,
                container, false);
        new LocationService(){
            @Override
            protected void onPostExecute(List<Location> result) {
                super. onPostExecute(result);
                initTable(result);
            }
        }.execute("");
        return view;
    }


    public void initTable(List<Location> locationList){
        if(locationList==null){
            Log.e("ERROR", "Location List is void! ");
            return;
        }
        TableLayout tableLayout = (TableLayout) this.view.findViewById(R.id.mainList);

        for (int i = 0; i <locationList.size(); i++) {

            TableRow row= new TableRow(this.view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            final CheckBox checkBox = new CheckBox(this.view.getContext());

            TextView tv = new TextView(this.view.getContext());
            ImageButton addBtn = new ImageButton(this.view.getContext());
            ImageButton minusBtn = new ImageButton(this.view.getContext());
            final TextView qty = new TextView(this.view.getContext());
            checkBox.setText("Name");

            qty.setText(""+locationList.get(i).getName());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Hi there: " + qty.getText(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            row.addView(checkBox);
            row.addView(minusBtn);
            row.addView(qty);
            row.addView(addBtn);
            tableLayout.addView(row,i);
        }
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
           /* throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
                    */
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // may also be triggered from the Activity
    public void updateDetail(String uri) {
        // create a string just for testing
        String newTime = String.valueOf(System.currentTimeMillis());

        // inform the Activity about the change based
        // interface defintion
        listener.onRssItemSelected(newTime);
    }
}
