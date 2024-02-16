package myLearn.myTest;

public class ShoppingMallV01DTO {
	private String id;
	private String pwd;
	private int account;
	private int[] cart;
	public Object cartTemp;

	// constructor
	public ShoppingMallV01DTO() {
	} // 기본 생성자

	public ShoppingMallV01DTO(String id, String pwd, int account, int[] cart) { // 매개변수 4개짜리 생성자
		this.id = id;
		this.pwd = pwd;
		this.account = account;
		this.cart = cart;
	}

	// ---------------------------------------/ ID
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// ---------------------------------------/ PWD
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	// ---------------------------------------/ account
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	// ---------------------------------------/ cart
	public int[] getCart() {
		return cart;
	}

	public void setCart(int[] cart) {
		this.cart = cart;
	}
}