import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class admin {
	static Connection con=null;
	static Connection con1=null;/*一个连接*/ 
	ResultSet rs=null;
	//创建语句对象
	Statement st=null;
	//创建控件
	static    JFrame frm=new JFrame();
	static    JPanel panel1=new JPanel();
	static    JPanel panel2=new JPanel();
	static    JLabel label1=new JLabel();
	static    JLabel laccount=new JLabel();
	static    JLabel lpas=new JLabel();
	static    JTextField taccount = new JTextField(15);
	static    JPasswordField tpas = new JPasswordField(15);//static
	static    JButton ok = new JButton("ok");
	static    JButton cancel = new JButton("cancel");//管理员登录界面所有控件 

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub      
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");/*加载一个驱动*/
	    //建立数据库连接//
	    con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Account","sa","123");
	    con1=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;DatabaseName=Account","sa","123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//引号内写连接字符串//
        if(con!=null&con1!=null)
	    	System.out.println("连接成功！");
        	
        frm.setTitle("管理员登录界面");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//建立窗口
        frm.getContentPane().add(panel1,BorderLayout.CENTER);
        frm.getContentPane().add(panel2,BorderLayout.NORTH);//面板
        
        label1.setText("管理员账号登录");
        label1.setFont(new Font("宋体",Font.BOLD,16));
        panel2.add(label1);//将控件加入面板
        laccount.setText("管理员账号：");
        lpas.setText("密             码：");
        
        ok.setText("登录");
        cancel.setText("退出");
        
        frm.setResizable(false);

        //将控件加入面板Panel
        panel1.add(laccount);panel1.add(taccount);
        panel1.add(lpas);panel1.add(tpas);
        panel1.add(ok);panel1.add(cancel);
        Color blue=new Color(50, 50, 50);
        laccount.setBackground(blue);
        Dimension ps=new Dimension(300,250);
        panel1.setMaximumSize(ps);
  
        //登录界面
        ok.addActionListener(new ActionListener(){

    	    public void actionPerformed(ActionEvent e) {
    	    // TODO Auto-generated method stub
    	    check();
    	}
			private void check() {
				// TODO Auto-generated method stub
				if(taccount.getText().equals(""))
					
	    		    JOptionPane.showMessageDialog(null, "请输入用户名!", "error",JOptionPane.ERROR_MESSAGE);
				
	    		    else if(tpas.getPassword().equals(""))
	    		    	
	    		    JOptionPane.showMessageDialog(null, "请输入密码!", "error",JOptionPane.ERROR_MESSAGE);
	    		    else
	    		    	
	    		    new admin().jc(taccount.getText(),tpas.getPassword());
			}});
					
        cancel.addActionListener(new ActionListener(){

    	    public void actionPerformed(ActionEvent e) {

    	    // TODO Auto-generated method stub

    	    System.exit(0);

    	    }
    	    });
       
        frm.setBounds(500, 300, 300, 200);
        frm.setVisible(true);
        
	}  
	    protected void jc(String text, char[] password) {
    	// TODO Auto-generated method stub    		    	
		try {
    		st=con.createStatement();
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	 	String tpassword=String.valueOf(password);
        	String sql="select*from AdminAccount where Aname='"+taccount.getText()+"'and Apassword='"+tpassword+"';"; 
        	try {
				rs=st.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	try {
			
			if(!rs.next())
			    JOptionPane.showMessageDialog(null, "此用户不存在或密码错误！", "error",JOptionPane.ERROR_MESSAGE);
			else
		    frm=new JFrame();			
			frm.setTitle("管理员管理界面");
		    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//建立窗口
		    frm.getContentPane().add(panel1,BorderLayout.CENTER);
	        frm.getContentPane().add(panel2,BorderLayout.NORTH);//面板
	        panel2.setSize(500, 200);
		    
		    
		    
		    
		    
		    
		    frm.setBounds(500, 350, 300, 200);
		    frm.setVisible(true);
				//JOptionPane.showMessageDialog(null, "下一步的操作","Next",JOptionPane.YES_OPTION);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//关闭
    	try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    				
		}
    	
    	
    	
				
			
			

	}

	}



	

