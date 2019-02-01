package com.example.ayur;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView xiaomi,samsung,vivo,lenovo;
    ArrayAdapter<String> adapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
//    public List<Card> options=new ArrayList<>();
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xiaomi=(CardView) findViewById(R.id.xiaomiCard);
        samsung=(CardView) findViewById(R.id.samsungCard);
        vivo=(CardView) findViewById(R.id.vivoCard);
        lenovo=(CardView) findViewById(R.id.lenovoCard);
        xiaomi.setOnClickListener(this);
        samsung.setOnClickListener(this);
        vivo.setOnClickListener(this);
        lenovo.setOnClickListener(this);


        mDrawerLayout=(DrawerLayout) findViewById(R.id.navigation) ;
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View v) {
    Intent i;
    switch (v.getId()){
        case R.id.xiaomiCard:i=new Intent(this,Xiaomi.class);startActivity(i);break;
        case R.id.samsungCard:i=new Intent(this,Samsung.class);startActivity(i);break;
        case R.id.vivoCard:i=new Intent(this,Vivo.class);startActivity(i);break;
        case R.id.lenovoCard:i=new Intent(this,Lenovo.class);startActivity(i);break;
        default:break;
    }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search,menu);
        MenuItem item= menu.findItem(R.id.searchItems);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}
