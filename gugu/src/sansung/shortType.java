package DB_project;


import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.text.DecimalFormat;


public class shortType extends JFrame implements ActionListener,KeyListener {
	
	private JTextField InputText;
	private JButton Start;
	private String[] Tmp = new String[5000];
		/*{
				"Love begets love", "No house without a mouse", "Patience conquers the world", "Hope is the poor man's bread", "Union is strength"
		};*/
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
	private JTextArea textArea;
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
	private int resultSpeed=0;
	private int resultAccur=0;
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://125.190.205.205:3306/jsp";
	String id="root";
	String pw="1234";
	
	
	
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
		
		ShortText = new JPanel();
		ShortText.setBounds(0, 0, 990, 450);
		contentPane.add(ShortText);
		ShortText.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("굴림", Font.PLAIN, 44));
		label_1.setBounds(5, 200, 985, 50);
		ShortText.add(label_1);
		
		textPane = new JTextPane();
		textPane.setBounds(5, 5, 985, 440);
		ShortText.add(textPane);
		
		
		
		Result = new JPanel();
		Result.setBounds(100, 100, 600, 480);
		Result.setVisible(false);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1275, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		back = new JButton("Back");
		back.setBounds(1000, 630, 270, 50);
		panel.add(back);
		back.setVisible(false);
		
		AccurLabel = new JLabel(" 정확도 : " + Accur + "%");
		AccurLabel.setBounds(1000, 10, 100, 50);
		panel.add(AccurLabel);
		
		TypingLabel = new JLabel("타수 : " + speed + "타/분");
		TypingLabel.setBounds(1000, 70, 110, 50);
		panel.add(TypingLabel);
		
		InputText = new JTextField();
		InputText.setBounds(0, 460, 990, 211);
		panel.add(InputText);
		InputText.setFont(new Font("굴림", Font.PLAIN, 40));
		InputText.setColumns(40);
		
		Start = new JButton("Start");
		Start.setBounds(1000, 570, 270, 50);
		panel.add(Start);
		
		timeLabel = new JLabel("경과시간 : 00 : 00");
		timeLabel.setBounds(1000, 130, 110, 50);
		panel.add(timeLabel);
		
		Jinhang = new JLabel("진행상황 : ");
		Jinhang.setBounds(1000, 500, 120, 20);
		panel.add(Jinhang);
		
		Start.addActionListener(this);
		InputText.disable();
		InputText.addKeyListener(this);
		contentPane.add(Result);
		Result.setLayout(null);
		
		NickLabel = new JLabel("이름: " + Nickname);
		NickLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		NickLabel.setBounds(240, 80, 160, 50);
		Result.add(NickLabel);
		
		resultAccurLabel = new JLabel("정확도 : " + Accur +"%" );
		resultAccurLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		resultAccurLabel.setBounds(240, 200, 150, 30);
		Result.add(resultAccurLabel);
		
		resultTypingLabel = new JLabel("타수 : " + speed +"타/분" );
		resultTypingLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		resultTypingLabel.setBounds(220, 240, 200, 30);
		Result.add(resultTypingLabel);
		
		okButton = new JButton("OK");
		okButton.setBounds(270, 340, 100, 100);
		Result.add(okButton);
		
		setVisible(true);
		okButton.addActionListener(this);
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if (!InputText.getText().equals("")) {
				String inText = InputText.getText().toString();
				for (int i = 0; i < bigyo.length(); i++) {
					if(i>= inText.length()) {
						
					}
					if(bigyo.charAt(i) != inText.charAt(i)) {
						tllim++;
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
				Accur = ((geulza-tllim)*1.0D/geulza)*100;
				
				AccurLabel.setText("정확도 : " + df.format(Accur) + "%");
				InputText.setText("");
			
			}
			if(soon<5)
			{
				soon++;
				label_1.setText(soonseo[soon]);
				bigyo = soonseo[soon];
			}
			if (soon == 5) {
				
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
			
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection(url, id, pw);
			    st = conn.createStatement(); 
			    rs = st.executeQuery("SELECT longword FROM longwordtbl");
			        
			    int cnt =0;
			      while (rs.next()) {	
			         String aword = rs.getString("longword");
			         Tmp[cnt] = aword;
			         System.out.println("짧은 글 : " + aword);
			         cnt++;                 
			       }
			 } catch(Exception e1){
			      System.out.println(e1.getMessage());
			 }
			
			/*for(int i = 0; i < 10; i ++) {
				nindex = random.nextInt(101);
				textArea.append(Tmp[nindex]);
				textArea.append("\n");
			}*/
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
			if (label_1 == null) {
				
			}
		
		}
		
		if(e.getSource() == okButton) {
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection(url, id, pw);
			    st = conn.createStatement(); 
		        st = conn.prepareStatement("UPDATE user SET tasu=? where  iduser=?");
		          ((PreparedStatement) st).setInt(1, resultSpeed);
		          ((PreparedStatement) st).setString(2, Nickname);
		          if (((PreparedStatement) st).executeUpdate() > 0) 
		          {
		                System.out.println("정보 업데이트 성공"); // 점수는 중복이여도 괜찮지만 사용자의 아이디는 중복되지않
		             } else {
		                System.out.println("정보 업데이트 실패");
		             }
		          System.out.println(resultSpeed);
		          System.out.println(Nickname);
            } catch(Exception e1){
			      System.out.println(e1.getMessage());
			 }
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection(url, id, pw);
			    st = conn.createStatement(); 
		        st = conn.prepareStatement("UPDATE user SET accurate=? where  iduser=?");
		          ((PreparedStatement) st).setInt(1, resultAccur);
		          ((PreparedStatement) st).setString(2, Nickname);
		          if (((PreparedStatement) st).executeUpdate() > 0) 
		          {
		                System.out.println("정보 업데이트 성공"); // 점수는 중복이여도 괜찮지만 사용자의 아이디는 중복되지않
		             } else {
		                System.out.println("정보 업데이트 실패");
		             }
		          System.out.println(resultSpeed);
		          System.out.println(Nickname);
            } catch(Exception e1){
			      System.out.println(e1.getMessage());
			 }
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
				resultAccur = Integer.parseInt(String.valueOf(Math.round(Accur))); //정확도
	            resultSpeed = Integer.parseInt(String.valueOf(Math.round(speed))); //타수
	       
				
				this.stop();
				this.interrupt();
			}
		}
	}
}
