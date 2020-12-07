package AllListForder.Object;

public class ItemSell {
    private int idItem, priceDontSale, priceSale, salePercent, totalItem, sold, idUserSell;
    private String codeidMainCategory, codeIdSideCategory, itemName, avatarItem, characteristics, codeEventID,sale;

    public ItemSell(int idItem, String codeidMainCategory, String codeIdSideCategory, String itemName, int idUserSell,
                    String avatarItem, String sale, int salePercent,
                    int priceDontSale, int priceSale, int totalItem, int sold,
                    String characteristics, String codeEventID) {
        this.idItem = idItem;
        this.priceDontSale = priceDontSale;
        this.priceSale = priceSale;
        this.salePercent = salePercent;
        this.sold = sold;
        this.codeidMainCategory = codeidMainCategory;
        this.codeIdSideCategory = codeIdSideCategory;
        this.sale = sale;
        this.itemName = itemName;
        this.idUserSell = idUserSell;
        this.avatarItem = avatarItem;
        this.characteristics = characteristics;
        this.codeEventID = codeEventID;
        this.totalItem = totalItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getPriceDontSale() {
        return priceDontSale;
    }

    public void setPriceDontSale(int priceDontSale) {
        this.priceDontSale = priceDontSale;
    }

    public int getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(int priceSale) {
        this.priceSale = priceSale;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getIdUserSell() {
        return idUserSell;
    }

    public void setIdUserSell(int idUserSell) {
        this.idUserSell = idUserSell;
    }

    public String getCodeidMainCategory() {
        return codeidMainCategory;
    }

    public void setCodeidMainCategory(String codeidMainCategory) {
        this.codeidMainCategory = codeidMainCategory;
    }

    public String getCodeIdSideCategory() {
        return codeIdSideCategory;
    }

    public void setCodeIdSideCategory(String codeIdSideCategory) {
        this.codeIdSideCategory = codeIdSideCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAvatarItem() {
        return avatarItem;
    }

    public void setAvatarItem(String avatarItem) {
        this.avatarItem = avatarItem;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getCodeEventID() {
        return codeEventID;
    }

    public void setCodeEventID(String codeEventID) {
        this.codeEventID = codeEventID;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
