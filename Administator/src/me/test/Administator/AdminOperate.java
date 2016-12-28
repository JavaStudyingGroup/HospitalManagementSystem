package me.test.Administator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class AdminOperate {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOperate window = new AdminOperate();
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
	public AdminOperate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("楷体", Font.PLAIN, 14));
		frame.setTitle("\u7BA1\u7406\u4FE1\u606F\u9875\u9762");
		frame.getContentPane().setSize(new Dimension(1000, 600));
		frame.getContentPane().setMaximumSize(new Dimension(1000, 2147483647));
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		frame.setVisible(true);
		frame.setBounds(100, 100, 778, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//开始连接数据库
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
        String sql= "select id,[name],price  from YaoPin";
        String sql2= "select id,kind,person  from KeShi";
        String sql1= "select id,[name],fee  from ChargeItem";
        String[] data = new String[3];
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		
		table_1 = new JTable();
		table_1.setBounds(494, 30, 238, 151);
		table_1.setFont(new Font("宋体", Font.PLAIN, 14));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "\u6536\u8D39\u9879\u76EE\u540D\u79F0", "\u4EF7\u683C"}
			},
			new String[] {
				"ID", "\u6536\u8D39\u9879\u76EE\u540D\u79F0", "\u4EF7\u683C"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(88);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(94, 0, 40, 25);
		panel_4.add(lblNewLabel_1);
		
		table_2 = new JTable();
		table_2.setBounds(10, 30, 225, 151);
		panel_4.add(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "\u79D1\u5BA4\u540D", "\u79D1\u5BA4\u4EBA\u5458"}
			},
			new String[] {
				"ID", "\u79D1\u5BA4\u540D", "\u79D1\u5BA4\u4EBA\u5458"
			}
		));
		table_2.setFont(new Font("宋体", Font.PLAIN, 14));
		DefaultTableModel model2=(DefaultTableModel) this.table_2.getModel();
		
		JLabel lblNewLabel = new JLabel("\u6536\u8D39\u9879\u76EE");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel.setBounds(586, 5, 65, 20);
		panel_4.add(lblNewLabel);
		panel_4.add(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u54C1");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(332, 5, 48, 20);
		panel_4.add(lblNewLabel_2);
		
		table = new JTable();
		table.setBounds(245, 30, 225, 151);
		panel_4.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "\u540D\u79F0", "\u4EF7\u683C"}
			},
			new String[] {
				"ID", "\u540D\u79F0", "\u4EF7\u683C"
			}
		));
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(218, 30, 17, 151);
		panel_4.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(453, 30, 17, 151);
		panel_4.add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(715, 30, 17, 151);
		panel_4.add(scrollBar_2);
		DefaultTableModel model=(DefaultTableModel) this.table.getModel();
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u8F6C\u5230\u8D26\u53F7\u7BA1\u7406");
		panel_2.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AccountManagement();
			}
		});
		DefaultTableModel model1=(DefaultTableModel) this.table_1.getModel();
		
		try{
			rs=st.executeQuery(sql);
	        while (rs.next()) {
	            data[0] = rs.getString(1).trim();
	            data[1] = rs.getString(2).trim();
	            data[2] = rs.getString(3).trim();
	            model.addRow(data);
	        }
	        }catch(SQLException e){
	        	System.err.print("Error" + e.getMessage());       	
	        } 
		try{
			rs=st.executeQuery(sql1);
	        while (rs.next()) {
	            data[0] = rs.getString(1).trim();
	            data[1] = rs.getString(2).trim();
	            data[2] = rs.getString(3).trim();
	            model1.addRow(data);
	        }
	        }catch(SQLException e){
	        	System.err.print("Error" + e.getMessage());       	
	        } 
		try{
			rs=st.executeQuery(sql2);
	        while (rs.next()) {
	            data[0] = rs.getString(1).trim();
	            data[1] = rs.getString(2).trim();
	            data[2] = rs.getString(3).trim();
	            model2.addRow(data);
	        }
	        }catch(SQLException e){
	        	System.err.print("Error" + e.getMessage());       	
	        } 
	}
}
