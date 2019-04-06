package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lianxi2.R;

import java.util.List;

import adapter.WaiAdapter;
import bean.MyBean;
import jiekou.ContraInterface;
import ptersenter.MyPresenter;


/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class ShowFragment extends Fragment implements ContraInterface.ShowIntterface{
    RecyclerView recyclerview_1;
    CheckBox checkBox_1;
    TextView text_zong;
    List<MyBean.DataBean> list;
    WaiAdapter adapter ;
    ContraInterface.Presenterface presenterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shou_fragment,container,false);
        recyclerview_1 =view.findViewById(R.id.recyclerview_1);
        checkBox_1 =view.findViewById(R.id.checkbox_1);
        text_zong =view.findViewById(R.id.text_zong);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_1.setLayoutManager(layoutManager);
        adapter = new WaiAdapter(list,getContext());
        recyclerview_1.setAdapter(adapter);
        presenterface =new MyPresenter<>(getContext());
        presenterface.requsetData();
    }

    @Override
    public void showData(Object obj) {
        MyBean myBean = (MyBean) obj;
        list.addAll(myBean.getData());
        adapter.notifyDataSetChanged();


    }
}
