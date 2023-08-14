package quanLyLuongcb;

import java.util.ArrayList;

public interface QuanLyCanBo {
	 void themCanBo(ArrayList<CanBo> arrCanBo);
     void suaCanBo(ArrayList<CanBo> arrCanBo);
     void xoaCanBo(ArrayList<CanBo> arrCanBo);
     void timKiemCanBo(ArrayList<CanBo> arrCanBo);
     void sapXepTheoLuong(ArrayList<CanBo> arrCanBo);
     void tangLuong(ArrayList<CanBo> arrCanBo);
     void timLoiCanBo(ArrayList<CanBo> arrCanBo);
     void thongKeSoLuongCanBoTheoLoai(ArrayList<CanBo> arrCanBo);
     void ghiDanhSachCanBoVaoFile(ArrayList<CanBo> arrCanBo, String tenFile);
     long tinhTongLuong(ArrayList<CanBo> arrCanBo);
	
	
}
