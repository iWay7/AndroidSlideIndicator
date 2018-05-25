package site.iway.androidslideindicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import site.iway.androidhelpers.SlideIndicator;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SlideIndicator slideIndicator = findViewById(R.id.slideIndicator);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText("PAGE_INDEX = " + position);
                textView.setTextSize(24);
                textView.setGravity(Gravity.CENTER);
                LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                container.addView(textView, layoutParams);
                return textView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
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
    }
}
