package amalhichri.androidprojects.com.kotlinlearning.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import amalhichri.androidprojects.com.kotlinlearning.fragments.FourthFragmet;
import amalhichri.androidprojects.com.kotlinlearning.fragments.RootFragment_learn;
import amalhichri.androidprojects.com.kotlinlearning.fragments.SecondFragmet;
import amalhichri.androidprojects.com.kotlinlearning.fragments.ThirdFragmet;


public class HomePageTabsAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 4;

        public HomePageTabsAdapter(FragmentManager fm) {
            super(fm);
        }

    @Override
    public int getCount() {
        return  NUM_ITEMS ;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            /** because to switch fragments inside a tab we need a root FrameLayout,
             in which we load fragments in each time ( getFragmentManager.replce(root,newFrag) )**/
            case 0:
                return new RootFragment_learn();
            case 1:
                return new SecondFragmet();
            case 2:
                return new ThirdFragmet();
            case 3:
                /** in this case we're not gonna switch fragments in this tab **/
                return new FourthFragmet();
            default:
                return null;
        }
    }

    /** needed for fragment refresh **/
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
