package myLearn.myTest;

import java.util.Scanner;

public class MemberLoginV01{
	UserAPI line = new UserAPI();
	Scanner scan = new Scanner(System.in);
	ShoppingMallV01DB db = new ShoppingMallV01DB();
	ShoppingMallV01DAO dao = new ShoppingMallV01DAO();
	ShoppingMallV01DTO[] dto = dao.dtoSet();

	int flag;   // 유저 정보 상태 확인용

	void intro(){
		System.out.println();
		line.mLine('=', 50);
		System.out.println("\tShopping Mall V01");
		line.mLine('=', 50);
	}
	void userId(String id){
		System.out.printf("\t+%1$s+\n\t|\t### %2$s 님 Login ###\t\t|\n\t+%1$s+\n", line.mLineReturn('-', 39), id);
	}
	void menu(){
		System.out.printf("\t+%s+\n", line.mLineReturn('-', 39));
		System.out.println("\t1. 장바구니 담기");
		System.out.println("\t2. 결제하기");
		System.out.println("\t3. 포인트 충전");
		System.out.println("\n\tQ. 로그아웃");
		System.out.printf("\t%s\n", line.mLineReturn('-', 41));
		System.out.print("\t메뉴 선택 [로그아웃 : Q] : ");
	}
	void printLogin(ShoppingMallV01DTO[] dtoArr){
        // 고객정보 객체배열 dtoArr[]를 매개변수로 받음
		System.out.println("\n\t로그인이 필요한 서비스입니다.\n\n");
		System.out.print("아이디를 입력해주세요[종료 : EXIT] : ");
		String inputId = scan.nextLine();
		if(inputId.length() == 0){  // 입력값의 길이가 0이라면
			flag = 0;
			return;
		}
		if(inputId.equalsIgnoreCase("exit")){
			System.out.println("시스템을 종료합니다.\n");
			System.exit(0);
		}else{
			for(int idx = 0; idx < dtoArr.length; idx++){// 계정 Chk
				if(inputId.equals(dtoArr[idx].getId())){	// ID Chk
					System.out.print("비밀번호를 입력해주세요. : ");
					String inputPwd = scan.nextLine();
					if(inputPwd.equals(dtoArr[idx].getPwd())){	// 고객정보 객체배열의 idx번째 비밀번호 비교
						flag = 1;   // 계정이 존재하면 flag 상태를 1로 갱신
						custMenu(dtoArr[idx]);	// 계정 메뉴 출력
						return; // custMenu를 빠져나오면 printLogin 메소드 종료
					}else{
						System.out.println("\t 비밀번호를 확인하세요.");
						flag = 0;   // 비밀번호 불일치시 flag 상태 0으로 갱신
						return;
					}
				}
				if(!(inputId.equals(dtoArr[idx].getId()))){
					flag = 0;   // 고객정보 객체배열의 idx 번째에 있는 idx가 존재하지 않는다 -> ID를 찾을 수 없다는 의미
					continue;
				}
			}
		}
		if(flag == 0){	// 로그인 상태 유무
			System.out.println("\t아이디를 확인하세요.");
			return;
		}
	}
	void custMenu(ShoppingMallV01DTO dtoObj){
        // 고객정보 객체 dtoObj를 매개변수로 받음
		userId(dtoObj.getId());
        // %1$s : mLineReturn / %2$s : dtoObj.getId()
		while(true){
			menu();
			String read = scan.nextLine();
			if(read.length() == 0 || read.length() > 1){
				System.out.println("\t\t메뉴를 선택하세요\n");
				continue;
			}
			if(read.equalsIgnoreCase("Q")){
				System.out.printf("\t%1$s\n\t\t%2$s님 로그아웃\n\t%1$s\n", line.mLineReturn('-', 30), dtoObj.getId());
				return;
			}
			if(read.charAt(0) >='1' && read.charAt(0) <= '3'){
				switch(Integer.parseInt(read)){
					case 1:
						dao.printItems(dtoObj); // dtoObj 객체 전달
						break;
					case 2:
						System.out.println("\t\t결제하기 Algorithm\n");
						break;
					case 3:
						System.out.println("\t\t포인트 충전 Algorithm\n");
						break;
				}
			}else{
				System.out.println("\t\t메뉴를 선택하세요\n");
				continue;
			}
		}
	}
	void memberMenu(){
		while(true){
			intro();
			printLogin(dto);    // 매개변수로 dto 객체배열 전달	
		}
	}
}