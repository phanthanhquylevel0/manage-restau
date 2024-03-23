//import enums.QuanLyGia;
//import services.QuanLy;
//import utils.Utils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//public class Test {
//    public static Double layGiaSanh(List<Map<Object, Object>> dsGiaThue, QuanLyGia quanLyGia){
//        for(int i = 0; i < dsGiaThue.size();i++){
//            if((QuanLyGia)dsGiaThue.get(1).get("loai") == quanLyGia){
//                double gia = (double) dsGiaThue.get(1).get("gia");
//                return gia;
//            }
//        }
//        return null;
//    }
//    public static QuanLyGia layQuanLyGia(String dayOfWeek, int buoi){
//        if (dayOfWeek.equals("SUNDAY") ||
//                dayOfWeek.equals("SATURDAY")){
//            switch (buoi){
//                case 1:
//                    return QuanLyGia.SANG_CUOI_TUAN;
//                case 2:
//                    return QuanLyGia.CHIEU_CUOI_TUAN;
//                case 3:
//                    return QuanLyGia.TOI_CUOI_TUAN;
//            }
//        }else {
//            switch (buoi){
//                case 1:
//                    return QuanLyGia.SANG_NGAY_THUONG;
//                case 2:
//                    return QuanLyGia.CHIEU_NGAY_THUONG;
//                case 3:
//                    return QuanLyGia.TOI_NGAY_THUONG;
//            }
//        }
//        return null;
//    }
//    public static void main(String[] args) throws ParseException {
//        double tong = 0;
//        LocalDate ngayBatDau = Utils.getSimpleDateFormat2().parse("12/12/2012").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate ngayKetThuc = Utils.getSimpleDateFormat2().parse("16/12/2012").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        List<Map<Object, Object>> dsGia = null;
//        int buoiBatDau = 1;
//        int buoiKetThuc = 3;
//        for(LocalDate date = ngayBatDau; date.isBefore(ngayKetThuc.plusDays(1)); date = date.plusDays(1)){
//            if(date.equals(ngayBatDau)){
//                if(date.equals(ngayKetThuc)){
//                    if (buoiKetThuc == buoiBatDau){
//                        tong += layGiaSanh(dsGia, layQuanLyGia(ngayBatDau.getDayOfWeek().toString(), buoiBatDau));
//                    }else {
//                        if (buoiKetThuc - buoiBatDau == 2){
//                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
//                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
//                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
//                        }else {
//                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
//                            tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
//                        }
//                    }
//                }else {
//                    if (buoiBatDau == 1){
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
//                    }else if (buoiBatDau == 2){
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
//                    }else {
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiBatDau));
//                    }
//                }
//            }else {
//                if (date.equals(ngayKetThuc)){
//                    if (buoiKetThuc == 1){
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
//                    }else if (buoiKetThuc == 2){
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
//
//                    }else {
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 1));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
//                        tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), buoiKetThuc));
//                    }
//                }else {
//                    tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 1));
//                    tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 2));
//                    tong += layGiaSanh(dsGia, layQuanLyGia(date.getDayOfWeek().toString(), 3));
//                }
//            }
//        }
//        return tong;
//    }
//}
