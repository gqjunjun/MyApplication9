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

import com.example.guoqiang20190404.R;

import java.util.List;

import bean.MyBean;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class WaiAdapter extends RecyclerView.Adapter<WaiAdapter.Hodler_1>{
    List<MyBean.DataBean> list;
    Context context;

    public WaiAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Hodler_1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.wai_adapter_layout,null);
        return new Hodler_1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler_1 hodler_1, int i) {

        String name = list.get(i).getSellerName();
        hodler_1.text_name.setText(name);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hodler_1.recyclerView.setLayoutManager(layoutManager);
        LiAdapter adapter = new LiAdapter(list.get(i).getList(),context);
        hodler_1.recyclerView.setAdapter(adapter);
        hodler_1.checkBox_2.setChecked(list.get(i).chebox_1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Hodler_1 extends RecyclerView.ViewHolder{
        CheckBox checkBox_2;
        TextView text_name;
        RecyclerView recyclerView;
        public Hodler_1(@NonNull View itemView) {
            super(itemView);
            checkBox_2 =itemView.findViewById(R.id.checkbox_2);
            text_name =itemView.findViewById(R.id.text_name);
            recyclerView =itemView.findViewById(R.id.recyvlerview_2);
        }
    }
}
