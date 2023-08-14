package quanLyLuongcb;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


	public  class QuanLyLuongImpl implements QuanLyCanBo {
	    @Override
	    public void themCanBo(ArrayList<CanBo> arrCanBo) {
	        int choose =0, soCanBo;
	        CanBo canBo = null;
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập số lượng cán bộ trong trường: ");

	        while (true) {
	            try {
	                soCanBo = Integer.parseInt(scanner.nextLine());
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Số lượng cán bộ không hợp lệ.  nhập lại.");
	            }
	        }

	        for (int i = 0; i < soCanBo; i++) {
	            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");

	            do {
	                System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
	                try {
	                    choose = Integer.parseInt(scanner.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Lựa chọn không hợp lệ.  nhập lại.");
	                    continue;
	                }

	                switch (choose) {
	                    case 1:
	                        canBo = new GiangVien();
	                        canBo.nhap();
	                        arrCanBo.add(canBo);
	                        break;
	                    case 2:
	                        canBo = new NhanVien();
	                        canBo.nhap();
	                        arrCanBo.add(canBo);
	                        break;
	                    default:
	                        System.out.println("Lựa chọn không hợp lệ.");
	                        break;
	                }
	            } while (choose < 1 || choose > 2);
	        }
	    }

        @Override
        public void suaCanBo(ArrayList<CanBo> arrCanBo) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên cán bộ cần sửa: ");
            String tenCanBo = scanner.nextLine();
            boolean daSua = false;

            for (CanBo canBo : arrCanBo) {
                if (canBo.getHoTen().equalsIgnoreCase(tenCanBo)) {
                    System.out.println("Thông tin cũ của cán bộ:");
                    System.out.println(canBo.toString());

                    canBo.nhap();
                    daSua = true;
                    break;
                }
            }

            if (!daSua) {
                System.out.println("Không tìm thấy cán bộ có tên: " + tenCanBo);
            }
        }

        @Override
        public void xoaCanBo(ArrayList<CanBo> arrCanBo) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên cán bộ cần xoá: ");
            String tenCanBo = scanner.nextLine();
            boolean daXoa = false;

            for (int i = 0; i < arrCanBo.size(); i++) {
                if (arrCanBo.get(i).getHoTen().equalsIgnoreCase(tenCanBo)) {
                    arrCanBo.remove(i);
                    System.out.println("Đã xoá cán bộ có tên: " + tenCanBo);
                    daXoa = true;
                    break;
                }
            }

            if (!daXoa) {
                System.out.println("Không tìm thấy cán bộ có tên: " + tenCanBo);
            }
        }

        @Override
        public void timKiemCanBo(ArrayList<CanBo> arrCanBo) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên cán bộ cần tìm: ");
            String tenCanBo = scanner.nextLine();
            boolean timThay = false;

            for (CanBo canBo : arrCanBo) {
                if (canBo.getHoTen().equalsIgnoreCase(tenCanBo)) {
                    System.out.println("Thông tin cán bộ:");
                    System.out.println(canBo.toString());
                    timThay = true;
                    break;
                }
            }

            if (!timThay) {
                System.out.println("Không tìm thấy cán bộ có tên: " + tenCanBo);
            }
        }
        @Override
        public long tinhTongLuong(ArrayList<CanBo> arrCanBo) {
            long tongLuong = 0;
            for (CanBo cb : arrCanBo) {
                long luong = cb.tinhLuong();
                tongLuong += luong;
            }
            return tongLuong;
        }

        @Override
        public void sapXepTheoLuong(ArrayList<CanBo> arrCanBo) {
            Collections.sort(arrCanBo, new Comparator<CanBo>() {
                @Override
                public int compare(CanBo cb1, CanBo cb2) {
                    long luong1 = cb1.tinhLuong();
                    long luong2 = cb2.tinhLuong();

                    if (luong1 < luong2) {
                        return -1;
                    } else if (luong1 > luong2) {
                        return 1;
                    }
                    return 0;
                }
            });

            System.out.println("Đã sắp xếp danh sách cán bộ theo lương.");
        }
        public void tangLuong(ArrayList<CanBo> arrCanBo) {
        	 Scanner scanner = new Scanner(System.in);
        	    System.out.print("Nhập tên cán bộ muốn tăng lương: ");
        	    String tenCanBo = scanner.nextLine();
        	    
        	    boolean timThay = false;
        	    
        	    for (CanBo canBo : arrCanBo) {
        	        if (canBo.getHoTen().equalsIgnoreCase(tenCanBo)) {
        	            System.out.print("Nhập số lương muốn tăng: ");
        	            long soLuongTang = scanner.nextLong();

        	            long luongCu = canBo.tinhLuong();
        	            int luongMoi = (int) (luongCu + soLuongTang);
        	            canBo.setHeSoLuong(luongMoi);

        	            System.out.println("Cán bộ: " + canBo.getHoTen() + " - Lương cũ: " + luongCu + " - Lương mới: " + luongMoi);
        	            timThay = true;
        	            break;
        	        }
        	    }

        	    if (!timThay) {
        	        System.out.println("Không tìm thấy cán bộ có tên: " + tenCanBo);
        	    }
        }
        public void timLoiCanBo(ArrayList<CanBo> arrCanBo) {
            for (CanBo cb : arrCanBo) {
                if (cb instanceof GiangVien) {
                    GiangVien giangVien = (GiangVien) cb;
                    if (giangVien.getSoTietDay() > 240) {
                        System.out.println("Lỗi: Giảng viên " + cb.getHoTen() + " dạy quá 240 tiết.");
                    }
                } else if (cb instanceof NhanVien) {
                    NhanVien nhanVien = (NhanVien) cb;
                    if (nhanVien.getSoNgayCong() > 31) {
                        System.out.println("Lỗi: Nhân viên " + cb.getHoTen() + " làm việc quá 31 ngày.");
                    }
                }
            }
        }
        public void thongKeSoLuongCanBoTheoLoai(ArrayList<CanBo> arrCanBo) {
            int soLuongGiangVien = 0;
            int soLuongNhanVien = 0;

            for (CanBo cb : arrCanBo) {
                if (cb instanceof GiangVien) {
                    soLuongGiangVien++;
                } else if (cb instanceof NhanVien) {
                    soLuongNhanVien++;
                }
            }

            System.out.println("Thống kê số lượng cán bộ theo loại:");
            System.out.println("Số lượng giảng viên: " + soLuongGiangVien);
            System.out.println("Số lượng nhân viên: " + soLuongNhanVien);
        }
        public CanBo timCanBoLuongCaoNhat(ArrayList<CanBo> arrCanBo) {
            CanBo maxLuong = arrCanBo.get(0);
            for (CanBo cb : arrCanBo) {
                if (cb.tinhLuong() > maxLuong.tinhLuong()) {
                    maxLuong = cb;
                }
            }
            return maxLuong;
        }

        public CanBo timCanBoLuongThapNhat(ArrayList<CanBo> arrCanBo) {
            CanBo minLuong = arrCanBo.get(0);
            for (CanBo cb : arrCanBo) {
                if (cb.tinhLuong() < minLuong.tinhLuong()) {
                    minLuong = cb;
                }
            }
            return minLuong;
        }
        public void xuPhatCanBo(ArrayList<CanBo> arrCanBo) {
            for (CanBo cb : arrCanBo) {
                if (cb instanceof GiangVien) {
                    GiangVien giangVien = (GiangVien) cb;
                    if (giangVien.getSoTietDay() < 30) {
                        long mucPhat = (long) (giangVien.tinhLuong() * 0.2); 
                        giangVien.setHeSoLuong(giangVien.getHeSoLuong() - 1);
                        System.out.println("Giảng viên " + giangVien.getHoTen() + " bị trừ " + mucPhat + " vì số tiết dạy quá ít.");
                    }
                } else if (cb instanceof NhanVien) {
                    NhanVien nhanVien = (NhanVien) cb;
                    if (nhanVien.getSoNgayCong() < 20) {
                        long mucPhat = (long) (nhanVien.tinhLuong() * 0.2); 
                        nhanVien.setHeSoLuong(nhanVien.getHeSoLuong() - 1);
                        System.out.println("Nhân viên " + nhanVien.getHoTen() + " bị trừ " + mucPhat + " vì số ngày công quá ít.");
                    }
                }
            }
        }
        @Override
        public void ghiDanhSachCanBoVaoFile(ArrayList<CanBo> arrCanBo, String tenFile) {
            try (FileWriter writer = new FileWriter(tenFile)) {
                for (CanBo cb : arrCanBo) {
                    writer.write(cb.toString() + "\n");
                }
                System.out.println("Đã ghi danh sách cán bộ vào file: " + tenFile);
            } catch (IOException e) {
                System.out.println("Lỗi ghi file: " + e.getMessage());
            }
        }
    }
	


