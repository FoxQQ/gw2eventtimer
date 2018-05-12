package gw2eventtimer_java;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.RootPaneContainer;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener{
	
	JLabel jLabelLocalTime, jLabelUTCTime;
	Date today;
	Timer mytimer;
	JButton btnToggleTimer, btnSetAlertTime;
	final int refreshRate = 10000;
	int preAlertTime = 10;
	JSpinner spinnerAlertTimer;
	
	public MainFrame(int width,int height) {
		this.setSize(width, height);
		this.setAutoRequestFocus(true);
		this.setTitle("GW2 Joko Invasion");
		this.setLocation(600, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int time= (int) System.currentTimeMillis();
		mytimer = new Timer(refreshRate, this);
		mytimer.start();
		initComponents();
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void initComponents() {
		jLabelLocalTime= new JLabel();
		jLabelUTCTime=new JLabel();
		today = new Date();
		jLabelLocalTime.setText(Integer.toString(today.getHours())+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		jLabelUTCTime.setText(Integer.toString(today.getHours()-2)+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		btnToggleTimer=new JButton();
		btnToggleTimer.setText("Stop Timer");
		btnToggleTimer.setActionCommand("toggleTimer");
		btnToggleTimer.disable();
		btnToggleTimer.addActionListener(this);
		GridBagLayout gridbag=new java.awt.GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		getContentPane().setLayout(gridbag);
		
		//First Row		
		c.gridwidth=1;
		c.weightx=1;
		c.weighty=0;
		JLabel labelLocal = new JLabel("Local Time:");
		gridbag.setConstraints(labelLocal, c);
		getContentPane().add(labelLocal);
		c.gridwidth=GridBagConstraints.REMAINDER;		
		gridbag.setConstraints(jLabelLocalTime, c);
		getContentPane().add(jLabelLocalTime);
		
		//Second Row
		c.gridwidth=1;
		c.weightx=1;
		c.weighty=0;
		JLabel labelUTC = new JLabel("Local Time:");
		gridbag.setConstraints(labelUTC, c);
		getContentPane().add(labelUTC);
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(jLabelUTCTime, c);
		getContentPane().add(jLabelUTCTime);
		
		//Third Row
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		gridbag.setConstraints(btnToggleTimer, c);
		getContentPane().add(btnToggleTimer);
		
		//Fourth Row
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0;
		c.fill=GridBagConstraints.BOTH;
		JLabel labelAlert = new JLabel("Set Pre-Event Alert");
		gridbag.setConstraints(labelAlert, c);
		getContentPane().add(labelAlert);
		spinnerAlertTimer = new JSpinner();
		spinnerAlertTimer.setValue(preAlertTime);
		gridbag.setConstraints(spinnerAlertTimer, c);
		getContentPane().add(spinnerAlertTimer);
		c.gridwidth=GridBagConstraints.REMAINDER;
		btnSetAlertTime = new JButton("Set");
		btnSetAlertTime.setActionCommand("btnSetAlertTime");
		btnSetAlertTime.addActionListener(this);
		gridbag.setConstraints(btnSetAlertTime, c);
		getContentPane().add(btnSetAlertTime);
		
		
		
		/*getContentPane().add(new JLabel("Local Time: "),c);
		getContentPane().add(jLabelLocalTime,c);
		
		
		getContentPane().add(new JLabel("UTC Time: "),c);
		getContentPane().add(jLabelUTCTime,c);
		
		getContentPane().add(btnToggleTimer,c);*/
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		today = new Date();
		jLabelLocalTime.setText(Integer.toString(today.getHours())+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		jLabelUTCTime.setText(Integer.toString(today.getHours()-2)+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		if(today.getSeconds()%preAlertTime==0) {
			AlertDialog alert=new AlertDialog(null,"textextext");
			alert.show();
		}
		if("toggleTimer".equals(arg0.getActionCommand())) {
			if(mytimer.isRunning()) {
				mytimer.stop();
				btnToggleTimer.setText("Start Timer");
			}
			else {
				mytimer.start();
				btnToggleTimer.setText("Stop Timer");
			}
		} else if("btnSetAlertTime".equals(arg0.getActionCommand())) {
			System.out.println(preAlertTime);
			preAlertTime=(int) spinnerAlertTimer.getValue();
		}
		
		this.repaint();
		
	}

}
