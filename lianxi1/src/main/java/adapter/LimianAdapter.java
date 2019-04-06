package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lianxi1.R;

import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class LimianAdapter extends RecyclerView.Adapter<LimianAdapter.Holder_2> {
    List<MyBean.DataBean.ListBean> list;
    Context context;
    int ss=1;
    public LimianAdapter(List<MyBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder_2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.limian_layout,null);
        return new Holder_2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_2 holder_2, int i) {
        holder_2.checkBox_3.setChecked(list.get(i).cheSelect);

        double price = list.get(i).getBargainPrice();
        String url = list.get(i).getImages();
        String title = list.get(i).getTitle();
        holder_2.text_title.setText(title);


        holder_2.text_price.setText(price+"");
        holder_2.text_shu.setText(1+"");
        Glide.with(context).load(url).into(holder_2.image_view);

        holder_2.text_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ss++;
               holder_2.text_shu.setText(ss+"");
            }
        });

        holder_2.text_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ss==1){
                    ss=1;
                }else{
                    ss--;
                    holder_2.text_shu.setText(ss+"");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_2 extends RecyclerView.ViewHolder{
        CheckBox checkBox_3;
        TextView text_title,text_price,text_shu,text_jia,text_jian;
        ImageView image_view;

        public Holder_2(@NonNull View itemView) {
            super(itemView);
            checkBox_3 = itemView.findViewById(R.id.checkbox_3);
            text_title = itemView.findViewById(R.id.text_title);
            text_price = itemView.findViewById(R.id.text_price);
            image_view = itemView.findViewById(R.id.image_view);
            text_shu=itemView.findViewById(R.id.text_shu);
            text_jia=itemView.findViewById(R.id.text_jia);
            text_jian=itemView.findViewById(R.id.text_jian);

        }
    }
}
