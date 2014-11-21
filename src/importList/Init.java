package importList;
import java.io.File;
import java.io.IOException;
import java.rmi.server.Operation;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


import java.sql.ResultSet;
import java.sql.Statement;










import javax.swing.JFileChooser;
/**
 * �������������ݱ����
 * @author feazen
 */
import javax.swing.JFrame;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class Init {
	static JFrame f;
	public static void main(String[] args) throws BiffException, IOException {
		
		initUI();
//		connectDataBase();
//		chooseFile();
	}
	
	/**
	 * ������ѡ�����Excel�ļ�
	 * @throws BiffException
	 * @throws IOException
	 */
	private static void chooseFile() throws BiffException, IOException {
		JFileChooser jfChooser = new JFileChooser();
		int results = jfChooser.showOpenDialog(f);
		if (results == JFileChooser.APPROVE_OPTION) {
			File file = jfChooser.getSelectedFile();// �����ļ�������һ���ļ�����
//			file.setReadOnly();
			Workbook wb = Workbook.getWorkbook(file);// ���ļ�����ȡ��Excel����������
			Sheet sheet = wb.getSheet(0);
			
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					String sTemp = cell.getContents();
						sTemp = sTemp.trim();
						System.out.println(sTemp);
				}
				wb.close();
//				file.
			}
		}
	}


	/**
	 * ��������ʼ������
	 */
	private static void initUI() {
//		JFrame f = new JFrame("init");
//		f.setVisible(true);
		f = new JFrame();
		f.setSize(404, 400);
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnfoundrateimport = new JButton("\u5BFC\u5165\u5E74\u5EA6\u5404\u5730\u793E\u4FDD\u516C\u79EF\u91D1\u57FA\u6570\u6BD4\u4F8B");
		btnfoundrateimport.addActionListener(new ActionListener() {
			//��ȸ����籣�����������������
			public void actionPerformed(ActionEvent e) {
				try {
					chooseFile();
				} catch (BiffException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnfoundrateimport.setBounds(28, 47, 253, 23);
		panel.add(btnfoundrateimport);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(24, 80, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(24, 128, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(24, 171, 93, 23);
		panel.add(btnNewButton_3);
		
		JLabel lbtitle = new JLabel("New label");
		lbtitle.setBounds(28, 22, 287, 15);
		lbtitle.setText("���������ⲿ��ϢExcel����--�����ڲ�ʹ��");
		panel.add(lbtitle);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
	}
}
