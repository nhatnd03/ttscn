package SchoolConstructionManagement.Objects;

public class ResourceAndJobObject {
	private int maTaiNguyen; 
	private int maCV;
	private String loaiTN;
	private String moTa;
	private int chiPhiTN; 
	private String ngayThanhToan; 
	private int tongChiPhi;
	
	public ResourceAndJobObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResourceAndJobObject(int maTaiNguyen, int maCV, String loaiTN, String moTa, int chiPhiTN,
			String ngayThanhToan, int tongChiPhi) {
		super();
		this.maTaiNguyen = maTaiNguyen;
		this.maCV = maCV;
		this.loaiTN = loaiTN;
		this.moTa = moTa;
		this.chiPhiTN = chiPhiTN;
		this.ngayThanhToan = ngayThanhToan;
		this.tongChiPhi = tongChiPhi;
	}

	public int getMaTaiNguyen() {
		return maTaiNguyen;
	}
	public int getMaCV() {
		return maCV;
	}
	public String getLoaiTN() {
		return loaiTN;
	}
	public String getMoTa() {
		return moTa;
	}
	public int getChiPhiTN() {
		return chiPhiTN;
	}
	public String getNgayThanhToan() {
		return ngayThanhToan;
	}
	public int getTongChiPhi() {
		return tongChiPhi;
	}
	public void setMaTaiNguyen(int maTaiNguyen) {
		this.maTaiNguyen = maTaiNguyen;
	}
	public void setMaCV(int maCV) {
		this.maCV = maCV;
	}
	public void setLoaiTN(String loaiTN) {
		this.loaiTN = loaiTN;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public void setChiPhiTN(int chiPhiTN) {
		this.chiPhiTN = chiPhiTN;
	}
	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public void setTongChiPhi(int tongChiPhi) {
		this.tongChiPhi = tongChiPhi;
	}
	@Override
	public String toString() {
		return "ResourceAndJobObject [maTaiNguyen=" + maTaiNguyen + ", maCV=" + maCV + ", loaiTN=" + loaiTN + ", moTa="
				+ moTa + ", chiPhiTN=" + chiPhiTN + ", ngayThanhToan=" + ngayThanhToan + ", tongChiPhi=" + tongChiPhi
				+ "]";
	}
	
	
}
