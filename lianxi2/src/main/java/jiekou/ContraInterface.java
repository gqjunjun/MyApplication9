package jiekou;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public interface ContraInterface {

    public interface LoginInterface{
        //登录
        public void  showLogin(String string);
        //注册
        public void  showRegist(String string);
    }
    public interface  Presenterface{

        public void requsetLogin(String phone,String pwd);

        public void requsetRegist(String phone,String pwd);

        public void requsetData();
    }

    public interface  ShowIntterface{
        public  void showData(Object obj);
    }
}
