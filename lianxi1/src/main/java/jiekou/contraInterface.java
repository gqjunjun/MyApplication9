package jiekou;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public interface contraInterface {
    public interface viewFace{
      public void showData(Object o);
    }
    public interface presenterFace{
        public void getData();
    }
}
