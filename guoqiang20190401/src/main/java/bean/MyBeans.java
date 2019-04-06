package bean;



import java.util.List;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyBeans {
    public Result result;

    public class Result{
        public  Rxxp rxxp;
        public  Pzsh pzsh;
        public  Mlss mlss;

    }

    public class Rxxp{
        public List<wode> commodityList;
    }
    public class Pzsh{
        public List<wode> commodityList;
    }
    public class Mlss{
        public List<wode> commodityList;
    }

    public class  wode{
        public String commodityName;
        public String masterPic;
    }
}
