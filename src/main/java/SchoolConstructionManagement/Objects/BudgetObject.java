package SchoolConstructionManagement.Objects;

public class BudgetObject {
	private int maNganSach; 
	private int tongSoTien; 
	private int soTienDaChi; 
	private int soTienConLai; 
	private String trangThai; 
	private int maDA;
	
	public BudgetObject() {
		
	}
	public BudgetObject(int maNganSach, int tongSoTien, int soTienDaChi, int soTienConLai, String trangThai,
			int maDA) {
		super();
		this.maNganSach = maNganSach;
		this.tongSoTien = tongSoTien;
		this.soTienDaChi = soTienDaChi;
		this.soTienConLai = soTienConLai;
		this.trangThai = trangThai;
		this.maDA = maDA;
	}

	public int getMaNganSach() {
		return maNganSach;
	}

	public int getTongSoTien() {
		return tongSoTien;
	}

	public int getSoTienDaChi() {
		return soTienDaChi;
	}

	public int getSoTienConLai() {
		return soTienConLai;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public int getMaDA() {
		return maDA;
	}

	public void setMaNganSach(int maNganSach) {
		this.maNganSach = maNganSach;
	}

	public void setTongSoTien(int tongSoTien) {
		this.tongSoTien = tongSoTien;
	}

	public void setSoTienDaChi(int soTienDaChi) {
		this.soTienDaChi = soTienDaChi;
	}

	public void setSoTienConLai(int soTienConLai) {
		this.soTienConLai = soTienConLai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}

	@Override
	public String toString() {
		return "BudgetObject [maNganSach=" + maNganSach + ", tongSoTien=" + tongSoTien + ", soTienDaChi=" + soTienDaChi
				+ ", soTienConLai=" + soTienConLai + ", trangThai=" + trangThai + ", maDA=" + maDA + "]";
	}
	
	
}
