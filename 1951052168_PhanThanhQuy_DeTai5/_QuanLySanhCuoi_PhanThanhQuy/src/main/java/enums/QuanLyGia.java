package enums;

public enum QuanLyGia {
    SANG_CUOI_TUAN, CHIEU_CUOI_TUAN, TOI_CUOI_TUAN,
    SANG_NGAY_THUONG, CHIEU_NGAY_THUONG, TOI_NGAY_THUONG;
    public String getValue(){
        switch (this){
            case SANG_CUOI_TUAN:
                return "Sáng Cuối Tuần";
            case CHIEU_CUOI_TUAN:
                return "Chiều Cuối Tuần";
            case TOI_CUOI_TUAN:
                return "Tối Cuối Tuần";
            case SANG_NGAY_THUONG:
                return "Sáng ngày thường";
            case CHIEU_NGAY_THUONG:
                return "Chiều ngày Thường";
            case TOI_NGAY_THUONG:
                return "Tối ngày thường";
        }
        return "";
    }
    public static QuanLyGia getValueByInt(int value) {
        switch (value){
            case 1:
                return QuanLyGia.SANG_CUOI_TUAN;
            case 2:
                return QuanLyGia.CHIEU_CUOI_TUAN;
            case 3:
                return QuanLyGia.TOI_CUOI_TUAN;
            case 4:
                return QuanLyGia.SANG_NGAY_THUONG;
            case 5:
                return QuanLyGia.CHIEU_NGAY_THUONG;
            case 6:
                return QuanLyGia.TOI_NGAY_THUONG;
        }
        return null;
    }

    public int getInt() {
        return switch (this) {
            case SANG_CUOI_TUAN -> 1;
            case CHIEU_CUOI_TUAN -> 2;
            case TOI_CUOI_TUAN -> 3;
            case SANG_NGAY_THUONG -> 4;
            case CHIEU_NGAY_THUONG -> 5;
            case TOI_NGAY_THUONG -> 6;
        };
    }


}
