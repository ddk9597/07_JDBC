package Properties.model.dto;

public class Properties {

	private int PORPERTIES_NO;		// 매물 번
	private String LOCATION_TITLE;	// 법정동 이름
	private String ADDRESS_NO;		// 상세주소
	private String SHOP_NAME;		// 상호
	private String CATEGORY;		// 매물 종류(상가, 사무실)
	private String CONTACT_INFO;	// 관리인 연락처
	private String FLOOR;			// 층수
	private int PY;					// 면적(평)
	private int PREMIUM;			// 권리금
	private int DEPOSIT;			// 보증금
	private int RENT;				// 월세
	private int ADMIN_COST;			// 관리비
	private String NOTE;			// 기타사항
	
	// 기본 생성자
	public Properties() {	}
	
	// 매개변수 생성자(매물 목록 조회)
	public Properties(int PORPERTIES_NO, String lOCATION_TITLE, String CATEGORY, String CLOOR, int PY, int PREMIUM,
			int DEPOSIT, int RENT, int ADMIN_COST) {
		super();
		PORPERTIES_NO = PORPERTIES_NO;
		LOCATION_TITLE = lOCATION_TITLE;
		CATEGORY = CATEGORY;
		FLOOR = FLOOR;
		PY = PY;
		PREMIUM = PREMIUM;
		DEPOSIT = DEPOSIT;
		RENT = RENT;
		ADMIN_COST = ADMIN_COST;
	}
	
	
	
	
}
