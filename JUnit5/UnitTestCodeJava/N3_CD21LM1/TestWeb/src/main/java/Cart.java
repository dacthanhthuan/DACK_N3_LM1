import static java.lang.Math.round;

public class Cart {
    public float tinhTongTien_1sanpham(float donGia, int soLuong) {
        float tongTien = donGia * soLuong;
        if (tongTien >= 500000 && tongTien < 1000000) {
            tongTien -= tongTien * 0.05;
        } else if (tongTien >= 1000000 && tongTien < 2000000) {
            tongTien -= tongTien * 0.1;
        } else if (tongTien >= 2000000) {
            tongTien -= tongTien * 0.2;
        }
        return round(tongTien);
    }

    public float tinhTongTien_2sanpham(float donGiaSP1, int soLuongSP1, float donGiaSP2, int soLuongSP2) {
        float tongTien2 = (donGiaSP1 * soLuongSP1) + (donGiaSP2 * soLuongSP2);
        if (tongTien2 >= 500000 && tongTien2 < 1000000) {
            tongTien2 -= tongTien2 * 0.05;
        } else if (tongTien2 >= 1000000 && tongTien2 < 2000000) {
            tongTien2 -= tongTien2 * 0.1;
        } else if (tongTien2 >= 2000000) {
            tongTien2 -= tongTien2 * 0.2;
        }
        return round(tongTien2);
    }
}
