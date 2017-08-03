package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import src.SequenceAlignment;

public class SequencesAlignmentProjectGUI extends JFrame
{
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	/**
	 * Instance of the logic of the sequence alignment
	 */
	private SequenceAlignment sequencesAlignment;
	
	/**
	 * Sequences panel
	 */
	private SequencesPanel sequencesPanel;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	public SequencesAlignmentProjectGUI()
	{
		setTitle("Sequences alignment");
		setSize(290, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		sequencesPanel = new SequencesPanel(this);
		add(sequencesPanel, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	public void alignSequences()
	{
		String sequence1 = sequencesPanel.getSequence1();
		String sequence2 = sequencesPanel.getSequence2();
		
		sequencesAlignment = new SequenceAlignment(sequence1, sequence2);
		
		String alignedSequence1 = sequencesAlignment.getNewSequence1();
		String alignedSequence2 = sequencesAlignment.getNewSequence2();
		
		sequencesPanel.setSequence1(alignedSequence1);
		sequencesPanel.setSequence2(alignedSequence2);
	}
	
	//-----------------------------------------------------------
	// Main
	//-----------------------------------------------------------
	
	public static void main(String[] args)
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Multiple Sequence Alignment Project");
		System.out.println("-------------------------------------------------");
		
		SequencesAlignmentProjectGUI gui = new SequencesAlignmentProjectGUI();
	}
}
