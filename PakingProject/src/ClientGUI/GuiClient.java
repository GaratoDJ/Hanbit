package ClientGUI;
 
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.Car;
import DB.DBClass;
import javax.swing.ImageIcon;

public class GuiClient extends JFrame implements ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<String> combo;
	JComboBox comboFloor;
	JTextField textField, textField_2;
	JRadioButton radio, radio_2, radio_3;
	int carNum, floor, floorNum;
	JTextArea textArea;
	JScrollPane scroll;
	ButtonGroup bg;
	
	String name;
	ArrayList floorList;
	
	Socket sk;
	BufferedReader br;
	ObjectOutputStream oos;
	
	DBClass db;
 
  public GuiClient() {
  	setIconImage(Toolkit.getDefaultToolkit().getImage("\\image\\logo.png"));
	  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 378, 682, 25);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("emiyaSystem V0.01");
		lblNewLabel.setBounds(539, 0, 143, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("메세지(상태창)");
		lblNewLabel_1.setBounds(14, 259, 107, 18);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 682, 256);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		combo = new JComboBox<String>();
		combo.addItem("주차하기");
		combo.addItem("출차하기");
		combo.addItem("요금확인");
		combo.setSelectedIndex(0);
		combo.setBounds(14,35, 165, 24);
		panel_1.add(combo);
		
		JLabel lblNewLabel_2 = new JLabel("주차, 출차, 요금확인 선택");
		lblNewLabel_2.setBounds(14, 5, 165, 18);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("층수 선택");
		lblNewLabel_3.setBounds(14, 71, 77, 18);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(14, 88, 229, 47);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.add(panel_2);
		
		radio = new JRadioButton("1층");
		radio.addActionListener(this);
		radio_2 = new JRadioButton("2층");
		radio_2.addActionListener(this);
		radio_3 = new JRadioButton("3층");
		radio_3.addActionListener(this);
		panel_2.add(radio);
		panel_2.add(radio_2);
		panel_2.add(radio_3);
		bg = new ButtonGroup();
		bg.add(radio);
		bg.add(radio_2);
		bg.add(radio_3);
		
		JLabel lblNewLabel_4 = new JLabel("주차 자리선택");
		lblNewLabel_4.setBounds(14, 147, 89, 18);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("차량번호(4자리)");
		lblNewLabel_5.setBounds(197, 147, 117, 18);
		panel_1.add(lblNewLabel_5);
		
		JLabel label = new JLabel("사용자 이름");
		label.setBounds(370, 147, 77, 18);
		panel_1.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(14, 177, 654, 67);
		panel_3.setLayout(null);
		panel_1.add(panel_3);
		
		comboFloor = new JComboBox();
		comboFloor.setSelectedItem(1);
		comboFloor.setBounds(0, 12, 102, 24);
		panel_3.add(comboFloor);
		
		textField = new JTextField();
		textField.setBounds(184, 12, 102, 24);
		panel_3.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(353, 12, 102, 24);
		panel_3.add(textField_2);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(514, 11, 105, 27);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("image/logo.png"));
		lblNewLabel_6.setBounds(495, 12, 173, 123);
		panel_1.add(lblNewLabel_6);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 286, 682, 91);
		scroll = new JScrollPane(textArea);
		scroll.setBounds(0, 286, 682, 91);
		contentPane.add(scroll);
		
		setVisible(true);
  }// 생성자 끝
 
  /**
   * 서버측에 접속기능 담당하는 메소드 작성
   * */
  public void serverConnection(){
      try {
          sk = new Socket("211.202.52.24", 7000);
          // 읽기준비
          br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
          // 쓰기준비
          oos = new ObjectOutputStream(sk.getOutputStream());
          new Thread(this).start();
      } catch (Exception e) {
          System.out.println(e + "Socket 접속 오류");
      }
  }
  public static void main(String[] args) {
	  new GuiClient().serverConnection();

  }
  // 쓰레드
  /**
   * 서버가 보내오는 데이터를 읽어서 TextArea에 올리기
   */
  @Override
  public void run() {	  
      String data = null;
      String[] list;
      try {
          while ((data = br.readLine()) != null) {
        	  System.out.println(data.toString());
        	  if(data.equals("1")){
        		  textArea.append("주차완료\n");
        	  }else if(data.equals("2")){
        		  textArea.append("주차실패\n");
        	  }else if(data.equals("3")){
        		  textArea.append("출차완료!\n");
        	  }else if(data.equals("5")){
        		  textArea.append("VIP 횟수 증가\n");
        	  }else if(data.equals("6")){
        		  textArea.append("신규 VIP 정보 추가\n");
        	  }
        	  if(String.valueOf(data).length()>1){
        		  if(String.valueOf((data.charAt(1))).equals(",")|| String.valueOf((data.charAt(2))).equals(",")){
        			  floorList = new ArrayList();
        			  list = data.split(",");
        			  for(int i = 0; i<list.length; i++){
        				  floorList.add(list[i]);
        			  }
        			  comboFloor.setModel(new DefaultComboBoxModel(floorList.toArray()));
        			  data = null;
        		  }else{
        			  textArea.append(data+"\n");
        		  }
        	  } 
          }      
      } catch (Exception e) {
          System.out.println(e + "--> Client run fail");
      }
  }
  //각종 버튼클릭 이벤트 발생
  @Override
  public void actionPerformed(ActionEvent e){
	  Car car = new Car();	
	  String click = e.getActionCommand();
	  if(click.equals("전송")){
		  if(combo.getSelectedItem().toString().equals("주차하기")){
			  car.setCarNum(Integer.parseInt(textField.getText()));
			  car.setName(textField_2.getText());
			  if(radio.isSelected()){
				  car.setFloor(1);
			  }else if(radio_2.isSelected()){
				  car.setFloor(2);
			  }else if(radio_3.isSelected()){
				  car.setFloor(3);
			  }
			  car.setFloorNum(Integer.parseInt(comboFloor.getSelectedItem().toString()));	
			  
			  try {
				oos.writeObject(1);
				oos.flush();
				oos.writeObject(car);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			  System.out.println("가는겨 마는겨");
		  }else if(combo.getSelectedItem().toString().equals("출차하기")){
			  car.setCarNum(Integer.parseInt(textField.getText()));
			  car.setName(textField_2.getText());
			  try {
				  	oos.writeObject(2);
				  	oos.flush();
					oos.writeObject(car);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		  }else if(combo.getSelectedItem().toString().equals("요금확인")){
			  car.setCarNum(Integer.parseInt(textField.getText()));
			  car.setName(textField_2.getText());
			  try {
				  	oos.writeObject(3);
				  	oos.flush();
					oos.writeObject(car);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		  }
	  }
	  if(radio.isSelected()){
		  try {
			oos.writeObject(4);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  }
	  else if(radio_2.isSelected()){
		  try {
			oos.writeObject(5);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  }else if(radio_3.isSelected()){
		  try {
			oos.writeObject(6);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  }
  }
}