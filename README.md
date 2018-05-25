# AndroidSlideIndicator
Android 滑动风格页面指示器。

### 本应用的示例

![image](https://github.com/iWay7/AndroidSlideIndicator/blob/master/sample.gif)   

### 本示例基于 AndroidHelpers 库，访问 https://github.com/iWay7/AndroidHelpers 添加依赖。

#### 开始使用：
##### 在布局文件中声明一个 SlideIndicator 视图：
```
<site.iway.androidhelpers.SlideIndicator
    android:id="@+id/slideIndicator"
    android:layout_width="match_parent"
    android:layout_height="5dp"
    app:indicatorDrawable="#cc0000"
    app:leftPositionOffset="0"
    app:rightPositionOffset="0.3333" />
```

##### 其中的属性如下：
```
app:indicatorDrawable 滑动指示器的 Drawable
app:leftPositionOffset 初始指示器 Drawable 左到左边界权重
app:rightPositionOffset 初始指示器 Drawable 右到左边界权重
```

##### 使用代码控制指示器 Drawable 的位置：
```
// left 代表 Drawable 左到左边界的距离，以像素为单位
// right 代表 Drawable 右到左边界的距离，以像素为单位
// 布尔值代表从旧位置移动到新位置是否进行动画
slideIndicator.setIndicatorTo(left, right, false); 
```

##### 可以用下方式绑定到 ViewPager 中：
```
viewPager.setOnPageChangeListener(new OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int totalWidth = viewPager.getWidth();
        int pageCount = viewPager.getAdapter().getCount();
        if (totalWidth > 0) {
            float part = totalWidth / pageCount;
            float left = (position + positionOffset) * part;
            float right = left + part;
            slideIndicator.setIndicatorTo((int) left, (int) right, false);
        }
    }
    @Override
    public void onPageSelected(int position) {
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }
});
```
