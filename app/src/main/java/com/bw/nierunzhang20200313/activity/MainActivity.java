package com.bw.nierunzhang20200313.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.nierunzhang20200313.R;
import com.bw.nierunzhang20200313.adpater.MyAdapter;
import com.bw.nierunzhang20200313.base.BaseActivity;
import com.bw.nierunzhang20200313.bean.LearyBean;
import com.bw.nierunzhang20200313.util.NetUtil;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
private PullToRefreshListView pullToRefreshListView;
private List<LearyBean.ListdataBean> list=new ArrayList<>();

    @Override
    protected void initData() {
getData();
    }
    @Override
    protected void initView() {
pullToRefreshListView=findViewById(R.id.pulllll);
pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
    private void getData() {
        if (NetUtil.getInstance().hasNet(this)){
            NetUtil.getInstance().doGet("http://blog.zhaoliang5156.cn/api/news/lawyer.json", new NetUtil.MyCallBack() {
                @Override
                public void DoSerssecc(String json) {
                    final LearyBean learyBean = new Gson().fromJson(json, LearyBean.class);
                list.addAll(learyBean.getListdata());
                    final MyAdapter myAdapter = new MyAdapter(list);
                    pullToRefreshListView.setAdapter(myAdapter);
                }

                @Override
                public void DoEroor() {

                }
            });
        }
    }
}
