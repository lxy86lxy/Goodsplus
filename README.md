# **Doods**

## 一、基本功能

该app为本地登录，其有首页、问答、广场、体系、个人五大板块和项目、搜索两个辅助板块。
首页、问答、广场这三个都是显示内容，都有点击事件可以跳转到对应内容的网页，其中首页中的公众号字样可以点击跳转对应公众号列表。
搜索板块可以输入关键词，将为其搜索相关内容并呈现在页面上，在项目和搜索出的内容同样可以点击跳转对应内容网页。
在体系中分为体系和导航，分别对应两大内容，在该内容中还包含对应子内容，子内容也可进行跳转网页搜索。
在所有列表中都有界面刷新功能，可以通过上拉和下拉实现内容刷新。

## 二、环境与语言

Androidstudio、java

## 三、代码目录说明

### activities

activities中article包中依次下来是项目界面、web界面、搜索界面、公众号界面，baby中是关于体系板块的的整个内容，主活动为TiActivity，TiZiActivity是每次要跳转的内容活动。ListActivity是首页、LoginActivity是登录、My_characteristicActivity是个人界面、RecommendActivity是问答界面、RegisterActivity是注册界面、SquareActivity是广场界面。

### adapter

adapter中就是对应几个列表的适配器。

### classes

classes中就是对json数据解析后存放所需要的数据创建的类和为适配器创建的类。

### Strings

Strings包中为所要用到的url。

### util

util包中包含自己封装的网络请求类HttpUtil和json数据解析类JsonUtil。

## 四、常见问题

1.在子线程内无法更新ui界面，可以使用Handel发送消息后更新，但常会出现内存泄漏的问题，需要弱引用或者runOnUiThread()回到主线程。
2.在recycleview更新中会出现无法更新当前页面，可以使用clear()清除之前的数据再更新。

## 五、引用的库

实现图片加载：com.github.bumptech.glide:glide:3.7.0