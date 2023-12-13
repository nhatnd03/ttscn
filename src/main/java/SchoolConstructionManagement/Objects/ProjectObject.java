package SchoolConstructionManagement.Objects;

public class ProjectObject {
	private int maDA; 
	private String tenDA; 
	private String ngayBatDau; 
	private String ngayKetThuc; 
	private String tienDo; 
	private String moTaDA; 
	private int maQL; 
	private int maTN;
	
	public ProjectObject() {
		
	}

	public ProjectObject(int maDA, String tenDA, String ngayBatDau, String ngayKetThuc, String tienDo, String moTaDA, int maQL,
			int maTN) {
		super();
		this.maDA = maDA;
		this.tenDA = tenDA;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tienDo = tienDo;
		this.moTaDA = moTaDA;
		this.maQL = maQL;
		this.maTN = maTN;
	}
	public ProjectObject(String tenDA, String ngayBatDau, String ngayKetThuc, String tienDo, String moTaDA) {
		super();
		
		this.tenDA = tenDA;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tienDo = tienDo;
		this.moTaDA = moTaDA;
		
	}

	public int getMaDA() {
		return maDA;
	}

	public String getTenDA() {
		return tenDA;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public String getMoTaDA() {
		return moTaDA;
	}

	public int getMaQL() {
		return maQL;
	}

	public int getMaTN() {
		return maTN;
	}

	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}
	
	public String getTienDo() {
		return tienDo;
	}

	public void setTienDo(String tienDo) {
		this.tienDo = tienDo;
	}
	public void setTenDA(String tenDA) {
		this.tenDA = tenDA;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public void setMoTaDA(String moTaDA) {
		this.moTaDA = moTaDA;
	}

	public void setMaQL(int maQL) {
		this.maQL = maQL;
	}

	public void setMaTN(int maTN) {
		this.maTN = maTN;
	}

	@Override
	public String toString() {
		return "ProjectObject [maDA=" + maDA + ", tenDA=" + tenDA + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + ", tienDo=" + tienDo + ", moTaDA=" + moTaDA + ", maQL=" + maQL + ", maTN=" + maTN + "]";
	}

	
	
	
}
