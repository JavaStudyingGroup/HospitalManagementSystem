package me.test.Administator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountManagement {

	private JFrame frame;
	private JPanel panel_1;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton button;
	private JButton btnNewButton_2;
	private JButton button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement window = new AccountManagement();
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
	public AccountManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("楷体", Font.PLAIN, 15));
		frame.setMaximumSize(new Dimension(700, 1000));
		frame.setFont(new Font("方正舒体", Font.PLAIN, 18));
		frame.setBounds(new Rectangle(100, 100, 0, 0));
		frame.setVisible(true);
		frame.setTitle("\u8D26\u53F7\u7BA1\u7406\u9875");
		frame.setBounds(100, 100, 573, 386);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] data = new String[6];//用于操作表内数据行的data数组，元素个数要与table的列的数量相一致
		       
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
		        String sql= "select id,[name],grender,account,password,[type]  from Account";
		       
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "\u59D3\u540D", "\u6027\u522B", "\u8D26\u53F7", "\u5BC6\u7801", "\u8D26\u6237\u7C7B\u578B"},
				
			},
			new String[] {
				"ID", "\u59D3\u540D", "\u6027\u522B", "\u8D26\u53F7", "\u5BC6\u7801", "\u8D26\u6237\u7C7B\u578B"
			}
		));
		DefaultTableModel model=(DefaultTableModel) this.table.getModel();
		panel_1.add(table);
		
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(400, 209));
		panel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.setBounds(new Rectangle(0, 0, 600, 200));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		button = new JButton("\u5220\u9664\u6570\u636E");
		button.setFont(new Font("\u6977\u4F53", button.getFont().getStyle(), button.getFont().getSize() + 5));
		panel.add(button);
		
		btnNewButton_2 = new JButton("\u589E\u52A0\u6570\u636E");
		btnNewButton_2.setFont(new Font("\u6977\u4F53", btnNewButton_2.getFont().getStyle(), btnNewButton_2.getFont().getSize() + 5));
		panel.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("\u4FEE\u6539\u6570\u636E");
		btnNewButton_1.setFont(new Font("\u6977\u4F53", btnNewButton_1.getFont().getStyle(), btnNewButton_1.getFont().getSize() + 5));
		panel.add(btnNewButton_1);
		
		btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 15));
		panel.add(btnNewButton);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdminOperate();
			}
		});
		button_1.setFont(new Font("黑体", Font.PLAIN, 15));
		panel.add(button_1);

		 try{
				rs=st.executeQuery(sql);
		        while (rs.next()) {
		            data[0] = rs.getString(1).trim();
		            data[1] = rs.getString(2).trim();
		            data[2] = rs.getString(3).trim();
		            data[3] = rs.getString(4).trim();
		            data[4] = rs.getString(5).trim();
		            data[5] = rs.getString(6).trim();
		            model.addRow(data);
		        }
		        }catch(SQLException e){
		        	System.err.print("Error" + e.getMessage());       	
		        } 
		
		
	}
}

