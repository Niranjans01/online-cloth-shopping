package com.niranjan.onlinecloths;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    List<ItemModel> itemModelList;
    Context mContext;

    public ItemAdapter(List<ItemModel> itemModelList, Context mContext) {
        this.itemModelList = itemModelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, final int i) {
        final ItemModel itemModel = itemModelList.get(i);

        itemViewHolder.img.setImageResource(itemModel.getItemimagename());
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ViewItems.class);
                intent.putExtra("itemName",itemModel.getItemname());
                intent.putExtra("itemPrice",itemModel.getItemprice());
                intent.putExtra("itemDesc",itemModel.getItemdescription());
                intent.putExtra("itemImage",itemModel.getItemimagename());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageNameLoad);

        }

    }
}
