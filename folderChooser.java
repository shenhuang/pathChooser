import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class folderChooser extends JPanel
{
	
	/* A file chooser that stores the chosen directory name as pathname. */
	
	public String pathName = "No Folder Selected";
	public File fileChoosed;
	private JLabel folderPathName = new JLabel("   " + pathName);
	
	public folderChooser(String name)
	{

		setLayout(new BorderLayout());
		TitledBorder border = new TitledBorder(name);
		setBorder(border);
		
		/* Choose button. */
		
		JButton chooseButton = new JButton("Choose");
		chooseButton.setPreferredSize(new Dimension(80, 20));
		add(chooseButton,  BorderLayout.EAST);
		
		chooseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				chooseButtonAction();
			}
		}
		);
		
		/* " Folder Path:   " label */
		
		JLabel label = new JLabel(" Folder Path:   ");
		add(label, BorderLayout.WEST);
		
		/* Folder path display. */
		
		JPanel pathBox = new JPanel();
		pathBox.setLayout(new BorderLayout());
		LineBorder pathBoxBorder = new LineBorder(Color.BLACK);
		pathBox.setBorder(pathBoxBorder);
		folderPathName.setHorizontalTextPosition(JLabel.LEFT);
		pathBox.add(folderPathName, BorderLayout.CENTER);
		
		add(pathBox, BorderLayout.CENTER);
		
	}
	
	private void chooseButtonAction()
	{
		
		/* Prompts the user to choose a path and update the label text. */
		
		JFileChooser fileChooser = new JFileChooser(); 
	    fileChooser.setCurrentDirectory(new java.io.File("."));
	    fileChooser.setDialogTitle("Choose a Folder");
	    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    fileChooser.showOpenDialog(this);
	    fileChoosed = fileChooser.getSelectedFile();
	    pathName = fileChoosed.getAbsolutePath();
	    folderPathName.setText("   " + pathName);

	}
}
