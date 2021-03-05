import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField textMSSV;
	private JTextField textHoten;
	private JTextField textNgaysinh;
	private JTextField textQuequan;
	private JTextField textHokhau;
	private JTextField textDiem;
	private JTable table;
	private JComboBox<String> cbKhoa;
	private JComboBox<String> cbGioitinh;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm()  {
		setResizable(false);
		setTitle("Quản lý sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Thông tin", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_UP || 
						e.getKeyCode() == KeyEvent.VK_DOWN) {
					getInfo(table, model);
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getInfo(table, model);
			}
		});
		scrollPane.setViewportView(table);
		model.addColumn("STT");
		model.addColumn("Mã SV");
        model.addColumn("Họ và tên");
        model.addColumn("Ngày sinh");
        model.addColumn("Giới tính");
        model.addColumn("Điểm TB");
        model.addColumn("Khoa");
        
    
		
		JButton btShow = new JButton("Show");
		btShow.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
								getData(table, model);
					}
		});
		
		JButton btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
							add();
					}
					
		});

		JButton btUpdate = new JButton("Update");
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				getData(table, model);
			}
		});
		
		JButton btDelete = new JButton("Delete");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(table, model);
			}
		});
		
		JButton btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(btShow, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btAdd, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(btUpdate, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btDelete, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btReset)
					.addGap(97))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btShow)
						.addComponent(btReset)
						.addComponent(btDelete)
						.addComponent(btUpdate)
						.addComponent(btAdd))
					.addGap(3)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
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
		cbKhoa.setModel(new DefaultComboBoxModel<String>(new String[] {"CNTT", "Môi trường", "Hóa", "Kiến trúc", "Điện tử viễn thông"}));
		cbKhoa.setBounds(420, 73, 218, 22);
		panel.add(cbKhoa);
		
		cbGioitinh = new JComboBox<>();
		cbGioitinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		cbGioitinh.setBounds(420, 98, 74, 22);
		panel.add(cbGioitinh);
		contentPane.setLayout(gl_contentPane);
	}
/*======================================================CONNECT CSDL===========================================================================*/	
	
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
	
	private void getData(JTable table, DefaultTableModel mode)
    {

        String getData = "select MaSV, Ten, NgaySinh, Gioitinh, DiemTB, Khoa from qlsv.sinhvien";
        connect();
        try
        {
			rs = stmt.executeQuery(getData);		
			mode.setRowCount(0); 
			while(rs.next())
			{
					mode.addRow(new Object[]{table.getRowCount()+1,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
			}
		
		}catch (SQLException e) 
        	{
			// TODO Auto-generated catch block
			e.printStackTrace();
        	}
        reset();
    }
	
	/*=======================================================================================================================================*/
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
	private void delete(JTable table, DefaultTableModel mode)
	{
		int del = table.getSelectedRow();
		Object ms = table.getModel().getValueAt(del, 1);
		String queryDel =  "delete from qlsv.sinhvien where MaSV = '" + ms + "'";
		connect();
		try {
			stmt.execute(queryDel);
			getData(table, mode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void add()
	{
		AddForm form = new AddForm();
		form.setVisible(true);
		setVisible(false);
	}
	private void getInfo(JTable table,DefaultTableModel mode)
	{
		int index = table.getSelectedRow();
		textMSSV.enable(false);
		textMSSV.setText(table.getValueAt(index, 1).toString());
		textHoten.setText(table.getValueAt(index, 2).toString());
		textNgaysinh.setText(table.getValueAt(index, 3).toString());
		cbGioitinh.setSelectedItem(table.getValueAt(index, 4));
		textDiem.setText(table.getValueAt(index, 5).toString());
		cbKhoa.setSelectedItem(table.getValueAt(index, 6));
		
		String queryInfo = "select Quequan , Hokhau from qlsv.sinhvien where MaSV  = '" +textMSSV.getText()+"'";
		connect();
		try {
			rs = stmt.executeQuery(queryInfo);
			while(rs.next())
			{
					
					textQuequan.setText(rs.getString(1));
					textHokhau.setText(rs.getNString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void update()
	{	
		int index = table.getSelectedRow();
		
		if (index == -1 )
        {
            JOptionPane.showMessageDialog(null, "Hãy chọn sinh viên muốn sửa!! ");
        
        }
        else
        {
          
            connect();
            String queryUpdate = "update SINHVIEN set MaSV ='" + textMSSV.getText() + "', Ten = '" + textHoten.getText() + "'," +
                                 "Ngaysinh = '" + textNgaysinh.getText() + "'," +
                                 "Quequan = '" + textQuequan.getText() + "',Hokhau = '" + textHokhau.getText() + "'," +
                                 "DiemTB = '" + textDiem.getText() + "',Khoa ='" + cbKhoa.getSelectedItem().toString() + "'," +
                                 "Gioitinh = '" +cbGioitinh.getSelectedItem().toString() + "' where MaSV = '" + textMSSV.getText() + "'";
            try {
				stmt.execute(queryUpdate);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi!!!\nCập nhật không thành công.\nKiểm tra thông tin nhập vào.");
				e.printStackTrace();
			}
            
            reset();
        }
	}
	
	
}
