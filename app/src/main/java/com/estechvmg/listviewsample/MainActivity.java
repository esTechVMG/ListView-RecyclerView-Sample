package com.estechvmg.listviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public Button first,second,third,fourth;
    public String[] list=new String[]{
            "Patatas","Tomtates","Esparragos"
    };
    public ListView listViewOne,listViewTwo;
    public RecyclerView recyclerViewOne,recyclerViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewOne=findViewById(R.id.listOne);
        listViewTwo=findViewById(R.id.listTwo);
        recyclerViewOne=findViewById(R.id.recyclerOne);
        recyclerViewTwo=findViewById(R.id.recyclerTwo);
        first=findViewById(R.id.button1);
        second=findViewById(R.id.button2);
        third=findViewById(R.id.button3);
        fourth=findViewById(R.id.button4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        listViewOne.setAdapter(adapter);
        showAndHideAction(first,listViewOne);
        showAndHideAction(second,listViewTwo);
        showAndHideAction(third,recyclerViewOne);
        showAndHideAction(fourth,recyclerViewTwo);

    }
    public void showAndHideAction(View usedButton, final View usedListView){
        usedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usedListView.getVisibility()==View.VISIBLE){
                    usedListView.setVisibility(View.GONE);
                }else{
                    usedListView.setVisibility(View.VISIBLE);
                }
            }
        });
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
