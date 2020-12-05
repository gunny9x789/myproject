package AllListForder.Object;

public class SideCategory {
    private int idMainCategory, idSideCategory;
    private String codeId, sideCategoryName, sideCategoryAvatar;

    public SideCategory(int idMainCategory, int idSideCategory, String codeId, String sideCategoryName, String sideCategoryAvatar) {
        this.idMainCategory = idMainCategory;
        this.idSideCategory = idSideCategory;
        this.codeId = codeId;
        this.sideCategoryName = sideCategoryName;
        this.sideCategoryAvatar = sideCategoryAvatar;
    }

    public int getIdMainCategory() {
        return idMainCategory;
    }

    public void setIdMainCategory(int idMainCategory) {
        this.idMainCategory = idMainCategory;
    }

    public int getIdSideCategory() {
        return idSideCategory;
    }

    public void setIdSideCategory(int idSideCategory) {
        this.idSideCategory = idSideCategory;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getSideCategoryName() {
        return sideCategoryName;
    }

    public void setSideCategoryName(String sideCategoryName) {
        this.sideCategoryName = sideCategoryName;
    }

    public String getSideCategoryAvatar() {
        return sideCategoryAvatar;
    }

    public void setSideCategoryAvatar(String sideCategoryAvatar) {
        this.sideCategoryAvatar = sideCategoryAvatar;
    }
}
