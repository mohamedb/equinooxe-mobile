package com.equinooxe.component.user.com.appnh.user.list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.equinooxe.main.R;
import com.equinooxe.component.user.UserService;
import com.equinooxe.domain.User;

import java.util.List;

/**
 * Created by mboullouz on 31/07/2016.
 */
public class UserListViewFragment extends Fragment{
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.content_main,container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        this.init();
    }
    public void init(){
        new UserService(){

            @Override
            protected void onPostExecute(List<User> result) {
                super. onPostExecute(result);
                initTable(result);
            }
        }.execute("");
    }
    public void initTable(List<User> users){
        if(users==null){
            Log.e("ERROR", "Users List is null! cause: It may be that it's no more in sync with the server! ");
            return;
        }
        TextView titleTextView = (TextView) this.view.findViewById(R.id.mainTitle);
        titleTextView.setText("List of users");
        TableLayout tableLayout = (TableLayout) this.view.findViewById(R.id.mainList);

        for (int i = 0; i <users.size(); i++) {

            TableRow row= new TableRow(this.view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            final CheckBox checkBox = new CheckBox(this.view.getContext());

            final TextView emailLabel = new TextView(this.view.getContext());
            checkBox.setText(""+users.get(i).getName());

            emailLabel.setText(" " + users.get(i).getEmail());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Hi " + emailLabel.getText()+" / "+ checkBox.getText(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            row.addView(checkBox);

            row.addView(emailLabel);

            tableLayout.addView(row,i);
        }
    }
}
