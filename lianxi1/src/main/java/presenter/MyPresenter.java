package presenter;

import java.util.HashMap;
import java.util.Map;

import jiekou.contraInterface;
import model.MyModel;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyPresenter<T> implements contraInterface.presenterFace{
    MyModel myModel;
    T tt;

    public MyPresenter(T tt) {
        this.tt = tt;
        myModel  = new MyModel();
    }

    @Override
    public void getData() {
        String url = "http://172.17.8.100/ks/product/getCarts?uid=51";

        myModel.setMyCallBeak(new MyModel.MyCallBeak() {
            @Override
            public void surssecc(Object o) {
                contraInterface.viewFace viewFace = (contraInterface.viewFace) tt;
                viewFace.showData(o);
            }
        });
        myModel.ReqeustData(url,null);
    }
}
