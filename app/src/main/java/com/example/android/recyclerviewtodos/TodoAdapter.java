package com.example.android.recyclerviewtodos;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<String> todoList;

    public TodoAdapter() {
        this.todoList = new ArrayList<>();
    }

    public void addTodo(String todo) {
        this.todoList.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {

    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView todoTextTV;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.todoTextTV = itemView.findViewById(R.id.tv_todo_text);
        }

        void bind(String todo) {
            this.todoTextTV.setText(todo);
        }
    }
}
