package SchoolConstructionManagement.Objects;

public class ManagerObject {
	private int maQL;
	private String tenQL;
	private String ngaySinh;
	private String soDienThoai; 
	private String email; 
	private String diaChi;
	private String taiKhoan;
	private String matKhau;
	
	public ManagerObject() {
		
	}
	
	public ManagerObject(int maQL, String tenQL, String ngaySinh, String soDienThoai, String email, String diaChi,
			String taiKhoan, String matKhau) {
		super();
		this.maQL = maQL;
		this.tenQL = tenQL;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	public ManagerObject(int maQL, String tenQL, String ngaySinh, String diaChi) {
		super();
		this.maQL = maQL;
		this.tenQL = tenQL;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public int getMaQL() {
		return maQL;
	}
	public String getTenQL() {
		return tenQL;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMaQL(int maQL) {
		this.maQL = maQL;
	}
	public void setTenQL(String tenQL) {
		this.tenQL = tenQL;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "ManagerObject [maQL=" + maQL + ", tenQL=" + tenQL + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", taiKhoan=" + taiKhoan + ", matKhau="
				+ matKhau + "]";
	}
	
}
