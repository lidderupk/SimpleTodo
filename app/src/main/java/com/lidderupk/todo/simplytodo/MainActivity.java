package com.lidderupk.todo.simplytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lidderupk.todo.simplytodo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private final static String TAG = MainActivity.class.getName();
    private RecyclerView rvTodos;
    private List<String> data;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        lvItems = (ListView) findViewById(R.id.lvItems);
        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);

        final List<Todo> todos = Todo.createTodos(30);

        TodoAdapter adapter = new TodoAdapter(todos, this);

        rvTodos.setAdapter(adapter);

        rvTodos.setLayoutManager(new LinearLayoutManager(this));

        ItemClickSupport.addTo(rvTodos).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.d(TAG, "item clicked on position: " + position);
                Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                startActivity(i); // brings up the second activity
            }
        });
    }

    private View.OnClickListener getAddButtonClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    @Override
    public void setAddBtn() {

    }

    @Override
    public void setItemsList() {
        data = new ArrayList<String>();

        data.add("First");
        data.add("Second");
        data.add("Third");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
    }
}
