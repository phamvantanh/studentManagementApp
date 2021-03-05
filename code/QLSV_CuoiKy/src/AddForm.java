import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AddForm extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	private JTextField textMSSV;
	private JTextField textHoten;
	private JTextField textNgaysinh;
	private JTextField textQuequan;
	private JTextField textHokhau;
	private JTextField textDiem;
	private JComboBox<String> cbKhoa;
	private JComboBox<String> cbGioitinh;
	private JButton btOK;
	private JButton btExit;
	private JButton btReset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm frame = new AddForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddForm() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Quản lý sinh viên");
		setBounds(100, 100, 706, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Thông tin", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		btExit = new JButton("Exit");
		btExit.addActionListener(this);
		
		btOK = new JButton("OK");
		btOK.addActionListener(this);
		
		btReset = new JButton("Reset");
		btReset.addActionListener(this);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addComponent(btOK, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(btExit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btReset)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btOK)
						.addComponent(btExit)
						.addComponent(btReset))
					.addGap(198))
		);
		panel.setLayout(null);
		
		JLabel lbMSSV = new JLabel("MSSV");
		lbMSSV.setBounds(10, 27, 38, 14);
		panel.add(lbMSSV);
		
		JLabel lbHovaten = new JLabel("Họ và tên");
		lbHovaten.setBounds(10, 52, 57, 14);
		panel.add(lbHovaten);
		
		JLabel lbNgaysinh = new JLabel("Ngày sinh");
		lbNgaysinh.setBounds(10, 77, 57, 14);
		panel.add(lbNgaysinh);
		
		JLabel lbQuequan = new JLabel("Quê quán");
		lbQuequan.setBounds(10, 102, 57, 14);
		panel.add(lbQuequan);
		
		JLabel lbHktt = new JLabel("Hộ khẩu thường trú");
		lbHktt.setBounds(284, 27, 126, 14);
		panel.add(lbHktt);
		
		JLabel lbDiemTB = new JLabel("Điểm TB tích lũy");
		lbDiemTB.setBounds(284, 52, 126, 14);
		panel.add(lbDiemTB);
		
		JLabel lbKhoa = new JLabel("Khoa");
		lbKhoa.setBounds(284, 77, 74, 14);
		panel.add(lbKhoa);
		
		JLabel lbGioitinh = new JLabel("Giới tính");
		lbGioitinh.setBounds(284, 102, 74, 14);
		panel.add(lbGioitinh);
		
		textMSSV = new JTextField();
		textMSSV.setBounds(72, 24, 197, 20);
		panel.add(textMSSV);
		textMSSV.setColumns(10);
		
		textHoten = new JTextField();
		textHoten.setBounds(72, 49, 197, 20);
		panel.add(textHoten);
		textHoten.setColumns(10);
		
		textNgaysinh = new JTextField();
		textNgaysinh.setBounds(72, 74, 110, 20);
		panel.add(textNgaysinh);
		textNgaysinh.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(yyyy-MM-dd)");
		lblNewLabel.setBounds(192, 77, 74, 14);
		panel.add(lblNewLabel);
		
		textQuequan = new JTextField();
		textQuequan.setBounds(72, 99, 197, 20);
		panel.add(textQuequan);
		textQuequan.setColumns(10);
		
		textHokhau = new JTextField();
		textHokhau.setBounds(420, 24, 218, 20);
		panel.add(textHokhau);
		textHokhau.setColumns(10);
		
		textDiem = new JTextField();
		textDiem.setBounds(420, 49, 218, 20);
		panel.add(textDiem);
		textDiem.setColumns(10);
		
		cbKhoa = new JComboBox<>();
		cbKhoa.setModel(new DefaultComboBoxModel<String>(new String[] {"CNTT", "Moi Truong", "Hoa", "Kien Truc", "Dien tu vien thong"}));
		cbKhoa.setBounds(420, 73, 218, 22);
		panel.add(cbKhoa);
		
		cbGioitinh = new JComboBox<>();
		cbGioitinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		cbGioitinh.setBounds(420, 98, 74, 22);
		panel.add(cbGioitinh);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent e)
	{	
		if (e.getSource()==btOK)
		add();
			
		if(e.getSource() == btExit)
		{	
			setVisible(false);
			MainForm form = new MainForm();
			form.setVisible(true);
		}
		if(e.getSource() == btReset)
		{
			reset();
		}
	}
	private void reset()
	{                                         
        textMSSV.setText("");
        textHoten.setText("");
        textNgaysinh.setText("");
        textQuequan.setText("");
        textHokhau.setText("");
        textDiem.setText("");
        cbKhoa.setSelectedIndex(0);
        cbGioitinh.setSelectedIndex(0);   
    }
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	public void connect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.print("Error: " + ex.getMessage());
		}
		try
		{
			String url = "jdbc:mysql://localhost/qlsv?user=root&password=123456";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(SQLException se)
		{
			System.err.println("Error: "+se.getMessage());
		}
	}
	public void add()
	{	
		DefaultTableModel model = new DefaultTableModel();
		JTable tableTam = new JTable(model);
		model.addColumn("Mã SV");
		
		try {
			connect();
			String checkMSSV = "SELECT MaSV FROM qlsv.sinhvien WHERE MaSV ='" +textMSSV.getText()+"'";
	        try
	        {
				rs = stmt.executeQuery(checkMSSV);		
				model.setRowCount(0); 
				while(rs.next())
				{
						model.addRow(new Object[]{rs.getString(1)});
				}
				
				if(tableTam.getRowCount()>0)
	            {
	                JOptionPane.showMessageDialog(null, "Mã sinh viên này đã tồn tại !!!");
	            }
	            else
	            {
	               
	                String queryAdd = "INSERT into qlsv.sinhvien values ('" + textMSSV.getText() + "','" + textHoten.getText() + "'," +
	                    "'" + textNgaysinh.getText() + "','" + textQuequan.getText() + "','" + textHokhau.getText() + "'," +
	                    "'" + textDiem.getText() + "','" +cbKhoa.getSelectedItem().toString()+ "','" +cbGioitinh.getSelectedItem().toString() + "')";
	                stmt.execute(queryAdd);
	                JOptionPane.showMessageDialog(null, "Đã thêm thành công!!!");
	                setVisible(false);
	                MainForm form = new MainForm();
	    			form.setVisible(true);
	            }
			
			}catch (SQLException e) 
	        	{
				JOptionPane.showMessageDialog(null, "Kiểm tra thông tin nhập vào. \n- Kiểm tra định dạng ngày tháng \n- Không để trống bất kỳ trường nào");
				e.printStackTrace();
	        	}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}


