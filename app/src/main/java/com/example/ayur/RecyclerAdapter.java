package com.example.ayur;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListHolder> {
    View view;
    private final Context context;
    public List<ListItems> mylist;

    public RecyclerAdapter(Context context, List<ListItems> mylist) {
        this.context=context;
        this.mylist= mylist;
    }




    public void setIt(List<ListItems> mylist)
    {
        this.mylist=mylist;
//        this.context=context;
    }


    public static class ListHolder extends RecyclerView.ViewHolder{
       LinearLayout linearlayout;
        ImageView imgView;
        TextView name;

        public ListHolder(View v){
            super(v);
            imgView=(ImageView) v.findViewById(R.id.imgView);
            name=(TextView) v.findViewById(R.id.txtView1);
            linearlayout=(LinearLayout) v.findViewById(R.id.layout_id);
        }



    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View viewH=inflater.inflate(R.layout.list_item_layout,parent,false);
        final ListHolder listHolder=new ListHolder(viewH);

        return new ListHolder(viewH);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ListHolder listHolder, int position) {
        ListItems list = mylist.get(position);
        listHolder.imgView.setImageDrawable(context.getResources().getDrawable(list.getImage()));
        listHolder.name.setText(list.getData());
        listHolder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(Intent.ACTION_VIEW);
               int data = listHolder.getAdapterPosition();
//                i.setType("text/plain");
//                context.startActivity(i);
                Toast.makeText(context, "Hello"+data, Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount(){
        final int size = mylist.size();

        return size;


    }

}
