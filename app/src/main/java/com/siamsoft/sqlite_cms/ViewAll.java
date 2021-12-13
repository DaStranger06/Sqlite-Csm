package com.siamsoft.sqlite_cms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity {

    ListView listView;
    public ArrayAdapter<String> adapter;
    ArrayList<String> tempList1;
    UserFunction userFunction;

    ArrayList<Custom> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);


        userFunction = new UserFunction();
        listView = findViewById(R.id.listView1);

        showDatalistView();
    }
    private void showDatalistView() {


        tempList1 = new ArrayList<String>();

        list = userFunction.getAllInfo(getApplicationContext());


        for(int i =0; i<list.size();i++)
        {
            if(!list.get(i).getStrName().isEmpty())
            {
                tempList1.add("ID:"+list.get(i).getStrID()+","+
                        "Name:"+list.get(i).getStrName()+","+
                        "Mobile:"+list.get(i).getStrMobile());
            }

        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tempList1);
        listView.setAdapter(adapter);


    }
    @Override
    protected void onStart()
    {
        super.onStart();
    }


}
