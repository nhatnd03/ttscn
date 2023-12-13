package SchoolConstructionManagement.Objects;

public class ResourceObject {
	private int maTaiNguyen;
	private String tenTaiNguyen;
	private int soLuong ;
	private String trangThai;
	private int donGia;
	private String ghiChu;
	private int maDA;
	
	public int getMaTaiNguyen() {
		return maTaiNguyen;
	}
	
	public ResourceObject() {
		
	}
	public ResourceObject(int maTaiNguyen, String tenTaiNguyen, int soLuong, String trangThai, int donGia,
			String ghiChu, int maDA) {
		super();
		this.maTaiNguyen = maTaiNguyen;
		this.tenTaiNguyen = tenTaiNguyen;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
		this.donGia = donGia;
		this.ghiChu = ghiChu;
		this.maDA = maDA;
	}

	public int getMaDA() {
		return maDA;
	}

	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}

	public String getTenTaiNguyen() {
		return tenTaiNguyen;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public int getDonGia() {
		return donGia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setMaTaiNguyen(int maTaiNguyen) {
		this.maTaiNguyen = maTaiNguyen;
	}
	public void setTenTaiNguyen(String tenTaiNguyen) {
		this.tenTaiNguyen = tenTaiNguyen;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "ResourceObject [maTaiNguyen=" + maTaiNguyen + ", tenTaiNguyen=" + tenTaiNguyen + ", soLuong=" + soLuong
				+ ", trangThai=" + trangThai + ", donGia=" + donGia + ", ghiChu=" + ghiChu + "]";
	}
	
	
	
}
