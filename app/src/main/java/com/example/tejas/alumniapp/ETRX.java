package com.example.tejas.alumniapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ETRX extends AppCompatActivity {

    DatabaseHandler_ETRX db2=new DatabaseHandler_ETRX(this);
    public static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etrx);
        ListView list=(ListView) findViewById(R.id.listview);
        list.setAdapter(new VivzAdapter1(this));


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food= ((TextView) view.findViewById(R.id.emailview)).getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",food , null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Alumni Reachout");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
        }



}

class SingleRow1
{
    String name_;
    String batch_;
    String email;
    SingleRow1(String name_, String batch_, String email)
    {
        this.name_=name_;
        this.batch_=batch_;
        this.email=email;
    }
}


class VivzAdapter1 extends BaseAdapter
{
    ArrayList<SingleRow1> list;
    Context context;
    VivzAdapter1(Context c)
    {
        context=c;
        list=new ArrayList<SingleRow1>();
        Resources res=c.getResources();
        String[] name=res.getStringArray(R.array.etrx_name);
        String[] batch=res.getStringArray(R.array.etrx_batch);
        String[] email=res.getStringArray(R.array.etrx_email);
        for(int i=0; i<5; i++)
        {
            list.add(new SingleRow1(name[i], batch[i], email[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.custom_row, parent, false);
        TextView name= (TextView) row.findViewById(R.id.largetextView);
        TextView batch= (TextView) row.findViewById(R.id.batch);
        TextView email= (TextView) row.findViewById(R.id.emailview);

        SingleRow1 temp= list.get(position);
        name.setText(temp.name_);
        batch.setText(temp.batch_);
        email.setText(temp.email);

        return row;
    }
}

