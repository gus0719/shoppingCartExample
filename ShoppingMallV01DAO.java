package myLearn.myTest;

import java.util.Arrays;
import java.util.Scanner;

public class ShoppingMallV01DAO {
	UserAPI line = new UserAPI();
	Scanner scan = new Scanner(System.in);
	ShoppingMallV01DB db = new ShoppingMallV01DB();

	// 데이터 설정
	ShoppingMallV01DTO[] dto = new ShoppingMallV01DTO[db.id.length];

	ShoppingMallV01DTO[] dtoSet() { // DTO배열 객체에 대한 dtoSet 메소드 생성
		// dto라는 배열 객체에 db의 id 배열 길이 만큼 객체 생성
		String id;
		String pwd;
		int account;
		int[] cart;

		for (int idx = 0; idx < db.id.length; idx++) {
			id = db.id[idx];
			pwd = db.pwd[idx];
			account = db.account[idx];
			cart = db.cart[idx];

			dto[idx] = new ShoppingMallV01DTO(id, pwd, account, cart);
			// dto배열객체의 idx번째(사람 수)마다 id와 pwd, account, cart 대입
		}
		return dto; // dto 객체 반환
	}

	void printItems(ShoppingMallV01DTO dtoObj) {
		String code; // 상품 코드
		String model; // 상품 분류
		String product; // 상품 이름
		int price; // 상품 가격

		System.out.printf("\n%s\n", line.mLineReturn('=', 70));
		System.out.println("\t\t\t상품 목록");
		System.out.printf("\n%s\n", line.mLineReturn('=', 70));
		System.out.println("상품 코드\t분류\t\t상품명\t\t\t가격");
		System.out.printf("\n%s\n", line.mLineReturn('=', 70));
		for (int idx = 0; idx < db.items.length; idx++) {
			code = db.items[idx][0]; // items 배열의 idx번째 행 상품 코드
			model = db.items[idx][1]; // items 배열의 idx번째 행 상품 분류
			product = db.items[idx][2]; // items 배열의 idx번째 행 상품 이름
			price = Integer.parseInt(db.items[idx][3]); // items 배열의 idx번째 행 상품 가격

			System.out.printf("%5s\t\t%-5s\t\t%-8s\t\t%,7d\n", code, model, product, price);
			// %5s Ex] 100 -> __100
			// %-5s Ex] 100 -> 100__
		}
		System.out.printf("\n%s\n", line.mLineReturn('=', 70));
		while (true) {
			int[] cartTemp = dtoObj.getCart(); // 기존 고객정보 객체배열의 카트를 받아옴
			int cartIdx = 0; // 카트를 받아와서 입력돼있던 인덱스를 기억하는 용도
			for (int idx = 0; idx < cartTemp.length; idx++) {
				if (cartTemp[idx] == 0) { // cartTemp에 0이 있으면
					cartIdx = idx; // 0이 있는 인덱스를 초기값
					break;
				}
			}
			cart: for (int idx = cartIdx; idx < db.cart[0].length; idx++) {
				// 0이 있는 인덱스부터 시작; cart의 길이만큼
				System.out.printf("\t\t %2$s의 장바구니 -> %1$s\n\n", Arrays.toString(dtoObj.getCart()), dtoObj.getId());
				// 현재 나의 장바구니 상태 출력
				System.out.print("\t장바구니에 담을 상품의 상품코드를 입력하세요[돌아가기 : Q] : ");
				String read = scan.nextLine();
				if (read.length() == 0) {
					System.out.println("\t^ 장바구니에 담을 상품을 선택하세요.");
					idx--; // 입력하고자 하는 자리로 돌아가기 위함
					continue;
				}
				if (read.equalsIgnoreCase("Q")) {
					System.out.println("\t돌아가기 ↘");
					dtoObj.setCart(cartTemp); // 호출한 곳으로 돌아가기 전에 내 장바구니 정보 저장
					// printItems 메소드 재 호출시 DTO 클래스에서 기억하고 있는 cart 배열을 받아오기
					return;
				}
				if (read.charAt(0) < '0' || read.charAt(0) > '9') {
					// 입력값이 숫자가 아니라면
					System.out.println("\t^ 상품코드(숫자)를 입력하세요.");
					idx--; // 내가 입력하고자 하는 cartTemp(장바구니)의 인덱스로 이동
					continue;
				}
				if(Integer.parseInt(read) > db.items.length || Integer.parseInt(read) == 0) {
					System.out.println("\t^ 있는 상품을 선택하세요");
					idx--;
					continue;
				}
				cartTemp[idx] = Integer.parseInt(read); // cartTemp 배열의 idx 번째에 입력값 할당

				for (int idx2 = idx - 1; idx2 >= 0; idx2--) {
					if (cartTemp[idx2] == Integer.parseInt(read)) {
						cartTemp[idx] = 0; // 장바구니에 중복된 상품 코드가 있으면 비우기
						System.out.printf("\t\t^ 상품 %s는 이미 선택된 상품입니다.\n",
								Arrays.toString(db.items[Integer.parseInt(read) - 1]));
						// items 배열의 (read-1)번째 상품 정보 출력
						idx--; // 입력하고자 하는 자리로 돌아가기 위함
						continue cart;
					}
				}
				System.out.printf("\t\t^ 장바구니 After Chk -> %s\n", Arrays.toString(cartTemp)); // 장바구니 출력
			}
		}
	}

	void printInfo() {
		for (int idx = 0; idx < db.id.length; idx++) {
			System.out.printf("계정 : %s\t", dto[idx].getId());
			System.out.printf("비밀번호 : %s\t", dto[idx].getPwd());
			System.out.printf("계좌 : %d\n", dto[idx].getAccount());
			System.out.printf("장바구니 -> %s\n\n", Arrays.toString(dto[idx].getCart()));
		} // 유저들의 정보 확인용도
	}
}