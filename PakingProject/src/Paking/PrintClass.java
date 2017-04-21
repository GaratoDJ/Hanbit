package Paking;

public class PrintClass implements constructor, time{
	void printLine(){
		System.out.println("================================================");
	}
	//초기 시작시에 빈자리를 출력  
	protected void setupVacancyPrint(int level, boolean a){
		if(a == true){
			System.out.println(level+"층의 빈자리는  없습니다");
		}else{
			System.out.println(level+"층은 주차 가능합니다.");
		}
	}
	//빈자리 검색 출력 메서드 
	protected void Vacancy(int num){
		switch(num){
			case 1:
				emptySpace.getOneKeyNum();
				System.out.print("현재 1층의 빈자리는 ");
				for(int i = 0; i<emptySpace.oneKey.size(); i++){
					System.out.print(emptySpace.oneKey.get(i)+", ");
				}
				System.out.println("입니다");
				break;
			case 2:
				emptySpace.getTwoKeyNum();
				System.out.print("현재 2층의 빈자리는 ");
				for(int i = 0; i<emptySpace.twoKey.size(); i++){
					System.out.print(emptySpace.twoKey.get(i)+", ");
				}
				System.out.println("입니다");
				break;
			case 3: 
				emptySpace.getTreeKeyNum();
				System.out.print("현재 3층의 빈자리는 ");
				for(int i = 0; i<emptySpace.threeKey.size(); i++){
					System.out.print(emptySpace.threeKey.get(i)+", ");
				}
				System.out.println("입니다");
				break;
		}	
	}
	//프린트 메뉴 메서드
	public void printMenu(String value){
		switch(value){
			case "start": 
				System.out.println("******************주차요금안내**********************"
								+ "\n*               기본 1시간 5000원                                         *"
								+ "\n*           1시간 초과시 시간당 2000원 추가                              *"
								+ "\n*           24시간 초과시 시간당 4000원 추가                            *"
								+ "\n************************************************");
				emptySpace.setupVacancy();
				printLine();
				System.out.println("1. 주차");
				System.out.println("2. 반차");
				System.out.println("3. 현재 요금확인");
				System.out.println("4. 종료");
				printLine();
				break;
			case "end":
				System.out.println("프로그램을 종료합니다. 정말 종료하시겠습니까?\n 종료하시려면 exit를 입력해주세요");
				break;
			case "line" : 
				printLine();
				break;
			case "reboot" :
				System.out.println("초기 메뉴로 돌아가시겠습니까? (1. 예 / 2. 종료)"); 
				break;
		}
	}
}
