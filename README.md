# RecyclerView添加头部尾部和中间插入自定义View

RecyclerView替代ListView 出道已经好几年了，作为开发者应该也都比较熟悉了，以及它的各种优势和方便多样化列表布局就更不用说了。

RecyclerView标准化了ViewHolder，可以轻松实现ListView实现不了的样式和功能，通过布局管理器LayoutManager可控制Item的布局方式，通过设置Item操作动画自定义Item添加和删除的动画，通过设置Item之间的间隔样式，自定义间隔。

总感觉RecyclerView已经是万能的了，对于复杂的列表界面和各种不同样式的Item都可以搞定，甚至我感觉好多资讯或者非资讯类的app一个页面只用一个RecyclerView都能做到，比如资讯类APP详情页头部是新闻详情中间又是相关新闻列表底部又是评论，评论上滑动加载更多，和大部分APP主要界面的各种不一样的列表，这些应该都是一个RecyclerView搞定的吧。

但是官网对RecyclerView也有它自己的解释：

```
The RecyclerView widget is a more advanced and flexible version of ListView. 
This widget is a container for displaying large data sets that can be scrolled 
very efficiently by maintaining a limited number of views. Use the RecyclerView 
widget when you have data collections whose elements change at runtime based on user action or network events.

这段解释意境很清楚，我们确实可以把它看作一个[advanced]的ListView，但是这里我想说的是，
千万不要把RecyclerView看成能和ListView［等价替换］的一个组件，
更不要把它看做是拯救你滑动组件的救星。
```

  但是不管怎么样现在自己开发基本的列表页面都是一个RecyclerView控件来做的，
  基本也就是自己去写添加头部和添加尾部和中间插入自己想要布局的GroupLayout 都可以满足各种需求UI样式。

记录下自己参照网上一些大神例子写了个Demo。


![2781551-9d5f6d5bf47cd76f](https://user-images.githubusercontent.com/13359093/209261570-d72f9589-a969-43e1-a180-700826de54a2.gif)

### 里面想穿插多少种类型的item  就由自己的需求而定，包括很多面布局，不同类型的复杂页面可以扩散思维去设计自己代码。新闻类型的详情页底部，有列表或者底部还有新闻，是不是就都可以用这种方式来设计代码，一并的加载出来。

![2781551-3a09f8f00f31cc6b](https://user-images.githubusercontent.com/13359093/209261579-c5efd100-938e-4eca-8a8f-f22184883b37.gif)

```
//主页面

<?xml version="1.0" encoding="utf-8"?>
<androidx.recyclerview.widget.RecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/home_news_rview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"/>


```

```
//头部
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <com.youth.banner.Banner
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="200dp" />


    <LinearLayout
        android:layout_marginTop="15dp"
        android:layout_marginBottom="15dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">



        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type00"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>



        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type01"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>


        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type02"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>


        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type03"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>


    </LinearLayout>



    <LinearLayout
        android:layout_marginBottom="15dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type04"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>
        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type00"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>
        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type02"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>
        <LinearLayout
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/icon_type04"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="教材"
                android:textColor="#000000"
                android:textSize="14sp" />
        </LinearLayout>

    </LinearLayout>


    <View
        android:background="#f1f1f1"
        android:layout_width="match_parent"
        android:layout_height="1dp"/>
</LinearLayout>
```

```
//样式 1
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:paddingLeft="5dp"
    android:paddingRight="5dp"
    android:paddingBottom="15dp"
    android:paddingTop="15dp"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <ImageView
        android:id="@+id/headline_img"
        android:layout_width="120dp"
        android:layout_height="90dp"
        android:scaleType="centerCrop"
        android:src="@mipmap/ic_launcher_round" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:orientation="vertical">

        <TextView
            android:id="@+id/title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="标题"
            android:textColor="#000000"
            android:textSize="18sp"
            android:textStyle="bold" />

    </LinearLayout>

</LinearLayout>

```

这就是效果，一个RecyclerView完成的，甚至还可以做更复杂的布局，不同的样式。

也不是特别的难主要就是添加头部尾部中间插入放Adapter getItemViewType不同的类型进行区分


### 主要注意一点，可以能添加了头，尾部之后就得重新去获取真实的position 要不然就会报数组越界错误。
### 这个是我的adapter 是根据真实的position 来显示不同样式的item，有自己来设置和判断不同类新。加多少种类型都是可以的

```
 if (listBeans.get(getPosition(position)).getReplies_count() ==1) {

return TYPE_1;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==2) {

return TYPE_2;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==3) {

return TYPE_3;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==4) {

return TYPE_4;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==5) {

return TYPE_5;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==6) {

return TYPE_6;

            }else {

return TYPE_7;

            }

}
```

### 这是整个Adapter类，我只是便于代码的分类把ViewHolder和onBindViewHolder绑定数据的分别都写到外面去了而已，如果这三个类 读写在Adapter里面的话到时候这个类会很臃肿代码量很大，分别写到外面去的话应该都知道是为了后期维护，以及代码的整洁，明确易于查找。

# 1、Adapter类

```

package com.example.recycleview_multi_layout.adapter;

import android.content.Context;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.Model;

import com.example.recycleview_multi_layout.R;

import java.util.List;

public  class Adapter extends RecyclerView.Adapter {

private static final int HEADER_VIEW =0;

    private static final int NORMAL_VIEW =1;

    private static final int TYPE_MIDDLE =2;

    private static final int TYPE_MIDDLE_TWO =3;

    private static final int TYPE_1 =4;

    private static final int TYPE_2 =5;

    private static final int TYPE_3 =6;

    private static final int TYPE_4 =7;

    private static final int TYPE_5 =8;

    private static final int TYPE_6 =9;

    private static final int TYPE_7 =10;

    private View mHeaderView;

    private View mMiddleView;

    private View mMiddleView2;

    private ListlistBeans;

    private OnClickListener mItemClickListener;

    BaseBindViewHolder baseBindViewHolder=new BaseBindViewHolder();

    private Context mContext;

    public void setItemClickListener(OnClickListener itemClickListener) {

mItemClickListener = itemClickListener;

    }

public void setHeaderView(View headerView) {

mHeaderView = headerView;

    }

public void setMiddleView(View middleView) {

mMiddleView = middleView;

    }

public void setMiddleView2(View middleView2) {

mMiddleView2 = middleView2;

    }

public Adapter(List list, Context context) {

this.listBeans = list;

        this.mContext = context;

    }

@Override

    public int getItemCount() {

if (listBeans !=null &&listBeans.size() !=0) {

return listBeans.size() +3;

        }

return 0;

    }

@Override

    public int getItemViewType(int position) {

if (position ==0) {

return HEADER_VIEW;

        }

if (position ==5) {

return TYPE_MIDDLE;

        }

if (position ==10) {

return TYPE_MIDDLE_TWO;

        }else {

if (listBeans.get(getPosition(position)).getReplies_count() ==1) {

return TYPE_1;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==2) {

return TYPE_2;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==3) {

return TYPE_3;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==4) {

return TYPE_4;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==5) {

return TYPE_5;

            }else if (listBeans.get(getPosition(position)).getReplies_count() ==6) {

return TYPE_6;

            }else {

return TYPE_7;

            }

}

}

public int getPosition(int i) {

if (i <4) {

return i -1;

        }

if (i >4 && i <10) {

return i -2;

        }else {

return i -3;

        }

}

@Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

if (mHeaderView !=null && viewType ==HEADER_VIEW) {

return new BaseViewHolder(mHeaderView);

        }

if (mMiddleView !=null && viewType ==TYPE_MIDDLE) {

return new BaseViewHolder(mMiddleView);

        }

if (mMiddleView2 !=null && viewType ==TYPE_MIDDLE_TWO) {

return new BaseViewHolder(mMiddleView2);

        }

if (viewType ==TYPE_1) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type1, null, false));

        }else if (viewType ==TYPE_2) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type2, null, false));

        }else if (viewType ==TYPE_3) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type3, null, false));

        }else if (viewType ==TYPE_4) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type4, null, false));

        }else if (viewType ==TYPE_5) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type5, null, false));

        }else if (viewType ==TYPE_6) {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type6, null, false));

        }else {

return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type0, null, false));

        }

}

@Override

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

if (getItemViewType(position) ==HEADER_VIEW) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder0(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_MIDDLE) {

if (holderinstanceof BaseViewHolder) {

}

return;

        }

if (getItemViewType(position) ==TYPE_MIDDLE_TWO) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindTYPE_MIDDLE_TWO(holder,listBeans,mContext);

            }

return;

        }

if (getItemViewType(position) ==TYPE_1) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder1(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_2) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder2(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_3) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder3(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_4) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder4(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_5) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder5(holder,listBeans);

            }

return;

        }

if (getItemViewType(position) ==TYPE_6) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder6(holder,listBeans);

            }

return;

        }

final int pos =getRealPosition(holder);

        if (getItemViewType(position) ==TYPE_7) {

if (holderinstanceof BaseViewHolder) {

baseBindViewHolder.onBindViewHolder7(holder,listBeans);

                if (mItemClickListener ==null) {

return;

                }

holder.itemView.setOnClickListener(new View.OnClickListener() {

@Override

                    public void onClick(View v) {

mItemClickListener.onItemClick(v, pos);

                    }

});

            }

return;

        }

}

// 获取条目的真实位置

    public int getRealPosition(RecyclerView.ViewHolder holder) {

int position = holder.getLayoutPosition();

        if (position <5) {

return position -1;

        }

if (position >5 &&position <10) {

return position -2;

        }else {

return position -3;

        }

}

interface OnClickListener {

void onItemClick(View view, int position);

    }

}

```
# 2、 RecyclerView.ViewHolder 视图类

```
public class BaseViewHolder extends RecyclerView.ViewHolder {
    public ImageView headlineImg, headlineImg2, headlineImg3;
    public TextView title,sourceTitle, sourceSummary,summary;
    public RoundedImageView sourceImage;
    public Banner banner;
    public RecyclerView recyclerView;


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        headlineImg = itemView.findViewById(R.id.headline_img);
        headlineImg2 = itemView.findViewById(R.id.headline_img2);
        headlineImg3 = itemView.findViewById(R.id.headline_img3);
        sourceImage = itemView.findViewById(R.id.source_image);


        title = itemView.findViewById(R.id.title);
        sourceTitle = itemView.findViewById(R.id.source_title);
        sourceSummary = itemView.findViewById(R.id.source_summary);
        summary = itemView.findViewById(R.id.summary);

        banner = itemView.findViewById(R.id.banner);
        recyclerView= itemView.findViewById(R.id.recyclerView);
    }
}

```

# 3、BindViewHolder 绑定数据类

```
public class BaseBindViewHolder {

    public void onBindViewHolder0(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.response01);
        list.add(R.mipmap.response02);
        list.add(R.mipmap.response03);
        list.add(R.mipmap.response04);
        list.add(R.mipmap.response05);
        list.add(R.mipmap.response06);
        ((BaseViewHolder) holder).banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    private List<Fruit> fruitList = new ArrayList<>();

    public void onBindTYPE_MIDDLE_TWO(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans, Context context) {
        initFruits();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ((BaseViewHolder) holder).recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(fruitList);
        ((BaseViewHolder) holder).recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("HHH", R.mipmap.response01);
            fruitList.add(apple);
            Fruit banana = new Fruit("AAA", R.mipmap.response02);
           
        }
    }


    public void onBindViewHolder1(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        if (!TextUtils.isEmpty(listBeans.get(pos).getHeadline_img())) {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        } else {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, "http://liveimg.miaobolive.com/pic/avator/201910/26/15/E31ED19F926F874063215984_640.png");
        }


    }

    public void onBindViewHolder2(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder3(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        ((BaseViewHolder) holder).summary.setText(listBeans.get(pos).getSummary());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder4(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());

        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }


    public void onBindViewHolder5(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());

        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg2, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg3, listBeans.get(pos).getHeadline_img());

    }

    public void onBindViewHolder6(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());
        ((BaseViewHolder) holder).sourceTitle.setText(listBeans.get(pos).getSource_data().getTitle());
        ((BaseViewHolder) holder).sourceSummary.setText(listBeans.get(pos).getSource_data().getSummary());
        XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        XImageOptions.imageData(((BaseViewHolder) holder).sourceImage, listBeans.get(pos).getSource_data().getImage());

    }


    public void onBindViewHolder7(RecyclerView.ViewHolder holder, List<Model.ResultBean> listBeans) {
        final int pos = getRealPosition(holder);
        ((BaseViewHolder) holder).title.setText(listBeans.get(pos).getTitle());


        if (TextUtils.isEmpty(listBeans.get(pos).getHeadline_img())||listBeans.get(pos).getHeadline_img()==null) {
            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, "http://2-im.guokr.com/BL-zs0S2cMtowORGmuKri_mYXjze4UY0ZkX-WGWn5Ug4BAAAvAEAAEpQ.jpg?imageView2/1/w/1080/h/444");

        } else {

            XImageOptions.imageData(((BaseViewHolder) holder).headlineImg, listBeans.get(pos).getHeadline_img());
        }

    }


    // 获取条目的真实位置
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        if (position < 5) {
            return position - 1;
        }
        if (position > 5 && position < 10) {
            return position - 2;
        } else {
            return position - 3;
        }

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }


}

```


###  最后基本的一些类，主要核心代码块都在这了，里面的变量命名我就随便的有些是直接复制的就没改了。
