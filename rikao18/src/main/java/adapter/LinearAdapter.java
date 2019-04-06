package adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.rikao18.MainActivity;
import com.example.rikao18.R;
import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.Holder>{
    List<MyBean.DataBean> list;
    Context context;
        MainActivity mainActivity;

    public LinearAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        mainActivity = (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(context).inflate(R.layout.linear_layout,null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        holder.checkBox.setChecked(list.get(i).isSelect);
        String title = list.get(i).getSellerName();
        holder.title.setText(title);

        //嵌套的RecyclerView设置
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(layoutManager);
        LimianAdapter adapter = new LimianAdapter(list.get(i).getList(),context);
        holder.recyclerView.setAdapter(adapter);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView title;
        RecyclerView recyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            checkBox =itemView.findViewById(R.id.checkbox_1);
            title =itemView.findViewById(R.id.text_title);
            recyclerView =itemView.findViewById(R.id.recyclerview_id);
        }
    }
}
