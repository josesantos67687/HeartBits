package com.example.jose.heartbits;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Dashboard extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<CamaFragment> camas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        Cama c1=new Cama();
        Cama c2=new Cama();
        Cama c3=new Cama();
        c1.id="1";
        c1.Alertas="Fazer penso dia 19/11";
        c1.Catetar="não tem";
        c2.id="2";
        c1.Alertas="Fazer avaliação do estado social";
        c1.Catetar="não tem";
        c3.id="3";
        c1.Alertas="Avaliação do risco de queda";
        c1.Catetar="16/11/2017";
        camas= new ArrayList<>();
        camas.add(new CamaFragment(c1));
        camas.add(new CamaFragment(c2));
        camas.add(new CamaFragment(c3));
        mViewPager = (ViewPager)findViewById(R.id.tab_viewpager);


        if(mViewPager!=null){
            setupViewPager(mViewPager);
        }
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for(CamaFragment c : camas){
            adapter.addFrag(c , "Cama "+c.cama.id);
        }
        viewPager.setAdapter(adapter);
    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }
}


