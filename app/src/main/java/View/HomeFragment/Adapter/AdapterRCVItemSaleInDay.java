package View.HomeFragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import AllListForder.Object.ItemSell;

public class AdapterRCVItemSaleInDay extends RecyclerView.Adapter<AdapterRCVItemSaleInDay.ViewHolder> {
    private List<ItemSell> itemSellList;
    private Context context;

    public AdapterRCVItemSaleInDay(List<ItemSell> itemSellList, Context context) {
        this.itemSellList = itemSellList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sale_day_in_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemSell itemSell = itemSellList.get(position);
        final DecimalFormatSymbols syms = new DecimalFormatSymbols();
        syms.setGroupingSeparator(',');
        DecimalFormat myFormatter = new DecimalFormat("###,###,###,###,###,###", syms);

        Picasso.get().load(itemSell.getAvatarItem())
                .placeholder(R.drawable.dont_loading_img)
                .error(R.drawable.dont_loading_img)
                .into(holder.avatarItem);
        holder.priceItem.setText(myFormatter.format(itemSell.getPriceSale())+" đ");
        holder.salePercentItem.setText("-"+itemSell.getSalePercent()+"%");
    }

    @Override
    public int getItemCount() {
        if (itemSellList.isEmpty() || itemSellList == null) {
            return 0;
        } else
            return itemSellList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarItem;
        TextView priceItem;
        TextView salePercentItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarItem = itemView.findViewById(R.id.img_item_sale_day);
            priceItem = itemView.findViewById(R.id.tv_price_item_sale_day);
            salePercentItem = itemView.findViewById(R.id.tv_sale_percen_in_sale_day);
        }
    }
}
