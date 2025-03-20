package com.yedam.bookapp;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	private enum Menu {
		NONE   (0),
		ADD    (1),
		MODIY  (2),
		REMOVE (3),
		LIST   (4),
		INFO   (5),
		PUBLISH(6),
		EXIT   (9);
		
		private final int value;
		private Menu(int value) {
			this.value = value;
		}
		private boolean compare(int i) {
			return value == i;
		}
		public static Menu getValue(int value) {
			Menu[] m = Menu.values();
			for (int i = 0; i < m.length; i++) {
				if (m[i].compare(value)) {
					return m[i];
				}
			}
			return Menu.NONE;
		}
	}
	private static BookManager instance;

	//private User[] userData;

	//JDBC 처리.
	private BookJdbc dao = new BookJdbc();
	private MemberJdbc mdao = new MemberJdbc(); 
	private String useUser;
	private Scanner scn;
	
	private BookManager() {
	   //setupBookStore();
	}
	
	public static BookManager getInstance() {
		if (instance == null) //생성되지 않았으면 생성.
			instance = new BookManager();
		instance.useUser = null; //사용자 초기화
		return instance;
	}
	
	private void setupBookStore() {
		System.out.println("dd");
		Book book = new BookBuilder("이것이 자바다.")
            .setPublisher("한빛미디어")
            .setAuthor("신용권")
            .setPrice(20000).build();
		dao.insert(book);
		book = new BookBuilder("쓰면서 익히는 알고리즘과 자료구조")
            .setPublisher("한빛미디어")
            .setAuthor("윤대석")
            .setPrice(25000).build();
		dao.insert(book);
		book = new BookBuilder("파이썬 정복")
            .setPublisher("한빛미디어")
            .setAuthor("김상형")
            .setPrice(20000).build();
		dao.insert(book);
		book = new BookBuilder("전문가를 위한C")
            .setPublisher("한빛미디어")
            .setAuthor("캄란 아미니")
            .setPrice(50000).build();
		dao.insert(book);
//    book = new BookBuilder("게임 프로그래밍 패턴")
//    .setPublisher("한빛미디어")
//    .setAuthor("로버트 나이스트롬")
//    .setPrice(35000).build();
	}
	
	public BookManager setup(String userId, String password) {
		login(userId, password);
		return this;
	}
	public BookManager setup(Scanner s, String userId, String password) {
		scn = s;
		login(userId, password);
		return this;
	}
	
	public String getUserName() {
		return useUser;
	}
	
	private boolean login() {
		System.out.print("id입력>>_");
		String id = scn.nextLine();
		System.out.print("pw입력>>_");
		String pw = scn.nextLine();
		return login(id, pw);
	}
	private boolean login(String userId, String password) {
		String user_name = mdao.login(userId, password);
		if (!user_name.isEmpty()) {
			useUser = user_name;
			return true;
		}
		return false;
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 추가하는 메소드.
	 * @see Book
	 */
	void addBook() {
		System.out.print("제목입력 >>_");
		String addTitle = scn.nextLine();
		if (addTitle.trim().length() == 0) {
			System.out.println("책 제목을 입력하지 않았습니다.");
			return;
		}
		
		System.out.print("작가 >>_");
		String addAuther = scn.nextLine();
		System.out.print("출판사 >>_");
		String addPub = scn.nextLine();
		System.out.print("가격 >>_");
		int addPrice = Integer.parseInt(scn.nextLine());
		
		Book book = new BookBuilder(addTitle)
				.setAuthor(addAuther)
				.setPublisher(addPub)
				.setPrice(addPrice).build();
		if (dao.insert(book))
			System.out.println("성공적으로 추가 되었습니다.");
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 수정하는 메소드.
	 * @see Book
	 */
	void modiyBook() {
		System.out.println("수정할 도서코드를 입력하세요.");
		System.out.print(">_");
		String bookCode = scn.nextLine();
		if (bookCode.length() <= 0) {
			System.out.println("도서코드를 반드시 입력.");
			return;
		}
		
		System.out.println("수정할 데이터를 선택하세요.");
		System.out.println("1.작가 2.제목 3.가격");
		System.out.print("_>> ");
		int modiy_menu = Integer.parseInt(scn.nextLine());
		
		String autor = "";
		String title = "";
		int price = 0;
		switch (modiy_menu) {
		case 1: //작가
			System.out.print("작가 >>_");
			autor = scn.nextLine();
			break;
		case 2: //출판사
			System.out.print("제목 >>_");
			title = scn.nextLine();
			break;
		case 3: //가격
			System.out.print("가격 >>_");
			price = Integer.parseInt(scn.nextLine());
			break;
		default:
			System.out.println("값을 잘못 입력 하셨습니다.");
		}
		if (price == 0) //값이 없으면 기본값
			price = dao.select(bookCode).getPrice();
		Book book = new BookBuilder(title)
				.setAuthor(autor)
				.setPrice(price).build();
		
		if (dao.update(bookCode, book))
			System.out.println("수정성공");
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 삭제하는 메소드.
	 * @see Book
	 */
	void removeBook() {
		System.out.println("삭제할 도서코드를 입력하세요.");
		System.out.print(">_");
		String bookCode = scn.nextLine();
		if (bookCode.length() <= 0) {
			System.out.println("도서코드를 반드시 입력.");
			return;
		}
		
		if (dao.delete(bookCode))
			System.out.println("성공적으로 삭제가 되었습니다.");
	}
	
	private void showBook(List<Book> list) {
		
		//제목 == 저자 == 가격
		System.out.println("도서번호 \t 제목 \t 저자 \t 가격");
		for (Book b : list)
			System.out.println(b.showList());
	}
	
	//listBook()와 publishInfo()에서 사용될 공통메소드.
	private List<Book> searchBook(String publish) {
		return dao.list(publish);
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 <b>console</b>에 출력하는 메소드.
	 * @see Book
	 */
	void listBook() {
		showBook(searchBook(null));
	}
	
	/**
	 * 책을 검색에서 상세정보를 출력하는 메소드.
	 * @see Book
	 */
	void bookInfo() {
		System.out.print("검색할 도서코드를 입력하세요. ");
		System.out.print(">_");
		String bookCode = scn.nextLine();
		
		Book info = dao.select(bookCode);
		
		System.out.println("책 제목 : "+info.getTitle());
		System.out.println("작가 : "+info.getAuthor());
		System.out.println("출판사 : "+info.getPublisher());
		DecimalFormat df = new DecimalFormat("#,###"); //천단위 콤마
		System.out.println("가격 : "+df.format(info.getPrice())+"원");
	}
	
	void publishInfo() {
		System.out.print("검색할 출판사");
		System.out.print(" >_");
		String pub = scn.nextLine();
		
		List<Book> list = searchBook(pub);
		if (list.size() > 0)
			showBook(list);
	}
	
	/**
	 * 책 데이터를 <b>추가</b>하거나 <b>삭제</b>하거나 하는 메소드<br>
	 *   이 메소드는 <b>console</b>로 작동을 하여 <i>데이터</i>를 수정합니다.
	 */
	public void run() {
		scn = new Scanner(System.in);
		if (useUser == null) {
			if (!login()) {
				System.out.println("아이디 비밀번호 중에 확인 하세요.");
				return;
			}
		} 
		System.out.println("환영합니다. "+getUserName()+"님!");
		
		boolean run = true;
		while(run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 6.목록조회(출판사) 9.종료");
			System.out.print("_>> ");
			Menu menu = Menu.NONE;
			try {
				menu = Menu.getValue(Integer.parseInt(scn.nextLine()));
				
				switch (menu) {
				case ADD    : addBook()    ; break; //추가
				case MODIY  : modiyBook()  ; break; //수정
				case REMOVE : removeBook() ; break; //삭제
				case LIST   : listBook()   ; break; //목록
				case INFO   : bookInfo()   ; break; //정보
				case PUBLISH: publishInfo(); break; //출판사 정보
				case EXIT: //종료
					run = false;
					break;
				default:
					System.out.println("숫자를 잘못 입력하셨습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하지 않았습니다.");
			}
		}
		System.out.println("end of prog.");
		//scn.close();
	}
}
