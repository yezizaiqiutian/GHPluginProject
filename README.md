# 插件化学习demo

插件化相关链接:
demo功能来源:简书地址：https://www.jianshu.com/p/71585d744076
学习链接:https://zhuanlan.zhihu.com/p/33017826

本demo根据上述件数地址学习而来,

### 介绍
使用代理activity来实现插件化功能,功能简单,但是效果还不错,属于学习类功能,如果再项目中使用,

### 特点
(引用)第一代：dynamic-load-apk最早使用ProxyActivity这种静态代理技术，由ProxyActivity去控制插件中PluginActivity的生命周期。该种方式缺点明显，插件中的activity必须继承PluginActivity，开发时要小心处理context。而DroidPlugin通过Hook系统服务的方式启动插件中的Activity，使得开发插件的过程和开发普通的app没有什么区别，但是由于hook过多系统服务，异常复杂且不够稳定。

### 使用
+ activity
插件的activity需要集成BaseActivity
+ 广播
广播的流程:
app-->plugin-->app
plugin-->plugin


