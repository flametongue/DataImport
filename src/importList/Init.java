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
 * 描述：中企数据表格导入
 * 
 * @author feazen
 */
public class Init {
	static JFrame f;

	public static void main(String[] args) throws BiffException, IOException,
			ClassNotFoundException, SQLException {

		initUI();
		// int s = JOptionPane.showConfirmDialog(null, "是否继续", "wtf",
		// JOptionPane.YES_NO_OPTION);

		// DbConnect dc = new DbConnect();
		// try {
		// Connection conn = dc.createConnection();
		// ResultSet rs =
		// dc.ExecuteSql("SELECT phone,mail FROM .[t_employee] where personName = '测试——2'");
		// while (rs.next()) {
		// String phone = rs.getString("phone");
		// String mail = rs.getString("mail");
		// System.out.println("查询成功：电话"+phone+"--邮箱"+mail);
		// }
		// conn.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 描述：选择导入的Excel文件
	 * 
	 * @throws BiffException
	 * @throws IOException
	 */
	private static void chooseFile() throws BiffException, IOException {
		JFileChooser jfChooser = new JFileChooser();
		int results = jfChooser.showOpenDialog(f);
		if (results == JFileChooser.APPROVE_OPTION) {
			File file = jfChooser.getSelectedFile();// 根据文件名创建一个文件对象
			Workbook wb = Workbook.getWorkbook(file);// 从文件流中取得Excel工作区对象
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
	 * 描述：初始化界面
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
			// 年度各地社保公积金基数比例表导入
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
		lbtitle.setText("中企人力外部信息Excel导入--仅限内部使用");
		panel.add(lbtitle);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
	}

	private void showInfo() {

	}
}
