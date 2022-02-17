
// YOU ARE NOT REQUIRED TO READ OR UNDERSTAND THIS CODE; YOU MAY NOT
// MODIFY IT.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.List;

public class BallotDialog extends JDialog{
	private JList<Object> choiceList;


	public BallotDialog(Frame owner, Ballot ballot){
		super(owner, "Vote for " + ballot.getOfficeName(), true);

		setSize(300, 500);

		buildUI(ballot);

		final BallotDialog bf = this;

		addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					int result = JOptionPane.showConfirmDialog(bf,
						"Are you done casting votes?",
						"Confirm Quit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (result == JOptionPane.YES_OPTION){
						dispose();
					}
				}
			});

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}


	private void buildUI(Ballot ballot){
		getContentPane().removeAll();

		GridBagLayout contentLayout = new GridBagLayout();
		setLayout(contentLayout);

		JLabel choicesLabel = new JLabel("Choices:");
		add(choicesLabel);
		contentLayout.setConstraints(
			choicesLabel,
			new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		//choiceList = new JList<Object>(ballot.getCandidates().toArray()); //FIXME
		choiceList = new JList<Object>(ballot.getCandidates().toArray());
		add(choiceList);
		choiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentLayout.setConstraints(
			choiceList,
			new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		JButton castVoteButton = new JButton("Cast Vote");
		castVoteButton.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					castVote();
				}
			});
		add(castVoteButton);
		contentLayout.setConstraints(
			castVoteButton,
			new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
	}


	private void castVote(){
		Candidate c = (Candidate) choiceList.getSelectedValue();

		if (c == null){
			JOptionPane.showMessageDialog(this,
				"No candidate is selected",
				"Choose a Candidate",
				JOptionPane.ERROR_MESSAGE);
		}	else {
			int result = JOptionPane.showConfirmDialog(this,
				"You are casting a vote for:\n   " + c.getName()
					+ " - " + c.getAffiliation() + "\nAre you sure?",
				"Confirm Vote",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (result == JOptionPane.OK_OPTION){
				c.tallyVote();
				choiceList.clearSelection();

				JOptionPane.showMessageDialog(this,
					"Vote tallied",
					"Done",
					JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
