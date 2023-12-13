package SchoolConstructionManagement.Objects;

public class JobObject {
	private int maCV; 
	private String tenCV; 
	private String moTaCV; 
	private String ngayBatDau; 
	private String ngayKetThuc;
	private String trangThai; 
	private String tienDoCV;
	private int luongNhanCong; 
	private int maDA; 
	private int maTN;
	
	public JobObject() {
		
	}

	public JobObject(int maCV, String tenCV, String moTaCV, String ngayBatDau, String ngayKetThuc, String trangThai,
			String tienDoCV, int luongNhanCong, int maDA, int maTN) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
		this.moTaCV = moTaCV;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
		this.tienDoCV = tienDoCV;
		this.luongNhanCong = luongNhanCong;
		this.maDA = maDA;
		this.maTN = maTN;
	}

	public int getMaCV() {
		return maCV;
	}

	public String getTenCV() {
		return tenCV;
	}

	public String getMoTaCV() {
		return moTaCV;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public String getTienDoCV() {
		return tienDoCV;
	}

	public int getLuongNhanCong() {
		return luongNhanCong;
	}

	public int getMaDA() {
		return maDA;
	}

	public int getMaTN() {
		return maTN;
	}

	public void setMaCV(int maCV) {
		this.maCV = maCV;
	}

	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}

	public void setMoTaCV(String moTaCV) {
		this.moTaCV = moTaCV;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void setTienDoCV(String tienDoCV) {
		this.tienDoCV = tienDoCV;
	}

	public void setLuongNhanCong(int luongNhanCong) {
		this.luongNhanCong = luongNhanCong;
	}

	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}

	public void setMaTN(int maTN) {
		this.maTN = maTN;
	}

	@Override
	public String toString() {
		return "JobObject [maCV=" + maCV + ", tenCV=" + tenCV + ", moTaCV=" + moTaCV + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + ", tienDoCV=" + tienDoCV
				+ ", luongNhanCong=" + luongNhanCong + ", maDA=" + maDA + ", maTN=" + maTN + "]";
	}
	
	
}
