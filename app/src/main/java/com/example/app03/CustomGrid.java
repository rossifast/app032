package com.example.app03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomGrid extends BaseAdapter {
    private Context context;
    private final int[] imageId;

    public CustomGrid(Context context, int[] imageId) {
        this.context = context;
        this.imageId = imageId;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(context);
            grid = layoutInflater.inflate(R.layout.grid_item_layout, null);
            ImageView imageView = grid.findViewById(R.id.grid_Image);
            imageView.setImageResource(imageId[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
