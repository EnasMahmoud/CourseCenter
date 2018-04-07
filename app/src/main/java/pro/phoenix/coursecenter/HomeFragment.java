package pro.phoenix.coursecenter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.view.PagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ANNAS on 4/2/2018.
 */

public class HomeFragment extends Fragment  {

    ViewPager viewPager;
    LinearLayout sliderDots;

    ImageView[] dots;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewPager = view.findViewById(R.id.vPager);
        ImagePageAdapter viewAdapter = new ImagePageAdapter(getContext());
        viewPager.setAdapter(viewAdapter);
        //Timer timer = new Timer();
        //timer.scheduleAtFixedRate(new MyTimeTask(),2000,4000);

        sliderDots=view.findViewById(R.id.SliderDots);
        dots = new ImageView[4];
        for(int i=0;i<4;i++){
            dots[i]=new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

        /*for (int image:images)
        {
            flipperImage(image);
        }*/
        return view;
    }



    /*class MyTimeTask extends TimerTask
    {

        @Override
        public void run() {
            HomeFragment.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0)
                        viewPager.setCurrentItem(1);
                    else if(viewPager.getCurrentItem()==1)
                        viewPager.setCurrentItem(2);
                    else
                        viewPager.setCurrentItem(3);
                }
            });
        }
    }*/

    /*@RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    void flipperImage (int image)
    {
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);
        vFipper.addView(imageView);
        vFipper.setFlipInterval(4000);
        vFipper.setAutoStart(true);
        vFipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        vFipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);

    }*/
}
