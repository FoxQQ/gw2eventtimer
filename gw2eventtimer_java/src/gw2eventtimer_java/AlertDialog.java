package gw2eventtimer_java;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AlertDialog extends Dialog implements ActionListener{

	public AlertDialog(Dialog arg0,String message) {
		super(arg0);
		this.setTitle("Attention!");
		this.setLayout(new java.awt.FlowLayout());
		this.add(new JLabel(message));
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setActionCommand("Ok");
		this.add(btnOk);
		pack();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if("Ok".equals(arg0.getActionCommand())) {
			dispose();
		}
		
	}

}
