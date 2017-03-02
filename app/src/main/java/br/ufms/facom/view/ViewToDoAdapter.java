package br.ufms.facom.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufms.facom.R;
import br.ufms.facom.model.Todo;

/**
 * Created by wandermar on 02/03/2017.
 */

public class ViewToDoAdapter extends ArrayAdapter<Todo> {

    public ViewToDoAdapter(Context context, ArrayList<Todo> todos) {
        super(context, 0, todos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Todo todo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_todo, parent, false);
        }

        /* personalizar o view


        View view;
        if(property.getFeatured() == true){
            view = inflater.inflate(R.layout.property_layout_alt, null);
        }else{
            view = inflater.inflate(R.layout.property_layout, null);
        }
        */
        // Lookup view for data population
        TextView lvtodo_note = (TextView) convertView.findViewById(R.id.lvtodo_note);
        TextView lvtodo_status = (TextView) convertView.findViewById(R.id.lvtodo_status);
        TextView lvtodo_tags = (TextView) convertView.findViewById(R.id.lvtodo_tags);
        // Populate the data into the template view using the data object
        lvtodo_note.setText(todo.getNote());
        lvtodo_status.setText(todo.getStatusDesc());
        lvtodo_tags.setText(todo.getTagDesc());
        // Return the completed view to render on screen
        return convertView;
    }
}
