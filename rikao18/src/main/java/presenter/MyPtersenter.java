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
public class MyPtersenter<T> implements contraInterface.PresenterFace{
    MyModel myModel;
        T tt;

    public MyPtersenter(T tt) {
        this.tt = tt;
        myModel = new MyModel();
    }



    @Override
    public void getData() {
        String url ="http://172.17.8.100/ks/product/getCarts?uid=51";
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void sruusrr(Object obj) {
                contraInterface.ViewFace viewFace = (contraInterface.ViewFace) tt;
                viewFace.showData(obj);
            }
        });
        Map<String,String> map = new HashMap<>();

        myModel.ReqeustData(url,null);
    }
}
