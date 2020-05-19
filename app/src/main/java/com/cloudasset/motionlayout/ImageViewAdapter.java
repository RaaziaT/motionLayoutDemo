package com.cloudasset.motionlayout;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudasset.motionlayout.databinding.ProductDescriptionImagesBinding;

import java.util.List;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private List<Integer> list;

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductDescriptionImagesBinding productDescriptionImagesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_description_images, parent, false);
        return new ImageViewHolder(productDescriptionImagesBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        if (list != null) {
            holder.productDescriptionImagesBinding.image.setImageResource(getImage(position));
        }
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else return 0;
    }

    public void updateList(List<Integer> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public Integer getImage(int position) {
        return list.get(position);
    }

}
