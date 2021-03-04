package com.example.urbanfresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.urbanfresh.network.ModelCategoryData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivityAdapter extends  RecyclerView.Adapter<MainActivityAdapter.AViewHolder> {
	Context context;
	ArrayList<ModelCategoryData> modelCategoryData;

	public MainActivityAdapter(Context context, ArrayList<ModelCategoryData> modelCategoryData) {
		this.context = context;
		this.modelCategoryData = modelCategoryData;
	}

	@NonNull
	@Override
	public MainActivityAdapter.AViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout_category, parent, false);
		return new AViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull MainActivityAdapter.AViewHolder holder, int position) {
		Picasso.get().load(modelCategoryData.get(position).getCategory_picture()).into(holder.singleListForImageView);
		holder.categoryName.setText(modelCategoryData.get(position).getCategory_name());
	}

	@Override
	public int getItemCount() {
		return modelCategoryData.size();
	}

	public class AViewHolder extends ViewHolder {
		ImageView singleListForImageView;
		TextView categoryName;
		public AViewHolder(@NonNull View itemView) {
			super(itemView);
			singleListForImageView = itemView.findViewById(R.id.singleListForImageView);
			categoryName = itemView.findViewById(R.id.categoryName);

		}
	}
}
