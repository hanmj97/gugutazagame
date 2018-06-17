package DB_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.*;      
import javax.swing.event.*;     
import java.awt.*;      
import java.awt.event.*; 


public class Sansung_nick extends JFrame implements ActionListener,KeyListener {
	private JTextField textField; // 닉 입력창
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://125.190.205.205/jsp?useSSL=false";
	String id="root";
	String pw="1234";
	JFrame internalframe;
	public String Nick; // 닉네임입력
	private JLabel NewLabel_1; // 오류 문구
	private Sansung_main main ;
	private JButton NewButton;
	private JButton shortTypingButton;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel bidul;
	
	public Sansung_nick() {
		main = new Sansung_main();
		
	 //화면 
		setSize(1280,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	
	
	JLabel NewLabel = new JLabel("구 구 한 글 타 자 연 습"); // 닉네임
	NewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	NewLabel.setFont(new Font("궁서",Font.PLAIN,30)); //글씨체
	NewLabel.setBounds(434,31,391,30);
	getContentPane().add(NewLabel);
	
	textField = new JTextField(); //닉네임 입력창
	
	textField.setFont(new Font("궁서", Font.BOLD, 24));
	textField.setBounds(434,500, 391, 66);
	getContentPane().add(textField);
	textField.setColumns(20); // 10글자 미만
	
	
	NewButton = new JButton("산성비 게임"); //확인버튼
	   
	NewButton.setFont(new Font("굴림", Font.BOLD, 12));
	NewButton.setBounds(177, 576, 189, 50);
	getContentPane().add(NewButton);
	NewButton.addActionListener(this);

	
	NewLabel_1 = new JLabel("닉네임을 입력하세요."); // 닉네임 라벨 
	NewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	NewLabel_1.setFont(new Font("궁서", Font.BOLD, 19));
	NewLabel_1.setBounds(434, 451, 391, 50);
	getContentPane().add(NewLabel_1);
	
	shortTypingButton = new JButton("짧은 글 연습");
	shortTypingButton.setFont(new Font("굴림", Font.BOLD, 12));
	shortTypingButton.setBounds(579, 576, 189, 50);
	getContentPane().add(shortTypingButton);
	
	btnNewButton = new JButton("산성비 게임 랭킹");
	btnNewButton.setFont(new Font("굴림", Font.BOLD, 11));
	btnNewButton.setBounds(780, 576, 152, 50);
	getContentPane().add(btnNewButton);
	btnNewButton.addActionListener(this);
	setVisible(true);
	
	btnNewButton_1 = new JButton("자원 캐기");
	btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));
	btnNewButton_1.setBounds(378, 576, 189, 50);
	getContentPane().add(btnNewButton_1);
	btnNewButton_1.addActionListener(this);
	
	btnNewButton_2 = new JButton("자원캐기 게임 랭킹");
	btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 11));
	btnNewButton_2.setBounds(944, 577, 159, 50);
	getContentPane().add(btnNewButton_2);
	btnNewButton_2.addActionListener(this);
	
	ImageIcon gugu = new ImageIcon("Character/gugu.png");
	JLabel bidul = new JLabel(gugu);
	bidul.setBounds(371, 10, 523, 523);
	getContentPane().add(bidul);
	
    
	// 닉네임 입력창 키 이벤트 (this)
	textField.addKeyListener(this);
	shortTypingButton.addActionListener(this);

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
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("드라이버 연결 성공!");
	         
	         conn = DriverManager.getConnection(url, id, pw);
	         System.out.println("데이터베이스 접속 성공!");
	            
	         
	         st = conn.createStatement();
	         st = conn.prepareStatement("INSERT INTO user (iduser) VALUES (?)");
	          Nick = textField.getText(); 
	          ((PreparedStatement) st).setString(1, Nick);
	          if (((PreparedStatement) st).executeUpdate() > 0) 
	          {
	                System.out.println("정보 업데이트 성공"); // 점수는 중복이여도 괜찮지만 사용자의 아이디는 중복되지않
	             } else {
	                System.out.println("정보 업데이트 실패");
	                NewLabel_1.setText("올바르지 않은 닉네임 입니다.");
	             }

	           st = conn.prepareStatement("SELECT iduser FROM user "); // 랭킹창 표현 (저장되잇던 값 표출)
	           rs = ((PreparedStatement) st).executeQuery();
	             
	           
	           while (rs.next()) 
	           {
	               String name = rs.getString("iduser");

	               System.out.println("사용자 닉네임 : " + name);
	            }
	               
	               
	           if(!textField.getText().equals("")){
	            
	            // 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기 
	            if(e.getSource() == NewButton) {
	               Nick = textField.getText().toString();  // 저장된 닉넴 값 들어감.
	               main.showGameView( Nick); // 이 닉네임이 메인게임의 닉넴에 출력됨
	            }
	            else if(e.getSource() == shortTypingButton)
	               {
	                  Nick = textField.getText().toString();  // 저장된 닉넴 값 들어감.
	                  main.showShort(this, Nick);
	               }
	            else if(e.getSource() == btnNewButton)
	            {
	            	Nick = textField.getText().toString();
	            	main.rank(this, Nick);
	            	
	            }
	            else if(e.getSource() == btnNewButton_2)
	            {
	            	Nick = textField.getText().toString();
	            	main.Mine_rank(this, Nick);
	            }
	            else if(e.getSource() == btnNewButton_1)
	            {
	            	Nick = textField.getText().toString();
	            	main.Mine_game(this, Nick);
	            	
	            }
	         }
	          else 
	          {                             
	             // 텍스트 입력창에 값이 없다면 라벨텍스트 변경 
	             NewLabel_1.setText("올바르지 않은 닉네임 입니다."); // 올바를 때
	          }
	             
	          while(rs.next())                          //하나라도 값이 들어왔으면       next() 메서드를 사용해서 SELECT 결과의 존재 여부를 확인
	          {
	             System.out.printf("사용자의 아이디 : " + rs.getString(1) + "\n");
	          }
	        } catch(Exception e1)
	   {
	        System.out.println(e1.getMessage());
	   }
	   }
}
	
	




