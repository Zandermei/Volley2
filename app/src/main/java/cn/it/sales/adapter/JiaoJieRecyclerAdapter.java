package cn.it.sales.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cn.it.sales.R;

/**
 * Created by Administrator on 2016/5/23.
 */
public class JiaoJieRecyclerAdapter extends RecyclerView.Adapter<JiaoJieRecyclerAdapter.MyViewHolder> {
    List<JSONObject> mDataList;
    Context mContext;
    //定义一个变量判断是否是接班
    boolean mIsJieBan;

    public JiaoJieRecyclerAdapter(Context context, List<JSONObject> dataList, boolean isJieBan) {
        mContext=context;
        mDataList = dataList;
        mIsJieBan = isJieBan;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder( LayoutInflater.from(mContext).
                inflate(R.layout.jiaojie_item,parent,false ));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JSONObject jsonObject = mDataList.get(position);
        //如果是接班刷新接班数据显示
        if (mIsJieBan) {
            try {
                holder.mTextView1.setText(jsonObject.get("banci").toString());
                holder.mTextView2.setText(jsonObject.get("mingcheng").toString());
                holder.mTextView3.setText(jsonObject.get("jiaobankucunliang").toString());
                holder.mTextView4.setText(jsonObject.get("xiaoshoushuliang").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
       //否则，刷新交班数据显示
        } else {
            try {
                holder.mTextView1.setText(jsonObject.get("mingcheng").toString());
                holder.mTextView2.setText(jsonObject.get("jiebankucunliang").toString());
                holder.mTextView3.setText(jsonObject.get("jiaobankucunliang").toString());
                holder.mTextView4.setText(jsonObject.get("xiaoshoushuliang").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView1, mTextView2, mTextView3, mTextView4;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView1 = (TextView) itemView.findViewById(R.id.name);
            mTextView2 = (TextView) itemView.findViewById(R.id.jiebankucun);
            mTextView3 = (TextView) itemView.findViewById(R.id.jiaobankucun);
            mTextView4 = (TextView) itemView.findViewById(R.id.xiaoshoushuliang);
        }
    }
}
