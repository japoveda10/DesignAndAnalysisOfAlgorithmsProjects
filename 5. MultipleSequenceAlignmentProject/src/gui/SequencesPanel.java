package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SequencesPanel extends JPanel implements ActionListener
{
	//-----------------------------------------------------------
	// Constants
	//-----------------------------------------------------------
	
	public final static String ALIGN_SEQUENCES = "Align";
	
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	private SequencesAlignmentProjectGUI gui;
	
	private JLabel sequence1Label;
	
	private JLabel sequence2Label;
	
	private JTextField sequence1TextField;
	
	private JTextField sequence2TextField;
	
	private JButton alignSequencesButton;
	
	private JLabel sequencesAlignedTitleLabel;
	
	private JLabel alignedSequence1Label;
	
	private JLabel alignedSequence2Label;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	public SequencesPanel(SequencesAlignmentProjectGUI pGUI)
	{
		gui = pGUI;
		
		setLayout(new GridLayout(6,2));
		setPreferredSize(new Dimension(0, 200));
		
		TitledBorder border = BorderFactory.createTitledBorder("Sequences");
		setBorder(border);
		
		sequence1Label = new JLabel("Sequence 1");
		sequence1TextField = new JTextField();
		sequence1TextField.setEditable(true);
		sequence1TextField.setBackground(Color.WHITE);
		
		sequence2Label = new JLabel("Sequence 2");
		sequence2TextField = new JTextField();
		sequence2TextField.setEditable(true);
		sequence2TextField.setBackground(Color.WHITE);
		
		alignSequencesButton = new JButton("Align");
		alignSequencesButton.setActionCommand(ALIGN_SEQUENCES);
		alignSequencesButton.addActionListener(this);
		
		sequencesAlignedTitleLabel = new JLabel("Sequences aligned:");
		
		alignedSequence1Label = new JLabel("SEQUENCE 1");
		alignedSequence2Label = new JLabel("SEQUENCE 2");
		
		add(sequence1Label);
		add(sequence1TextField);
		add(sequence2Label);
		add(sequence2TextField);
		add(new JLabel(""));
		add(alignSequencesButton);
		add(sequencesAlignedTitleLabel);
		add(new JLabel(""));
		add(new JLabel(""));
		add(alignedSequence1Label);
		add(new JLabel(""));
		add(alignedSequence2Label);
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	public String getSequence1()
	{
		return sequence1TextField.getText();
	}
	
	public String getSequence2()
	{
		return sequence2TextField.getText();
	}
	
	public void setSequence1(String pSequence1)
	{
		alignedSequence1Label.setText(pSequence1);
	}
	
	public void setSequence2(String pSequence2)
	{
		alignedSequence2Label.setText(pSequence2);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		
		if(command.equals(ALIGN_SEQUENCES))
		{
			System.out.println("Align sequences");
			gui.alignSequences();
		}
	}
}
