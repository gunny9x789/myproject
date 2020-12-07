package support_functions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import AllListForder.AllItemSellList;
import AllListForder.Event_In_Home_List;
import AllListForder.MainAdsList;
import AllListForder.Object.EventInHome;
import AllListForder.Object.ItemSell;
import AllListForder.Object.MainAdsImg;

public class GetJson implements MainAdsList, Event_In_Home_List, AllItemSellList {
    public static void getADSJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String codeMainAdsId = jsonObject.getString("codeMainAdsId");
                String local = jsonObject.getString("local");
                String urlIMG = jsonObject.getString("urlIMG");
                MAIN_ADS_IMG_LIST.add(new MainAdsImg(id, codeMainAdsId, local, urlIMG));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEventHomeJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String codeEvent = jsonObject.getString("codeEvent");
                String UrlMainEventImg = jsonObject.getString("UrlMainEventImg");
                String UrlSideEventImg1 = jsonObject.getString("UrlSideEventImg1");
                String UrlSideEventImg2 = jsonObject.getString("UrlSideEventImg2");
                String UrlSideEventImg3 = jsonObject.getString("UrlSideEventImg3");
                String UrlSideEventImg4 = jsonObject.getString("UrlSideEventImg4");
                EVENT_IN_HOME_LIST.add(new EventInHome(id, codeEvent, UrlMainEventImg,
                        UrlSideEventImg1, UrlSideEventImg2, UrlSideEventImg3, UrlSideEventImg4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTotalItemJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int idItemSell = jsonObject.getInt("idItemSell");
                String CodeMainCateId = jsonObject.getString("CodeMainCateId");
                String CodeSideCateId = jsonObject.getString("CodeSideCateId");
                String nameItemSell = jsonObject.getString("nameItemSell");
                String avatarItemSell = jsonObject.getString("avatarItemSell");
                String sale = jsonObject.getString("sale");
                int salePercent = jsonObject.getInt("salePercent");
                int priceDontSale = jsonObject.getInt("priceDontSale");
                int priceSale = jsonObject.getInt("priceSale");
                int totalItem = jsonObject.getInt("totalItem");
                int itemSold = jsonObject.getInt("itemSold");
                int idUserSell = jsonObject.getInt("idUserSell");
                String characteristics = jsonObject.getString("characteristics");
                String EventCode = jsonObject.getString("EventCode");
                ALL_ITEM_SELL_LIST.add(new ItemSell(idItemSell, CodeMainCateId, CodeSideCateId, nameItemSell, idUserSell, avatarItemSell,
                        sale, salePercent, priceDontSale, priceSale, totalItem, itemSold, characteristics, EventCode));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}