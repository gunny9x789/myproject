package View.categoryFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.databinding.CategoryFragmentBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import AllListForder.MainCategoryList;
import View.categoryFragment.Adapter.AdsCategoriAdapter;
import View.categoryFragment.Adapter.MainCategoryRCVAdapter;

public class CategoryFragment extends Fragment implements MainCategoryList {

    CategoryFragmentBinding categoryFragmentBinding;
    private List<Integer> listItemAdsCategory;
    private AdsCategoriAdapter adsCategoriAdapter;
    private MainCategoryRCVAdapter mainCategoryRCVAdapter;
    private Timer timer;

    public static CategoryFragment newInstance() {

        Bundle args = new Bundle();

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        categoryFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.category_fragment, container, false);
        listItemAdsCategory = new ArrayList<>();
        listItemAdsCategory.add(R.drawable.ads_in_category_1);
        listItemAdsCategory.add(R.drawable.ads_in_category_2);
        listItemAdsCategory.add(R.drawable.ads_in_category_3);


        mainCategoryRCVAdapter = new MainCategoryRCVAdapter(MAIN_CATEGORY_LIST);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        categoryFragmentBinding.rcvMainCategory.setLayoutManager(layoutManager);
        categoryFragmentBinding.rcvMainCategory.setAdapter(mainCategoryRCVAdapter);

        adsCategoriAdapter = new AdsCategoriAdapter(listItemAdsCategory, getActivity().getBaseContext());
        categoryFragmentBinding.pagerAdsSideCategory.setAdapter(adsCategoriAdapter);
        categoryFragmentBinding.CIAdsSideCategory.setViewPager(categoryFragmentBinding.pagerAdsSideCategory);
        adsCategoriAdapter.registerDataSetObserver(categoryFragmentBinding.CIAdsSideCategory.getDataSetObserver());

        autoSlide();

        return categoryFragmentBinding.getRoot();
    }

    private void autoSlide() {
        if (listItemAdsCategory == null || listItemAdsCategory.isEmpty() || categoryFragmentBinding.pagerAdsSideCategory == null) {
            return;
        }
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = categoryFragmentBinding.pagerAdsSideCategory.getCurrentItem();
                        int totalItem = listItemAdsCategory.size() - 1;
                        if (currentItem < totalItem){
                            currentItem++;
                            categoryFragmentBinding.pagerAdsSideCategory.setCurrentItem(currentItem);
                        }else {
                            categoryFragmentBinding.pagerAdsSideCategory.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
