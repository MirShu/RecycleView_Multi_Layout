# RecycleView_Multi_Layout
RecyclerView添加头部尾部和中间插入自定义View
 RecyclerView替代ListView 出道已经好几年了，作为开发者应该也都比较熟悉了，以及它的各种优势和方便多样化列表布局就更不用说了。

RecyclerView标准化了ViewHolder，可以轻松实现ListView实现不了的样式和功能，通过布局管理器LayoutManager可控制Item的布局方式，通过设置Item操作动画自定义Item添加和删除的动画，通过设置Item之间的间隔样式，自定义间隔。

总感觉RecyclerView已经是万能的了，对于复杂的列表界面和各种不同样式的Item都可以搞定，甚至我感觉好多资讯或者非资讯类的app一个页面只用一个RecyclerView都能做到，比如资讯类APP详情页头部是新闻详情中间又是相关新闻列表底部又是评论，评论上滑动加载更多，和大部分APP主要界面的各种不一样的列表，这些应该都是一个RecyclerView搞定的吧。

但是官网对RecyclerView也有它自己的解释：

    The RecyclerView widget is a more advanced and flexible version of ListView. This widget is a container for displaying large data sets that can be scrolled very efficiently by maintaining a limited number of views. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.

    这段解释意境很清楚，我们确实可以把它看作一个[advanced]的ListView，但是这里我想说的是，千万不要把RecyclerView看成能和ListView［等价替换］的一个组件，更不要把它看做是拯救你滑动组件的救星。

但是不管怎么样现在自己开发基本的列表页面都是一个RecyclerView控件来做的，基本也就是自己去写添加头部和添加尾部和中间插入自己想要布局的GroupLayout 都可以满足各种需求UI样式。

记录下自己参照网上一些大神例子写了个Demo。、

