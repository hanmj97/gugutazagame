package sansung;


public class Sansung_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");		
		Sansung_nick gui = new Sansung_nick();  //닉네임 설정 화면 띄우기
		
		
	}
	
	// 닉네임 클래스 , 닉네임 가지고 showGameView 메소드 실행 
	public void showGameView(String nick){
		System.out.println("showGameView - nick : "+nick);		
		Sansung_game game = new Sansung_game(nick);// 닉네임 가지고 게임화면 띄우기 
		
	}
	
	public void showShort(Sansung_nick gui, String nick)
	{
		
		shortType Type = new shortType(nick);//닉네임 가지고 짧은 글 실행
	}
	

}
