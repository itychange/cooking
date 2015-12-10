package util;

/**
 * Created by Windows on 12/7/2015.
 */
public class object_chitietmonan {
    public String img;
    public String buocnau;
    public String nguyenlieu;
    public String congthuc;
    public String gioithieu;
    public int images;
    public String txt;
    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public object_chitietmonan(String gioithieu){
        this.gioithieu=gioithieu;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public object_chitietmonan(){

    }

    public String getGioithieu() {
        return gioithieu;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getBuocnau() {
        return buocnau;
    }

    public void setBuocnau(String buocnau) {
        this.buocnau = buocnau;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }
}
