# MVPSupport
MVP框架


知识点：

1.双向代理（生命周期代理、P层代理），在生命周期代理——目标对象角色中对View的绑定解绑，以及P层创建和销毁。Activity或Fragment只需代理目标对象即可。

2.P层的缓存，当Activity遇到横竖切换、长按Home键等执行onSaveInstanceState生命周期方法，缓存P层。当Activity再次执行onCreate时不必重新创建P,获取之前缓存P。

3.Lce的设计（Loading、content、error）

4.稍后...*[]:
[MVP框架之双向代理设计](https://www.jianshu.com/p/94a8e65433a4)
