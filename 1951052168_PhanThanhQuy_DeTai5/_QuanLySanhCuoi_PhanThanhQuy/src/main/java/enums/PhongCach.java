package enums;

public enum PhongCach {
    CO_DIEN, HIEN_DAI;
    public String getValue(){
        switch (this) {
            case CO_DIEN:
                return "Phong cách cổ điển";
            case HIEN_DAI:
                return "Phong cách hiện đại";
        }

        return "";
    }
    public static PhongCach getValueByInt(int value) {
        switch (value){
            case 1:
                return PhongCach.CO_DIEN;
            case 2:
                return PhongCach.HIEN_DAI;

        }
        return null;
    }
}
