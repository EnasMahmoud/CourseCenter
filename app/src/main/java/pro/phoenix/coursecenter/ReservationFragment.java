package pro.phoenix.coursecenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ReservationFragment extends Fragment {
    SectionsPageAdapter mSectionsPageAdapter;
    ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_rooms_tab, container, false);

        mSectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());

        mViewPager = view.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new AvilabilityFragment(), "TAB1");
        adapter.addFragment(new AvilabilityFragment(), "TAB2");
        adapter.addFragment(new AvilabilityFragment(), "TAB3");
        adapter.addFragment(new AvilabilityFragment(), "TAB4");
        adapter.addFragment(new AvilabilityFragment(), "TAB5");
        adapter.addFragment(new AvilabilityFragment(), "TAB6");
        adapter.addFragment(new AvilabilityFragment(), "TAB7");
        adapter.addFragment(new AvilabilityFragment(), "TAB8");
        adapter.addFragment(new AvilabilityFragment(), "TAB9");
        adapter.addFragment(new AvilabilityFragment(), "TAB10");
        adapter.addFragment(new AvilabilityFragment(), "TAB11");
        adapter.addFragment(new AvilabilityFragment(), "TAB12");
        viewPager.setAdapter(adapter);
    }
}
