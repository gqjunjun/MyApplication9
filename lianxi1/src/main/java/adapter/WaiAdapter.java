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

import com.example.lianxi1.MainActivity;
import com.example.lianxi1.R;

import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class WaiAdapter  extends RecyclerView.Adapter<WaiAdapter.Holder_1> {
    List<MyBean.DataBean> list;
    Context context;
    MainActivity activity;

    public WaiAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        activity = (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder_1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.wai_layout,null);
        return new Holder_1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder_1 holder_1, int i) {
        holder_1.checkBox.setChecked(list.get(i).isSelect);
        String name = list.get(i).getSellerName();
        holder_1.text_name .setText(name);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder_1.recyclerView.setLayoutManager(layoutManager);
        LimianAdapter adapter = new LimianAdapter(list.get(i).getList(),context);
        holder_1.recyclerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_1 extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView text_name;
        RecyclerView recyclerView;
        public Holder_1(@NonNull View itemView) {

            super(itemView);
            checkBox=itemView.findViewById(R.id.checkbox_2);
            text_name=itemView.findViewById(R.id.text_name);
            recyclerView=itemView.findViewById(R.id.recyclerview_2);
        }
    }
}
