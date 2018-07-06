package com.example.abc.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.abc.myapplication.R;
import com.example.abc.myapplication.Utils.RelaemSingletone;


import java.util.ArrayList;
import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import model.Book;

public class RealmBookListActivity extends AppCompatActivity implements View.OnClickListener {
    Button addLib, addBook;
    Activity context;
    RecyclerView recyclerView;
    EditText searchText;
    RealemAdapter adapter;
    private Realm realm;
    public  RealmResults<Book> result2;
    Spinner spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        this.realm = RelaemSingletone.with().getRealm();
        setContentView(R.layout.activity_realem_book_list);

        result2 = realm.where(Book.class).sort("title", Sort.ASCENDING, "library.name", Sort.ASCENDING).findAll();
        spinnerCategory = (Spinner) findViewById(R.id.rd_add_book_category);
        searchText = findViewById(R.id.et_rd_search);
        callThreads();
        RelaemSingletone.with().refresh();
        adapter = new RealemAdapter( result2);


        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  result2= realm.where(Book.class).sort("title", Sort.ASCENDING, "library.name", Sort.ASCENDING).like("title","*"+s.toString()+"*").or().like("library.name","*"+s.toString()+"*").findAll();
              //  result2 = realm.where(Book.class).contains("title", s.toString()).findAll();

                adapter =  new RealemAdapter(result2);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        List<String> categories = new ArrayList<String>();
        categories.add("All");
        categories.add("Drama");
        categories.add("Mystery");
        categories.add("Education");
        categories.add("Horror");
        categories.add("Travel");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(dataAdapter);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    result2 = realm.where(Book.class).equalTo("bookCategory", parent.getItemAtPosition(position).toString()).sort("title", Sort.ASCENDING, "library.name", Sort.ASCENDING).findAll();
                    adapter= new RealemAdapter(result2);
                    recyclerView.setAdapter(adapter);

                } else {
                    result2 = realm.where(Book.class).equalTo("bookCategory", parent.getItemAtPosition(position).toString()).sort("title", Sort.ASCENDING, "library.name", Sort.ASCENDING).findAll();
                    adapter = new RealemAdapter(result2);
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        recyclerView = findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        addBook = findViewById(R.id.rd_add_book_add_book);
        addLib = findViewById(R.id.rd_add_book_list_add_lib);
        addLib.setOnClickListener(this);
        addBook.setOnClickListener(this);
        adapter = new RealemAdapter(result2);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rd_add_book_add_book:
                startActivity(new Intent(this, AddBookDetail.class));
                break;
            case R.id.rd_add_book_list_add_lib:
                startActivity(new Intent(this, AddLibraryDetailActivity.class));
                break;
        }
    }

    /*    public void setRealmAdapter(RealmResults<Book> books) {

            RealmModelAdapter realmAdapter = new RealmModelAdapter( books);
            // Set the data and tell the RecyclerView to draw
            adapter.setRealmAdapter(realmAdapter);
            adapter.notifyDataSetChanged();
        }*/
    private void callThreads() {
        new Thread(new Runnable() {
            public void run() {
                // a potentially  time consuming task
                RelaemSingletone.with();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                // a potentially  time consuming task
                RelaemSingletone.with();
            }
        }).start();
    }

}
