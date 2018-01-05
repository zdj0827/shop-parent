package dto;

public class Search {
    private String title;
    private byte status;
    /*重写title的get方法*/
    public String getTitle() {
        /*if(this.title !=""&&this.title!=null){
            String OWTitle = "concat('%','"+this.title+"','%')";
            return OWTitle;
        }*/
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
