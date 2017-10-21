package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AssetNumberField;
	private JButton submitButton;
	private JButton infoButton;
	private JLabel assetChanged;

	/**
	 * Create the frame.
	 */
	public View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/if_computer_settings_103452.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 323);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(154, 205, 50));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(154, 205, 50)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerintIatmTool = new JLabel("Verint ITAM Tool");
		lblVerintIatmTool.setFont(new Font("Arial", Font.BOLD, 17));
		lblVerintIatmTool.setBounds(10, 11, 148, 14);
		contentPane.add(lblVerintIatmTool);
		
		JLabel lblEnterAssetNumber = new JLabel("Enter Verint Asset Number");
		lblEnterAssetNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterAssetNumber.setBounds(44, 78, 198, 29);
		contentPane.add(lblEnterAssetNumber);
		
		AssetNumberField = new JTextField();
		AssetNumberField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		AssetNumberField.setBounds(44, 132, 198, 20);
		contentPane.add(AssetNumberField);
		AssetNumberField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setMnemonic(KeyEvent.VK_STOP);
		btnSubmit.setBounds(93, 184, 89, 23);
		contentPane.add(btnSubmit);
		submitButton = btnSubmit;
		
		JButton btnAssetInfo = new JButton("Asset Info");
		btnAssetInfo.setBounds(10, 255, 100, 29);
		contentPane.add(btnAssetInfo);
		infoButton = btnAssetInfo;
		
		JLabel lblAssetDataChanged = new JLabel("Asset Data Changed");
		lblAssetDataChanged.setForeground(new Color(30, 144, 255));
		lblAssetDataChanged.setBounds(136, 262, 137, 14);
		contentPane.add(lblAssetDataChanged);
		assetChanged = lblAssetDataChanged;
		assetChanged.setVisible(false);
	}
	
	/** 
	 * controller listeners
	 */
	protected void submitAsset(ActionListener listenerForSubmitAsset){
		submitButton.addActionListener(listenerForSubmitAsset);
	}
	
	protected void assetInfo(ActionListener listenerForAssetInfo){
		infoButton.addActionListener(listenerForAssetInfo);
	}
	
	//getters
	protected String getAsset() {
		return AssetNumberField.getText();
	}
	
	//methods
	
	//if no errors in model, asset data has been changed successfully
	protected void showChange(boolean value) {
		assetChanged.setVisible(value);
	}

}
