package models;

import java.util.Date;

public class HoaDon {
    private String maHoaDon;

    private Date ngayThanhToan = new Date() ;
    private SuKien maSuKien;
    private double tongHoaDon = 0;
    private static int dem = 0;
    {
        this.setMaHoaDon(String.format("H%03d",++dem));

    }

    public double getTongHoaDon() {
        return tongHoaDon;
    }

    public void setTongHoaDon(double tongHoaDon) {
        this.tongHoaDon = tongHoaDon;
    }


    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public SuKien getMaSuKien() {
        return maSuKien;
    }

    public void setMaSuKien(SuKien maSuKien) {
        this.maSuKien = maSuKien;
    }
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }



}
