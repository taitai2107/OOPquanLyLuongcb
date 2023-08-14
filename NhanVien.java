package quanLyLuongcb;

public class NhanVien extends CanBo {
	private String phongBan, chucVu;
    private int soNgayCong, choose;
     
    public NhanVien() {
        super();
    }
 
    public NhanVien(String phongBan, String chucVu, int soNgayCong) {
        super();
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.soNgayCong = soNgayCong;
    }
 
    public String getPhongBan() {
        return phongBan;
    }
 
    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
 
    public String getChucVu() {
        return chucVu;
    }
 
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
 
    public int getSoNgayCong() {
        return soNgayCong;
    }
 
    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }
 
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập phòng ban: ");
        phongBan = scanner.nextLine();
        do {
            System.out.print("Nhập chức vụ (1 - trưởng phòng, 2 - phó phòng, 3 - nhân viên): ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    chucVu = "trưởng phòng";
                    this.setPhuCap(15000);
                    break;
                case 2:
                    chucVu = "phó phòng";
                    this.setPhuCap(10000);
                    break;
                case 3:
                    chucVu = "nhân viên";
                    this.setPhuCap(3000);
                    break;
                default:
                    System.out.println("Chọn không đúng!");
                    break;
            }
        } while (choose < 1 || choose > 3);
        System.out.print("Nhập số ngày công: ");
        soNgayCong = scanner.nextInt();
    }
 
    @Override
    public long tinhLuong() {
        return (long) (this.getHeSoLuong() * 7300 + this.getPhuCap() + this.getSoNgayCong() * 200) *500;
    }
 
    @Override
    public String toString() {
        return super.toString() + ", phòng ban: " + this.phongBan + ", chức vụ: " + this.chucVu + 
            ", số ngày công: " + this.soNgayCong;
    }
}
