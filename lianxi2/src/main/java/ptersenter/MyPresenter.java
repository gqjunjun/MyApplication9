package ptersenter;

import android.util.Log;

import jiekou.ContraInterface;
import model.MyModel;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyPresenter<T> implements ContraInterface.Presenterface{
    MyModel myModel;
    T tt;

    public MyPresenter(T tt) {
        this.tt = tt;
        myModel = new MyModel();
    }

    @Override
    public void requsetLogin(String phone, String pwd) {

    }

    @Override
    public void requsetRegist(String phone, String pwd) {

    }

    @Override
    public void requsetData() {
        String url="http://172.17.8.100/ks/product/getCarts?uid=51";
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void suruucee(Object obj) {
                ContraInterface.ShowIntterface showIntterface = (ContraInterface.ShowIntterface) tt;

                showIntterface.showData(obj);

            }
        });

        myModel.reqeustGet(url,null);
    }
}
