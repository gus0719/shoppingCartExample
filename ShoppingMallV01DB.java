package myLearn.myTest;

public class ShoppingMallV01DB {
	String[][] items = {
			// 상품코드, 분류, 상품명, 가격
			{ "1", "OUTER", "자켓", "80000" },
			{ "2", "OUTER", "코트", "200000" },
			{ "3", "OUTER", "패딩", "280000" },
			{ "4", "OUTER", "래더", "70000" },
			{ "5", "SHIRT", "stripe 셔츠", "40000" },
			{ "6", "SHIRT", "check 셔츠", "35000" },
			{ "7", "TOP", "반팔 티", "20000" },
			{ "8", "TOP", "긴팔 티", "40000" },
			{ "9", "TOP", "후드 티", "60000" },
			{ "10", "TOP", "니트", "50000" },
			{ "11", "BOTTOM", "슬랙스", "30000" },
			{ "12", "BOTTOM", "청바지", "40000" },
			{ "13", "BOTTOM", "면바지", "20000" },
			{ "14", "SHOES", "운동화", "70000" },
			{ "15", "SHOES", "구두", "90000" },
			{ "16", "SHOES", "슬리퍼", "10000" }
	};

	// 고객 ID
	String[] id = { "CUST01", "CUST02", "CUST03", "CUST04", "CUST05" };

	// 고객 비밀번호
	String[] pwd = { "1234", "1234", "1234", "1234", "1234" };

	// 고객 잔액
	// int[] account = {0, 0, 0, 0, 0};
	int[] account = new int[id.length]; // 호환성

	// 장바구니
	int[][] cart = new int[id.length][items.length];
	// items의 길이만큼 담을 수 있는 크기
	// cart 초기화 : 0 0 0 0 ... 0
}