package AllListForder.Object;

public class EventInHome {
    private int id;
    private String codeEventID,URL_Main_Event_Img,URL_Side_Event_Img_1,URL_Side_Event_Img_2,URL_Side_Event_Img_3,URL_Side_Event_Img_4;

    public EventInHome(int id, String codeEventID, String URL_Main_Event_Img, String URL_Side_Event_Img_1, String URL_Side_Event_Img_2, String URL_Side_Event_Img_3, String URL_Side_Event_Img_4) {
        this.id = id;
        this.codeEventID = codeEventID;
        this.URL_Main_Event_Img = URL_Main_Event_Img;
        this.URL_Side_Event_Img_1 = URL_Side_Event_Img_1;
        this.URL_Side_Event_Img_2 = URL_Side_Event_Img_2;
        this.URL_Side_Event_Img_3 = URL_Side_Event_Img_3;
        this.URL_Side_Event_Img_4 = URL_Side_Event_Img_4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeEventID() {
        return codeEventID;
    }

    public void setCodeEventID(String codeEventID) {
        this.codeEventID = codeEventID;
    }

    public String getURL_Main_Event_Img() {
        return URL_Main_Event_Img;
    }

    public void setURL_Main_Event_Img(String URL_Main_Event_Img) {
        this.URL_Main_Event_Img = URL_Main_Event_Img;
    }

    public String getURL_Side_Event_Img_1() {
        return URL_Side_Event_Img_1;
    }

    public void setURL_Side_Event_Img_1(String URL_Side_Event_Img_1) {
        this.URL_Side_Event_Img_1 = URL_Side_Event_Img_1;
    }

    public String getURL_Side_Event_Img_2() {
        return URL_Side_Event_Img_2;
    }

    public void setURL_Side_Event_Img_2(String URL_Side_Event_Img_2) {
        this.URL_Side_Event_Img_2 = URL_Side_Event_Img_2;
    }

    public String getURL_Side_Event_Img_3() {
        return URL_Side_Event_Img_3;
    }

    public void setURL_Side_Event_Img_3(String URL_Side_Event_Img_3) {
        this.URL_Side_Event_Img_3 = URL_Side_Event_Img_3;
    }

    public String getURL_Side_Event_Img_4() {
        return URL_Side_Event_Img_4;
    }

    public void setURL_Side_Event_Img_4(String URL_Side_Event_Img_4) {
        this.URL_Side_Event_Img_4 = URL_Side_Event_Img_4;
    }
}
