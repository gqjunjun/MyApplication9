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
import com.example.lianxi2.R;

import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class LiAdapter extends RecyclerView.Adapter<LiAdapter.Holder_2> {
    List<MyBean.DataBean.ListBean> list;
    Context context;

    public LiAdapter(List<MyBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder_2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.li_adapter_layout,null);
        return new Holder_2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_2 holder_2, int i) {
        double price = list.get(i).getBargainPrice();
        String title = list.get(i).getTitle();
        String url = list.get(i).getImages();
        int num = list.get(i).getNum();

        holder_2.text_sum.setText(num+"");
        holder_2.text_price.setText(price+"");
        holder_2.text_title.setText(title);
        Glide.with(context).load(url).into(holder_2.image_view);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  Holder_2 extends  RecyclerView.ViewHolder{
        CheckBox checkBox_3;
        TextView text_title,text_price,text_jian,text_jia,text_sum;
        ImageView image_view;
        public Holder_2(@NonNull View itemView) {
            super(itemView);
            checkBox_3 = itemView.findViewById(R.id.checkbox_3);
            text_title = itemView.findViewById(R.id.text_title);
            text_price = itemView.findViewById(R.id.text_price);
            image_view = itemView.findViewById(R.id.image_view);
            text_jian = itemView.findViewById(R.id.text_jian);
            text_jia = itemView.findViewById(R.id.text_jia);
            text_sum = itemView.findViewById(R.id.text_sum);
        }
    }
}
