package com.example.mytodolist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodolist.MainActivity;
import com.example.mytodolist.Model.MyToDoModel;
import com.example.mytodolist.R;

import java.util.List;

public class MyToDoAdapter extends RecyclerView.Adapter<MyToDoAdapter.ViewHolder> {
    private List<MyToDoModel> todoList;
    private MainActivity activity;

    public MyToDoAdapter(MainActivity activity) {
        this.activity = activity;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new RecyclerView.ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        MyToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(item.getStatus());
    }

    public int getItemCount() {
        return todoList.size();
    }
    private boolean toBoolean(int n) {
        return n!=0;
    }

    public void setTasks(List<MyToDoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task;

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }

}
