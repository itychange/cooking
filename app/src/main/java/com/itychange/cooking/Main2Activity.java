package com.itychange.cooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private EditText edt;
    private Button btn;
    private ListView lv;
    ArrayList<String> arrayList=new ArrayList<String>();
    ArrayAdapter arrayAdapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edt= (EditText) findViewById(R.id.txt);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=edt.getText().toString();
                arrayList.add(str);
                arrayAdapter=new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,arrayList);
                lv.setAdapter(arrayAdapter);
            }
        });
        lv= (ListView) findViewById(R.id.lv);

    }
}
