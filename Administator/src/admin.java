import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

public class admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("HELLO JAVA");
        Connection con=null;
        Connection con1=null;/*һ������*/
	    
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");/*����һ������*/
	    //�������ݿ�����//
	    con=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433; DatabaseName=Account","sa","123");
	    con1=DriverManager.getConnection("jdbc:sqlserver://192.168.0.11:1433;DatabaseName=Administrator","sa","123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//������д�����ַ���//
        if(con!=null&con1!=null)
	    	System.out.println("�����Ѿ��ɹ��˰���");
        JFrame frm=new JFrame();
        frm.setTitle("����Ա");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������
        JPanel panel1=new JPanel();
        frm.getContentPane().add(panel1,BorderLayout.CENTER);
        JPanel panel2=new JPanel();
        frm.getContentPane().add(panel2, BorderLayout.NORTH);//���
        JLabel label1=new JLabel();
        label1.setText("����Ա�˺ŵ�¼");
        label1.setFont(new Font("����",Font.BOLD,16));
        panel2.add(label1);//���ؼ��������
        JLabel laccount=new JLabel();
        laccount.setText("����Ա�˺ţ�");
        JLabel lpas=new JLabel();
        lpas.setText("����");
        JTextField taccount = new JTextField(15);
        JPasswordField tpas = new JPasswordField(20);//static
        JButton ok = new JButton("ok");
        ok.setText("��¼");
        JButton cancel = new JButton("cancel");
        cancel.setText("�˳�");
        
        panel1.add(laccount);panel1.add(taccount);
        panel1.add(lpas);panel1.add(tpas);
        panel1.add(ok);panel1.add(cancel);//��¼����
        
        
        
        frm.setBounds(500, 300, 400, 200);
        frm.setVisible(true);

	}

}
