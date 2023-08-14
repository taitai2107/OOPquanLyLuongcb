package quanLyLuongcb;

import java.util.Scanner;

public abstract class CanBo {
	  private String hoTen, loaiCanBo;
	    private int heSoLuong;
	    private int phuCap;
	    protected int choose;
	    Scanner scanner = new Scanner(System.in);
	    CanBo canBo;
	     
	    public CanBo() {
	        super();
	    }
	 
	    public CanBo(String hoTen, String loaiCanBo, int heSoLuong, int phuCap) {
	        super();
	        this.hoTen = hoTen;
	        this.loaiCanBo = loaiCanBo;
	        this.heSoLuong = heSoLuong;
	        this.phuCap = phuCap;
	    }
	 
	    public String getHoTen() {
	        return hoTen;
	    }
	 
	    public void setHoTen(String hoTen) {
	        this.hoTen = hoTen;
	    }
	 
	    public String getLoaiCanBo() {
	        return loaiCanBo;
	    }
	 
	    public void setLoaiCanBo(String loaiCanBo) {
	        this.loaiCanBo = loaiCanBo;
	    }
	 
	    public int getHeSoLuong() {
	        return heSoLuong;
	    }
	 
	    public void setHeSoLuong(int heSoLuong) {
	        this.heSoLuong = heSoLuong;
	    }
	 
	    public int getPhuCap() {
	        return phuCap;
	    }
	 
	    public void setPhuCap(int phuCap) {
	        this.phuCap = phuCap;
	    }
	     
	    public void nhap() {
	        System.out.print("Nhập họ tên: ");
	        hoTen = scanner.nextLine();
	        System.out.print("Nhập hệ số lương: ");
	        heSoLuong = scanner.nextInt();
	    }
	     
	    public long tinhLuong() {
	        return 0;
	    }
	     
	    @Override
	    public String toString() {
	        return "Tên: " + this.hoTen + ", hệ số lương: " + this.heSoLuong + ", phụ cấp: " + 
	                phuCap + ", lương: " + this.tinhLuong();
	    }
	}

