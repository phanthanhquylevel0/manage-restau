package models;

import utils.Utils;

import java.util.Date;

public class ThueCaSi extends DichVu {
    private String tenCaSi;
    private int soLuongBai;

    public void capNhatDichVu() {
        try {
            super.capNhatDichVu();
            System.out.print("Nhập tên ca sĩ: ");
            String tenCaSi = Utils.getScanner().nextLine();

            System.out.print("Nhập số lượng bài: ");
            int soLuong = Integer.parseInt(Utils.getScanner().nextLine());
            this.setTenCaSi(tenCaSi);
            this.setSoLuongBai(soLuong);
            System.out.println("Cập nhật thành công! ");
        } catch (Exception ex) {
            System.out.println("Cập nhật không thành công! ");
        }
    }

    public ThueCaSi(String tenCaSi, int soLuongBai) {
        this.tenCaSi = tenCaSi;
        this.soLuongBai = soLuongBai;

    }

    @Override
    public String toString() {
        return
                "Mã dịch vụ: " + maDichVu + '\n' +
                        "Tên ca sĩ: " + tenCaSi + '\n' +
                        "Số Lượng Bài: " + soLuongBai + '\n' +
                        "Tên dịch vụ: " + tenDichVu + '\n' +
                        "Đơn Giá: " + donGia + '\n' +
                        "Đơn vị: " + unit + '\n' +
                        "===================================\n";
    }

    public ThueCaSi() {

    }

    public void taoMoi() throws Exception {
        super.taoMoi();
        System.out.print("Nhập tên ca sĩ muốn thuê: ");
        String tenCaSi = Utils.getScanner().nextLine();
        this.tenCaSi = tenCaSi;
        System.out.print("Nhập số lượng bài: ");
        int soLuongBai = Integer.parseInt(Utils.getScanner().nextLine());
        this.soLuongBai = soLuongBai;
    }

    @Override
    public double tinhGia() {
        return this.soLuongBai * this.donGia;
    }

    public void setSoLuongBai(int soLuongBai) {
        this.soLuongBai = soLuongBai;
    }

    public int getSoLuongBai() {
        return soLuongBai;
    }


    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }
}




