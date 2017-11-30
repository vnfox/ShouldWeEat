package com.how.should.eat.ui.mainfeeds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.how.should.eat.ui.feed.blogs.BlogFragment;
import com.how.should.eat.ui.feed.opensource.OpenSourceFragment;
import com.how.should.eat.ui.mainfeeds.fish.FishFragment;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsFragment;
import com.how.should.eat.ui.mainfeeds.meat.MeatFragment;
import com.how.should.eat.ui.mainfeeds.nuts.NutsFragment;
import com.how.should.eat.ui.mainfeeds.vegetables.VegetablesFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return FruitsFragment.newInstance();
            case 1:
                return VegetablesFragment.newInstance();
            case 2:
                return MeatFragment.newInstance();
            case 3:
                return FishFragment.newInstance();
            case 4:
                return NutsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
