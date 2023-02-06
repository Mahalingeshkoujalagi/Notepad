package notepad;

import java.awt.Font;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.System.Logger;
import java.util.logging.Level;

public class notepad extends JFrame implements ActionListener{
	
	
	JMenuBar menubar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help");
	
	JMenuItem newfile=new JMenuItem("new");
	JMenuItem openfile=new JMenuItem("Open");
	JMenuItem savefile=new JMenuItem("save");
	JMenuItem print=new JMenuItem("Print");
	JMenuItem exit=new JMenuItem("exit");
	
	JMenuItem cut=new JMenuItem("cut");
	JMenuItem copy=new JMenuItem("copy");
	JMenuItem paste=new JMenuItem("paste");
	JMenuItem selectall=new JMenuItem("select all");
	
	JMenuItem about=new JMenuItem("about");
	
	JTextArea textArea=new JTextArea();	

	notepad(){
		setTitle("notepad application");
		setBounds(100,100,600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon =new ImageIcon(getClass().getResource("download.png"));
		
		setIconImage(icon.getImage());
		
		setJMenuBar(menubar);
		
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		file.add(newfile);
		file.add(openfile);
		file.add(savefile);
		file.add(print);
		file.add(exit);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		help.add(about);
		
		JScrollPane scrollpane=new JScrollPane(textArea);
		
		add(scrollpane); 
		
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,19));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		newfile.addActionListener(this);
		openfile.addActionListener(this);
		savefile.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		about.addActionListener(this);
		
		
		newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));

		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));

		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_DOWN_MASK));

	    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));

		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));

		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK));



	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("new"))
		{
			
			textArea.setText(null);			
		}else if(e.getActionCommand().equalsIgnoreCase("open")) {
			
			JFileChooser filechooser =new JFileChooser();
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("only text file(.txt)", "txt");
		   filechooser.setAcceptAllFileFilterUsed(false);
		   filechooser.addChoosableFileFilter(textFilter);
		   
 int action=filechooser.showOpenDialog(null); 
		   
		   if(action!=JFileChooser.APPROVE_OPTION) {
			   return;
			   
		   }else
		   {
			  
			     try {
			     BufferedReader reader =new BufferedReader(new FileReader(filechooser.getSelectedFile()));
			     textArea.read(reader,null);
			     }catch (Exception ex) {

			    	 ex.printStackTrace();
				}
		   }
			
		}else if(e.getActionCommand().equalsIgnoreCase("save")) {
			
			JFileChooser filechooser =new JFileChooser();
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("only text file(.txt)", "txt");
		   filechooser.setAcceptAllFileFilterUsed(false);
		   filechooser.addChoosableFileFilter(textFilter);
		   
		   int action=filechooser.showSaveDialog(null); 
		   
		   if(action!=JFileChooser.APPROVE_OPTION) {
			   return;
			   
		   }else
		   {
			   String fileName=filechooser.getSelectedFile().getAbsolutePath().toString();
			   if(!fileName.contains(".txt"));
			     fileName+=".txt";
			     try {
			     BufferedWriter writer =new BufferedWriter(new FileWriter(fileName));
			     textArea.write(writer);
			     }catch (Exception ex) {

			    	 ex.printStackTrace();
				}
		   }
			
		}else if(e.getActionCommand().equalsIgnoreCase("print")) {
			
			
				try {
					textArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			
			
		}else if(e.getActionCommand().equalsIgnoreCase("exit")) {
			
			System.exit(0);
			
		}else if(e.getActionCommand().equalsIgnoreCase("cut")) {
			
			textArea.cut();
			
		}else if(e.getActionCommand().equalsIgnoreCase("copy")) {
			textArea.copy();
			
		}else if(e.getActionCommand().equalsIgnoreCase("paste")) {
			
			textArea.paste();
			
		}else if(e.getActionCommand().equalsIgnoreCase("select all")) {
			
			textArea.selectAll();
			
		}else if(e.getActionCommand().equalsIgnoreCase("about")) {
			
			new about().setVisible(true);
			
		}

		
	}
public static void main(String[] args) throws Exception{
	
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		new notepad().setVisible(true);

	}

}
