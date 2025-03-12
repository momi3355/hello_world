package com.yedam.variable;

import java.util.Scanner;

public class VarExe7 {
	public static void main(String[] args) {
		final int MAX_MEMBER = 100;
		Scanner scn = new Scanner(System.in);
		
		//사용자가 메뉴값을 입력.
		//목록에 대한 프로그램.
		//1. 추가 2. 수정 3. 삭제 4. 목록출력 5. 종료

		boolean run = true;
		int last_index = 0;
		Member[] storage = new Member[MAX_MEMBER];
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("김민혁", 86);
		storage[2] = new Member("한수아", 90);
		storage[3] = new Member("김수자", 82);
		last_index = 4;
		
		while (run) {
			System.out.println("1. 등록 2. 수정 3. 삭제 4. 출력 5. 평균 6.종료");
			System.out.print(">_");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1: //등록
				System.out.print("이름 >>_");
				String name = scn.nextLine();
				System.out.print("점수 >>_");
				int score = Integer.parseInt(scn.nextLine());
				
				if (last_index != 0) { /* 같은 이름을 찾는 로직 */
					for (int i = 0; i < last_index; i++) {
						if (storage[i].getName().equals(name)) {
							System.out.println("같은 이름을 넣을 수 없습니다.");
							break;
						}
					}
				}
				
				Member addMember = new Member(); //인스턴스 생성
				addMember.setName(name);
				addMember.setScore(score);
				if (addMember.getScore() < 0 || addMember.getScore() > 100) {
					System.out.println("점수가 올바르지 않습니다.");
					break;
				}
				storage[last_index++] = addMember;
				System.out.println("성공적으로 등록이 되었습니다.");
				break;
			case 2: //수정
				if (last_index == 0) {
					System.out.println("요소가 없습니다.");
					break;
				}
				
				System.out.print("수정할 이름 >>_");
				int modify_index = -1;
				String modifyName = scn.nextLine();
				for (int i = 0; i < last_index; i++) {
					if (storage[i].getName().equals(modifyName)) {
						modify_index = i;
						break;
					}
				}
				if (modify_index != -1) {
					System.out.print("점수 >>_");
					int modifyScore = Integer.parseInt(scn.nextLine());
					if (modifyScore < 0 || modifyScore > 100) {
						System.out.println("점수가 올바르지 않습니다.");
						break;
					}
					storage[modify_index].setScore(modifyScore);
					System.out.println("성공적으로 수정이 되었습니다.");
				} else {
					System.out.println("이름을 찾을 수 없습니다.");
				}
				break;
			case 3: //삭제
				if (last_index == 0) {
					System.out.println("요소가 없습니다.");
					break;
				}
				
				System.out.print("삭제할 이름 >>_");
				String removeName = scn.nextLine();
				int removeIndex = -1;
				for (int i = 0; i < last_index; i++) {
					if (storage[i].getName().equals(removeName)) {
						removeIndex = i;
					}
				}
				
				if (removeIndex != -1) { //이름을 찾은 경우
					//배열의 빈 공간이 없게 좌로 이동하는 로직.
					for (int i = removeIndex; i < last_index - 1; i++) {
						storage[i] = storage[i + 1];
					}
					last_index--;
					System.out.println("성공적으로 삭제되었습니다.");
				} else {
					System.out.println("이름을 찾을 수 없습니다.");
				}
				break;
			case 4: //출력
				for (int i = 0; i < last_index; i++) {
					Member element = storage[i];
					System.out.println((i+1)+". "+element.getName()+":"+element.getScore());
				}
				break;
			case 5:
				int sum = 0;
				for (int i = 0; i < last_index; i++)
					sum += storage[i].getScore();
				String avg = String.format("%.2f", (sum * 1.0 / last_index));
				System.out.println("학생의 평균은: "+avg+"입니다.");
				break;
			case 6: run = false; break;
			default:
				System.out.println("값을 잘못 입력 하셨습니다.");
				break;
			}
		}
		scn.close();
		System.out.println("end of prog.");
	} //end of main();
}
