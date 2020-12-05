package AllListForder.Object;

public class ItemSell {
    private int idItem, idMainCategory, priceDontSale, priceSale, salePercent, sold;
    private String codeIdSideCategory, sale, itemName, idUserSell, avatarItem, characteristics;

    public ItemSell(int idItem, int idMainCategory, int priceDontSale, int priceSale, int salePercent,
                    int sold, String codeIdSideCategory, String sale, String itemName, String idUserSell,
                    String avatarItem, String characteristics) {
        this.idItem = idItem;
        this.idMainCategory = idMainCategory;
        this.priceDontSale = priceDontSale;
        this.priceSale = priceSale;
        this.salePercent = salePercent;
        this.sold = sold;
        this.codeIdSideCategory = codeIdSideCategory;
        this.sale = sale;
        this.itemName = itemName;
        this.idUserSell = idUserSell;
        this.avatarItem = avatarItem;
        this.characteristics = characteristics;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdMainCategory() {
        return idMainCategory;
    }

    public void setIdMainCategory(int idMainCategory) {
        this.idMainCategory = idMainCategory;
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

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getCodeIdSideCategory() {
        return codeIdSideCategory;
    }

    public void setCodeIdSideCategory(String codeIdSideCategory) {
        this.codeIdSideCategory = codeIdSideCategory;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIdUserSell() {
        return idUserSell;
    }

    public void setIdUserSell(String idUserSell) {
        this.idUserSell = idUserSell;
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
}
