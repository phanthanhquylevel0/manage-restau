package models;

import utils.Utils;

public abstract class DoAnVaThucUong {
    protected String maFood;
    protected   String tenFood;
    protected double donGiaFood;

     private static int count = 0;
     {
         this.setMaFood(String.format("F%03d",++count));
     }
     // pt khởi tạo không tham số
     public DoAnVaThucUong(){

     }
    public  void taoMoi() throws Exception {
        System.out.print("Hãy Nhập tên: ");
        String tenFood = Utils.getScanner().nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGiaFood = Integer.parseInt(Utils.getScanner().nextLine());

        this.tenFood = tenFood;
        this.donGiaFood = donGiaFood;

    }
    public void capNhatMenu(){
        try{
            System.out.print("Hãy Nhập tên món ăn: ");
            String tenMon = Utils.getScanner().nextLine();

            System.out.print("Nhập đơn giá: ");
            double donGiaMon = Integer.parseInt(Utils.getScanner().nextLine());


            this.setTenFood(tenMon);
            this.setDonGiaFood(donGiaMon);

        }catch (Exception ex){
            System.out.println("Cập nhật không thành công! ");
        }


    }

    public DoAnVaThucUong(String maFood, String tenFood, double donGiaFood) {
        this.maFood = maFood;
        this.tenFood = tenFood;
        this.donGiaFood = donGiaFood;
    }

    public String getMaFood() {
        return maFood;
    }

    public void setMaFood(String maFood) {
        this.maFood = maFood;
    }

    public String getTenFood() {
        return tenFood;
    }

    public void setTenFood(String tenFood) {
        this.tenFood = tenFood;
    }

    public double getDonGiaFood() {
        return donGiaFood;
    }

    public void setDonGiaFood(double donGiaFood) {
        this.donGiaFood = donGiaFood;
    }
}
