package com.example.android.recyclerviewtodos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements TodoAdapter.OnTodoCheckedChangeListener {
    private EditText todoEntryET;
    private RecyclerView todoListRV;
    private TodoAdapter todoAdapter;
    private Toast todoToast;

//    private TextView todoListTV;
//    private ArrayList<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        todoList = new ArrayList<>();
        this.todoAdapter = new TodoAdapter(this);

//        this.todoListTV = findViewById(R.id.tv_todo_list);
        this.todoEntryET = findViewById(R.id.et_todo_entry_box);
        this.todoListRV = findViewById(R.id.rv_todo_list);

        this.todoListRV.setAdapter(this.todoAdapter);
        this.todoListRV.setLayoutManager(new LinearLayoutManager(this));
        this.todoListRV.setHasFixedSize(true);
        this.todoListRV.setItemAnimator(new DefaultItemAnimator());

        Button addTodoBtn = findViewById(R.id.btn_add_todo);
        addTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText = todoEntryET.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    todoEntryET.setText("");
                    todoAdapter.addTodo(todoText);
                    todoListRV.scrollToPosition(0);
//                    todoListTV.setText("");
//                    todoList.add(todoText);
//                    for (String todo : todoList) {
//                        todoListTV.append(todo + "\n\n");
//                    }
                }
            }
        });
    }

    @Override
    public void onTodoCheckedChanged(String todo, boolean isChecked) {
        if (this.todoToast != null) {
            this.todoToast.cancel();
        }
        String completionState = isChecked ? "COMPLETED" : "MARKED INCOMPLETE";
        String toastText = completionState + " - " + todo;
        this.todoToast = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
        this.todoToast.show();
    }
}