package models;

import utils.Utils;

public class DoUong extends DoAnVaThucUong{
    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    private String hangSanXuat;

    public DoUong(){}
    public DoUong(String hangSanXuat){
        this.hangSanXuat = hangSanXuat;

    }
    public void capNhatMenu(){
        try{
            super.capNhatMenu();
            System.out.print("Hãy nhập tên hãng sản xuất: ");
            String tenHangSanXuat = Utils.getScanner().nextLine();
            this.setHangSanXuat(tenHangSanXuat);
            System.out.println("Cập nhật thành công! ");
        }catch (Exception ex){
            System.out.println("Cập nhật không thành công! ");
        }
    }
    public  void taoMoi() throws Exception {
        super.taoMoi();
        System.out.print("Nhập hãng sản xuất cho đồ uống: ");
        String tenNhaSanXuat = Utils.getScanner().nextLine();
        this.hangSanXuat = tenNhaSanXuat;
        System.out.println("Thêm thành công!");
    }

    @Override
    public String toString() {
        return
                "Mã đồ uống: " + maFood  + '\n' +
                "Tên đồ uống: " + tenFood + '\n' +
                "Đơn Giá: " + donGiaFood + '\n' +
                "Hãng sản xuất: " + hangSanXuat + '\n'+
              "==================================\n";
    }
}




