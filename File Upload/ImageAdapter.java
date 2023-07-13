package com.example.fileupload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext; //get the context
    private List<Upload> mUploads;

    public ImageAdapter(Context context, List<Upload> uploads){
        mContext = context; //assign
        mUploads = uploads; //assign
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent,false); //resource id of card item , image_item
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        //get data out of upload items into single card items
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getUploadName());

        //load images from url
        Picasso.get()
                .load(uploadCurrent.getUploadImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView); //load() - pass url where we want to load it from, fit() resizes image to fit in image view, into() load to image view
    }

    @Override
    public int getItemCount() {
        return mUploads.size(); //return uploads size
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName; //display name of single items
        public ImageView imageView;
        public ImageViewHolder(View itemView){
             super(itemView);
             textViewName = itemView.findViewById(R.id.text_view_name); //from image_item.xml
             imageView = itemView.findViewById(R.id.image_view_upload); //from image_item.xml
        }
    }
}
