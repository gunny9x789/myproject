package support_functions;

import AllListForder.AllItemSellList;
import AllListForder.ItemSaleInDay;
import AllListForder.Object.ItemSell;

public class Classify_item_list implements AllItemSellList, ItemSaleInDay {
    public static void getItemSaleInDay() {
        if (ITEM_SALE_IN_DAY_LIST != null||ITEM_SALE_IN_DAY_LIST.isEmpty() ==false) {
            ITEM_SALE_IN_DAY_LIST.clear();
        }
        for (int i=0;i<ALL_ITEM_SELL_LIST.size();i++){
            ItemSell itemSell = ALL_ITEM_SELL_LIST.get(i);
            String checkSale = itemSell.getSale();
            if (checkSale.equals("yes")){
                ITEM_SALE_IN_DAY_LIST.add(itemSell);
            }
        }
    }
}
