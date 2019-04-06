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
import com.example.rikao18.MainActivity;
import com.example.rikao18.R;

import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class LimianAdapter extends RecyclerView.Adapter<LimianAdapter.Holder_1>{
    List<MyBean.DataBean.ListBean> list;
    Context context;
    MainActivity mainActivity;

    public LimianAdapter(List<MyBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
        mainActivity = (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder_1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.limian_layout,null);
        return new Holder_1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_1 holder_1, final int i) {


        holder_1.checkBox_2.setChecked(list.get(i).cheSelect);
        String title = list.get(i).getTitle();
        String url = list.get(i).getImages();
        double price = list.get(i).getPrice();

        holder_1.price.setText(price+"");
        holder_1.text_view.setText(title);
        Glide.with(context).load(url).into(holder_1.image_view);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_1 extends RecyclerView.ViewHolder{
        CheckBox checkBox_2;
        ImageView image_view;
        TextView text_view;
        TextView price;
        public Holder_1(@NonNull View itemView) {

            super(itemView);
            checkBox_2 =itemView.findViewById(R.id.checkbox_2);
            image_view =itemView.findViewById(R.id.iamge_view);
            text_view =itemView.findViewById(R.id.text_view);
            price =itemView.findViewById(R.id.price);

        }
    }
}
