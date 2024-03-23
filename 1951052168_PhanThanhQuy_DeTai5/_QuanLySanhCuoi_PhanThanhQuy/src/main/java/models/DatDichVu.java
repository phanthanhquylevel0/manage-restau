package models;

public class DatDichVu {
    private DichVu maDichVu;
    private double giaDichVu;
    private int thuTu;


    @Override
    public String toString() {
        return
                "Số thứ tự: " + thuTu +
                +'\n' + maDichVu +
                "Giá dịch vụ: " + giaDichVu

                ;
    }

    public DichVu getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(DichVu maDichVu) {
        this.maDichVu = maDichVu;
    }

    public double getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    public int getThuTu() {
        return thuTu;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }



}
