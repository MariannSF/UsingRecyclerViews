package com.example.usingrecyclerviews;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*
this class needs to extend the RecyclerView.Adapter and instead of the type of the
object it needs the type of a viewHolder it is managing
 */
public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder> {
    ArrayList<User> users;
//Created a constructor
    public UserRecyclerViewAdapter(ArrayList<User> data){
        this.users = data;
    }
/*
Here we create the view Holder which returns a holder which is empty like getView
the viewHolder has oly references to the view

This is a method creating view holders for me

 */
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }
//Here we are binging a viewHolder with the data item
    //This method gives a viewHolder and a position

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.textViewName.setText(user.name);
        holder.textViewAge.setText(user.age+" Years Old");
        holder.position = position;
        holder.user = user;


    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    //Here is the viewHolder it has the ui components we would like to maintain so we can change them later

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewAge;
        View rootView;
        int position;
        User user;

        //constructor when creating the constuctor we are initializing the values textViewName and age
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewName = itemView.findViewById(R.id.textViewName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.d("demo", "onClick: item clicked "+ position + " user "+ user.name);
                }
            });

        }
    }
}
