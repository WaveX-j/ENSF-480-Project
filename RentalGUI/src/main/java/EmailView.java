

import javax.swing.*;

//import Client.Controller.EmailController;
//import Client.Controller.GuestController;
//import Client.Controller.RenterController;

import java.awt.*;
import java.awt.event.ActionListener;

public class EmailView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField subject;
	private JTextField from;
	private JTextField to;
	private JTextArea email = new JTextArea();
	private JButton btnSend = new JButton("send");
//	private RenterController rc;
//	private GuestController gc;
	
	
    public EmailView() {
    	setSize(452, 450);
    	//getContentPane().setBackground(new Color(230, 230, 250));
    	setTitle("Send Email");
    	getContentPane().setLayout(null);
    	
    	JLabel fromLbl = new JLabel("From:");
    	fromLbl.setBounds(15, 16, 69, 20);
    	getContentPane().add(fromLbl);
    	
    	JLabel subjectLbl = new JLabel("Subject:");
    	subjectLbl.setBounds(15, 52, 69, 20);
    	getContentPane().add(subjectLbl);
    	
    	email.setLocation(15, 0);
    	email.setLineWrap(true);

    	getContentPane().add(email);
    	JScrollPane scroll = new JScrollPane (email);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(10, 88, 403, 262); 
        getContentPane().add(scroll);
        
        btnSend.setBounds(150, 358, 115, 29);
        getContentPane().add(btnSend);
        
        subject = new JTextField();
        subject.setBounds(77, 52, 336, 26);
        getContentPane().add(subject);
        subject.setColumns(10);
        
        from = new JTextField();
        from.setBounds(74, 10, 146, 26);
        getContentPane().add(from);
        from.setColumns(10);
        setLocationRelativeTo ( null );
    }
    
//    public void setRenterController(RenterController rc) {
//    	this.rc = rc;
//    }
//    
//    public void setGuestController(GuestController gc) {
//    	this.gc = gc;
//    }
    
    public void addSendListener(ActionListener al)  {
    	btnSend.addActionListener(al);
    	btnSend.setActionCommand("send email");
	}
	
	public String getFrom() {
		return from.getText();
	}
	
	public String getEmail() {
		return email.getText();
	}
	
	public String getSubject() {
		return subject.getText();
	}
	
	public void setTo(String ll) {
		to.setText(ll);
	}
        
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailView().setVisible(true);
            }
        });
    }
}