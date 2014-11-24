package importList;

import importList.DbUtil.DbConnect;
import importList.tableinfo.FundRateInfo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * �������������ݱ����
 * 
 * @author feazen
 */
public class Init {
	static JFrame f;

	public static void main(String[] args) throws BiffException, IOException,
			ClassNotFoundException, SQLException {

		initUI();
		// int s = JOptionPane.showConfirmDialog(null, "�Ƿ����", "wtf",
		// JOptionPane.YES_NO_OPTION);

		// DbConnect dc = new DbConnect();
		// try {
		// Connection conn = dc.createConnection();
		// ResultSet rs =
		// dc.ExecuteSql("SELECT phone,mail FROM .[t_employee] where personName = '���ԡ���2'");
		// while (rs.next()) {
		// String phone = rs.getString("phone");
		// String mail = rs.getString("mail");
		// System.out.println("��ѯ�ɹ����绰"+phone+"--����"+mail);
		// }
		// conn.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * ������ѡ�����Excel�ļ�
	 * 
	 * @throws BiffException
	 * @throws IOException
	 */
	private static void chooseFile() throws BiffException, IOException {
		JFileChooser jfChooser = new JFileChooser();
		int results = jfChooser.showOpenDialog(f);
		if (results == JFileChooser.APPROVE_OPTION) {
			File file = jfChooser.getSelectedFile();// �����ļ�������һ���ļ�����
			Workbook wb = Workbook.getWorkbook(file);// ���ļ�����ȡ��Excel����������
			Sheet sheet = wb.getSheet(0);

			for (int i = 6; i < sheet.getRows(); i++) {
				FundRateInfo fundRateInfo = new FundRateInfo();//fundRateInfo.getClass().getDeclaredFields()[1].set(obj, value);
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					String sTemp = cell.getContents();
					if (sTemp != null)
						sTemp = sTemp.trim();
//					fundRateInfo.set(key, value);
				}
			}
			wb.close();
		}
	}

	/**
	 * ��������ʼ������
	 */
	private static void initUI() {
		f = new JFrame();
		f.setSize(404, 400);

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnfoundrateimport = new JButton(
				"\u5BFC\u5165\u5E74\u5EA6\u5404\u5730\u793E\u4FDD\u516C\u79EF\u91D1\u57FA\u6570\u6BD4\u4F8B");
		btnfoundrateimport.addActionListener(new ActionListener() {
			// ��ȸ����籣�����������������
			public void actionPerformed(ActionEvent e) {
				try {
					chooseFile();
				} catch (BiffException | IOException e1) {
					JOptionPane.showConfirmDialog(f, e1.getMessage());
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

	private void showInfo() {

	}
}
