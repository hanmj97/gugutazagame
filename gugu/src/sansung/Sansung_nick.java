package sansung;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Sansung_nick extends JFrame implements ActionListener,KeyListener {
	
	private JTextField textField; // 닉 입력창
	
	public String Nick; // 닉네임입력
	private JLabel NewLabel_1; // 오류 문구
	private Sansung_main main ;
	
	public Sansung_nick() {
		main = new Sansung_main();
		
	 //화면 
		setSize(1280,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("산성비 게임");
		getContentPane().setLayout(null);
	
	
	JLabel NewLabel = new JLabel("구구 타자 연습"); // 닉네임
	NewLabel.setFont(new Font("궁서",Font.PLAIN,30)); //글씨체
	NewLabel.setBounds(550,30,380,30);
	getContentPane().add(NewLabel);
	
	textField = new JTextField(); //닉네임 입력창
	
	textField.setFont(new Font("궁서", Font.BOLD, 24));
	textField.setBounds(450,500, 238, 66);
	getContentPane().add(textField);
	textField.setColumns(20); // 10글자 미만
	
	
	JButton NewButton = new JButton("확인"); //확인버튼
	
	NewButton.setFont(new Font("궁서", Font.BOLD, 22));
	NewButton.setBounds(700, 500, 156, 66);
	getContentPane().add(NewButton);
	NewButton.addActionListener(this);
	
	NewLabel_1 = new JLabel("닉네임"); // 닉네임 라벨 
	NewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	NewLabel_1.setFont(new Font("궁서", Font.BOLD, 19));
	NewLabel_1.setBounds(420, 450, 300, 50);
	getContentPane().add(NewLabel_1);
	setVisible(true);
	
	// 닉네임 입력창 키 이벤트 (this)
	textField.addKeyListener(this);
	
	}
	
	@Override
	public void  keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//엔터키로 눌렀을 때 
				if (e.getKeyCode() == KeyEvent.VK_ENTER){ // 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기 
					
				if(!textField.getText().equals("")){
					
					Nick = textField.getText().toString();
					System.out.println("nick - keyPressed : "+Nick);
					this.dispose();
					main.showGameView( Nick);
					
				}else {
					// 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
					NewLabel_1.setText("올바르지 않은 닉네임 입니다.");
				}
			}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {  // 버튼으로 눌렀을 때
		// TODO Auto-generated method stub
		
		if(!textField.getText().equals("")){			
			// 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기 
			Nick = textField.getText().toString();  // 저장된 닉넴 값 들어감.
			System.out.println("nick - actionPerformed : "+Nick);
			this.dispose();
			main.showGameView(Nick); // 이 닉네임이 메인게임의 닉넴에 출력됨
			
			
		}else {                             
			// 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
			NewLabel_1.setText("올바르지 않은 닉네임 입니다."); // 올바를 때
		}
		
	}
	     //Main 등록 
//		public void setSansung_main(Sansung_main main) {		
//			this.main = main;			
//		}
}
	




