package models;

import utils.Utils;

public class DoAn extends DoAnVaThucUong{
    public boolean isKiemTraAnChay() {
        return kiemTraAnChay;
    }

    public void setKiemTraAnChay(boolean kiemTraAnChay) {
        this.kiemTraAnChay = kiemTraAnChay;
    }

    private boolean kiemTraAnChay;
    public DoAn(boolean kiemTraAnChay) {
        this.kiemTraAnChay = kiemTraAnChay;
    }
    public DoAn(){

    }
    public void capNhatMenu(){
        try{
            super.capNhatMenu();
            System.out.print("Món chay(1)/ Món mặn(0) : ");
            boolean kt = Boolean.parseBoolean(Utils.getScanner().nextLine());
            this.setKiemTraAnChay(kt);
            System.out.println("Cập nhật thành công! ");
        }catch (Exception ex){
            System.out.println("Cập nhật không thành công! ");
        }
    }
    public  void taoMoi() throws Exception {
        super.taoMoi();
        System.out.print("Nếu là món chay ấn phím 1, nếu không ấn phím 0! ");
        int loai = Integer.parseInt(Utils.getScanner().nextLine());
        if(loai==1)
        {
            this.kiemTraAnChay=true;
        } else if (loai == 0) {
            this.kiemTraAnChay=false;

        }else {
            System.out.println("Bạn đã thực hiện sai!");
        }
        System.out.println("Thêm thành công!");
    }

    @Override
    public String toString() {
        return  "Mã đồ ăn: " + maFood + '\n' +
                "Tên đồ ăn: " + tenFood + '\n' +
                "Đơn giá: " + donGiaFood + '\n'+
                "Ăn chay: " + kiemTraAnChay + '\n'+
                "=================================\n";
    }
}
