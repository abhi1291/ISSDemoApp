package com.example.abc.myapplication.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.abc.myapplication.R;
import com.example.abc.myapplication.Utils.RelaemSingletone;


import io.realm.Realm;
import io.realm.RealmResults;
import model.Book;
import model.Library;

public class AddLibraryDetailActivity extends AppCompatActivity {
    private Button submit;
    private EditText name, address;
    private Realm realm;
    Spinner spinner;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_library_detail);

        context=this;
        intitView();
    }
    private void intitView() {

        this.realm = RelaemSingletone.with().getRealm();

        //  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        name = findViewById(R.id.rd_add_lib_name);
        address = findViewById(R.id.rd_add_lib_address);


        submit = findViewById(R.id.rd_add_lib_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Library library = new Library();
                    library.setId(realm.where(Library.class).findAll().size() + 1);
                library.setId((realm.where(Library.class).findAll()).max("id").intValue() + 1);
                    library.setAddress(address.getText().toString());
                    library.setName(name.getText().toString());
                    realm.beginTransaction();
                    realm.copyToRealm(library);
                    realm.commitTransaction();
                    finish();
                }



        });
    }

}
