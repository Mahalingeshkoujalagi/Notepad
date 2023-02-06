package notepad;

import java.awt.Font;

import javax.swing.*;

public class about extends JFrame{

	
	about(){
		setBounds(100,100,500,400);
		setTitle("About Notepad Application");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
ImageIcon icon =new ImageIcon(getClass().getResource("download.png"));
	
	setIconImage(icon.getImage());
	setLayout(null);
		
		JLabel iconlabel=new JLabel(new ImageIcon(getClass().getResource("download.png")));
		iconlabel.setBounds(100,50,80,80);
		add(iconlabel);
		
		JLabel textlabel=new JLabel("<html>Notepad is a simple text editor program included <br/> in most Windows computers. It can be used for creating, viewing and editing text files, as well as saving webpages in HTML format <br><br/><i>CREATED BY MAHALINGESH KOUJALAGI</i></html>");
	textlabel.setBounds(100,50,400,300);
	textlabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
	add(textlabel);
	
	
	}
	
	
	public static void main(String[] args) {
		
		new about().setVisible(true);
		
	}
}
