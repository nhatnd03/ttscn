package SchoolConstructionManagement.Objects;

public class LeaderObject {
	private int maTN;
	private String tenTN; 
	private String diaChi;
	private String ngaySinh; 
	private String soDienThoai; 
	private String email;
	private int maQL;
	public LeaderObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LeaderObject(int maTN, String tenTN, String diaChi, String ngaySinh, String soDienThoai, String email,
			int maQL) {
		super();
		this.maTN = maTN;
		this.tenTN = tenTN;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.maQL = maQL;
	}

	public int getMaTN() {
		return maTN;
	}
	public String getTenTN() {
		return tenTN;
	}
	public String getDiaChi() {
		return diaChi;
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
	public int getMaQL() {
		return maQL;
	}
	public void setMaTN(int maTN) {
		this.maTN = maTN;
	}
	public void setTenTN(String tenTN) {
		this.tenTN = tenTN;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public void setMaQL(int maQL) {
		this.maQL = maQL;
	}
	
	@Override
	public String toString() {
		return "LeaderObject [maTN=" + maTN + ", tenTN=" + tenTN + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", maQL=" + maQL + "]";
	}
	
	
}
