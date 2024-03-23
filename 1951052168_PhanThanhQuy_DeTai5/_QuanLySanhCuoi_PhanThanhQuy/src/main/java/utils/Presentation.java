package utils;


import enums.QuanLyGia;
import models.*;
import services.QuanLy;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Presentation {
    public static void showMenu() throws ParseException, IOException, InterruptedException {
        System.out.println("\n\t\t======================>-- MENU --<======================");
        System.out.println("\t\t|\t1. Quản lý sảnh cưới ");
        System.out.println("\t\t|\t2. Quản lý thông tin dịch vụ ");
        System.out.println("\t\t|\t3. Quản lý thông tin đồ ăn va thức uống ");
        System.out.println("\t\t|\t4. Đặt sự kiện  ");
        System.out.println("\t\t|\t5. Danh sách các sảnh được thuê ");
        System.out.println("\t\t|\t6. Xuất hóa đơn ");
        System.out.println("\t\t|\t7. Báo cáo doanh thu ");
        System.out.println("\t\t|\t0. Exit");
        System.out.println("\n\t\t==========================================================\n");
        int choose;
        try {
            do {
                System.out.print("\t\t|\t=> Hãy chọn các mục trên: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 7 || choose < 0)
                    System.out.println(">>>>>>>LỰA CHỌN KHÔNG HỢP LỆ. LÀM ƠN CHỌN LẠI !!! <<<<<<<");
            } while (choose > 7 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 7 && choose >= 0) {
            switch (choose) {
                case 1:

                    showOption01();
                    break;
                case 2:
                    showOption02();
                    break;
                case 3:
                    showOption03();
                    break;
                case 4:
                    showOption04();
                    break;
                case 5:
                    List<SanhCuoi> dsTam = QuanLy.dsSanhCuoi.stream().sorted(SanhCuoi::compareTo).collect(Collectors.toList());

                    QuanLy.hienThiDanhSachSanhCuoi(dsTam);
                    break;
                case 6:
                      showOption06();
                    break;
                case 7:
                     showOption07();
                    break;
                default:
                     Presentation.exit();
            }
        } else {
            if (Presentation.continueConfirm("Do you want to continue?"))
                Presentation.showMenu();
            else
                Presentation.exit();
        }

    }

    private static boolean continueConfirm(String content) {
        int exit;
        do {
            System.out.printf("%s (1 - Có/ 2 - Không): ", content);
            try {
                exit = Integer.parseInt(Utils.getScanner().nextLine());
            } catch (Exception ex) {
                exit = 0;
            }
            if (exit < 1 || exit > 2) {
                System.out.println("Làm ơn thử lại !!!");
            }


        } while (exit < 1 || exit > 2);
        if (exit == 1)
            return true;
        return false;

    }

    private static void exit() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss - dd/MM/yyyy");
        System.out.printf("Goodbye!!!\nYou exited at %s", simpleDateFormat.format(new Date()));
        System.exit(0);
    }

    private static void showOption01() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- QL SẢNH --<======================");
        System.out.println("\t\t|\t1. Thêm sảnh cưới ");
        System.out.println("\t\t|\t2. Xóa sảnh cưới ");
        System.out.println("\t\t|\t3. Cập nhật sảnh cưới");
        System.out.println("\t\t|\t4. Tra cứu sảnh cưới");
        System.out.println("\t\t|\t5. Xem");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy Chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 5 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 5 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 5 && choose >= 0) {
            switch (choose) {
                case 0:
                    Presentation.showMenu();
                    break;
                case 1:
                    QuanLy.themSanhCuoi();
                    break;
                case 2:
                    System.out.println("Bạn hãy nhập mã sảnh cần xóa: ");
                    String maSanhCuoi = Utils.getScanner().nextLine();
                    QuanLy.xoaSanhCuoi(maSanhCuoi);
                    break;
                case 3:
                    List<SanhCuoi> kq4 = new ArrayList<>();
                    String maSanh;
                    int dem = 1;
                    do {
                        System.out.println("Nhập mã sảnh cưới cần cập nhật: ");
                        maSanh = Utils.getScanner().nextLine();
                        kq4 = QuanLy.timKiemSanhCuoi(maSanh, 3);
                        if (kq4.isEmpty()) {
                            System.out.println("Không tìm thấy sảnh cưới cần cập nhật: ");
                        }
                        dem++;
                    } while (kq4.isEmpty() && dem <= 3);
                    if (!kq4.isEmpty()) {
                        System.out.println("Nhập lại tên sảnh cưới: ");
                        String ten = Utils.getScanner().nextLine();
                        System.out.println("Nhập lại vị trí sảnh cưới: ");
                        String viTri = Utils.getScanner().nextLine();
                        System.out.println("Nhập lại sức chứa sảnh cưới: ");
                        int sucChua = Integer.parseInt(Utils.getScanner().nextLine());
                        List<Map<Object, Object>> dsGia = new ArrayList<>();
                        for (int i = 1; i <= 6; i++) {
                            Map<Object, Object> giaThoiDiem = new HashMap<>();
                            System.out.print(String.format("Bạn hãy nhập giá cho thời điểm %s:", QuanLyGia.getValueByInt(i).getValue()));
                            Double giaTien = Double.parseDouble(Utils.getScanner().nextLine());
                            giaThoiDiem.put("loai", QuanLyGia.getValueByInt(i));
                            giaThoiDiem.put("gia", giaTien);
                            dsGia.add(giaThoiDiem);
                        }
                        QuanLy.capNhatSanhCuoi(maSanh, ten, viTri, sucChua, dsGia);
                    }
                    break;
                case 4:
                    Presentation.showOption014();
                    break;
                case 5:
                    QuanLy.hienThiDanhSachSanhCuoi(QuanLy.dsSanhCuoi);
                    break;
                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption01();
            else
                Presentation.exit();
        }
    }

    // Menu tìm sảnh
    private static void showOption014() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- TÌM SẢNH --<======================");
        System.out.println("\t\t|\t1. Tìm kiếm theo tên sảnh ");
        System.out.println("\t\t|\t2. Tìm kiếm theo vị trí sảnh ");
        System.out.println("\t\t|\t3. Tìm kiếm theo sức chứa của sảnh");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 3 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 3 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 3 && choose >= 0) {
            switch (choose) {

                case 0:
                    Presentation.showOption01();
                    break;

                case 1:
                    System.out.print("Nhập tên sảnh cưới cần tìm: ");
                    String tenSanhCuoi = Utils.getScanner().nextLine();
                    List<SanhCuoi> kq = QuanLy.timKiemSanhCuoi(tenSanhCuoi, 1);
                    if (kq.size() < 1) {
                        System.out.println("không tim thấy kết quả! ");
                    }
                    QuanLy.hienThiDanhSachSanhCuoi(kq);
                    break;

                case 2:
                    System.out.print("Nhập vị trí sảnh cưới cần tìm: ");
                    String viTriSanhCuoi = Utils.getScanner().nextLine();
                    List<SanhCuoi> kq2 = QuanLy.timKiemSanhCuoi(viTriSanhCuoi, 2);
                    if (kq2.size() < 1) {
                        System.out.println("không tim thấy kết quả! ");
                    }
                    QuanLy.hienThiDanhSachSanhCuoi(kq2);
                    break;

                case 3:
                    System.out.print("Nhập sức chứa của sảnh cưới cần tìm trong khoảng từ: ");
                    int tu = Integer.parseInt(Utils.getScanner().nextLine());
                    System.out.print("Nhập sức chứa của sảnh cưới cần tìm trong khoảng đến: ");
                    int den = Integer.parseInt(Utils.getScanner().nextLine());
                    if (den < tu) {
                        System.out.print("không hợp lệ");
                    } else {
                        List<SanhCuoi> kq3 = QuanLy.timKiemSanhCuoi(tu, den);
                        if (kq3.size() < 1) {
                            System.out.println("không tim thấy kết quả! ");
                        }
                        QuanLy.hienThiDanhSachSanhCuoi(kq3);
                    }
                    break;

                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption014();
            else
                Presentation.exit();
        }
    }

    // Menu quản lý dịch vụ
    private static void showOption02() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- QL DỊCH VỤ --<======================");
        System.out.println("\t\t|\t1. Thêm dịch vụ ");
        System.out.println("\t\t|\t2. Xóa dịch vụ ");
        System.out.println("\t\t|\t3. Cập nhật dịch vụ");
        System.out.println("\t\t|\t4. Tra cứu dịch vụ");
        System.out.println("\t\t|\t5. Xem");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy Chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 5 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 5 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 5 && choose >= 0) {
            switch (choose) {
                case 0:
                    Presentation.showMenu();
                    break;
                case 1:
                    System.out.print("Bạn muốn thêm dịch vụ gì? (1/ Karaoke, 2/ Trang Trí, 3/ Thuê ca sĩ): ");
                    int loai = Integer.parseInt(Utils.getScanner().nextLine());
                    if (loai >= 1 && loai <= 3) {
                        try {
                            switch (loai) {
                                case 1:
                                    DichVu dichVu1 = new Karaoke();
                                    dichVu1.taoMoi();
                                    QuanLy.themDichVu(dichVu1);

                                    break;
                                case 2:
                                    DichVu dichVu2 = new TrangTri();
                                    dichVu2.taoMoi();
                                    QuanLy.themDichVu(dichVu2);
                                    break;
                                case 3:
                                    DichVu dichVu3 = new ThueCaSi();
                                    dichVu3.taoMoi();
                                    QuanLy.themDichVu(dichVu3);
                                    break;

                            }
                        } catch (ParseException p) {
                            System.out.println("Sai đinh dạng ngày!");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                    } else {
                        System.out.print("Nhập sai");
                    }
                    break;

                case 2:
                    System.out.println("Bạn hãy nhập mã dịch vụ cần xóa: ");
                    String maDichVu = Utils.getScanner().nextLine();
                    QuanLy.xoaDichVu(maDichVu);
                    break;

                case 3:
                    System.out.print("Nhập mã dịch vụ cần cập nhật: ");
                    String ma = Utils.getScanner().nextLine();
                    DichVu dv = QuanLy.timKiemDichVuTheoMa(ma);
                    if (dv == null) {
                        System.out.print("Không tìm thấy mã cần cập nhật: ");
                    } else {
                        dv.capNhatDichVu();
                    }
                    break;

                case 4:
                    System.out.print("Nhập tên dịch vụ cần tìm: ");
                    String tenDichVu = Utils.getScanner().nextLine();
                    List<DichVu> kq = QuanLy.timKiemDichVu(tenDichVu);
                    if (kq.size() < 1) {
                        System.out.println("không tim thấy kết quả! ");
                    }
                    QuanLy.hienThiDanhSachDichVu(kq);
                    break;

                case 5:
                    QuanLy.hienThiDanhSachDichVu(QuanLy.dsDichVu);
                    break;

                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption02();
            else
                Presentation.exit();
        }
        // Menu quản lý đồ ăn và thức uôống
    }

    private static void showOption03() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- QL MÓN ĂN VÀ ĐỒ UỐNG --<======================");
        System.out.println("\t\t|\t1. Thêm Món hoặc đồ uống ");
        System.out.println("\t\t|\t2. Xóa món ăn, đồ uống ");
        System.out.println("\t\t|\t3. Cập nhật menu");
        System.out.println("\t\t|\t4. Tra cứu menu");
        System.out.println("\t\t|\t5. Xem");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy Chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 5 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 5 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 5 && choose >= 0) {
            switch (choose) {
                case 0:
                    Presentation.showMenu();
                    break;
                case 1:
                    System.out.print("Bạn muốn thêm đồ ăn hay thức uống? (1/ Đồ ăn, 2/ Thức uống): ");
                    int loai = Integer.parseInt(Utils.getScanner().nextLine());
                    if (loai >= 1 && loai <= 2) {
                        try {
                            switch (loai) {
                                case 1:
                                    DoAnVaThucUong themDoAn = new DoAn();
                                    themDoAn.taoMoi();
                                    QuanLy.themDoAnVaThucUong(themDoAn);
                                    break;
                                case 2:
                                    DoAnVaThucUong themDoUong = new DoUong();
                                    themDoUong.taoMoi();
                                    QuanLy.themDoAnVaThucUong(themDoUong);
                                    break;
                            }
                        } catch (ParseException p) {
                            System.out.println("Sai đinh dạng ngày!");
                        } catch (Exception e) {
                            System.out.println("Lỗi");
                        }
                    } else {
                        System.out.print("Nhập sai");
                    }
                    break;

                case 2:
                    System.out.println("Bạn hãy nhập mã món cần xóa: ");
                    String maFood = Utils.getScanner().nextLine();
                    QuanLy.xoaMonAn(maFood);
                    break;

                case 3:
                    System.out.print("Nhập mã món cần cập nhật: ");
                    String ma = Utils.getScanner().nextLine();
                    DoAnVaThucUong dv = QuanLy.timKiemMonTheoMa(ma);
                    if (dv == null) {
                        System.out.print("Không tìm thấy mã cần cập nhật: ");
                    } else {
                        dv.capNhatMenu();
                    }
                    break;

                case 4:
                    System.out.print("Nhập tên món ăn hoặc đồ uống cần tìm: ");
                    String tenFood = Utils.getScanner().nextLine();
                    List<DoAnVaThucUong> kq = QuanLy.timKiemMenu(tenFood);
                    if (kq.size() < 1) {
                        System.out.println("không tim thấy kết quả! ");
                    }
                    QuanLy.hienThiMenu(kq);
                    break;

                case 5:
                    QuanLy.hienThiMenu(QuanLy.dsDoAnVaThucUong);
                    break;

                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption03();
            else
                Presentation.exit();
        }
    }
    private static void showOption04() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- Đặt Sự Kiện --<======================");
        System.out.println("\t\t|\t1. Nhập thông tin sự kiện: ");
        System.out.println("\t\t|\t2. Chọn dịch vụ thuê: ");
        System.out.println("\t\t|\t3. Chọn món ăn: ");
        System.out.println("\t\t|\t4. Xem sự kiện đã đặt: ");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy Chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 5 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 5 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 5 && choose >= 0) {
            switch (choose) {
                case 0:
                    Presentation.showMenu();
                    break;
                case 1:
                    try{
                        System.out.print("Nhập tên sự kiện: ");
                        String tenSukien = Utils.getScanner().nextLine();
                        System.out.print("Hãy chọn sảnh cần thuê: \n");
                        QuanLy.hienThiDanhSachSanhCuoi(QuanLy.dsSanhCuoi);
                        System.out.print("Nhập mã sảnh cưới cần thuê: ");
                        String maSanhCuoi = Utils.getScanner().nextLine();
                        List<SanhCuoi> kq1 = QuanLy.timKiemSanhCuoi(maSanhCuoi, 3);
                        if (kq1.size() < 1) {
                            System.out.print("Nhập mã không hợp lệ!: ");
                        } else {
                            System.out.print("Nhập ngày bắt đầu: ");
                            Date batDau = Utils.getSimpleDateFormat2().parse(Utils.getScanner().nextLine());
                            System.out.print("Nhập ngày kết thúc: ");
                            Date ketThuc = Utils.getSimpleDateFormat2().parse(Utils.getScanner().nextLine());
                            if (batDau.after(ketThuc)) {
                                System.out.print("Nhập thời gian kết thúc trước thời gian bắt đầu: ");
                            }
                            System.out.print("Nhập buổi bắt đầu (1/sáng, 2/chiều, 3/tối): ");
                            int buoiBD = Integer.parseInt( Utils.getScanner().nextLine());
                            System.out.print("Nhập buổi kết thúc (1/sáng, 2/chiều, 3/tối): ");
                            int buoiKT = Integer.parseInt( Utils.getScanner().nextLine());
                            Map<Object,Object> kt = QuanLy.kiemTraDatSanh(batDau,ketThuc,buoiBD,buoiKT,maSanhCuoi);
                            if ((Boolean) kt.get("state")){
                                SuKien suKien = new SuKien();
                                suKien.setTenSuKien(tenSukien);
                                suKien.setNgayBatDauThue(batDau);
                                suKien.setNgayKetThucThue(ketThuc);
                                ThueSanhCuoi thueSanhCuoi = new ThueSanhCuoi();
                                thueSanhCuoi.setSuKien(suKien);
                                thueSanhCuoi.setBuoiBatDau(buoiBD);
                                thueSanhCuoi.setBuoiKetThuc(buoiKT);
                                thueSanhCuoi.setNgayBatDauThue(batDau);
                                thueSanhCuoi.setNgayKetThucThue(ketThuc);
                                thueSanhCuoi.setMaSanhCuoi(kq1.get(0));
                                suKien.setThueSanhCuoi(thueSanhCuoi);
                                QuanLy.dsSuKien.add(suKien);
                                QuanLy.dsThueSanhCuoi.add(thueSanhCuoi);
                                kq1.get(0).setSoLanThue(kq1.get(0).getSoLanThue()+1);
                                System.out.printf("Sụ kiện đã được tạo, mã là %s \n", suKien.getMaSuKien());
                                System.out.println("Đã thuê sảnh thành công!");
                            }else{
                                System.out.printf("Sảnh đã được thuê! %s ", kt.get("message"));
                            }
                        }
                    }catch (Exception e){System.out.println(e.getMessage());}
                    break;

                case 2:
                    try{
                        System.out.println("Nhập mã sự kiện cần thêm dịch vụ: ");
                        String suKienID = Utils.getScanner().nextLine();
                        SuKien kq4 = QuanLy.timKiemSuKienTheoMa(suKienID);
                        if(kq4 == null){
                            System.out.println("Không tìm thấy sự kiện! ");
                        }else{
                            System.out.println("Danh sách các dịch vụ của nhà hàng!");
                            QuanLy.hienThiDanhSachDichVu(QuanLy.dsDichVu);
                            String maDichVu;
                            do{
                                System.out.println("Nhập mã dịch vụ cần đặt cho sự kiện (Ấn 0 để thoát!): ");
                                maDichVu = Utils.getScanner().nextLine();
                                DichVu res = QuanLy.timKiemDichVuTheoMa(maDichVu);
                                if(res == null){
                                    System.out.println("Nhập mã không hợp lệ!");
                                }else{
                                    int soThuTu = kq4.getDatDichVu().size()+1;
                                    DatDichVu datDichVu = new DatDichVu();
                                    datDichVu.setThuTu(soThuTu);
                                    datDichVu.setMaDichVu(res);
                                    datDichVu.setGiaDichVu(res.tinhGia());
                                    kq4.getDatDichVu().add(datDichVu);
                                    System.out.println("Thêm dịch vụ thành công!");
                                }
                            }while (!maDichVu.equals("0"));
                        }
                    }catch (Exception e){System.out.println(e.getMessage());}
                    break;

                case 3:
                    try{
                        System.out.println("Nhập mã sự kiện muốn thêm đồ ăn: ");
                        String maSuKien = Utils.getScanner().nextLine();
                        SuKien kq3 = QuanLy.timKiemSuKienTheoMa(maSuKien);
                        if(kq3 == null){
                            System.out.println("Nhập mã sự kiện không hợp lệ!");
                        }else{
                            QuanLy.hienThiMenu(QuanLy.dsDoAnVaThucUong);
                            String maMonAn;
                            do{
                                System.out.println("Nhập mã đồ ăn cần đặt cho sự kiện (Ấn 0 để thoát!): ");
                                maMonAn = Utils.getScanner().nextLine();
                                DoAnVaThucUong kq2 = QuanLy.timKiemMonTheoMa(maMonAn);
                                if(kq2 == null){
                                    System.out.println("Nhập mã không hợp lệ!");
                                }else{
                                    System.out.println("Nhập số lượng của món: ");
                                    int soLuong = Integer.parseInt(Utils.getScanner().nextLine());
                                    if(soLuong <= 0){
                                        System.out.println("Nhập số lượng không hợp lệ!");
                                    } else {
                                        int soThuTu = kq3.getDatMonAn().size()+1;
                                        DatMonAn datMonAn = new DatMonAn();
                                        datMonAn.setSoThuTu(soThuTu);
                                        datMonAn.setMaMonAn(kq2);
                                        datMonAn.setSoLuongMon(soLuong);
                                        datMonAn.setGiaTien(kq2.getDonGiaFood()*soLuong);
                                        kq3.getDatMonAn().add(datMonAn);
                                        System.out.println("Thêm món ăn thành công!");
                                    }
                                }
                            }while (!maMonAn.equals("0"));
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    for (int i=0;i < QuanLy.dsSuKien.size();i++) {
                        System.out.println(QuanLy.dsSuKien.get(i));
                    }
                    break;
                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption04();
            else
                Presentation.exit();

        }

    }
    private static void showOption06() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- XỬ LÝ HÓA ĐƠN --<======================");
        System.out.println("\t\t|\t1. Thanh toán ");
        System.out.println("\t\t|\t2. Xuất hóa đơn ");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 2 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 2 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 2 && choose >= 0) {
            switch (choose) {

                case 0:
                    Presentation.showOption01();
                    break;

                case 1:
                    System.out.print("Nhập mã sự kiện cần thanh toán! : ");
                    String maSK = Utils.getScanner().nextLine();
                    SuKien kq9 = QuanLy.timKiemSuKienTheoMa(maSK);
                    if(kq9 == null){
                        System.out.println("Nhập mã sự kiện không hợp lệ!");
                    }else{
                        if(kq9.getKiemTraThanhToan()){
                            System.out.println("Sự kiện đã được thanh toán! ");
                        } else {
                            System.out.println(String.format("Số tiền của hóa đơn là %,.0f (VND)\n THANH TOÁN nhấn phím 1, O để hủy! ",kq9.tinhTongSK() ));
                            int luaChon =Integer.parseInt(Utils.getScanner().nextLine()) ;
                            if(luaChon == 1){
                                HoaDon hoaDon = new HoaDon();
                                hoaDon.setMaSuKien(kq9);
                                kq9.setKiemTraThanhToan(true);
                                hoaDon.setTongHoaDon(kq9.tinhTongSK());
                                QuanLy.dsHoaDon.add(hoaDon);
                            }else{
                                System.out.println("Thanh toán không thành công! ");
                            }
                            }
                    }
                    break;

                case 2:

                    break;


                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption06();
            else
                Presentation.exit();
        }
    }
    private static void showOption07() throws ParseException, IOException, InterruptedException {
        int choose;
        System.out.println("\n\t\t======================>-- BÁO CÁO DOANH THU --<======================");
        System.out.println("\t\t|\t1. Thống kê theo tháng ");
        System.out.println("\t\t|\t2. Thống kê theo quý ");
        System.out.println("\t\t|\t0. Trờ về!");
        System.out.println("\n\t\t============================================================\n");
        try {
            do {
                System.out.print("\t\t|\t=> Hãy chọn: ");
                choose = Integer.parseInt(Utils.getScanner().nextLine());
                if (choose > 2 || choose < 0)
                    System.out.println(">>>>>>> INVALID VALUE.<<<<<<<");
            } while (choose > 2 || choose < 0);
        } catch (Exception ex) {
            choose = -1;
            System.out.println(ex.getMessage());
        }
        if (choose <= 2 && choose >= 0) {
            switch (choose) {

                case 0:
                    Presentation.showMenu();
                    break;

                case 1:
                    System.out.println("Nhập năm cần thống kê: ");
                    int nam1 = Integer.parseInt(Utils.getScanner().nextLine());
                    System.out.println("Nhập tháng cần thống kê: ");
                    int thang = Integer.parseInt(Utils.getScanner().nextLine());
                    if(thang <= 0 || thang > 12){
                        System.out.println("Nhập tháng không hợp lệ! ");
                    } else {
                        System.out.println(String.format("Doanh thu của tháng %d thuộc năm %d là: %,.0f (VND) ",thang,nam1,QuanLy.thongKeTheoThang(thang, nam1)));
                    }
                    break;

                case 2:

                    System.out.print("Nhập năm cần thống kê: ");
                    int nam = Integer.parseInt(Utils.getScanner().nextLine());
                    System.out.print("Nhập quý cần thống kê: ");
                    int quy = Integer.parseInt(Utils.getScanner().nextLine());
                    if(quy <= 0 || quy > 4){
                        System.out.println("Nhập quý không hợp lệ! ");
                    }else {
                       System.out.println(String.format("Doanh thu của quý %d thuộc năm %d là: %,.0f (VND) ",quy,nam,QuanLy.thongKeTheoQuy(quy, nam)));

                    }

                    break;


                default:
                    Presentation.exit();
            }
            if (Presentation.continueConfirm("Bạn có muốn tiếp tục không?"))
                Presentation.showOption07();
            else
                Presentation.exit();
        }
    }
}
