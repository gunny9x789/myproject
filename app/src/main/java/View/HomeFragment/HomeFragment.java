package View.HomeFragment;

import android.content.Intent;
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
import com.example.myproject.databinding.HomeFragmentBinding;

import java.util.Timer;
import java.util.TimerTask;

import AllListForder.Event_In_Home_List;
import AllListForder.ItemSaleInDay;
import AllListForder.MainAdsList;
import View.HomeFragment.Adapter.AdapteMainADS;
import View.HomeFragment.Adapter.AdapterEventHome;
import View.HomeFragment.Adapter.AdapterRCVItemSaleInDay;


public class HomeFragment extends Fragment implements MainAdsList, Event_In_Home_List , ItemSaleInDay {

    HomeFragmentBinding homeFragmentBinding;
    private Intent intent;
    private AdapteMainADS adapteMainADS;
    private AdapterEventHome adapterEventHome;
    private AdapterRCVItemSaleInDay adapterRCVItemSaleInDay;
    private Timer timer;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);

        adapteMainADS = new AdapteMainADS(MAIN_ADS_IMG_LIST,getActivity().getBaseContext());
        homeFragmentBinding.VpMainAdsHomeFragment.setAdapter(adapteMainADS);
        homeFragmentBinding.CIMainAdsHomeFragment.setViewPager(
                homeFragmentBinding.VpMainAdsHomeFragment
        );
        adapteMainADS.registerDataSetObserver(homeFragmentBinding.CIMainAdsHomeFragment.getDataSetObserver());
        autoSide();

        adapterEventHome = new AdapterEventHome(EVENT_IN_HOME_LIST,getActivity().getBaseContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(),RecyclerView.VERTICAL,false);
        homeFragmentBinding.rcvHomeEventShow.setAdapter(adapterEventHome);
        homeFragmentBinding.rcvHomeEventShow.setLayoutManager(layoutManager);

        adapterRCVItemSaleInDay = new AdapterRCVItemSaleInDay(ITEM_SALE_IN_DAY_LIST,getActivity().getBaseContext());
        RecyclerView.LayoutManager layoutManager1 =new LinearLayoutManager(getActivity().getBaseContext(),RecyclerView.HORIZONTAL,false);
        homeFragmentBinding.rcvItemSaleInDay.setLayoutManager(layoutManager1);
        homeFragmentBinding.rcvItemSaleInDay.setAdapter(adapterRCVItemSaleInDay);

        return homeFragmentBinding.getRoot();
    }
    private void autoSide() {
        if (MAIN_ADS_IMG_LIST == null || MAIN_ADS_IMG_LIST.isEmpty() || homeFragmentBinding.VpMainAdsHomeFragment == null){
            return;
        }
        if (timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = homeFragmentBinding.VpMainAdsHomeFragment.getCurrentItem();
                        int total = MAIN_ADS_IMG_LIST.size()-1;
                        if (currentItem<total){
                            currentItem++;
                            homeFragmentBinding.VpMainAdsHomeFragment.setCurrentItem(currentItem);
                        }else {
                            homeFragmentBinding.VpMainAdsHomeFragment.setCurrentItem(0);
                        }
                    }
                });
            }
        },500,3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer!= null){
            timer.cancel();
            timer = null;
        }
    }
}
