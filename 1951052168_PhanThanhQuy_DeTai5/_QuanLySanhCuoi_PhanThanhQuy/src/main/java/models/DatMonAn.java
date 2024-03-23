package models;

public class DatMonAn {
    private DoAnVaThucUong maMonAn;
    private int soLuongMon;
    private int soThuTu;
    private double giaTien;
    private static int dem = 0;

    {
        this.setSoThuTu(Integer.parseInt(String.format("%01d", ++dem)));

    }

    public DoAnVaThucUong getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(DoAnVaThucUong maMonAn) {
        this.maMonAn = maMonAn;
    }


    public int getSoLuongMon() {
        return soLuongMon;
    }

    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return
                        "Số thứ tự: " + soThuTu + '\n' +
                        "Số lượng món: " + soLuongMon + '\n' +
                        "Giá tiền: " + giaTien + '\n' + maMonAn
                ;


    }
}
