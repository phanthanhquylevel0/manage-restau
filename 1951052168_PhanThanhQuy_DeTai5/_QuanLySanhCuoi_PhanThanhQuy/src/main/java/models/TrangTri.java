package models;

import enums.PhongCach;
import utils.Utils;

import java.text.ParseException;

public class TrangTri extends DichVu{


    public double getSoMetVuong() {
        return soMetVuong;
    }

    public void setSoMetVuong(double soMetVuong) {
        this.soMetVuong = soMetVuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getPhongCach() {
        return phongCach;
    }

    public void setPhongCach(String phongCach) {
        this.phongCach = phongCach;
    }

    private double soMetVuong;
    private String ghiChu;
    private String phongCach;

    public void capNhatDichVu() {
        try {
            super.capNhatDichVu();
            System.out.print("Nhập ghi chú: ");
            String ghiChu = Utils.getScanner().nextLine();
            System.out.print("Nhập phong cách: ");
            String phongCach = Utils.getScanner().nextLine();
            System.out.print("Nhập số mét vuông: ");
            int soMet = Integer.parseInt(Utils.getScanner().nextLine());
            this.setGhiChu(ghiChu);
            this.setPhongCach(phongCach);
            this.setSoMetVuong(soMet);
            System.out.println("Cập nhật thành công! ");
        } catch (Exception ex) {
            System.out.println("Cập nhật không thành công! ");
        }
    }


    public TrangTri(double soMetVuong, String ghiChu, String phongCach) {
        this.soMetVuong = soMetVuong;
        this.ghiChu = ghiChu;
        this.phongCach = phongCach;
    }

    @Override
    public String toString() {
        return
                "Mã dịch vụ: " + maDichVu + '\n' +
                "Tên Dịch vụ: =" + tenDichVu + '\n'+
                "Ghi chú: " + ghiChu + '\n' +
                "Phong Cách: " + phongCach + '\n' +
                "Số mét vuông: " + soMetVuong + '\n' +
                "Đơn Giá: " + donGia + '\n' +
                "Đơn vị dịch vụ: " + unit + '\n' +
                "===================================\n";
    }


    public TrangTri() {
    }

    public  void taoMoi() throws Exception {
        super.taoMoi();
        System.out.print("Nhập số mét vuông trang trí ");
        int soMet = Integer.parseInt(Utils.getScanner().nextLine());
        this.soMetVuong = soMet;
        System.out.print("Nhập phong cách trang trí: ");
        String phongCach = Utils.getScanner().nextLine();
        this.phongCach = phongCach;
        System.out.print("Nhập ghi chú: ");
        String ghiChu = Utils.getScanner().nextLine();
        this.ghiChu = ghiChu;


    }

    @Override
    public double tinhGia() {
        return this.soMetVuong * this.donGia;
    }
}
