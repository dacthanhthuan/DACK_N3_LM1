import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestCart {
    Cart cart = new Cart();

    @Test
    public void TestingCart1() {
        assertEquals(400000, cart.tinhTongTien_1sanpham(200000, 2), "Tongtien should equal 400 000");
    }

    @Test
    public void TestingCart2() {
        assertEquals(570000, cart.tinhTongTien_1sanpham(300000, 2), "Tongtien should equal 570 000");
    }

    @Test
    public void TestingCart3() {
        assertEquals(1080000, cart.tinhTongTien_1sanpham(400000, 3), "Tongtien should equal 1 080 000");
    }

    @Test
    public void TestingCart4() {
        assertEquals(2000000, cart.tinhTongTien_1sanpham(500000, 5), "Tongtien should equal 2 000 000");
    }

    @Test
    public void TestingCart5() {
        assertEquals(280000, cart.tinhTongTien_2sanpham(100000, 1, 90000, 2),
                "Tongtien should equal 280 000");
    }

    @Test
    public void TestingCart6() {
        assertEquals(551000, cart.tinhTongTien_2sanpham(200000, 2, 90000, 2),
                "Tongtien should equal 551 000");
    }

    @Test
    public void TestingCart7() {
        assertEquals(1080000, cart.tinhTongTien_2sanpham(400000, 2, 200000, 2),
                "Tongtien should equal 1 080 000");
    }

    @Test
    public void TestingCart8() {
        assertEquals(1920000, cart.tinhTongTien_2sanpham(800000, 2, 400000, 2),
                "Tongtien should equal 1 920 000");
    }

}

