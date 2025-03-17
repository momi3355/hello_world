package com.yedam.bookapp;

import java.text.DecimalFormat;
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
	private static final int MAX_BOOK = 100;
	private static BookManager instance;

	private Book[] bookStore;
	private User[] userData;
   
	private User useUser;
	private Scanner scn;
	private int lastIndex = 0;
	
	private BookManager() {
	   setupUserData();
	   setupBookStore();
	   lastIndex = 4;
	}
	
	public static BookManager getInstance() {
		if (instance == null) //생성되지 않았으면 생성.
			instance = new BookManager();
		instance.useUser = null; //사용자 초기화
		return instance;
	}
	
	private void setupUserData() {
	   userData = new User[3];
	   userData[0] = new User("user", "김유저", "user");
	   userData[1] = new User("test", "테스트", "test");
       userData[2] = new User("root", "관리자", "root");
	}
	
	private void setupBookStore() {
	   bookStore = new Book[MAX_BOOK];
	   bookStore[0] = new BookBuilder("이것이 자바다.")
            .setPublisher("한빛미디어")
            .setAuthor("신용권")
            .setPrice(20000)
            .setOrderNo(3).build();
      bookStore[1] = new BookBuilder("쓰면서 익히는 알고리즘과 자료구조")
            .setPublisher("한빛미디어")
            .setAuthor("윤대석")
            .setPrice(25000)
            .setOrderNo(4).build();
      bookStore[2] = new BookBuilder("파이썬 정복")
            .setPublisher("한빛미디어")
            .setAuthor("김상형")
            .setPrice(20000)
            .setOrderNo(1).build();
      bookStore[3] = new BookBuilder("전문가를 위한C")
            .setPublisher("한빛미디어")
            .setAuthor("캄란 아미니")
            .setPrice(50000)
            .setOrderNo(2).build();
//    bookStore[4] = new BookBuilder("게임 프로그래밍 패턴")
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
	
	private boolean login() {
		System.out.print("id입력>>_");
		String id = scn.nextLine();
		System.out.print("pw입력>>_");
		String pw = scn.nextLine();
		return login(id, pw);
	}
	private boolean login(String userId, String password) {
		String userName = "";
		for (User item : userData)
			if (item.getUserId().equals(userId) && item.getPassword().equals(password))
				userName = item.getUserName();
		return login(new User(userId, userName, password));
	}
	private boolean login(User user) {
		for (User item : userData) {
			if (item.equals(user)) {
				useUser = item;
				break;
			}
		}
		return useUser != null;
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 <b>정렬</b>하는 메소드.
	 */
	private void sort() {
		//버블정렬		
		for (int i = lastIndex - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (bookStore[j].getOrderNo() > bookStore[j + 1].getOrderNo()) {
					Book temp = bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * 마지막 순서를 리턴하는 메소드.
	 * @return 마지막 순서
	 */
	private int getSequnceNo() {
		int max = 0;
		for (int i = 0; i < lastIndex; i++) {
			if (bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		
		return max + 1; //현재 마지막 번호 + 1;
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
		} else if (findBook(bookStore, lastIndex, addTitle) != -1) {
			System.out.println("입력한 책이 이미 존재합니다.");
			return;
		}
		
		System.out.print("작가 >>_");
		String addAuther = scn.nextLine();
		System.out.print("출판사 >>_");
		String addPub = scn.nextLine();
		System.out.print("가격 >>_");
		int addPrice = Integer.parseInt(scn.nextLine());
		
		bookStore[lastIndex] = new BookBuilder(addTitle)
				.setAuthor(addAuther)
				.setPublisher(addPub)
				.setPrice(addPrice)
				.setOrderNo(getSequnceNo())
				.build();
		lastIndex++;
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 수정하는 메소드.
	 * @see Book
	 */
	void modiyBook() {
		if (lastIndex == 0) {
			System.out.println("요소가 없습니다.");
			return;
		}
		System.out.print("수정할 ");
		int modiy_idx = findBook(bookStore, lastIndex, scn);
		if (modiy_idx != -1) {
			System.out.println("수정할 데이터를 선택하세요.");
			System.out.println("1.작가 2.출판사 3.가격");
			System.out.print("_>> ");
			int modiy_menu = Integer.parseInt(scn.nextLine());

			switch (modiy_menu) {
			case 1: //작가
				System.out.print("작가 >>_");
				bookStore[modiy_idx].setAuthor(scn.nextLine());
				System.out.println("성공적으로 수정되었습니다.");
				break;
			case 2: //출판사
				System.out.print("출판사 >>_");
				bookStore[modiy_idx].setPublisher(scn.nextLine());
				System.out.println("성공적으로 수정되었습니다.");
				break;
			case 3: //가격
				System.out.print("가격 >>_");
				bookStore[modiy_idx].setPrice(Integer.parseInt(scn.nextLine()));
				System.out.println("성공적으로 수정되었습니다.");
				break;
			default:
				System.out.println("값을 잘못 입력 하셨습니다.");
			}
		} else System.out.println("제목을 찾을 수 없습니다.");
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 삭제하는 메소드.
	 * @see Book
	 */
	void removeBook() {
		if (lastIndex == 0) {
			System.out.println("요소가 없습니다.");
			return;
		}
		System.out.print("삭제할 ");
		int remove_idx = findBook(bookStore, lastIndex, scn);
		if (remove_idx != -1) {
			int orderNum = bookStore[remove_idx].getOrderNo();
			for (int i = 0; i < lastIndex ; i++) {
				int tempOrder = bookStore[i].getOrderNo();
				if (orderNum < tempOrder)
					bookStore[i].setOrderNo(tempOrder - 1);
				//개체(entity)가 하나가 줄어들기 때문에 순번도 하나식 뺀다.
				if (i >= remove_idx && i < lastIndex - 1)
					bookStore[i] = bookStore[i + 1];
			}
			lastIndex--;
			System.out.println("성공적으로 삭제가 되었습니다.");
		} else System.out.println("제목을 찾을 수 없습니다.");
	}
	
	private int[] getLength() {
		return getLength(bookStore, lastIndex);
	}
	private int[] getLength(Book[] list, int index) {
		int titleLength = 0;
		int authorLength = 0;
		
		for (int i = 0; i < index; i++) {
			Book b = list[i];
			String title = b.getTitle();
			String author = b.getAuthor();
			
			if (titleLength < title.length())   titleLength = title.length();
			if (authorLength < author.length()) authorLength = author.length();
		}
		return new int[] { titleLength, authorLength };
	}
	
	private String getTableHead() {
		return getTableHead(getLength());
	}
	private String getTableHead(int[] length) {
		int len = "제목".length();
		String str = "순번";
		str += "\t제목";
		for (int i = len; i < length[0]; i++) str += " ";
		str += "\t저자";
		for (int i = 0; i < length[1]; i++) str += " ";
		str += "\t가격";
		System.out.println(str);
		return str;
	}
	
	private void showBook(Book[] list) {
		int[] length = getLength();
		String th = getTableHead(length);
		//제목 == 저자 == 가격
		String line = "=";
		for (int i = 0; i < th.length()*1.6; i++) {
			line += "=";
		}

		sort();
		System.out.println(line);
		for (Book b : list) {
			System.out.println(b.getOrderNo()+"\t"
					+ b.showList(length[0], length[1] + 2));
		}
		System.out.println(line);
	}
	
	//listBook()와 publishInfo()에서 사용될 공통메소드.
	private Book[] searchBook(String publish) {
		int idx = 0;
		int[] index = new int[lastIndex];
		for (int i = 0; i < lastIndex; i++) {
			if (publish == null || bookStore[i].getPublisher().equals(publish)) {
				index[idx++] = i;
			}
		}
		Book[] list = new Book[idx];
		for (int i = 0; i < idx; i++) {
			list[i] = bookStore[index[i]];
		}
		return list;
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 <b>console</b>에 출력하는 메소드.
	 * @see Book
	 */
	void listBook() {
		if (lastIndex == 0) {
			System.out.println("요소가 없습니다.");
			return;
		}
		showBook(searchBook(null));
	}
	
	/**
	 * 책을 검색에서 상세정보를 출력하는 메소드.
	 * @see Book
	 */
	void bookInfo() {
		System.out.print("검색할 책 ");
		int info_idx = findBook(bookStore, lastIndex, scn);
		if (info_idx != -1) {
			Book info = bookStore[info_idx];
			
			System.out.println("책 제목 : "+info.getTitle());
			System.out.println("작가 : "+info.getAuthor());
			System.out.println("출판사 : "+info.getPublisher());
			DecimalFormat df = new DecimalFormat("#,###"); //천단위 콤마
			System.out.println("가격 : "+df.format(info.getPrice())+"원");
		} else System.out.println("제목을 찾을 수 없습니다.");
	}
	
	void publishInfo() {
		if (lastIndex == 0) {
			System.out.println("요소가 없습니다.");
			return;
		}
		System.out.print("검색할 출판사");
		System.out.print(" >_");
		String pub = scn.nextLine();
		
		Book[] list = searchBook(pub);
		if (list.length > 0) {
			showBook(list);
		} else {
			System.out.println("출판사를 찾을 수 없습니다.");
		}
	}
	
	/**
	 * <i>책 정보</i>({@code bookStore})를 리턴 하는 메소드.
	 * @return <b>bookStore</b> 책 정보 배열
	 * @see Book
	 */
	public Book[] getBooks() {
		return bookStore;
	}
	/**
	 * <i>책 정보</i>({@code bookStore})의 크기를 리턴 하는 메소드.
	 * @return <b>lastIndex</b>  책 정보 크기
	 * @see Book
	 */
	public final int getSize() {
		return lastIndex;
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
		System.out.println("환영합니다. "+useUser.getUserName()+"님!");
		
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
	
	private static int findBook(Book[] bookStore, int lastIndex, String title) {
		int idx = -1;
		for (int i = 0; i < lastIndex; i++) {
			if (bookStore[i].getTitle().equals(title)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	private static int findBook(Book[] bookStore, int lastIndex, Scanner scn) {
		System.out.println("제목을 입력하세요.");
		System.out.print(">_");
		String title = scn.nextLine();
		return findBook(bookStore, lastIndex, title);
	}
	
//	public static void main(String[] args) {
//		new BookManager().run();
//	}
}
