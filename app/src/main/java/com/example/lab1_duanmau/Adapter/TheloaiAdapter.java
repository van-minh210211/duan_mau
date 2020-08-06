package com.example.lab1_duanmau.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1_duanmau.R;
import com.example.lab1_duanmau.TheLoai.TheloaiDao;
import com.example.lab1_duanmau.model.Theloai;

import java.util.List;

public class TheloaiAdapter extends BaseAdapter {
    List<Theloai> arrTheLoai;
    public Activity context;
    public LayoutInflater inflater;
    TheloaiDao theLoaiDAO;
    public TheloaiAdapter(Activity context, List<Theloai> arrayTheLoai) {
        super();
        this.context = context;
        this.arrTheLoai = arrayTheLoai;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDAO = new TheloaiDao(context);
    }
    @Override
    public int getCount() {
        return arrTheLoai.size();
    }
    @Override
    public Object getItem(int position) {
        return arrTheLoai.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtMaTheLoai;
        TextView txtTenTheLoai;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.itemtheloai, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtMaTheLoai = (TextView)
                    convertView.findViewById(R.id.tvMaTheLoai);
            holder.txtTenTheLoai = (TextView)
                    convertView.findViewById(R.id.tvTenTheLoai);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    theLoaiDAO.deleteTheLoaiByID(arrTheLoai.get(position).getMaTheLoai());
                    arrTheLoai.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        Theloai _entry = (Theloai) arrTheLoai.get(position);
        holder.img.setImageResource(R.drawable.cateicon);
        holder.txtMaTheLoai.setText(_entry.getMaTheLoai());
        holder.txtTenTheLoai.setText(_entry.getTenTheLoai());
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<Theloai> items){
        this.arrTheLoai = items;
        notifyDataSetChanged();
    }
}