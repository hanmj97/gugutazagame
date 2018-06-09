package sansung

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font; 


public class shortType extends JFrame implements ActionListener,KeyListener {
	
	private JTextField InputText;
	private JButton Start;
	private String[] Tmp = {"가는 날이 장날." ,"가는 말에 채찍질." ,"가는 말이 고와야 오는 말이 곱다." ,"가물에 콩 나듯 한다." ,"간에 기별도 안 간다." ,"간에 붙었다 쓸개에 붙었다 한다." ,"갓 쓰고 자전거 타는 격." ,"강 건너 불구경하듯 한다."
			,"강물도 쓰면 준다.", "개도 닷새가 되면 주인을 안다.", "거미도 줄을 쳐야 벌레를 잡는다.", "걷기도 전에 뛰려고 한다.", "계란으로 바위치기.", "구슬이 서 말이라도 꿰어야 보배.", "굶어 보아야 세상을 안다." , "그물에 든 고기."
			, "기르던 개에게 다리가 물렸다." , "나무에 오르라 하고 흔드는 격.", "날면 기는 것이 능하지 못하다." , "남아 일언 중천금." , "남의 말 하기는 식은 죽 먹기." , "남의 밥에 든 콩이 굵어 보인다." , "남의 잔치에 감 놔라 배 놔라 한다."
			, "낮말은 새가 듣고 밤말은 쥐가 듣는다." , "내 배가 부르니 종의 배고픔을 모른다." , "내일은 해가 서쪽에서 뜨겠네.", "누울 자리 봐 가며 발 뻗어라.", "느린 소도 성낼 적이 있다.", "다 된 밥에 재 뿌리기.", "닭에게는 보석이 보리알만 못하다."
			, "닭 쫓던 개 지붕 쳐다보듯 한다.", "도둑놈 문 열어 준 셈.", "도둑에게 열쇠 주는 격.", "도둑을 맞으려면 개도 안 짖는다.", "도둑이 없으면 법도 쓸데없다.", "도둑이 제 발 저리다.", "돌다리도 두드려 보고 건너라.", "등잔 밑이 어둡다."
			, "떡 줄 사람은 생각도 않는데 김칫국부터 마신다.", "똥 묻은 개가 겨 묻은 개 나무란다.", "말로 온 동네를 다 겪는다.", "말 안하면 귀신도 모른다.", "말이 고마우면 비지 사러 갔다 두부 사 온다.", "망건 쓰다 장 파한다.", "맞은 놈은 펴고 자고 때린 놈은 오그리고 잔다."
			, "모기 보고 칼 뺀다.", "모난 돌이 정 맞는다.", "모르면 약 아는 게 병.", "목구멍이 포도청.", "물에 빠진 놈 건져 놓으니 보따리 내놓으라 한다", "믿는 도끼에 발등 찍힌다.", "바늘 도둑이 소 도둑 된다.", "바다는 메워도 사람의 욕심은 못 채운다.", "발 없는 말이 천리 간다."
			, "배부른 흥정.", "사공이 많으면 배가 산으로 간다.", "사람 나고 돈 났지 돈 나고 사람 났나.", "새끼 많이 둔 소 길마 벗을 날 없다.", "새벽달 보자고 초저녁부터 기다린다.", "서당 개 삼 년이면 풍월을 읊는다.", "설마가 사람 잡는다.", "소도 언덕이 있어야 비빈다."
			, "소 잃고 외양간 고친다.", "손톱 밑에 가시 드는 줄은 알아도 염통 안이 곪는 것은 모른다.", "수염이 열 자라도 먹어야 양반.", "숭어가 뛰니까 망둥이도 뛴다.", "숯이 검정 나무란다.", "신선놀음에 도끼 자루 썩는 줄 모른다."
			, "쏟아 놓은 쌀은 주워 담을 수 있어도 쏟아 놓은 말은 주워 담을 수 없다.", "아는 길도 물어 가라.", "아흔아홉 가진 사람이 하나 가진 사람보고 백 개 채워 달라 한다.", "앞에서 꼬리치는 개가 뒤에서 발꿈치 문다.", "얌전한 고양이가 부뚜막에 먼저 올라간다."
			, "양지가 음지 되고 음지가 양지 된다.", "열 번 찍어 안 넘어가는 나무 없다.", "오르지 못할 나무는 쳐다보지도 말아라.", "옷이 날개다.", "웃는 낯에 침 뱉으랴.", "원수는 외나무다리에서 만난다.", "자라 보고 놀란 가슴 솥뚜껑 보고 놀란다. ", "저 먹자니 싫고 남 주자니 아깝다."
			, "제 눈에 안경이다.", "종로에서 뺨 맞고 한강에 가서 눈 흘긴다.", "죄지은 놈 옆에 있다가 벼락 맞는다.", "죽어 석 잔 술이 살아 한 잔 술만 못하다.", "쥐구멍에도 볕 들 날 있다.", "지렁이도 밟으면 꿈틀한다.", "집에서 새는 바가지 들에서도 샌다."
			, "참새가 방앗간을 그냥 지나랴.", "천 리 길도 첫 걸음으로 시작된다.", "칼로 물 베기.", "콩 심은 데 콩 나고 팥 심은 데 팥 난다.", "티끌 모아 태산.", "핑계 없는 무덤 없다.", "하늘의 별 따기.", "하늘이 무너져도 솟아날 구멍이 있다.", "하룻강아지 범 무서운 줄 모른다 ."
			, "한 귀로 듣고 한 귀로 흘린다.", "한 술 밥에 배 부르랴.", "함흥차사라.", "호랑이도 제 말 하면 온다."};
     
     //db로 바꿀예정.
		
	private JPanel contentPane;
	private Label label[] = new Label[10000];
	private JLabel AccurLabel;
	private JLabel TypingLabel;
	private JLabel timeLabel;
	private JButton back;
	private JTextPane textPane;
	private JPanel ShortText;
	private double Accur = 0.0;
	private int Typing = 0;
	Sansung_main main;
	long nStart;
	private String Nickname;
	private int nindex = 0;
	private JLabel label_1;
	private String bigyo;
	private int tllim=0;
	private String[] soonseo = {"","","","","",""};
	private int soon=0;
	private double speed = 0.0;
	
	
	private int geulza=0;
	
	private JPanel Result;
	private JButton okButton ;
	private JLabel resultAccurLabel;
	private JLabel resultTypingLabel;
	private JLabel NickLabel;
	
	private JPanel panel;
	
	DecimalFormat df = new DecimalFormat(".0");
	private JLabel Jinhang;
	
	
	
	public shortType(String nick)
	{
		Nickname = nick;
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("짧은 글 짓기");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ShortText = new JPanel(); // 글이 나오는 모음 패널.
		ShortText.setBounds(0, 0, 990, 450);
		contentPane.add(ShortText);
		ShortText.setLayout(null);
		
		label_1 = new JLabel(""); // 글을 출력하는 라벨.
		label_1.setFont(new Font("굴림", Font.PLAIN, 44));
		label_1.setBounds(5, 200, 985, 50);
		ShortText.add(label_1);
		
		textPane = new JTextPane(); // 하얀 텍스트공간.
		textPane.setBounds(5, 5, 985, 440);
		ShortText.add(textPane);
		
		
		
		Result = new JPanel(); //결과창 모음 패널.
		Result.setBounds(100, 100, 600, 480);
		Result.setVisible(false); // 초기에 보이지않음.
		
		panel = new JPanel(); // 기본 ui패널
		panel.setBounds(0, 0, 1275, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		back = new JButton("Back"); // 미구현.
		back.setBounds(1000, 630, 270, 50);
		panel.add(back);
		back.setVisible(false);
		
		AccurLabel = new JLabel(" 정확도 : " + Accur + "%"); // 정확도를 나타내 주는 라벨.
		AccurLabel.setBounds(1000, 10, 100, 50);
		panel.add(AccurLabel);
		
		TypingLabel = new JLabel("타수 : " + speed + "타/분"); // 타수를 나타내 주는 라벨.
		TypingLabel.setBounds(1000, 70, 110, 50);
		panel.add(TypingLabel);
		
		InputText = new JTextField(); // 라벨의 값과 비교하기 위한 입력 텍스트.
		InputText.setBounds(0, 460, 990, 211);
		panel.add(InputText);
		InputText.setFont(new Font("굴림", Font.PLAIN, 40));
		InputText.setColumns(40);
		
		Start = new JButton("Start"); //시작 버튼.
		Start.setBounds(1000, 570, 270, 50);
		panel.add(Start);
		
		timeLabel = new JLabel("경과시간 : 00 : 00"); // 경과시간을 보여주는 라벨
		timeLabel.setBounds(1000, 130, 110, 50);
		panel.add(timeLabel);
		
		Jinhang = new JLabel("진행상황 : "); // 현재 얼마나 진행되어있는지 상황을 알려주는라벨
		Jinhang.setBounds(1000, 500, 120, 20);
		panel.add(Jinhang);
		
		Start.addActionListener(this); // 시작 액션리스너
		InputText.disable(); // 시작하기전 입력칸 비활성화
		InputText.addKeyListener(this); // 텍스트필드에서 키보드를 누를 때의 키 리스너
		contentPane.add(Result); //결과창 추가
		Result.setLayout(null);
		
		NickLabel = new JLabel("이름: " + Nickname); // 이름받아온걸 넣어줌
		NickLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		NickLabel.setBounds(240, 80, 160, 50);
		Result.add(NickLabel);
		
		resultAccurLabel = new JLabel("정확도 : " + Accur +"%" ); // 위 라벨과 동일.
		resultAccurLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		resultAccurLabel.setBounds(240, 200, 150, 30);
		Result.add(resultAccurLabel);
		
		resultTypingLabel = new JLabel("타수 : " + speed +"타/분" ); // 위 라벨과 동일.
		resultTypingLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		resultTypingLabel.setBounds(220, 240, 200, 30);
		Result.add(resultTypingLabel);
		
		okButton = new JButton("OK"); // 종료와 db저장을 위한 버튼.
		okButton.setBounds(270, 340, 100, 100);
		Result.add(okButton);
		
		setVisible(true);
		okButton.addActionListener(this); //저장 종료 버튼리스너
	}
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) { // 엔터 시 작동하는 키리스너
			
			if (!InputText.getText().equals("")) { // 값이 있을 때 비교하는 메소드
				String inText = InputText.getText().toString(); // 텍스트필드값 저장.
				for (int i = 0; i < bigyo.length(); i++) {
					if(i>= inText.length()) { // 아직고민중.
						
					}
					if(bigyo.charAt(i) != inText.charAt(i)) { // 텍스트 비교.
						tllim++; // 틀린글자 추가.
						System.out.println(bigyo);
						System.out.println(inText);
						System.out.print("^");
						
					}
					else {
						System.out.print(" ");
						
						
					}
					
				}
				System.out.println();
				System.out.println(tllim);
				Accur = ((geulza-tllim)*1.0D/geulza)*100; // 정확도 계산 후 저장
				
				AccurLabel.setText("정확도 : " + df.format(Accur) + "%"); // 라벨수정 및 소수점 첫째자리까지 입력.
				InputText.setText("");//입력 텍스트필드 빈공간화.
			
			}
			if(soon<5)//배열이 4번째가 될때까지 작동
			{
				soon++;
				label_1.setText(soonseo[soon]);
				bigyo = soonseo[soon];
			}
			if (soon == 5) { // 끝에 도달시 
				
				InputText.disable();
			}
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_NUMPAD0 ||e.getKeyCode() == KeyEvent.VK_NUMPAD1 || e.getKeyCode() == KeyEvent.VK_NUMPAD2
				|| e.getKeyCode() == KeyEvent.VK_NUMPAD3 || e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_NUMPAD5 || e.getKeyCode() == KeyEvent.VK_NUMPAD6
				|| e.getKeyCode() == KeyEvent.VK_NUMPAD7 || e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_NUMPAD9 || e.getKeyCode() == KeyEvent.VK_MULTIPLY
				|| e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_SUBTRACT || e.getKeyCode() == KeyEvent.VK_DECIMAL || e.getKeyCode() == KeyEvent.VK_DIVIDE
				|| e.getKeyCode() == KeyEvent.VK_0|| e.getKeyCode() == KeyEvent.VK_1|| e.getKeyCode() == KeyEvent.VK_2|| e.getKeyCode() == KeyEvent.VK_3|| e.getKeyCode() == KeyEvent.VK_4
				|| e.getKeyCode() == KeyEvent.VK_5|| e.getKeyCode() == KeyEvent.VK_6|| e.getKeyCode() == KeyEvent.VK_7|| e.getKeyCode() == KeyEvent.VK_8|| e.getKeyCode() == KeyEvent.VK_9
				|| e.getKeyChar() == 'Q'|| e.getKeyChar() == 'W'|| e.getKeyChar() == 'E'|| e.getKeyChar() == 'R'|| e.getKeyChar() == 'T'
				|| e.getKeyChar() == 'Y'|| e.getKeyChar() == 'U'|| e.getKeyChar() == 'I'|| e.getKeyChar() == 'O'|| e.getKeyChar() == 'P'
				|| e.getKeyChar() == 'A'|| e.getKeyChar() == 'S'|| e.getKeyChar() == 'D'|| e.getKeyChar() == 'F'|| e.getKeyChar() == 'G'
				|| e.getKeyChar() == 'H'|| e.getKeyChar() == 'J'|| e.getKeyChar() == 'K'|| e.getKeyChar() == 'L'|| e.getKeyChar() == 'Z'
				|| e.getKeyChar() == 'X'|| e.getKeyChar() == 'C'|| e.getKeyChar() == 'V'|| e.getKeyChar() == 'B'|| e.getKeyChar() == 'N'
				|| e.getKeyChar() == 'M'|| e.getKeyCode()== KeyEvent.VK_PERIOD || e.getKeyCode()== KeyEvent.VK_COLON || e.getKeyCode()== KeyEvent.VK_COMMA || e.getKeyCode()== KeyEvent.VK_SLASH
				)
		{
			Typing++;
			speed = Typing/((System.currentTimeMillis() - nStart)*1.0D/1000/60);
			TypingLabel.setText("타수 : " + df.format(speed)  +"타/분");
			
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		System.out.println(Typing);
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			Typing--;
			speed = Typing/((System.currentTimeMillis() - nStart)*1.0D/1000/60);
			TypingLabel.setText("타수 : " + df.format(speed)  +"타/분");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a'|| e.getKeyChar() == 'b'|| e.getKeyChar() == 'c'|| e.getKeyChar() == 'd'|| e.getKeyChar() == 'e'|| e.getKeyChar() == 'f'
				|| e.getKeyChar() == 'g'|| e.getKeyChar() == 'h'|| e.getKeyChar() == 'i'|| e.getKeyChar() == 'j'|| e.getKeyChar() == 'k'|| e.getKeyChar() == 'l'
				|| e.getKeyChar() == 'm'|| e.getKeyChar() == 'n'|| e.getKeyChar() == 'o'|| e.getKeyChar() == 'p'|| e.getKeyChar() == 'q'|| e.getKeyChar() == 'r'
				|| e.getKeyChar() == 's'|| e.getKeyChar() == 't'|| e.getKeyChar() == 'u'|| e.getKeyChar() == 'v'|| e.getKeyChar() == 'b'|| e.getKeyChar() == 'w'
				|| e.getKeyChar() == 'x'|| e.getKeyChar() == 'y'|| e.getKeyChar() == 'z') {
			System.out.println(e.getKeyChar());
			Typing++;
			System.out.println(Typing);
			speed = Typing/((System.currentTimeMillis() - nStart)*1.0D/1000/60);
			TypingLabel.setText("타수 : " + df.format(speed)  +"타/분");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		geulza++;
    //영문구별 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Start) {
			
			int index = 0;
			Random random = new Random();
			
			double Dmin = 0.0;
			
			
			
			InputText.enable();
			nStart = System.currentTimeMillis();
			
			
			
			for (int i = 0; i< 5; i++)
			{
				nindex = random.nextInt(50);
				soonseo[i] = Tmp[nindex];
				for (int j = 0; j< i ; j++) {
					if(soonseo[j] == soonseo[i])
					{
						i--;
						break;
					}
				}
			}
			
			label_1.setText(soonseo[0]);;
			bigyo=soonseo[0];
			
			
			Start.setEnabled(false);
			new shortTime().start();
		}
		if(e.getSource() == back) {
			if (label_1 == "") {
				
			}
		
		}
		
		if(e.getSource() == okButton) { //db추가예정
			
			
			
			this.dispose();
		}
	}
	
	class shortTime extends Thread
	{
		private int time = 0;
		private int bun = 0;
		
		public void run()
		{
			while(true)
			{
				try {
					showTime();
					sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		private void showTime() {
			
			time ++;
			
			if(time == 60)
			{
				bun++;
				time = 0;
			}
			timeLabel.setText("경과시간 : " + bun+ " : " + time);
			
			speed = Typing/((System.currentTimeMillis() - nStart)*1.0D/1000/60);
			TypingLabel.setText("타수 : " + df.format(speed)  +"타/분");
			
			Jinhang.setText("진행상황 : " + (soon+1) +" / "+ "5");
			
			if (soon == 5) {
				resultAccurLabel.setText("정확도 : " + df.format(Accur) +"%" );
				resultTypingLabel.setText("타수 : " + df.format(speed)  +"타/분");
				setBounds(100, 100, 800, 600);
				ShortText.setVisible(false);
				panel.setVisible(false);
				Result.setVisible(true);
				
				
				
				this.stop();
				this.interrupt();
			}
		}
	}
	
}
