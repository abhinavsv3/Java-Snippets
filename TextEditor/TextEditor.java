import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class TextEditor extends Frame implements ActionListener
{
		TextArea ta;
		MenuBar mb;
		String cpy;
		String fileName;
		String buffer;
		TextArea line;
		String padText;
		TextEditor ()
		{
				ta=new TextArea ();
				padText = "";
				mb = new MenuBar ();
				setMenuBar (mb);
				fileName = "Untitled.txt";
				setTitle ("TextEditor - " + fileName);
				Dimension d = getSize ();
				setVisible (true);
				setLayout (new BorderLayout ());
				setSize (500,500);
				add (ta,BorderLayout.CENTER);
				Menu file =new Menu ("File");
				Menu edit = new Menu ("Edit");
				Menu  look = new Menu ("Search");
				Menu  help = new Menu ("Help");
				
				mb.add (file);
				mb.add (edit);
				mb.add (look);
				mb.add (help);
				
				MenuItem newm = new MenuItem ("New",new MenuShortcut ('N'));
				MenuItem save = new MenuItem ("Save",new MenuShortcut ('S'));
				MenuItem open = new MenuItem ("Open",new MenuShortcut ('N'));
				MenuItem quit = new MenuItem ("Quit",new MenuShortcut ('Q'));
				MenuItem cut = new MenuItem ("Cut",new MenuShortcut ('X'));
				MenuItem copy = new MenuItem ("Copy",new MenuShortcut ('C'));
				MenuItem undo = new MenuItem ("Undo",new MenuShortcut ('Z'));
				MenuItem redo = new MenuItem ("Redo",new MenuShortcut ('Y'));
				MenuItem paste = new MenuItem ("Paste",new MenuShortcut ('V'));
				MenuItem del = new MenuItem ("Delete");
				MenuItem search = new MenuItem ("Search",new MenuShortcut ('F'));
				MenuItem replace = new MenuItem ("Replace",new MenuShortcut ('H'));
				MenuItem about = new MenuItem ("About");
				
				file.add (newm);
				file.add (new MenuItem ("-"));
				file.add (open);
				file.add (save);
				file.add (new MenuItem ("-"));
				file.add (quit);
				
				edit.add (undo);
				edit.add (redo);
				edit.add (new MenuItem ("-"));
				edit.add (cut);
				edit.add (copy);
				edit.add (paste);
				
				
				
				look.add (search);
				look.add (replace);
				
				help.add (about);
				
				open.addActionListener (this);
				quit.addActionListener (this);
				save.addActionListener (this);
				newm.addActionListener (this);
				
				undo.addActionListener (this);
				redo.addActionListener (this);
				cut.addActionListener (this);
				copy.addActionListener (this);
				paste.addActionListener (this);
				
				search.addActionListener (this);
				replace.addActionListener (this);
				
				about.addActionListener (this);
				
				addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);
		
		}
		TextEditor (String txt,String fileN)
		{
				ta=new TextArea ();
				ta.setText(txt);
				fileName = fileN;
				mb = new MenuBar ();
				setMenuBar (mb);
				fileName = "Untitled.txt";
				setTitle ("TextEditor - " + fileName);
				Dimension d = getSize ();
				setVisible (true);
				setLayout (new BorderLayout ());
				setSize (500,500);
				add (ta,BorderLayout.CENTER);
				Menu file =new Menu ("File");
				Menu edit = new Menu ("Edit");
				Menu  look = new Menu ("Search");
				Menu  help = new Menu ("Help");
				
				mb.add (file);
				mb.add (edit);
				mb.add (look);
				mb.add (help);
				
				MenuItem newm = new MenuItem ("New",new MenuShortcut ('N'));
				MenuItem save = new MenuItem ("Save",new MenuShortcut ('S'));
				MenuItem open = new MenuItem ("Open",new MenuShortcut ('N'));
				MenuItem quit = new MenuItem ("Quit",new MenuShortcut ('Q'));
				MenuItem cut = new MenuItem ("Cut",new MenuShortcut ('X'));
				MenuItem copy = new MenuItem ("Copy",new MenuShortcut ('C'));
				MenuItem undo = new MenuItem ("Undo",new MenuShortcut ('Z'));
				MenuItem redo = new MenuItem ("Redo",new MenuShortcut ('Y'));
				MenuItem paste = new MenuItem ("Paste",new MenuShortcut ('V'));
				MenuItem del = new MenuItem ("Delete");
				MenuItem search = new MenuItem ("Search",new MenuShortcut ('F'));
				MenuItem replace = new MenuItem ("Replace",new MenuShortcut ('H'));
				MenuItem about = new MenuItem ("About");
				
				file.add (newm);
				file.add (new MenuItem ("-"));
				file.add (open);
				file.add (save);
				file.add (new MenuItem ("-"));
				file.add (quit);
				
				edit.add (undo);
				edit.add (redo);
				edit.add (new MenuItem ("-"));
				edit.add (cut);
				edit.add (copy);
				edit.add (paste);
				
				
				
				look.add (search);
				look.add (replace);
				
				help.add (about);
				
				open.addActionListener (this);
				quit.addActionListener (this);
				save.addActionListener (this);
				newm.addActionListener (this);
				
				undo.addActionListener (this);
				redo.addActionListener (this);
				cut.addActionListener (this);
				copy.addActionListener (this);
				paste.addActionListener (this);
				
				search.addActionListener (this);
				replace.addActionListener (this);
				
				about.addActionListener (this);
				
				addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);
		
		}
		public void actionPerformed (ActionEvent ae)
		{
				if(ae.getActionCommand().equals("Open"))
				{
					try{
						FileDialog fd = new FileDialog(this);
						fd.setVisible(true);
						FileInputStream fin = new FileInputStream(fd.getDirectory()+fd.getFile());
						int bs;
						
						while((bs=fin.read()) != -1)
						{
								buffer += String.valueOf((char)bs); 
						}
						new TextEditor(buffer,fd.getFile());
						fin.close();
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
		        else if(ae.getActionCommand().equals("Save"))
				{
					try{
						FileDialog fd = new FileDialog(this,"Save",FileDialog.SAVE);
						fd.setVisible(true);
						FileOutputStream fout = new FileOutputStream(fd.getDirectory()+fd.getFile());
						fout.write(ta.getText().getBytes());
						fout.close();					
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
				else if(ae.getActionCommand().equals("New"))
				{
					try{
						new TextEditor();
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
				else if(ae.getActionCommand().equals("Quit"))
				{
					try{
						System.exit(0);
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
				else if(ae.getActionCommand().equals("Cut"))
				{
					try{
	
						System.out.println(ta.getSelectedText());
						
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
				else if(ae.getActionCommand().equals("Copy"))
				{
					try{
	
						cpy = ta.getSelectedText();
						
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
				else if(ae.getActionCommand().equals("Paste"))
				{
					try{
	
						cpy = ta.getSelectedText();
						
					}
					catch(Exception e)
					{
					    System.out.println(e.getMessage());
					}
				}
		}
		public static void main (String arg[])
		{
			new TextEditor ();
			Frame f = new Frame();
		}
}
class Invalid extends Exception
{
	Dialog d;
	Invalid()
	{
		super("Invalid Exception thrown");
	}
	Invalid(String msg,Frame f)
	{
			super("Invalid Exception thrown");
			d = new Dialog(f,"Exception Caught");
			d.setLayout(new FlowLayout());
			d.setVisible(true);
			d.setSize(100,100);
			Label l = new Label(msg);
			d.add(l);			
			Button b = new Button("Ok");
			d.add(b);
			b.addMouseListener(new MouseAdapter()
			{
			 public void  mouseClicked(MouseEvent ae)
			 {
				d.setVisible(false);
			 }
			}
				
			);
	}
}
