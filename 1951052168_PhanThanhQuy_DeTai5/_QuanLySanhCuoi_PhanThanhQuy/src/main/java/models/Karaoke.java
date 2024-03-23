package models;


import utils.Utils;

import java.text.ParseException;
import java.util.Date;

public class Karaoke extends DichVu{
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;

    @Override
    public double tinhGia() {
        double gia = 0.0;
        gia = ((double) (this.thoiGianKetThuc.getTime() - this.thoiGianBatDau.getTime()) / 3600000) * this.getDonGia();
        return gia;
    }

    public void capNhatDichVu(){
        try{
            super.capNhatDichVu();
            System.out.print("Nhập thời gian bắt đầu (dd/mm/yyyy hh:mm:ss): ");
            Date batDau = Utils.getSimpleDateFormat().parse(Utils.getScanner().nextLine());

            System.out.print("Nhập thời gian kết thúc (dd/mm/yyyy hh:mm:ss): ");
            Date ketThuc = Utils.getSimpleDateFormat().parse(Utils.getScanner().nextLine());


            this.setThoiGianBatDau(batDau);
            this.setThoiGianKetThuc(ketThuc);
            System.out.println("Cập nhật thành công! ");
        }catch (Exception ex){
            System.out.println("Cập nhật không thành công! ");
        }


    }
    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Karaoke(Date thoiGianBatDau, Date thoiGianKetThuc) {
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;

    }
    public Karaoke() {
    }
    public  void taoMoi() throws Exception {
        super.taoMoi();
        System.out.print("Nhập thời gian bắt đầu (dd/mm/yyyy hh:mm:ss): ");
        Date batDau = Utils.getSimpleDateFormat().parse(Utils.getScanner().nextLine());
        this.thoiGianBatDau = batDau;
        System.out.print("Nhập thời gian kết thúc (dd/mm/yyyy hh:mm:ss): ");
        Date ketThuc = Utils.getSimpleDateFormat().parse(Utils.getScanner().nextLine());
        this.thoiGianKetThuc = ketThuc;

        if(batDau.after(ketThuc) )
        {
            System.out.print("Nhập thời gian kết thúc trước thời gian bắt đầu: ");
            throw new Exception("Loi");
        }
        System.out.println("Thêm thành công!");





    }

    @Override
    public String toString() {
        return
                "Mã dịch vụ: " + maDichVu + '\n' +
                        "Tên dịch vụ: " + tenDichVu + '\n' +
                "Thời gian bắt đầu: " + thoiGianBatDau + '\n'+
                "Thời gian kết thúc: " + thoiGianKetThuc + '\n'+
                "Đơn Gia: " + donGia + '\n' +
                "Đơn vị dịch vụ: " + unit + '\n' +
                "++++++++++++++++++++++++++++++++++++++++\n";
    }
}
