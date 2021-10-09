package For_Atricles;

import java.util.ArrayList;

public class News_Modal {

    private int result;
    private String status;
    private ArrayList<Atricle> atricles;

    public News_Modal(int result, String status, ArrayList<Atricle> atricles) {
        this.result = result;
        this.status = status;
        this.atricles = atricles;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Atricle> getAtricles() {
        return atricles;
    }

    public void setAtricles(ArrayList<Atricle> atricles) {
        this.atricles = atricles;
    }
}
