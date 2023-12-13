package SchoolConstructionManagement.Objects;

public class DocumentObject {
	private int maTL;
	private String tenTL; 
	private String ngayLap; 
	private String trangThai;
	private String moTa; 
	private int maDA;
	
	public DocumentObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentObject(int maTL, String tenTL, String ngayLap, String trangThai, String moTa, int maDA) {
		super();
		this.maTL = maTL;
		this.tenTL = tenTL;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.moTa = moTa;
		this.maDA = maDA;
	}
	
	public DocumentObject(String tenTL, String ngayLap, String trangThai, String moTa, int maDA) {
		super();
		this.tenTL = tenTL;
		this.ngayLap = ngayLap;
		this.trangThai = trangThai;
		this.moTa = moTa;
		this.maDA = maDA;
	}
	
	public int getMaTL() {
		return maTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public String getMoTa() {
		return moTa;
	}

	public int getMaDA() {
		return maDA;
	}

	public void setMaTL(int maTL) {
		this.maTL = maTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}

	

	@Override
	public String toString() {
		return "DocumentObject [maTL=" + maTL + ", tenTL=" + tenTL + ", ngayLap=" + ngayLap + ", trangThai=" + trangThai
				+ ", moTa=" + moTa + ", maDA=" + maDA + "]";
	}
	
	 
}
