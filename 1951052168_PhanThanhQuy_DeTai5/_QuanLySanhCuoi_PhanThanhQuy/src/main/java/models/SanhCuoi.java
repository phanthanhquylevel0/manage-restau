package models;

import enums.QuanLyGia;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;

public class SanhCuoi implements Comparable<SanhCuoi> {
    private String maSanhCuoi;
    private String tenSanhCuoi;
    private String viTriSanh;
    private int sucChua;
    private int soLanThue = 0;




    private List<Map<Object, Object>> giaThue;
    private static int dem = 0;
    {
        this.setMaSanhCuoi(String.format("S%03d",++dem));

    }

    public SanhCuoi(String tenSanhCuoi, String viTriSanh, int sucChua, List<Map<Object, Object>> giaThue) {
        this.tenSanhCuoi = tenSanhCuoi;
        this.viTriSanh = viTriSanh;
        this.sucChua = sucChua;
        this.giaThue = giaThue;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 6; i++){
            temp.append(String.format("Thời điểm %s: %,.0f (VND)", ((QuanLyGia) giaThue.get(i).get("loai")).getValue(),
                    (Double) giaThue.get(i).get("gia"))).append("\n");
        }
        return "Mã sảnh cưới: " + maSanhCuoi + '\n' +
                "Tên sảnh cưới: " + tenSanhCuoi + '\n' +
                "Vị Trí: " + viTriSanh + '\n' +
                "Sức chứa: " + sucChua +'\n'+
                "Giá thuê: " +   '\n'+ temp + '\n' + "Số lần thuê: " + soLanThue + '\n'+
                "+++++++++++++++++++++++++++++++++++++++++\n";
    }

    public String getMaSanhCuoi() {
        return maSanhCuoi;
    }

    public void setMaSanhCuoi(String maSanhCuoi) {
        this.maSanhCuoi = maSanhCuoi;
    }

    public String getTenSanhCuoi() {
        return tenSanhCuoi;
    }

    public void setTenSanhCuoi(String tenSanhCuoi) {
        this.tenSanhCuoi = tenSanhCuoi;
    }

    public String getViTriSanh() {
        return viTriSanh;
    }

    public void setViTriSanh(String viTriSanh) {
        this.viTriSanh = viTriSanh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public List<Map<Object, Object>> getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(List<Map<Object, Object>> giaThue) {
        this.giaThue = giaThue;
    }
    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

    @Override
    public int compareTo(SanhCuoi o) {
        if(this.getSoLanThue() > o.getSoLanThue()){
            return -1;
        } else if (this.getSoLanThue() < o.getSoLanThue()) {
            return 1;
        }
        return 0;
    }
}

