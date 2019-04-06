package ptesenter;

import jiekou.contraInterface;
import model.MyModel;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyPresenter<T> implements contraInterface.Presenterface{
    MyModel myModel;
    T tt;

    public MyPresenter(T tt) {
        this.tt = tt;
        myModel = new MyModel();
    }
        //登录
    @Override
    public void requsetLogin(String phone, String pwd) {
        String url = "http://172.17.8.100/small/user/v1/login";
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void srussecc(Object o) {
                contraInterface.LoginInterface loginInterface = (contraInterface.LoginInterface) tt;
                loginInterface.showLogin((String) o);
            }
        });

        myModel.RequestPost(url,phone,pwd);
    }
    //注册
    @Override
    public void requsetRegist(String phone, String pwd) {
            String url  ="http://172.17.8.100/small/user/v1/register";
            myModel.setMyCallBack(new MyModel.MyCallBack() {
                @Override
                public void srussecc(Object o) {
                    contraInterface.LoginInterface loginInterface = (contraInterface.LoginInterface) tt;
                    loginInterface.showRegist((String) o);
                }
            });

            myModel.RequestPost(url,phone,pwd);
    }

    @Override
    public void requsetData() {
        String url = "http://172.17.8.100/ks/product/getCarts?uid=51";
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void srussecc(Object o) {
                contraInterface.ShowIntterface showIntterface  = (contraInterface.ShowIntterface) tt;
                showIntterface.showData(o);
            }
        });
        myModel.RequestGet(url,null);
    }
}
