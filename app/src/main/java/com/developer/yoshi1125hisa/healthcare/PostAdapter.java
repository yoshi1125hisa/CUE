package com.developer.yoshi1125hisa.healthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    List<Post> item;

    public PostAdapter(Context context, int resource, List<Post> objects) {
        super(context, resource, objects);
        item = objects;
    }

    @Override
    public int getCount(){
        return  item.size();
    }

    @Override
    public Post getItem(int position){
        return  item.get(position);
    }


        @Override
        public View getView (int position, View convertView, ViewGroup parent) {
            Post item = getItem(position);
            final ViewHolder viewHolder;

            if (convertView != null) {
                viewHolder = (ViewHolder) convertView.getTag();
            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.walkingText = convertView.findViewById(R.id.walking);
                viewHolder.sleepingText = convertView.findViewById(R.id.sleeping);
              convertView.setTag(viewHolder);
            }

            viewHolder.walkingText.setText(item.getWalking());
            viewHolder.sleepingText.setText(item.getSleeping());

            return convertView;
        }
    static class ViewHolder{

        TextView walkingText;
        TextView sleepingText;
}
}
