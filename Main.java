package quanLyLuongcb;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
 
    	 public static void main(String[] args) {
    	        ArrayList<CanBo> arrCanBo = new ArrayList<>();
    	        QuanLyCanBo quanLyCanBo = new QuanLyLuongImpl();
    	        int choose = 0  ;
    	     
    	      
    	        Scanner scanner = new Scanner(System.in);

    	        do {
    	            System.out.println("Chọn chức năng:");
    	            System.out.println("1. Thêm cán bộ");
    	            System.out.println("2. Sửa thông tin cán bộ");
    	            System.out.println("3. Xoá cán bộ");
    	            System.out.println("4. Tìm kiếm cán bộ");
    	            System.out.println("5. Hiển thị danh sách cán bộ và lương phải trả");
    	            System.out.println("6. Sắp xếp theo lương");
    	            System.out.println("7. Tăng lương cho cán bộ");
    	            System.out.println("8. Thống kê số lượng cán bộ theo loại");
    	            System.out.println("9. Tìm lương cán bộ cao nhất");
    	            System.out.println("10. Tìm lương cán bộ thấp nhất");
    	            System.out.println("11. Tìm lỗi nhập dữ liệu cán bộ");
    	            System.out.println("12. Xử phạt cán bộ");
    	            System.out.println("13. Ghi dữ liệu cán bộ vào file");
    	            System.out.println("0. Thoát");
    	            System.out.print("Nhập lựa chọn: ");
    	            try {
    	                choose = Integer.parseInt(scanner.nextLine());
    	                
    	            } catch (NumberFormatException e) {
    	                System.out.println("Lựa chọn không hợp lệ. nhập lại.");
    	          continue;
    	            }
    	         
    	        

    	            switch (choose) {
    	                case 1:
    	                    quanLyCanBo.themCanBo(arrCanBo);
    	                    break;
    	                case 2:
    	                    quanLyCanBo.suaCanBo(arrCanBo);
    	                    break;
    	                case 3:
    	                    quanLyCanBo.xoaCanBo(arrCanBo);
    	                    break;
    	                case 4:
    	                    quanLyCanBo.timKiemCanBo(arrCanBo);
    	                    break;
    	                case 5:
    	                    System.out.println("Hiển thị danh sách cán cán bộ và tổng số tiền lương phải trả : ");
    	                    for (CanBo cb : arrCanBo) {
    	                        System.out.println(cb.toString());
    	                    }
    	                    long tongLuong = quanLyCanBo.tinhTongLuong(arrCanBo);
    	                    System.out.println("Tổng lương phải trả cho cán bộ trong trường = " + tongLuong);
    	                    break;
    	                case 6:
    	                    quanLyCanBo.sapXepTheoLuong(arrCanBo);
    	                    System.out.println("Danh sách cán bộ sau khi sắp xếp:");
    	                    for (CanBo cb : arrCanBo) {
    	                        System.out.println(cb.toString());
    	                    }
    	                    break;
    	                case 7:
    	                	quanLyCanBo.tangLuong(arrCanBo);
    	                    break;
    	                case 8: 
    	                	quanLyCanBo.thongKeSoLuongCanBoTheoLoai(arrCanBo);
    	                	break;
    	                case 9:
    	                	CanBo maxLuong = ((QuanLyLuongImpl) quanLyCanBo).timCanBoLuongCaoNhat(arrCanBo);
    	                    System.out.println("Cán bộ có lương cao nhất:");
    	                    System.out.println(maxLuong.toString());
    	                    break;
    	                case 10:
    	                	CanBo minLuong = ((QuanLyLuongImpl) quanLyCanBo).timCanBoLuongThapNhat(arrCanBo);
    	                    System.out.println("Cán bộ có lương thấp nhất:");
    	                    System.out.println(minLuong.toString());
    	                    break;
    	                case 11:
    	                	quanLyCanBo.timLoiCanBo(arrCanBo);
    	                	break;   	                
    	                case 12:
    	                	((QuanLyLuongImpl) quanLyCanBo).xuPhatCanBo(arrCanBo);
    	                	break;
    	                case 13:
    	                	String tenFile = "C:\\Users\\nguye\\Desktop\\danhsachcanbo.txt";
    	                    quanLyCanBo.ghiDanhSachCanBoVaoFile(arrCanBo, tenFile);
    	                    break;
    	                case 0:
    	                    System.out.println("Kết thúc chương trình.");
    	                    break;
    	                default:
    	                    System.out.println("Lựa chọn không hợp lệ.");
    	                    break;
    	            }
    	        } while (choose != 0);
    	    }
    	}
