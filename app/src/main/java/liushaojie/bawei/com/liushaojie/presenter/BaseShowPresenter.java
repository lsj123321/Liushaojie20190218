package liushaojie.bawei.com.liushaojie.presenter;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 08:56:51
 * @Description:
 */
public class BaseShowPresenter<V> {
    private V mView;
    public void setView(V v){
        this.mView=v;
    }
    public void detachView(){
        this.mView=null;
    }
    public V getView(){
        return mView;
    }
}
