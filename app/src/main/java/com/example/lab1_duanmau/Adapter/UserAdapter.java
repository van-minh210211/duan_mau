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
import com.example.lab1_duanmau.NguoiDung.UserDao;
import com.example.lab1_duanmau.model.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<User> listND;
    public Activity context;
    public LayoutInflater inflater;
    UserDao nguoiDungDAO;

    public UserAdapter( Activity context, List<User> listND) {
        super();
        this.listND = listND;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new UserDao(context);
    }

    @Override
    public int getCount() {
        return listND.size();
    }

    @Override
    public Object getItem(int i) {
        return listND.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder{
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.itemuser, null);
            holder.img = (ImageView) view.findViewById(R.id.ivIcon);
            holder.txtName = (TextView) view.findViewById(R.id.tvName);
            holder.txtPhone = (TextView) view.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView) view.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nguoiDungDAO.deleteNguoiDungByID(listND.get(i).getUserName());
                    listND.remove(i);
                    notifyDataSetChanged();
                }
            });
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        User entry  = (User) listND.get(i);

        if (i % 3 == 0){
            holder.img.setImageResource(R.drawable.emone);
        }else if (i % 3 == 1){
            holder.img.setImageResource(R.drawable.emtwo);
        }else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText(entry.getHoTen());
        holder.txtPhone.setText(entry.getPhone());
        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<User> items){
        this.listND = items;
        notifyDataSetChanged();
    }
}
