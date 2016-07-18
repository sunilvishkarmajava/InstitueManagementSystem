package com.bmpl.ims.users.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bmpl.ims.users.dao.Batchdao;
import com.bmpl.ims.users.dto.BatchDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;
import java.util.Properties;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Cursor;

public class AddBatch extends JFrame {

	private JPanel contentPane;
	private JTextField tnr_name;
	private JTextField Bth_name;
	private JTextField cur_name;
	private JTextField total_set;
	private JTextField field;
	private java.util.Date date1;
	private java.sql.Date sqldate;
	private Batchdao batchDAO;
	private BatchDTO batchDTO;
	private JTextField batchStarts;
	private JTextArea des_area;
	
	
	public static void main(String[] args) {
	
					AddBatch frame = new AddBatch();
					frame.setVisible(true);
		
	}

	public AddBatch() {
		setTitle("AddBatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 508);
		getContentPane().setLayout(null);
		
		JLabel lblBatchname = new JLabel("CourseName");
		lblBatchname.setLabelFor(this);
		lblBatchname.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBatchname.setBounds(41, 103, 138, 27);
		getContentPane().add(lblBatchname);
		
		JLabel label = new JLabel("BatchName");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(52, 60, 110, 27);
		getContentPane().add(label);
		
		JLabel lblTrainername = new JLabel("BatchCount");
		lblTrainername.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrainername.setBounds(41, 184, 127, 27);
		getContentPane().add(lblTrainername);
		
		tnr_name = new JTextField();
		tnr_name.setBounds(226, 151, 117, 20);
		getContentPane().add(tnr_name);
		tnr_name.setColumns(10);
		
		Bth_name = new JTextField();
		Bth_name.setColumns(10);
		Bth_name.setBounds(226, 65, 117, 20);
		getContentPane().add(Bth_name);
		
		cur_name = new JTextField();
		cur_name.setColumns(10);
		cur_name.setBounds(226, 108, 117, 20);
		getContentPane().add(cur_name);
		
		JLabel label_1 = new JLabel("TrainerName");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(51, 146, 117, 27);
		getContentPane().add(label_1);
		
		total_set = new JTextField();
		total_set.setColumns(10);
		total_set.setBounds(226, 189, 35, 20);
		getContentPane().add(total_set);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(41, 267, 125, 27);
		getContentPane().add(lblDescription);
		
		JButton btnAddBatch = new JButton("Add Batch");
		btnAddBatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBatch();
			}
		});
		btnAddBatch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddBatch.setBounds(73, 435, 127, 23);
		getContentPane().add(btnAddBatch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Resetfield();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(229, 435, 127, 23);
		getContentPane().add(btnReset);
		
		JLabel lblBatchtime = new JLabel("Date");
		lblBatchtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchtime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBatchtime.setBounds(41, 222, 72, 27);
		getContentPane().add(lblBatchtime);
		
		batchStarts = new JTextField();
		batchStarts.setToolTipText("DD-MM-YYYY");
		batchStarts.setBounds(223, 227, 120, 20);
		getContentPane().add(batchStarts);
		batchStarts.setColumns(10);
		
		des_area = new JTextArea();
		des_area.setBounds(226, 270, 117, 134);
		des_area.setLineWrap(true);
		getContentPane().add(des_area);
		//date1 = date.getDate();
		//sqldate=new java.sql.Date(date1.getTime());
	}
	
	public void addBatch()
	{
		BatchDTO batchDTO =new BatchDTO();
		batchDAO=new Batchdao();
		batchDTO.setBatchname(Bth_name.getText());
		batchDTO.setCoursename(cur_name.getText());
		batchDTO.setTrainername(tnr_name.getText());
		int total=Integer.parseInt(total_set.getText());
		batchDTO.setTotalsets(total);
		batchDTO.setDescription(des_area.getText());
		batchDTO.setBatchstartdate(batchStarts.getText());
		/*java.util.Date di=dateChooser.getDate();
		long date=di.getTime();
		java.sql.Date sql=new java.sql.Date(date);*/
		//batchdto.setBatchstartdate(sqldate);
		//boolean isaddbatch=false;
		try {
			boolean isaddbatch = batchDAO.addbatch(batchDTO);
			if(isaddbatch)
			{
				JOptionPane.showMessageDialog(this, "Batch Created........");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	  	}
		public void Resetfield()
		{
			Bth_name.setText("");
			cur_name.setText("");
			tnr_name.setText("");
			total_set.setText("");
			des_area.setText("");
			batchStarts.setText("");
			
			
		}
	}
