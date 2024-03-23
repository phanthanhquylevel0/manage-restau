package models;


import services.QuanLy;
import utils.Utils;

import java.text.ParseException;
import java.util.Date;

public  abstract class DichVu {
    protected String maDichVu;
    protected String tenDichVu;
    protected double donGia;
    protected String unit; // Đơn vị dịch vụ
    private static int count = 0;
    {
        this.setMaDichVu(String.format("D%03d",++count));
    }
    public double tinhGia(){
        return 0.0;
    }
    public void capNhatDichVu(){
        try{
            System.out.print("Hãy Nhập tên dịch vụ: ");
            String tenDichVu = Utils.getScanner().nextLine();

            System.out.print("Nhập đơn giá dịch vụ ");
            double donGiaDichVu = Integer.parseInt(Utils.getScanner().nextLine());

            System.out.print("Nhập đơn vị dịch vụ ");
            String donViDichVu = Utils.getScanner().nextLine();
            this.setTenDichVu(tenDichVu);
            this.setDonGia(donGiaDichVu);
            this.setUnit(donViDichVu);
        }catch (Exception ex){
            System.out.println("Cập nhật không thành công! ");
        }


    }
    public  void taoMoi() throws Exception {
        System.out.print("Hãy Nhập tên dịch vụ: ");
        String tenDichVu = Utils.getScanner().nextLine();

        System.out.print("Nhập đơn giá dịch vụ ");
        double donGiaDichVu = Integer.parseInt(Utils.getScanner().nextLine());

        System.out.print("Nhập đơn vị dịch vụ ");
        String donViDichVu = Utils.getScanner().nextLine();
        this.tenDichVu = tenDichVu;
        this.donGia = donGiaDichVu;
        this.unit = donViDichVu;
    }


    @Override
    public String toString() {
        return "DichVu{" +
                "maDichVu='" + maDichVu + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", donGia=" + donGia +
                ", unit='" + unit + '\'' +
                '}';
    }

    public DichVu(String maDichVu, String tenDichVu, double donGia, String unit) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.unit = unit;
    }
    public DichVu(){

    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
