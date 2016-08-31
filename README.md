# ProxyModel
代理模式（Proxy）：为其他对象提供一种代理以控制对这个对象的访问。
看一下基本代码。
abstract class Subject{
 public abstract void Request();
}
class RealSubject extends Subject{
 @Override
 public void Request(){
  //真实的请求
 }
}
class Proxy extends Subject{
 private RealSubject realSubject;
 @Override
 public void Request(){
  if(realSubject == null){
    realSubject = new RealSubject();
  }
  realSubject.Request();
 }
}
客户端代码
class MainActivity extends Activity{
 public void onCreate(){
  Proxy proxy = new Proxy();
  proxy.Request();
 }
}
接下来举个例子，应用一下代理模式。比如A同学要给C同学送礼物，但是C同学不认识A同学，怎么办呢，那么B同学就出现了。B和A是好朋友，B和C也认识。那么A要给C送礼物，可以通过B来实现这个需求。
按照依赖倒置原则，针对接口编程。
package com.abings.proxymodel.Proxy;

/**
 * Created by Shuwen on 2016/8/31.
 */
public interface GiftSubject {
    void giveFloors();
    void giveDolls();
    void giveLove();
}
接着是开放封闭原则。真正有需求的对象
package com.abings.proxymodel.Proxy;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Shuwen on 2016/8/31.
 */
public class RealSubjectPersonA implements GiftSubject {

    private String name;
    private Context context;
    public RealSubjectPersonA(String name,Context context){
        this.name = name;
        this.context = context;
    }

    @Override
    public void giveFloors() {
        Toast.makeText(context, "A先生送"+name+"小姐一束花。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void giveDolls() {
        Toast.makeText(context, "A先生送"+name+"小姐一个玩具熊。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void giveLove() {
        Toast.makeText(context, "A先生向"+name+"小姐表达爱意。", Toast.LENGTH_SHORT).show();
    }
}
接下来是代理对象
package com.abings.proxymodel.Proxy;

import android.content.Context;

/**
 * Created by Shuwen on 2016/8/31.
 */
public class ProxyPersonB implements GiftSubject {
    private RealSubjectPersonA realSubjectPersonA;
    public ProxyPersonB(PersonC personC,Context context){
        if (realSubjectPersonA == null){
            realSubjectPersonA = new RealSubjectPersonA(personC.getName(),context);
        }
    }

    @Override
    public void giveFloors() {
        realSubjectPersonA.giveFloors();
    }

    @Override
    public void giveDolls() {
        realSubjectPersonA.giveDolls();
    }

    @Override
    public void giveLove() {
        realSubjectPersonA.giveLove();
    }
}
这就是按照UML图设计出来的代码，简单易懂。（顺便告诉大家，追女孩子采用代理模式，最终的结果是代理那个人会成功追到手。苦不堪言的结局，面对爱情就是要用于表达，不然只有单身咯。不过，程序猿单身也是在正常不过的了。）





