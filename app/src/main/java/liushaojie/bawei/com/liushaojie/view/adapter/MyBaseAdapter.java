package liushaojie.bawei.com.liushaojie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import liushaojie.bawei.com.liushaojie.R;
import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 10:16:20
 * @Description:
 */
public class MyBaseAdapter extends RecyclerView.Adapter<MyBaseAdapter.MyViewHolder>{
    private Context context;

    public MyBaseAdapter(Context context) {
        this.context = context;
    }
    private ArrayList<NewsBean.DataBeanX.DataBean> arr=new ArrayList<>();

    public void setData(ArrayList<NewsBean.DataBeanX.DataBean> list){
        if (list!=null){
            arr.addAll(list);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(arr.get(i).getTitle());
        Glide.with(context).load(arr.get(i).getTitle()).into(myViewHolder.url);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{


        private final TextView name;
        private final ImageView url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.t1);
            url = itemView.findViewById(R.id.img1);
        }
    }
}
