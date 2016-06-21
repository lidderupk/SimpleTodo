package com.lidderupk.todo.simplytodo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.lidderupk.todo.simplytodo.model.Todo;

import java.util.List;

/**
 * Created by ulidder on 6/21/16.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private static String TAG = TodoAdapter.class.getName();

    private List<Todo> todos;
    private Context mContext;

    public TodoAdapter(List<Todo> todos, Context mContext) {
        this.todos = todos;
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTodoItem;
        public ViewHolder(View itemView) {
            super(itemView);

            tvTodoItem = (TextView) itemView.findViewById(R.id.tvTodoItem);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.todo_item, parent, false);

        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "view clicked");
            }
        });

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        Todo todo = todos.get(position);

        // Set item views based on the data model
        TextView textView = holder.tvTodoItem;
        textView.setText(todo.getTitle() + " " + todo.getDescription() + " " + todo.getCategory());


    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
