package sc.teach.a4seasons.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

import sc.teach.a4seasons.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NatureFragment.newInstance(0, mContext.getString(R.string.title_summer));
            case 1:
                return NatureFragment.newInstance(1, mContext.getString(R.string.title_autumn));
            case 2:
                return NatureFragment.newInstance(2, mContext.getString(R.string.title_winter));
            case 3:
                return NatureFragment.newInstance(3, mContext.getString(R.string.title_spring));
            case 4:
                return NatureFragment.newInstance(4, mContext.getString(R.string.title_season));
        }
        return null;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        Drawable icone=null;
        switch (position) {
            case 0:
                titre = mContext.getString(R.string.title_summer).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ic_action_sun);
                break;
            case 1:
                titre = mContext.getString(R.string.title_autumn).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ic_action_cloud);
                break;

            case 2:
                titre = mContext.getString(R.string.title_winter).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ic_action_snowflake);
                break;

            case 3:
                titre = mContext.getString(R.string.title_spring).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.ic_action_flower);
                break;

            case 4:
                return mContext.getString(R.string.title_season).toUpperCase(l);

        }
        SpannableString sb = new SpannableString(" " + titre);
        // un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;

    }


    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}