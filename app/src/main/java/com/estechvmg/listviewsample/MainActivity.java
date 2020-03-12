package com.estechvmg.listviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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
        ArrayList<Jugador> secList = new ArrayList<>();
        secList.add(new Jugador());
        secList.add(new Jugador("Carvajal",23));
        secList.add(new Jugador("Ramos",21));
        MyAdapter adapterTwo = new MyAdapter(this, secList);
        listViewTwo.setAdapter(adapterTwo);
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
        private final Context context;
        private ArrayList<Jugador> list;
        MyAdapter(Context context, ArrayList<Jugador> list){
            this.list=list;
            this.context=context;
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
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder;
            if(view==null){
                view=View.inflate(context,R.layout.list_row,null);
                holder = new ViewHolder();
                holder.tName = view.findViewById(R.id.item1);
                holder.tYears = view.findViewById(R.id.item2);
                holder.tType = view.findViewById(R.id.item3);
                view.setTag(holder);
            }else{
                holder=(ViewHolder) view.getTag();
            }
            holder.tName.setText(list.get(position).getFirstName());
            holder.tYears.setText(list.get(position).getYears());
            holder.tType.setText(list.get(position).getType());
            return view;
        }
    }
}
class ViewHolder {
    TextView tName, tYears, tType;
}
class Jugador{
    String firstName;
    int years;
    String type;
    Jugador(){
        firstName="TestFirstName";
        years=0;
        type="Unidentified";
    }
    Jugador(String firstName,int years){
        this.firstName=firstName;
        this.years=years;
        type="Unidentified";
    }

    public String getYears() {
        return String.valueOf(years);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getType() {
        return type;
    }
}
