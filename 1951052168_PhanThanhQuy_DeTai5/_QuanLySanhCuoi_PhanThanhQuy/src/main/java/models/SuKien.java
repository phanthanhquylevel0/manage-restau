package models;

import services.QuanLy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuKien {


    private Boolean kiemTraThanhToan = false;
    private String maSuKien;
    private String tenSuKien;
    private ThueSanhCuoi thueSanhCuoi;
    private List<DatDichVu> datDichVu = new ArrayList<>();
    private List<DatMonAn> datMonAn = new ArrayList<>();
    private Date ngayBatDauThue;
    private Date ngayKetThucThue;

    public List<DatDichVu> getDatDichVu() {
        return datDichVu;
    }

    public void setDatDichVu(List<DatDichVu> datDichVu) {
        this.datDichVu = datDichVu;
    }

    public List<DatMonAn> getDatMonAn() {
        return datMonAn;
    }

    public void setDatMonAn(List<DatMonAn> datMonAn) {
        this.datMonAn = datMonAn;
    }

    public SuKien() {
    }


    public SuKien(String maSuKien, String tenSuKien, String thoiDiemThue, Date ngayBatDauThue, Date ngayKetThucThue) {
        this.maSuKien = maSuKien;
        this.tenSuKien = tenSuKien;
        this.ngayBatDauThue = ngayBatDauThue;
        this.ngayKetThucThue = ngayKetThucThue;
    }

    private static int count = 0;

    {
        this.setMaSuKien(String.format("SK%03d", ++count));
    }

    public String getMaSuKien() {
        return maSuKien;
    }


    @Override
    public String toString() {
        try {
            int buoiBD = this.getThueSanhCuoi().getBuoiBatDau();
            String batDau = null;
            if (buoiBD == 1) {
                batDau = "Sáng";
            } else if (buoiBD == 2) {
                batDau = "Chiều";
            } else {
                batDau = "Tối";
            }
            int buoiKT = this.getThueSanhCuoi().getBuoiKetThuc();
            String ketThuc = null;
            if (buoiKT == 1) {
                ketThuc = "Sáng";
            } else if (buoiKT == 2) {
                ketThuc = "Chiều";
            } else {
                ketThuc = "Tối";
            }
            String dsDoAn = "";
            for(int i = 0; i < this.getDatMonAn().size(); i++){
                dsDoAn += this.getDatMonAn().get(i).toString()+"\n";
            }
            String dsDichVu = "";
            for(int i = 0; i < this.getDatDichVu().size(); i++){
                dsDichVu += this.getDatDichVu().get(i).toString()+"\n";
            }
            return "Mã sự kiện: " + this.getMaSuKien() + "\n" +
                    "Tên sự kiện: " + this.getTenSuKien() + '\n' +
                    "Sảnh được thuê: " + this.getThueSanhCuoi().getMaSanhCuoi().getTenSanhCuoi() + '\n' +
                    "Buổi bắt đầu: " + batDau + '\n' +
                    "Buổi kết thúc: " + ketThuc + '\n' +
                    "Ngày bắt đầu: " + this.getNgayBatDauThue().toString() + '\n' +
                    "Ngày kết thúc: " + this.getNgayKetThucThue().toString() + '\n' +
                    "Giá thuê sảnh: " + String.format("%,.0f", QuanLy.tinhTienThueSanh(this.getThueSanhCuoi())) + '\n' +
                    "**********Danh sách đồ ăn, thức uống***********\n" + dsDoAn +
                    "**********Danh sách dịch vụ được thuê**********\n"+ dsDichVu +
                    "===========================================\n";
        } catch (Exception e) {
            System.out.println("Loi roi");
            System.out.println(e.getMessage());
        }
        return "";

    }
    public double tinhTongSK(){
        double tong = 0.0;
        tong += QuanLy.tinhTienThueSanh(this.getThueSanhCuoi());
        for(int i = 0; i < this.getDatDichVu().size(); i++){
            tong += this.getDatDichVu().get(i).getGiaDichVu();
        }
        for(int i = 0; i < this.getDatMonAn().size(); i++){
            tong += this.getDatMonAn().get(i).getGiaTien();
        }
        return tong;
    }
    public Boolean getKiemTraThanhToan() {
        return kiemTraThanhToan;
    }

    public void setKiemTraThanhToan(Boolean kiemTraThanhToan) {
        this.kiemTraThanhToan = kiemTraThanhToan;
    }


    public void setMaSuKien(String maSuKien) {
        this.maSuKien = maSuKien;
    }

    public String getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public ThueSanhCuoi getThueSanhCuoi() {
        return thueSanhCuoi;
    }

    public void setThueSanhCuoi(ThueSanhCuoi thueSanhCuoi) {
        this.thueSanhCuoi = thueSanhCuoi;
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


}
