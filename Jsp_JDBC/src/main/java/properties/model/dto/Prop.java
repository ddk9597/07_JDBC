package properties.model.dto;

import java.io.FileInputStream;

public class Prop {

	private int propertiesNo;		// 매물 번호
	private String locationTitle;	// 법정동 이름
	private String adressNo;		// 상세주소
	private String shopName;		// 상호
	private String category;		// 매물 종류(상가, 사무실)
	private String contactInfo;	// 관리인 연락처
	private String floor;			// 층수
	private int py;					// 면적(평)
	private int premium;			// 권리금
	private int deposit;			// 보증금
	private int rent;				// 월세
	private int adminCost;			// 관리비
	private String note;			// 기타사항
	
	
	// 기본 생성자
	public Prop() {}
	
	// 매개변수 생성자(매물 목록 조회)
	public Prop(int propertiesNo, String locationTitle, int py, String floor,  int premium,
			int deposit, int rent, int adminCost) {
		super();
		this.propertiesNo = propertiesNo;
		this.locationTitle = locationTitle;
		this.py = py;
		this.floor = floor;
		this.premium = premium;
		this.deposit = deposit;
		this.rent = rent;
		this.adminCost = adminCost;
	}
	

	public int getPropertiesNo() {
		return propertiesNo;
	}

	public void setPropertiesNo(int propertiesNo) {
		this.propertiesNo = propertiesNo;
	}

	public String getLocationTitle() {
		return locationTitle;
	}

	public void setLocationTitle(String locationTitle) {
		this.locationTitle = locationTitle;
	}

	public String getAdressNo() {
		return adressNo;
	}

	public void setAdressNo(String adressNo) {
		this.adressNo = adressNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getAdminCost() {
		return adminCost;
	}

	public void setAdminCost(int adminCost) {
		this.adminCost = adminCost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Prop [propertiesNo=" + propertiesNo + ", locationTitle=" + locationTitle + ", adressNo=" + adressNo
				+ ", shopName=" + shopName + ", category=" + category + ", contactInfo=" + contactInfo + ", floor="
				+ floor + ", py=" + py + ", premium=" + premium + ", deposit=" + deposit + ", rent=" + rent
				+ ", adminCost=" + adminCost + ", note=" + note + "]";
	}

	

}
