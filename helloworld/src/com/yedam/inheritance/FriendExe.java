package com.yedam.inheritance;

/*
 * 상속.
 * 친구1 : 이름, 연락처
 * 친구2 : 이름, 연락처, 학교, 학과
 * 친구3 : 이름, 연락처, 회사, 부서
 */
public class FriendExe {

	public static void main(String[] args) {
		Friend[] friends = new Friend[10];
		
		//instance.
		Friend f1 = new Friend("홍길동", "010-1111-2222");
		//System.out.println(f1);
		UnivFriend f2 = new UnivFriend("김자식", "010-1111-1111", "우리학교", "역사학과");
		//System.out.println(f2);
		CompanyFriend f3 = new CompanyFriend("김영식", "010-2323-2323", "아마존", "개발팀");
		
		//타입이 Friend인데 자식으로 넣을 수 있는 이유는 '다형성'을 사용하기 위함이다.
		//부모에서 자식으로 값을 넣으면 '다운캐스팅'이된다.
		friends[0] = new UnivFriend("권자감", "010-3344-5566", "저희학교", "사회학과");
		friends[1] = new Friend("강길동", "010-2222-3333");
		friends[2] = new CompanyFriend("이사원", "010-5678-9453", "우리회사", "사무원");
		friends[3] = f1;
		friends[4] = f2;
		friends[5] = f3;
		
		
		for (Friend fri : friends)
			if (fri != null)
				System.out.println(fri);
		System.out.println();
		//각각 알맞는 클래스의 toString()로 이동을 한다.
		//이를 동적바인딩이라고 한다.
		
		//형변환
		int num = 20;
		double num2 = num; //자동형변환. promotion
		num = (int)num2; //강제형변환. casting
		
		//업캐스팅
		Friend f4 = new CompanyFriend("김무열", "010-1111-1111", "자회사", "인사팀");
		
		//다운캐스팅
		CompanyFriend cf = (CompanyFriend)f4;
		System.out.println(cf);
		System.out.println("회사이름 : "+cf.getCompany());
		
		//Friend -> CompanyFriend로 캐스팅을 하면,
		//Friend에서 CompanyFriend의 정보가 없기 때문에 ClassCastException가 발생한다.
		//cf = (CompanyFriend)new Friend("박성길", "010-1111-5555");
		Friend f5 = new Friend("박성길", "010-1111-5555");
		if (f4 instanceof CompanyFriend) {
			CompanyFriend temp = (CompanyFriend)f4;
			System.out.println(temp);
			System.out.println("회사이름 : "+temp.getCompany());
		} else {
			System.out.println("Casting을 할 수 없습니다.");
		}
	}

}
