package models;

import java.util.Date;

public class ThueSanhCuoi {
    private SanhCuoi maSanhCuoi;
    private int buoiBatDau;
    private int buoiKetThuc;
    private SuKien suKien;
    private Date ngayBatDauThue;
    private Date ngayBatKetThuc;
    private double tongTien;


    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }




    public ThueSanhCuoi(SanhCuoi maSanhCuoi, int buoiBatDau, int buoiKetThuc, SuKien suKien, Date ngayBatDauThue, Date ngayBatKetThuc, Date ngayKetThucThue) {
        this.maSanhCuoi = maSanhCuoi;
        this.buoiBatDau = buoiBatDau;
        this.buoiKetThuc = buoiKetThuc;
        this.suKien = suKien;
        this.ngayBatDauThue = ngayBatDauThue;
        this.ngayBatKetThuc = ngayBatKetThuc;
        this.ngayKetThucThue = ngayKetThucThue;
    }

    public SuKien getSuKien() {
        return suKien;
    }

    public void setSuKien(SuKien suKien) {
        this.suKien = suKien;
    }


    public Date getNgayBatKetThuc() {
        return ngayBatKetThuc;
    }

    public void setNgayBatKetThuc(Date ngayBatKetThuc) {
        this.ngayBatKetThuc = ngayBatKetThuc;
    }



    @Override
    public String toString() {
        return "ThueSanhCuoi{" +
                "maSanhCuoi=" + maSanhCuoi +
                ", buoiBatDau=" + buoiBatDau +
                ", buoiKetThuc=" + buoiKetThuc +
                ", ngayBatDauThue=" + ngayBatDauThue +
                ", ngayKetThucThue=" + ngayKetThucThue +
                '}';
    }

    public ThueSanhCuoi() {
    }

    private Date ngayKetThucThue;

    public ThueSanhCuoi(SanhCuoi maSanhCuoi, int buoiBatDau, int buoiKetThuc, Date ngayBatDauThue, Date ngayKetThucThue) {
        this.maSanhCuoi = maSanhCuoi;
        this.buoiBatDau = buoiBatDau;
        this.buoiKetThuc = buoiKetThuc;
        this.ngayBatDauThue = ngayBatDauThue;
        this.ngayKetThucThue = ngayKetThucThue;
    }

    public int getBuoiBatDau() {
        return buoiBatDau;
    }

    public void setBuoiBatDau(int buoiBatDau) {
        this.buoiBatDau = buoiBatDau;
    }

    public int getBuoiKetThuc() {
        return buoiKetThuc;
    }

    public void setBuoiKetThuc(int buoiKetThuc) {
        this.buoiKetThuc = buoiKetThuc;
    }

    public Date getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(Date ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public Date getNgayKetThucThue() {
        return ngayKetThucThue;
    }

    public void setNgayKetThucThue(Date ngayKetThucThue) {
        this.ngayKetThucThue = ngayKetThucThue;
    }
    public SanhCuoi getMaSanhCuoi() {
        return maSanhCuoi;
    }

    public void setMaSanhCuoi(SanhCuoi maSanhCuoi) {
        this.maSanhCuoi = maSanhCuoi;
    }



}
