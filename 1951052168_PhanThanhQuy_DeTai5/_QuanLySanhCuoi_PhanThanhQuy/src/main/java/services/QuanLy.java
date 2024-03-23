package services;

import enums.QuanLyGia;
import models.*;
import utils.Utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class QuanLy {
    public static List<SanhCuoi> dsSanhCuoi = new ArrayList<>();
    public static List<DichVu> dsDichVu = new ArrayList<>();
    public static List<SuKien> dsSuKien = new ArrayList<>();
    public static List<HoaDon> dsHoaDon = new ArrayList<>();

    public static List<DoAnVaThucUong> dsDoAnVaThucUong = new ArrayList<>();
    public static List<ThueSanhCuoi> dsThueSanhCuoi = new ArrayList<>();
    public static Double layGiaSanh(List<Map<Object, Object>> dsGiaThue, QuanLyGia quanLyGia){
        Double gia = 0.0;
        for(int i = 0; i < dsGiaThue.size();i++){
            if(quanLyGia.getInt() == ((QuanLyGia) dsGiaThue.get(i).get("loai")).getInt()) {
                gia = (double) dsGiaThue.get(i).get("gia");
                break;
            }
        }
        return gia;
    }
    public static QuanLyGia layQuanLyGia(String dayOfWeek, int buoi){
        if (dayOfWeek.equals("SUNDAY") ||
                dayOfWeek.equals("SATURDAY")){
            switch (buoi){
                case 1:
                    return QuanLyGia.SANG_CUOI_TUAN;
                case 2:
                    return QuanLyGia.CHIEU_CUOI_TUAN;
                case 3:
                    return QuanLyGia.TOI_CUOI_TUAN;
            }
        }else {
            switch (buoi){
                case 1:
                    return QuanLyGia.SANG_NGAY_THUONG;
                case 2:
                    return QuanLyGia.CHIEU_NGAY_THUONG;
                case 3:
                    return QuanLyGia.TOI_NGAY_THUONG;
            }
        }
        return null;
    }
    public static Double tinhTienThueSanh(ThueSanhCuoi thueSanhCuoi){
        try {
            double tong = 0;
            LocalDate ngayBatDau = thueSanhCuoi.getNgayBatDauThue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ngayKetThuc = thueSanhCuoi.getNgayKetThucThue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            List<Map<Object, Object>> dsGia = thueSanhCuoi.getMaSanhCuoi().getGiaThue();
            int buoiBatDau = thueSanhCuoi.getBuoiBatDau();
            int buoiKetThuc = thueSanhCuoi.getBuoiKetThuc();
            for(LocalDate date = ngayBatDau; date.isBefore(ngayKetThuc.plusDays(1)); date = date.plusDays(1)){
                if(date.equals(ngayBatDau)){
                    if(date.equals(ngayKetThuc)){
                        if (buoiKetThuc == buoiBatDau){
                            tong += layGiaSanh(dsGia, layQuanLyGia(ngayBatDau.getDayOfWeek().toString(), buoiBatDau));
                        }else {
                            if (buoiKetThuc - buoiBatDau == 2){
                                tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
                                tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
                                tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
                            }else {
                                tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
                                tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
                            }
                        }
                    }else {
                        if (buoiBatDau == 1){
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
                        }else if (buoiBatDau == 2){
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
                        }else {
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
                        }
                    }
                }else {
                    if (date.equals(ngayKetThuc)){
                        if (buoiKetThuc == 1){
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
                        }else if (buoiKetThuc == 2){
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));

                        }else {
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 1));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
                        }
                    }else {
                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 1));
                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
                    }
                }
            }
            return tong;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    return 0.0;
    }

    public static Map<Object, Object> kiemTraDatSanh(Date ngayBatdau, Date ngayKetThuc, int buoiBatDau, int buoiKetThuc, String ma) {
        Map<Object, Object> kq = new HashMap<>();
        kq.put("state", true);
        kq.put("message", "Hợp lệ!");
        for (int i = 0; i < dsThueSanhCuoi.size(); i++) {
            ThueSanhCuoi thueSanhCuoi = dsThueSanhCuoi.get(i);
            if(thueSanhCuoi.getMaSanhCuoi().getMaSanhCuoi().equals(ma)){
                Date ngayBD = thueSanhCuoi.getNgayBatDauThue();
                Date ngayKT = thueSanhCuoi.getNgayKetThucThue();
                int buoiBD = thueSanhCuoi.getBuoiBatDau();
                int buoiKT = thueSanhCuoi.getBuoiKetThuc();
                if (ngayBatdau.after(ngayBD) && ngayBatdau.before(ngayKT)||(ngayKetThuc.before(ngayKT) && ngayKetThuc.after(ngayBD)) ) {
                    kq.put("state", false);
                    kq.put("message", String.format("Không hợp lệ. Đã có sự kiện khác thuê sảnh này " +
                                    "trong khoảng %s đến %s",
                            ngayBD.toString(), ngayKT.toString()));
                    break;
                }else if (ngayBatdau.equals(ngayKT) && (buoiBatDau <= buoiKT)) {
                    kq.put("state", false);
                    kq.put("message", "Bạn thử chọn buổi khác của ngày bắt đầu");
                    break;
                } else if (ngayKetThuc.equals(ngayBD) && (buoiKetThuc >= buoiBD)) {
                    kq.put("state", false);
                    kq.put("message", "Bạn thử chọn buổi khác của ngày kêết thúc");
                    break;
                }else if (ngayKetThuc.equals(ngayBatdau) && (buoiKetThuc < buoiBatDau)) {
                    kq.put("state", false);
                    kq.put("message", "Chọn buổi khong hợp lệ!");
                    break;
                }
            }

        }
        return kq;
    }

    public static void themSanhCuoi() {
        try {
            System.out.print("Hãy Nhập tên sảnh cưới: ");
            String tenSanhCuoi = Utils.getScanner().nextLine();

            System.out.print("Nhập vị trí sảnh cưới: ");
            String viTriSanhCuoi = Utils.getScanner().nextLine();


            System.out.print("Nhập sức chứa sảnh cưới ");
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
            SanhCuoi sanhCuoi = new SanhCuoi(tenSanhCuoi, viTriSanhCuoi, sucChua, dsGia);
            QuanLy.dsSanhCuoi.add(sanhCuoi);
            System.out.println("Thêm thành công!");
        } catch (Exception ex) {
            System.out.println("Bạn đã thực hiện sai! ");
        }

    }

    public static void xoaSanhCuoi(String maSanhCuoi) {
        try {
            boolean trangThai = QuanLy.dsSanhCuoi.removeIf(item -> item.getMaSanhCuoi().equals(maSanhCuoi));
            if (trangThai == true) {
                System.out.println("Xoa thanh cong ");
            } else {
                System.out.println("Không tìm thấy sảnh cần xóa! ");
            }


        } catch (Exception ex) {
            System.out.println("Xóa không thành công! ");

        }


    }

    public static List<SanhCuoi> timKiemSanhCuoi(String Kw, int loaiTimKiem) {
        List<SanhCuoi> kq;
        if (loaiTimKiem == 1) {
            kq = QuanLy.dsSanhCuoi.stream().filter(item -> item.getTenSanhCuoi().contains(Kw)).collect(Collectors.toList());
        } else if (loaiTimKiem == 2) {

            kq = QuanLy.dsSanhCuoi.stream().filter(item -> item.getViTriSanh().contains(Kw)).collect(Collectors.toList());
        } else {
            kq = QuanLy.dsSanhCuoi.stream().filter(item -> item.getMaSanhCuoi().equals(Kw)).collect(Collectors.toList());
        }

        return kq;
    }

    public static List<SanhCuoi> timKiemSanhCuoi(int tu, int den) {
        List<SanhCuoi> kq = QuanLy.dsSanhCuoi.stream().filter(item -> item.getSucChua() <= den && item.getSucChua() >= tu).collect(Collectors.toList());
        return kq;
    }

    public static void capNhatSanhCuoi(String ma, String ten, String viTri, int sucChua, List<Map<Object, Object>> gia) {
        try {
            SanhCuoi sanhCuoi = QuanLy.timKiemSanhCuoi(ma, 3).get(0);
            sanhCuoi.setTenSanhCuoi(ten);
            sanhCuoi.setViTriSanh(viTri);
            sanhCuoi.setSucChua(sucChua);
            sanhCuoi.setGiaThue(gia);
            System.out.println("Cập nhật thành công! ");
        } catch (Exception ex) {
            System.out.println("Cập nhật không thành công! ");
        }


    }

    public static void hienThiDanhSachSanhCuoi(List<SanhCuoi> input) {
        for (SanhCuoi sanhCuoi : input) {
            System.out.println(sanhCuoi);
        }
    }
    //////////////////// Quản Lý dịch vụ////////////////////////////////////

    public static void themDichVu(DichVu dichVu) {
        try {
            QuanLy.dsDichVu.add(dichVu);
        } catch (Exception ex) {
            System.out.println("Bạn đã thực hiện sai! ");
        }
    }

    public static List<DichVu> timKiemDichVu(String tuKhoa) {

        return QuanLy.dsDichVu.stream().filter(item -> item.getTenDichVu().contains(tuKhoa)).collect(Collectors.toList());

    }

    public static DichVu timKiemDichVuTheoMa(String ma) {
        try{
            List<DichVu> ds = QuanLy.dsDichVu.stream().filter(item -> item.getMaDichVu().equals(ma)).collect(Collectors.toList());
            if (ds.isEmpty()) {
                return null;
            }
            return ds.get(0);
        }catch (Exception e){}
        return null;

    }

    public static void xoaDichVu(String maDichVu) {
        try {
            boolean trangThai = QuanLy.dsDichVu.removeIf(item -> item.getMaDichVu().equals(maDichVu));
            if (trangThai == true) {
                System.out.println("Xoa thanh cong ");
            } else {
                System.out.println("Không tìm thấy sảnh cần xóa! ");
            }


        } catch (Exception ex) {
            System.out.println("Xóa không thành công! ");

        }


    }

    public static void hienThiDanhSachDichVu(List<DichVu> input) {
        for (DichVu dichvu : input) {
            System.out.println(dichvu);
        }
    }

    // Quản Lý Menu
    public static void themDoAnVaThucUong(DoAnVaThucUong doAnVaThucUong) {
        try {
            QuanLy.dsDoAnVaThucUong.add(doAnVaThucUong);
        } catch (Exception ex) {
            System.out.println("Bạn đã thực hiện sai! ");
        }
    }

    public static void hienThiMenu(List<DoAnVaThucUong> input) {
        for (DoAnVaThucUong menu : input) {
            System.out.println(menu);
        }
    }

    public static List<DoAnVaThucUong> timKiemMenu(String tuKhoa) {
        return QuanLy.dsDoAnVaThucUong.stream().filter(item -> item.getTenFood().contains(tuKhoa)).collect(Collectors.toList());

    }

    public static DoAnVaThucUong timKiemMonTheoMa(String ma) {
        try {
            List<DoAnVaThucUong> ds = QuanLy.dsDoAnVaThucUong.stream().filter(item -> item.getMaFood().equals(ma)).collect(Collectors.toList());
            if (ds.isEmpty()) {
                return null;
            }
            return ds.get(0);
        }catch (Exception e){}
        return  null;

    }

    public static void xoaMonAn(String maFood) {
        try {
            boolean trangThai = QuanLy.dsDoAnVaThucUong.removeIf(item -> item.getMaFood().equals(maFood));
            if (trangThai == true) {
                System.out.println("Xoa thanh cong ");
            } else {
                System.out.println("Không tìm thấy món cần xóa! ");
            }


        } catch (Exception ex) {
            System.out.println("Xóa không thành công! ");

        }
    }
    // quan ly su kien
    public static SuKien timKiemSuKienTheoMa(String ma) {
        try {
            List<SuKien> ds = QuanLy.dsSuKien.stream().filter(item -> item.getMaSuKien().equals(ma)).collect(Collectors.toList());
            if (ds.isEmpty()) {
                return null;
            }
            return ds.get(0);

        }catch (Exception e){System.out.println(e.getMessage());}
        return null;

    }

    // Bao cao theo thang va quy
    public static double thongKeTheoQuy(int quy, int nam){
        int thangKT = quy*3;
        int thangBD = thangKT - 2;
        double tongQuy = QuanLy.dsHoaDon.stream().filter(obj ->
                (obj.getNgayThanhToan().getYear() + 1900 == nam) &&
                (obj.getNgayThanhToan().getMonth()+1 >= thangBD) &&
                        (obj.getNgayThanhToan().getMonth()+1 <= thangKT)).collect(Collectors.toList()).stream().mapToDouble(HoaDon::getTongHoaDon).sum();
        return tongQuy;

    }
    public static double thongKeTheoThang(int thang, int nam){

        List<HoaDon> hoaDonList = QuanLy.dsHoaDon.stream().filter(obj ->
                (obj.getNgayThanhToan().getYear() + 1900 == nam) &&
                        (obj.getNgayThanhToan().getMonth()+1 == thang)).collect(Collectors.toList());
        for(int i = 0; i< hoaDonList.size(); i++){
            System.out.println(hoaDonList.get(i).getTongHoaDon());
        }
        double tongQuy = hoaDonList.stream().mapToDouble(HoaDon::getTongHoaDon).sum();
        return  tongQuy;


    }
}
