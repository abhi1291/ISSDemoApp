package com.example.abc.myapplication.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abc.myapplication.R;
import com.example.abc.myapplication.Utils.RelaemSingletone;
import com.example.abc.myapplication.adapters.SpinnerCustomeAdapter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import model.Book;
import model.Library;

public class AddBookDetail extends AppCompatActivity {
    private Button submit;
    private EditText title, author, description;
    private Realm realm;
    Spinner spinnerLibrary, spinnerCategory;
    Activity context;
    SpinnerCustomeAdapter adapter;
    Library selectedLibrary = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_detail);
        Realm realm = Realm.getDefaultInstance();
        context = this;
        intitView();
    }

    private void intitView() {

        spinnerCategory = (Spinner) findViewById(R.id.rd_add_book_category);
        spinnerLibrary = (Spinner) findViewById(R.id.rd_add_book_library);
        this.realm = RelaemSingletone.with().getRealm();
        List<String> categories = new ArrayList<String>();
        categories.add("Drama");
        categories.add("Mystery");
        categories.add("Education");
        categories.add("Horror");
        categories.add("Travel");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final RealmResults<Library> result2 = realm.where(Library.class).findAll();

        adapter = new SpinnerCustomeAdapter(context, R.layout.spinner_rows, result2);

        // attaching data adapter to spinnerLibrary
        spinnerLibrary.setAdapter(adapter);
        spinnerCategory.setAdapter(dataAdapter);
        spinnerLibrary.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View v, int position, long id) {
                // your code here
                // Get selected row data to show on screen
                selectedLibrary = result2.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });


        title = findViewById(R.id.rd_add_book_title);
        author = findViewById(R.id.rd_add_book_author);
        description = findViewById(R.id.rd_add_book_description);

        submit = findViewById(R.id.rd_add_book_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result2.size() == 0) {
                    Toast.makeText(context, "Please Add Library First", Toast.LENGTH_SHORT).show();
                } else {
                    Book book = new Book();
                    book.setId((realm.where(Book.class).findAll()).max("id").intValue() + 1);
                    book.setTitle(title.getText().toString());
                    book.setAuthor(author.getText().toString());
                    book.setDescription(description.getText().toString());
                    book.setLibrary(selectedLibrary);
                    book.setBookCategory(spinnerCategory.getSelectedItem().toString());
                    realm.beginTransaction();
                    realm.copyToRealm(book);
                    realm.commitTransaction();
                    finish();
                }


            }
        });
    }
}
