package com.lidderupk.todo.simplytodo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ulidder on 6/21/16.
 */
public class Todo {
    private String title;
    private String description;
    private String category;

    private static int lastTodoId = 0;


    public Todo(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static List<Todo> createTodos(int num){
        List<Todo> list = new ArrayList<>();

        for(int i = 0; i < num; i++){
            list.add(new Todo("title " + lastTodoId, "desc " + lastTodoId, "cat " + lastTodoId));
            lastTodoId++;
        }
        return list;
    }
}
