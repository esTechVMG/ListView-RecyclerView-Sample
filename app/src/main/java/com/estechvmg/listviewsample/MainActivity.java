package com.estechvmg.listviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public Button first;
    public String[] list=new String[]{
            "Patatas","Tomtates","Esparragos"
    };
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listOne);
        first=findViewById(R.id.firstButton);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listView.getVisibility()==View.VISIBLE){
                    listView.setVisibility(View.GONE);
                }else{
                    listView.setVisibility(View.VISIBLE);
                }
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapter);
    }
    class MyAdapter extends BaseAdapter{
        MyAdapter(){
            super();

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
    class Jugador{
        String firstName;
        String lastName;
        int years;
        String type;
        Jugador(){
            firstName="TestFirstName";
            lastName="TestLastName";
            years=0;
            type="Unidentified";
        }
        Jugador(String firstName,String lastName,int years){

        }
    }
}
