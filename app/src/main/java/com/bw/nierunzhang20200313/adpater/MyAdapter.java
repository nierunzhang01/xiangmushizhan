package com.bw.nierunzhang20200313.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.nierunzhang20200313.R;
import com.bw.nierunzhang20200313.bean.LearyBean;
import com.bw.nierunzhang20200313.util.NetUtil;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.13<p>
 * <p>更改时间：2020.3.13<p>
 */
public class MyAdapter  extends BaseAdapter {
    private List<LearyBean.ListdataBean> list;

    public MyAdapter(List<LearyBean.ListdataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_left, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.name=convertView.findViewById(R.id.nameee);
            viewHolder.imageView=convertView.findViewById(R.id.img);
            viewHolder.info=convertView.findViewById(R.id.infooooo);
            viewHolder.connn=convertView.findViewById(R.id.connnnnnn);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final LearyBean.ListdataBean listdataBean = list.get(position);
        viewHolder.name.setText(listdataBean.getName());
        viewHolder.info.setText(listdataBean.getInfo());
        viewHolder.connn.setText(listdataBean.getContent());
        NetUtil.getInstance().doGetPhoto(listdataBean.getAvatar(), viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        TextView name,info,connn;
        ImageView imageView;
    }
}
