package pro.phoenix.coursecenter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePageAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int images[] = {R.drawable.slide1 , R.drawable.slide2 , R.drawable.slide3 , R.drawable.slide4 };

    public ImagePageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_slide,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        ViewPager vPager = (ViewPager)container;
        vPager.addView(view , 0);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vPager = (ViewPager)container;
        View view = (View) object;
        vPager.removeView(view);
    }
}
