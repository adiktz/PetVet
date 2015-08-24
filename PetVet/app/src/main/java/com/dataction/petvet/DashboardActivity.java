package com.dataction.petvet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dataction.petvet.adapters.DashboardPagerAdapter;
import com.dataction.petvet.fragments.DashboardFragment;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity implements DashboardFragment.OnFragmentInteractionListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.pager)
    ViewPager mViewPager;
    @Bind(R.id.profile_image)
    CircleImageView profileImage;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        // Set the padding to match the Status Bar height
//        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        mPagerAdapter = new DashboardPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        tabLayout.setTabsFromPagerAdapter(mPagerAdapter);

        mViewPager.clearOnPageChangeListeners();
        mViewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout, this));

        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @OnClick(R.id.profile_image)
    public void profile(View view) {
        Intent profile = new Intent(this,ProfileActivity.class);
        startActivity(profile);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        Toast.makeText(DashboardActivity.this, "Ymm", Toast.LENGTH_SHORT).show();
    }

    private static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        private final WeakReference<TabLayout> mTabLayoutRef;
        private int mPreviousScrollState;
        private int mScrollState;
        private Activity activity;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout, Activity activity) {
            mTabLayoutRef = new WeakReference<>(tabLayout);
            this.activity = activity;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            mPreviousScrollState = mScrollState;
            mScrollState = state;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            final TabLayout tabLayout = mTabLayoutRef.get();
            if (tabLayout != null) {
                final boolean updateText = (mScrollState == ViewPager.SCROLL_STATE_DRAGGING)
                        || (mScrollState == ViewPager.SCROLL_STATE_SETTLING
                        && mPreviousScrollState == ViewPager.SCROLL_STATE_DRAGGING);
                tabLayout.setScrollPosition(position, positionOffset, updateText);
            }
        }

        @Override
        public void onPageSelected(int position) {
            final TabLayout tabLayout = mTabLayoutRef.get();
            final View fab = ((View) activity.findViewById(R.id.fab));
            if (tabLayout != null) {
                tabLayout.getTabAt(position).select();
                if (position == 0) {
                    fab.setVisibility(View.VISIBLE);
                    fab.animate()
                            .translationY(0)
                            .alpha(1.0f)
                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    fab.setVisibility(View.VISIBLE);
                                }
                            });
                } else {
                    fab.animate()
                            .translationY(fab.getHeight())
                            .alpha(0.0f)
                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    fab.setVisibility(View.GONE);
                                }
                            });
                }
            }
        }
    }

    // A method to find height of the status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
