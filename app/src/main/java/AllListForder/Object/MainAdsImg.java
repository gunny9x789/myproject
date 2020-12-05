package AllListForder.Object;

public class MainAdsImg {
    private int id;
    private String  codeMainAdsId, local, urlIMG;

    public MainAdsImg(int id, String codeMainAdsId, String local, String urlIMG) {
        this.id = id;
        this.codeMainAdsId = codeMainAdsId;
        this.local = local;
        this.urlIMG = urlIMG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeMainAdsId() {
        return codeMainAdsId;
    }

    public void setCodeMainAdsId(String codeMainAdsId) {
        this.codeMainAdsId = codeMainAdsId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getUrlIMG() {
        return urlIMG;
    }

    public void setUrlIMG(String urlIMG) {
        this.urlIMG = urlIMG;
    }
}
