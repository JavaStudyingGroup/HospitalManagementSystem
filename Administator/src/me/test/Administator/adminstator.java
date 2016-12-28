package me.test.Administator;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class adminstator {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * @wbp.nonvisual location=455,147
	 */


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminstator window = new adminstator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminstator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBackground(Color.GRAY);
		frame.setForeground(new Color(102, 255, 153));
		frame.setFont(new Font("Dialog", Font.ITALIC, 19));
		frame.setTitle("\u533B\u9662\u95E8\u8BCA\u6D41\u7BA1\u7406\u7CFB\u7EDF\u7BA1\u7406\u5458\u7AEF");
		frame.setBounds(100, 100, 343, 373);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u8BF7\u5148\u767B\u5F55");
		label.setFont(new Font("楷体", Font.ITALIC, 16));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(30, 31, 123, 21);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(153, 32, 153, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(30, 93, 123, 21);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 93, 153, 21);
		panel_1.add(passwordField);
		
		JButton cancel = new JButton("\u9000\u51FA");
		cancel.setBounds(29, 166, 85, 35);
		cancel.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_1.add(cancel);
		
		JButton ok = new JButton("\u767B\u5F55");
		
		ok.setBounds(184, 166, 85, 35);
		ok.setFont(new Font("楷体", Font.PLAIN, 14));
		panel_1.add(ok);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 220, 153, 73);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(153, 220, 153, 73);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
	
	 ok.addActionListener(new ActionListener(){
 	    public void actionPerformed(ActionEvent e) {
 	    // TODO Auto-generated method stub
 	    check();
 	}
			private void check() {
				// TODO Auto-generated method stub
				if(textField.getText().equals(""))
					
	    		    JOptionPane.showMessageDialog(null, "请输入用户名!", "error",JOptionPane.ERROR_MESSAGE);
				
	    		    else if(passwordField.getPassword().equals(""))
	    		    	
	    		    JOptionPane.showMessageDialog(null, "请输入密码!", "error",JOptionPane.ERROR_MESSAGE);
	    		    else
	    		    	new adminstator().jc(textField.getText(),passwordField.getPassword());
	          }}  );				   		
     cancel.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {

           // TODO Auto-generated method stub
           System.exit(0);

      }
 });
	 

	}
     protected void jc(String text, char[] password) {
		 	// TODO Auto-generated method stub  
	    	Connection con=null;/*一个连接*/ 
			ResultSet rs=null;
			//创建语句对象
			Statement st=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");/*加载一个驱动*/
		    //建立数据库连接//
		    con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;DatabaseName=Account","sa","123");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//引号内写连接字符串//
	        if(con!=null)
		    	System.out.println("连接成功！");
	    	try {
	     		st=con.createStatement();
	     	} catch (SQLException e) {
	     		// TODO Auto-generated catch block
	     		e.printStackTrace();
	     	}
	     	
	     	 	String apassword=String.valueOf(passwordField.getPassword());
	         	String sql="select*from AdminAccount where Aname='"+textField.getText()+"'and Apassword='"+apassword+"';"; 
	         	try {
	    				rs=st.executeQuery(sql);
	    			} catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
	     	try {
	    			
	    			if(rs.next())
	    			    JOptionPane.showMessageDialog(null, "此用户不存在或密码错误！", "error",JOptionPane.ERROR_MESSAGE);
	    			else
	    				{new AdminOperate();}		    		    
	    			rs.close();
	    			st.close();
	    			con.close();
	    		    			    		    			    		   			    		    
	    				//JOptionPane.showMessageDialog(null, "下一步的操作","Next",JOptionPane.YES_OPTION);
	    		} catch (HeadlessException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
}

		}	




