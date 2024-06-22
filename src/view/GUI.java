package view;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
//Import thư viện JDBC của MySQL
import com.mysql.cj.jdbc.Driver;
import java.awt.SystemColor;
import java.util.Arrays;
public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel_1;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTable table;
    private DefaultTableModel model;
    private Map<String, boolean[]> rolePermissions = new HashMap<>();
    private Map<String, String[]> rolePermissionNames = new HashMap<>();
    private List<JCheckBox> checkBoxes;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    GUI frame = new GUI();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public GUI() {
    	setBackground(SystemColor.inactiveCaptionBorder);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        RoundedPanel jPanelMenu = new RoundedPanel(50, Color.WHITE);
        jPanelMenu.setBounds(5, 5, 136, 453);
        contentPane.add(jPanelMenu);

        JLabel labelHouse = new JLabel("");
        labelHouse.setBounds(0, 0, 136, 78);
        labelHouse.setHorizontalAlignment(SwingConstants.CENTER);
        Image img = new ImageIcon(getClass().getResource("/img/House.png")).getImage();
        jPanelMenu.setLayout(null);
        labelHouse.setIcon(new ImageIcon(img));
        jPanelMenu.add(labelHouse);

        JPanel panel = new JPanel();
        panel.setBounds(0, 78, 136, 375);
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        JLabel labelDH = new JLabel("Đơn Hàng");
        labelDH.setHorizontalAlignment(SwingConstants.CENTER);
        labelDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgDH = new ImageIcon(getClass().getResource("/img/icon_DonHang.png")).getImage();
        Image scaledImgDH = imgDH.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        labelDH.setIcon(new ImageIcon(scaledImgDH));
        labelDH.setBounds(29, 88, 140, 50);
        panel.add(labelDH);
        labelDH.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTK = new JLabel("Tồn Kho");
        labelTK.setHorizontalAlignment(SwingConstants.CENTER);
        labelTK.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgTK = new ImageIcon(getClass().getResource("/img/icon_TonKho.png")).getImage();
        Image scaledImgTK = imgTK.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        labelTK.setIcon(new ImageIcon(scaledImgTK));
        labelTK.setBounds(29, 149, 140, 50);
        panel.add(labelTK);
        labelTK.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelNX = new JLabel("Nhập/Xuất");
        labelNX.setHorizontalAlignment(SwingConstants.CENTER);
        labelNX.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgNX = new ImageIcon(getClass().getResource("/img/icon_NhapXuat.png")).getImage();
        Image scaledImgNX = imgNX.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        labelNX.setIcon(new ImageIcon(scaledImgNX));
        labelNX.setBounds(29, 197, 140, 50);
        panel.add(labelNX);
        labelNX.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelVT = new JLabel("Vị Trí Kho");
        labelVT.setHorizontalAlignment(SwingConstants.CENTER);
        labelVT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgVT = new ImageIcon(getClass().getResource("/img/icon_ViTri.png")).getImage();
        Image scaledImgVT = imgVT.getScaledInstance(40, 36, Image.SCALE_SMOOTH);
        labelVT.setIcon(new ImageIcon(scaledImgVT));
        labelVT.setBounds(29, 258, 140, 50);
        panel.add(labelVT);
        labelVT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelQT = new JLabel("Quản Trị");
        labelQT.setHorizontalAlignment(SwingConstants.CENTER);
        labelQT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgQT = new ImageIcon(getClass().getResource("/img/icon_QuanTri.png")).getImage();
        Image scaledImgQT = imgQT.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        labelQT.setIcon(new ImageIcon(scaledImgQT));
        labelQT.setBounds(29, 319, 140, 50);
        panel.add(labelQT);
        labelQT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTKe = new JLabel("Thống kê");
        labelTKe.setHorizontalAlignment(SwingConstants.CENTER);
        labelTKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Image imgTKe = new ImageIcon(getClass().getResource("/img/icon_ThongKe.png")).getImage();
        Image scaledImgTKe = imgTKe.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        labelTKe.setIcon(new ImageIcon(scaledImgTKe));
        labelTKe.setBounds(29, 376, 140, 50);
        panel.add(labelTKe);
        labelTKe.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalGlue());

        jPanelMenu.add(panel);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(SystemColor.inactiveCaptionBorder);
        tabbedPane.setBounds(141, 5, 541, 453);
        contentPane.add(tabbedPane);
        
        panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.inactiveCaption);
        panel_1.setToolTipText("");
        tabbedPane.addTab("Quản lí nhân viên", null, panel_1, null);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Mã nhân viên");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_7.setBounds(21, 50, 96, 13);
        panel_1.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Tên nhân viên");
        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_8.setBounds(21, 90, 96, 13);
        panel_1.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Chức vụ");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_9.setBounds(21, 128, 71, 13);
        panel_1.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Số điện thoại");
        lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_10.setBounds(302, 50, 82, 13);
        panel_1.add(lblNewLabel_10);
        
        textField_7 = new JTextField();
        textField_7.setBounds(394, 47, 96, 19);
        panel_1.add(textField_7);
        textField_7.setColumns(10);
        
        JLabel lblNewLabel_11 = new JLabel("Giới tính");
        lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_11.setBounds(302, 87, 56, 13);
        panel_1.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("Email");
        lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_12.setBounds(302, 128, 45, 13);
        panel_1.add(lblNewLabel_12);
        
        textField_8 = new JTextField();
        textField_8.setBounds(394, 125, 96, 19);
        panel_1.add(textField_8);
        textField_8.setColumns(10);
        
        JLabel lblNewLabel_13 = new JLabel("Tìm kiếm");
        lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_13.setBounds(168, 154, 82, 13);
        panel_1.add(lblNewLabel_13);
        
        textField_9 = new JTextField();
        textField_9.setBounds(261, 151, 96, 19);
        panel_1.add(textField_9);
        textField_9.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.inactiveCaption);
        panel_3.setBounds(10, 10, 516, 211);
        panel_1.add(panel_3);
        panel_3.setLayout(null);
        
        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton.setBounds(72, 180, 85, 21);
        panel_3.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Xóa");
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(193, 180, 85, 21);
        panel_3.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Tìm");
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_2.setBounds(330, 180, 85, 21);
        panel_3.add(btnNewButton_2);
        
        textField_4 = new JTextField();
        textField_4.setBounds(116, 36, 96, 19);
        panel_3.add(textField_4);
        textField_4.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(116, 76, 96, 19);
        panel_3.add(textField_6);
        textField_6.setColumns(10);
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Nữ");
        chckbxNewCheckBox_1.setBounds(423, 74, 50, 21);
        panel_3.add(chckbxNewCheckBox_1);
        chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        textField_5 = new JTextField();
        textField_5.setBounds(116, 113, 96, 19);
        panel_3.add(textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Thông tin nhân viên");
        lblNewLabel_6.setBounds(193, 10, 135, 13);
        panel_3.add(lblNewLabel_6);
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Nam");
        chckbxNewCheckBox.setBounds(351, 74, 64, 21);
        panel_3.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 222, 516, 194);
        panel_1.add(scrollPane);
        
        table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ch\u1EE9c v\u1EE5", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Gi\u1EDBi t\u00EDnh", "Email"
        	}
        ));
        scrollPane.setViewportView(table);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Phân quyền", null, panel_2, null);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Quản lí phân quyền");
        lblNewLabel.setBounds(213, 22, 129, 13);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nhóm quyền");
        lblNewLabel_1.setBounds(121, 59, 85, 13);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(lblNewLabel_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(244, 59, 98, 21);
        comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
        panel_2.add(comboBox);
        
        JButton btnNewButton_4 = new JButton("Sửa quyền");
        btnNewButton_4.setBounds(195, 341, 116, 21);
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Lưu quyền");
        btnNewButton_5.setBounds(343, 341, 116, 21);
        btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(btnNewButton_5);
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Quản lí nhập hàng");
        chckbxNewCheckBox_2.setBounds(236, 107, 150, 21);
        chckbxNewCheckBox_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(chckbxNewCheckBox_2);
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Quản lí sản phẩm");
        chckbxNewCheckBox_3.setBounds(236, 144, 150, 21);
        chckbxNewCheckBox_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(chckbxNewCheckBox_3);
        
        JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Quản lí nhân viên");
        chckbxNewCheckBox_4.setBounds(236, 185, 150, 21);
        chckbxNewCheckBox_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(chckbxNewCheckBox_4);
        
        JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Quản lí khách hàng");
        chckbxNewCheckBox_5.setBounds(236, 224, 150, 21);
        chckbxNewCheckBox_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(chckbxNewCheckBox_5);
        
        JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Quản lí thống kê");
        chckbxNewCheckBox_6.setBounds(236, 266, 150, 21);
        chckbxNewCheckBox_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_2.add(chckbxNewCheckBox_6);
        
        // Khởi tạo model cho JTable
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {
            "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Số điện thoại", "Giới tính", "Email"
        });

        // Set model cho table
        table.setModel(model);

        // Kết nối và lấy dữ liệu từ cơ sở dữ liệu
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Thiết lập kết nối với cơ sở dữ liệu MySQL
            String url = "jdbc:mysql://localhost:3306/Nhanvien";
            String user = "root";
            String password = "thuan12345";
            
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(url, user, password);

            // Query để lấy dữ liệu từ bảng nhân viên (ví dụ)
            String sql = "SELECT * FROM Hg";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Duyệt ResultSet và thêm từng dòng vào model của JTable
            while (rs.next()) {
                Object[] row = new Object[] {
                    rs.getString("manhanvien"),
                    rs.getString("tennhanvien"),
                    rs.getString("chucvu"),
                    rs.getString("sodienthoai"),
                    rs.getString("gioitinh"),
                    rs.getString("email")
                };
                model.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
     // Thông tin kết nối đến MySQL
        String url = "jdbc:mysql://localhost:3306/Nhanvien";
        String user = "root";
        String password = "thuan12345";

     // Sự kiện cho nút "Thêm"
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường
                String maNV = textField_4.getText();
                String tenNV = textField_6.getText();
                String chucVu = textField_5.getText();
                String soDienThoai = textField_7.getText();
                String gioiTinh = (chckbxNewCheckBox.isSelected()) ? "Nam" : "Nữ";
                String email = textField_8.getText();
                
                // Thêm vào bảng (JTable)
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{maNV, tenNV, chucVu, soDienThoai, gioiTinh, email});
                
                // Lưu vào cơ sở dữ liệu
                Connection conn = null;
                PreparedStatement pstmt = null;
                try {
                    // Kết nối đến cơ sở dữ liệu
                    conn = DriverManager.getConnection(url, user, password);
                    
                    // Câu lệnh SQL để thêm dữ liệu vào bảng nhân viên
                    String sql = "INSERT INTO Hg (manhanvien, tennhanvien, chucvu, sodienthoai, gioitinh, email) VALUES (?, ?, ?, ?, ?, ?)";
                    
                    // Tạo đối tượng PreparedStatement để thực thi câu lệnh SQL
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, maNV);
                    pstmt.setString(2, tenNV);
                    pstmt.setString(3, chucVu);
                    pstmt.setString(4, soDienThoai);
                    pstmt.setString(5, gioiTinh);
                    pstmt.setString(6, email);
                    
                    // Thực thi câu lệnh
                    pstmt.executeUpdate();
                    
                    // Thông báo thành công (nếu cần)
                    JOptionPane.showMessageDialog(GUI.this, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Xử lý các lỗi kết nối hoặc thao tác với cơ sở dữ liệu
                } finally {
                    // Đóng các đối tượng PreparedStatement và Connection sau khi sử dụng
                    try {
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                
                // Xóa nội dung các trường sau khi thêm thành công
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                textField_8.setText("");
                chckbxNewCheckBox.setSelected(false);
                chckbxNewCheckBox_1.setSelected(false);
            }
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                
                if (selectedRow == -1) {
                    return;
                }
                
                String maNV = (String) table.getValueAt(selectedRow, 0);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                
                Connection conn = null;
                PreparedStatement pstmt = null;
                try {
                    conn = DriverManager.getConnection(url, user, password);
                    
                    String sql = "DELETE FROM Hg WHERE manhanvien = ?";
                    
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, maNV);
                    
                    int rowsAffected = pstmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        // Hiển thị hộp thoại thông báo khi xóa thành công
                        JOptionPane.showMessageDialog(GUI.this, "Xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(GUI.this, "Không thể xóa nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(GUI.this, "Lỗi khi xóa nhân viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
     // Sự kiện cho nút "Tìm"
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy mã nhân viên từ textField_9
                String maNV = textField_9.getText().trim(); // trim() để loại bỏ khoảng trắng đầu cuối
                
                // Xóa hết dữ liệu trong bảng (table)
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                // Kết nối đến cơ sở dữ liệu
                Connection conn = null;
                PreparedStatement pstmt = null;
                try {
                    // Thiết lập kết nối đến cơ sở dữ liệu
                    conn = DriverManager.getConnection(url, user, password);
                    
                    // Câu lệnh SQL để tìm kiếm nhân viên theo mã nhân viên
                    String sql = "SELECT * FROM Hg WHERE manhanvien = ?";
                    
                    // Tạo đối tượng PreparedStatement để thực thi câu lệnh SQL
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, maNV);
                    
                    // Thực thi câu lệnh
                    ResultSet rs = pstmt.executeQuery();
                    
                    // Kiểm tra xem có kết quả trả về hay không
                    if (!rs.isBeforeFirst()) { // Nếu không có kết quả (rs không trỏ đến dòng trước đầu tiên)
                        // Hiển thị hộp thoại thông báo khi không tìm thấy nhân viên
                        JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhân viên có mã " + maNV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Hiển thị thông tin nhân viên lên bảng
                        while (rs.next()) {
                            String maNhanVien = rs.getString("manhanvien");
                            String tenNhanVien = rs.getString("tennhanvien");
                            String chucVu = rs.getString("chucvu");
                            String soDienThoai = rs.getString("sodienthoai");
                            String gioiTinh = rs.getString("gioitinh");
                            String email = rs.getString("email");
                            
                            // Thêm thông tin vào bảng (table)
                            model.addRow(new Object[]{maNhanVien, tenNhanVien, chucVu, soDienThoai, gioiTinh, email});
                        }
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Xử lý các lỗi kết nối hoặc thực thi câu lệnh SQL
                } finally {
                    // Đóng các đối tượng PreparedStatement và Connection sau khi sử dụng
                    try {
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

       
       
        
        
        
        
//        btnNewButton_4.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Lấy JCheckBox đang được chọn
//                Component[] components = panel_2.getComponents();
//                JCheckBox selectedCheckBox = null;
//                for (Component component : components) {
//                    if (component instanceof JCheckBox && ((JCheckBox) component).isSelected()) {
//                        selectedCheckBox = (JCheckBox) component;
//                        break;
//                    }
//                }
//                
//                if (selectedCheckBox != null) {
//                    // Hiển thị hộp thoại nhập tên quyền mới
//                    String tenQuyenMoi = JOptionPane.showInputDialog(GUI.this, "Nhập tên quyền mới:", selectedCheckBox.getText());
//                    
//                    if (tenQuyenMoi != null && !tenQuyenMoi.isEmpty()) {
//                        // Lấy mã nhóm quyền từ JComboBox
//                        String nhomQuyen = (String) comboBox.getSelectedItem();
//                        String maNhomQuyen = (nhomQuyen.equals("Quản lý")) ? "N01" : "N02";
//                        
//                        // Kết nối đến cơ sở dữ liệu
//                        Connection conn = null;
//                        PreparedStatement pstmt = null;
//                        try {
//                            conn = DriverManager.getConnection(url, user, password);
//                            
//                            // Câu lệnh SQL để cập nhật tên quyền trong cơ sở dữ liệu
//                            String sql = "UPDATE phanquyen SET tenquyen = ? WHERE maquyen = ? AND tenquyen = ?";
//                            pstmt = conn.prepareStatement(sql);
//                            pstmt.setString(1, tenQuyenMoi);
//                            pstmt.setString(2, maNhomQuyen);
//                            pstmt.setString(3, selectedCheckBox.getText());
//                            
//                            // Thực thi câu lệnh SQL
//                            int rowsUpdated = pstmt.executeUpdate();
//                            
//                            if (rowsUpdated > 0) {
//                                // Cập nhật tên quyền trên JCheckBox
//                                selectedCheckBox.setText(tenQuyenMoi);
//                                
//                                JOptionPane.showMessageDialog(GUI.this, "Sửa quyền thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                JOptionPane.showMessageDialog(GUI.this, "Sửa quyền thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                            }
//                            
//                        } catch (SQLException ex) {
//                            ex.printStackTrace();
//                            JOptionPane.showMessageDialog(GUI.this, "Lỗi khi sửa quyền: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
//                        } finally {
//                            // Đóng PreparedStatement và Connection
//                            try {
//                                if (pstmt != null) pstmt.close();
//                                if (conn != null) conn.close();
//                            } catch (SQLException ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(GUI.this, "Vui lòng chọn quyền cần sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        });
     // Tạo một danh sách để lưu trữ các JCheckBox
        checkBoxes = Arrays.asList(
        	    chckbxNewCheckBox_2, chckbxNewCheckBox_3, chckbxNewCheckBox_4, 
        	    chckbxNewCheckBox_5, chckbxNewCheckBox_6
        	);
        rolePermissions.put("Quản lý", new boolean[checkBoxes.size()]);
        rolePermissions.put("Nhân viên", new boolean[checkBoxes.size()]);
     // Khởi tạo quyền mặc định cho mỗi vai trò
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) e.getItem();
                    boolean[] permissions = rolePermissions.get(selectedRole);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setSelected(permissions[i]);
                    }
                }
            }
        });
        
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedRole = (String) comboBox.getSelectedItem();
                boolean[] permissions = rolePermissions.get(selectedRole);
                
                boolean anySelected = false;
                for (int i = 0; i < checkBoxes.size(); i++) {
                    permissions[i] = checkBoxes.get(i).isSelected();
                    if (permissions[i]) {
                        anySelected = true;
                    }
                }

                if (anySelected) {
                    JOptionPane.showMessageDialog(GUI.this, 
                        "Lưu quyền thành công cho " + selectedRole, 
                        "Thông báo", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(GUI.this, 
                        "Vui lòng chọn quyền để lưu", 
                        "Cảnh báo", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });  
        
        checkBoxes = Arrays.asList(
                chckbxNewCheckBox_2, chckbxNewCheckBox_3, chckbxNewCheckBox_4, 
                chckbxNewCheckBox_5, chckbxNewCheckBox_6
            );
       
        rolePermissions.put("Quản lý", new boolean[checkBoxes.size()]);
        rolePermissions.put("Nhân viên", new boolean[checkBoxes.size()]);
        // Khởi tạo tên quyền ban đầu
        String[] initialNames = new String[checkBoxes.size()];
        for (int i = 0; i < checkBoxes.size(); i++) {
            initialNames[i] = checkBoxes.get(i).getText();
        }
        rolePermissionNames.put("Quản lý", initialNames.clone());
        rolePermissionNames.put("Nhân viên", initialNames.clone());

      

        // ... code cho comboBox và btnNewButton_5 (Lưu quyền) như trước

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedRole = (String) comboBox.getSelectedItem();
                boolean[] permissions = rolePermissions.get(selectedRole);
                String[] names = rolePermissionNames.get(selectedRole);

                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        String currentName = names[i];
                        String input = JOptionPane.showInputDialog(GUI.this,
                            "Nhập tên mới cho quyền " + currentName + ":",
                            currentName);
                        
                        if (input != null && !input.trim().isEmpty()) {
                            names[i] = input.trim();
                            permissions[i] = true;
                            checkBoxes.get(i).setText(input.trim());
                        }
                    }
                }

                // Cập nhật trạng thái checkbox sau khi sửa
                for (int i = 0; i < checkBoxes.size(); i++) {
                    checkBoxes.get(i).setSelected(permissions[i]);
                }

                JOptionPane.showMessageDialog(GUI.this,
                    "Đã cập nhật quyền cho " + selectedRole,
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Thêm ItemListener cho comboBox để cập nhật tên quyền khi chuyển đổi vai trò
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) e.getItem();
                    boolean[] permissions = rolePermissions.get(selectedRole);
                    String[] names = rolePermissionNames.get(selectedRole);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setSelected(permissions[i]);
                        checkBoxes.get(i).setText(names[i]);
                    }
                }
            }
        });
        setVisible(true);
        
    }
}

