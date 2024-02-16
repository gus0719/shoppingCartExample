package myLearn.myTest;

public class ShoppingMallV01Main {
	public static void main(String[] args) {
		// 모든 유저 정보 확인용
		ShoppingMallV01DAO dao = new ShoppingMallV01DAO();
		dao.dtoSet();
		dao.printInfo();

		MemberLoginV01 member = new MemberLoginV01();
		member.memberMenu();
	}
}