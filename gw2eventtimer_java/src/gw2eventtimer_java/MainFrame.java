package gw2eventtimer_java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.RootPaneContainer;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener{
	
	JLabel jLabelLocalTime, jLabelUTCTime;
	Date today;
	Timer mytimer;
	JButton btnToggleTimer, btnSetAlertTime;
	final int refreshRate = 1000;
	int preAlertTime = 10;
	JSpinner spinnerAlertTimer;
	
	public MainFrame(int width,int height) {
		
		
		this.setSize(width, height);
		this.setAutoRequestFocus(true);
		this.setTitle("GW2 Joko Invasion");
		Map<String,Integer[]> screens = getScreens();
		if(screens.get("1")!=null) {
			this.setLocation(screens.get("0")[0]+screens.get("1")[0]/2-width/2, 200);
		}
		else {
			this.setLocation(screens.get("0")[0]/2-width/2, 200);
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		mytimer = new Timer(refreshRate, this);
		mytimer.start();
		initComponents();
		
		
	}
	
	public Map<String,Integer[]> getScreens() {
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = g.getScreenDevices();
		Map<String,Integer[]> screens = new Hashtable<String,Integer[]>();
		for (int i=0;i<devices.length;i++) {
			
			Integer[] dim = {devices[i].getDisplayMode().getWidth(),
					devices[i].getDisplayMode().getHeight()};
			screens.put(Integer.toString(i), dim);
			//System.out.println("width"+devices[i].getDisplayMode().getWidth() +"height"+ devices[i].getDisplayMode().getHeight());
		}
		
		return screens;
		
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
		JLabel labelUTC = new JLabel("UTC Time:");
		gridbag.setConstraints(labelUTC, c);
		getContentPane().add(labelUTC);
		c.gridwidth=GridBagConstraints.REMAINDER;
		gridbag.setConstraints(jLabelUTCTime, c);
		getContentPane().add(jLabelUTCTime);
		
		//Third Row
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.weightx=1;
		c.weighty=0;
		c.fill=GridBagConstraints.BOTH;
		gridbag.setConstraints(btnToggleTimer, c);
		getContentPane().add(btnToggleTimer);
		
		//3.5 row
		c.gridwidth=GridBagConstraints.REMAINDER;;
		c.weighty=1;
		JLabel nextMap = new JLabel();
		nextMap.setText("Next Map:");
		nextMap.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.GREEN));
		getContentPane().add(nextMap,c);
		
		//Fourth Row
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0;
		c.fill=GridBagConstraints.BOTH;
		JLabel labelAlert = new JLabel("Set Pre-Event Alert to time - XX:");
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
		c.gridwidth=1;
		int day = today.getDay();
		JLabel labelDay = new JLabel();
		switch (day) {
			case 0: labelDay.setText("Sunday"); break;
			case 1: labelDay.setText("Monday"); break;
			case 2: labelDay.setText("Wendnesday");break;
			case 3: labelDay.setText("Tuesday");break;
			case 4: labelDay.setText("Thursday");break;
			case 5: labelDay.setText("Friday");break;
			case 6: labelDay.setText("Saturday");break;
		}
		
		gridbag.setConstraints(labelDay, c);
		getContentPane().add(labelDay);
		
		
		
		
		
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
		//System.out.println(arg0);
		today = new Date();
		jLabelLocalTime.setText(Integer.toString(today.getHours())+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		jLabelUTCTime.setText(Integer.toString(today.getHours()-2)+":"+Integer.toString(today.getMinutes())+":"+Integer.toString(today.getSeconds()));
		if(today.getMinutes()==preAlertTime && today.getSeconds()==0) {
			AlertDialog alert=new AlertDialog(null,"New Ivasion will start in " + Integer.toString(30-today.getMinutes()) + " minutes!",this.getLocation());
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
			preAlertTime=(int) spinnerAlertTimer.getValue();
		}
		
		this.repaint();
		
	}

}
