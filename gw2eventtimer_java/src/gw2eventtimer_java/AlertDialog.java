package gw2eventtimer_java;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AlertDialog extends Dialog implements ActionListener{

	Clip clip;
	public AlertDialog(Dialog arg0,String message, Point location) {
		super(arg0);
		this.setFocusable(true);
		this.getFocusOwner();
		this.setLocation(location.x, location.y);
		this.setBackground(new Color(255,0,0));
		this.setTitle("Attention!");
		this.setLayout(new java.awt.FlowLayout());
		this.add(new JLabel(message));
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setActionCommand("Ok");
		this.add(btnOk);
		pack();
//		try {
//			playAlert();
//		} catch (LineUnavailableException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedAudioFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// TODO Auto-generated constructor stub
	}

//	public void playAlert() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
//		File soundFile = new File(new java.io.File(".").getCanonicalPath()+"\\data\\Heimat.wav");
//		clip = AudioSystem.getClip();
//		AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
//		clip.open(inputStream);
//		clip.start();
//	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if("Ok".equals(arg0.getActionCommand())) {
			clip.stop();
			dispose();
		}
		
	}

}
