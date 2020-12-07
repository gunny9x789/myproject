package View.HomeFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import AllListForder.Object.EventInHome;

public class AdapterEventHome extends RecyclerView.Adapter<AdapterEventHome.ViewHolder> {
    private List<EventInHome> eventInHomeList;
    private Context context;

    public AdapterEventHome(List<EventInHome> eventInHomeList, Context context) {
        this.eventInHomeList = eventInHomeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_home_event_show, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EventInHome eventInHome = eventInHomeList.get(position);

        Picasso.get().load(eventInHome.getURL_Main_Event_Img())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.imgMainEvent);
        Picasso.get().load(eventInHome.getURL_Side_Event_Img_1())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.imgSideEvent1);
        Picasso.get().load(eventInHome.getURL_Side_Event_Img_2())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.imgSideEvent2);
        Picasso.get().load(eventInHome.getURL_Side_Event_Img_3())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.imgSideEvent3);
        Picasso.get().load(eventInHome.getURL_Side_Event_Img_4())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.imgSideEvent4);
    }

    @Override
    public int getItemCount() {
        if (eventInHomeList.isEmpty() || eventInHomeList == null) {
            return 0;
        }
        return eventInHomeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMainEvent, imgSideEvent1, imgSideEvent2, imgSideEvent3, imgSideEvent4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMainEvent = itemView.findViewById(R.id.img_main_event_home);
            imgSideEvent1 = itemView.findViewById(R.id.img_side_event_home1);
            imgSideEvent2 = itemView.findViewById(R.id.img_side_event_home2);
            imgSideEvent3 = itemView.findViewById(R.id.img_side_event_home3);
            imgSideEvent4 = itemView.findViewById(R.id.img_side_event_home4);
        }
    }
}
