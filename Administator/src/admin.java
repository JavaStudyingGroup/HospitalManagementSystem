import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class admin {
	static Connection con=null;
	static Connection con1=null;/*һ������*/ 
	ResultSet rs=null;
	//����������
	Statement st=null;
	//�����ؼ�
	static    JFrame frm=new JFrame();
	static    JPanel panel1=new JPanel();
	static    JPanel panel2=new JPanel();
	static    JLabel label1=new JLabel();
	static    JLabel laccount=new JLabel();
	static    JLabel lpas=new JLabel();
	static    JTextField taccount = new JTextField(15);
	static    JPasswordField tpas = new JPasswordField(15);//static
	static    JButton ok = new JButton("ok");
	static    JButton cancel = new JButton("cancel");//����Ա��¼�������пؼ� 

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub      
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");/*����һ������*/
	    //�������ݿ�����//
	    con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Account","sa","123");
	    con1=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;DatabaseName=Account","sa","123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//������д�����ַ���//
        if(con!=null&con1!=null)
	    	System.out.println("���ӳɹ���");
        	
        frm.setTitle("����Ա��¼����");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//��������
        frm.getContentPane().add(panel1,BorderLayout.CENTER);
        frm.getContentPane().add(panel2,BorderLayout.NORTH);//���
        
        label1.setText("����Ա�˺ŵ�¼");
        label1.setFont(new Font("����",Font.BOLD,16));
        panel2.add(label1);//���ؼ��������
        laccount.setText("����Ա�˺ţ�");
        lpas.setText("��             �룺");
        
        ok.setText("��¼");
        cancel.setText("�˳�");
        
        frm.setResizable(false);

        //���ؼ��������Panel
        panel1.add(laccount);panel1.add(taccount);
        panel1.add(lpas);panel1.add(tpas);
        panel1.add(ok);panel1.add(cancel);
        Color blue=new Color(50, 50, 50);
        laccount.setBackground(blue);
        Dimension ps=new Dimension(300,250);
        panel1.setMaximumSize(ps);
  
        //��¼����
        ok.addActionListener(new ActionListener(){

    	    public void actionPerformed(ActionEvent e) {
    	    // TODO Auto-generated method stub
    	    check();
    	}
			private void check() {
				// TODO Auto-generated method stub
				if(taccount.getText().equals(""))
					
	    		    JOptionPane.showMessageDialog(null, "�������û���!", "error",JOptionPane.ERROR_MESSAGE);
				
	    		    else if(tpas.getPassword().equals(""))
	    		    	
	    		    JOptionPane.showMessageDialog(null, "����������!", "error",JOptionPane.ERROR_MESSAGE);
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
			    JOptionPane.showMessageDialog(null, "���û������ڻ��������", "error",JOptionPane.ERROR_MESSAGE);
			else
		    frm=new JFrame();			
			frm.setTitle("����Ա�������");
		    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//��������
		    frm.getContentPane().add(panel1,BorderLayout.CENTER);
	        frm.getContentPane().add(panel2,BorderLayout.NORTH);//���
	        panel2.setSize(500, 200);
		    
		    
		    
		    
		    
		    
		    frm.setBounds(500, 350, 300, 200);
		    frm.setVisible(true);
				//JOptionPane.showMessageDialog(null, "��һ���Ĳ���","Next",JOptionPane.YES_OPTION);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//�ر�
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



	

