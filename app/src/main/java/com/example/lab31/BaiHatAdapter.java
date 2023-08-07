package com.example.lab31;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.ViewHolder> {
    private List<BaiHat> lstBaiHat;
    public BaiHatAdapter(){}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baihat,parent,false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        BaiHat temp = lstBaiHat.get(position);
        holder.txtBaiHat.setText(temp.MaBaiHat+"-"+ temp.TenBaiHat);
        holder.txtNhacSi.setText(temp.TenNhacSi);
        Context context = holder.imgView.getContext();
        int imageId = context.getResources().getIdentifier(temp.TenHinh,"mipmap",context.getPackageName());
        if(imageId!=0){
            holder.imgView.setImageResource(imageId);
        }
    }
    @Override
    public int getItemCount(){
        if(lstBaiHat != null){
            return lstBaiHat.size();
        }
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView txtBaiHat;
        TextView txtNhacSi;

        FloatingActionButton btn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.imgBaiHat);
            txtBaiHat = (TextView) itemView.findViewById(R.id.txtTenBaiHat);
            txtNhacSi = (TextView) itemView.findViewById(R.id.txtNhacSiCaSi);
        }


    }
    public void setData(List<BaiHat> list){
        this.lstBaiHat = list;
        notifyDataSetChanged();
    }
}
