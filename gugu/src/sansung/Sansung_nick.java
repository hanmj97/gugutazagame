package DB_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.mysql.jdbc.PreparedStatement;

public class Sansung_nick extends JFrame implements ActionListener,KeyListener {
   
   private JTextField textField; // 닉 입력창
   public String Nick; // 닉네임입력
   private JLabel NewLabel_1; // 오류 문구
   private Sansung_main main;
   Connection conn = null;
   Statement st = null;
   ResultSet rs = null;
   String url = "jdbc:mysql://125.190.205.205/jsp?useSSL=false";
   String id="root";
   String pw="1234";
   private JButton NewButton;
   private JButton shortTypingButton;
   private JButton longTypingButton;
   
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
   
   
   NewButton = new JButton("확인"); //확인버튼
	
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
   
   
   shortTypingButton = new JButton("짧은 글 연습");
   shortTypingButton.setBounds(450, 576, 240, 50);
   getContentPane().add(shortTypingButton);
	
   longTypingButton = new JButton("긴 글 연습");
   longTypingButton.setBounds(450, 636, 238, 23);
   getContentPane().add(longTypingButton);
   setVisible(true);
   
   shortTypingButton.addActionListener(this);
   longTypingButton.addActionListener(this);
   // 닉네임 입력창 키 이벤트 (this)
   textField.addKeyListener(this);
   
   }
   
   
   @Override
   public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub
	   if (e.getKeyCode() == KeyEvent.VK_ENTER){ // �뀓�뒪�듃 �씠�젰李쎌뿉 媛믪씠 �엳�떎硫� �땳�꽕�엫 蹂��닔�뿉 ���옣 �썑 寃뚯엫�솕硫� �쓣�슦湲� 
			
			if(!textField.getText().equals("")){
				
				Nick = textField.getText().toString();
				System.out.println(Nick);
				main.showGameView(this, Nick);
				
			}else {
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
   public void actionPerformed(ActionEvent e){  // 버튼으로 눌렀을 때
      
      // TODO Auto-generated method stub
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("드라이버 연결 성공!");
         
         conn = DriverManager.getConnection(url, id, pw);
         System.out.println("데이터베이스 접속 성공!");
            
         
         st = conn.createStatement();
         st = conn.prepareStatement("INSERT INTO user (iduser,score, tasu, accurate) VALUES (?,?,?,?)");
          Nick = textField.getText(); 
          ((PreparedStatement) st).setString(1, Nick);
          ((PreparedStatement) st).setInt(2, 0);
          ((PreparedStatement) st).setInt(3, 0);
          ((PreparedStatement) st).setInt(4, 0);
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
   				main.showGameView(this, Nick); // 이 닉네임이 메인게임의 닉넴에 출력됨
   			}
   			else if(e.getSource() == shortTypingButton)
   				{
   					Nick = textField.getText().toString();  // 저장된 닉넴 값 들어감.
   					main.showShort(this, Nick);
   				}
   			else if(e.getSource() == longTypingButton)
			{
			Nick = textField.getText().toString();  // 저장된 닉넴 값 들어감.
			main.showLong(this, Nick);
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

   //Main 등록 
 		public void setSansung_main(Sansung_main main) {
 		
 			this.main = main;
 			
 		}
}
   


