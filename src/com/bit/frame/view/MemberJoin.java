package com.bit.frame.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.bit.frame.controller.MemberDAO;
import com.bit.frame.model.MemberDTO;

public class MemberJoin extends JFrame{
JPanel jPan1 = new JPanel();
	
	JTextField txtId = new JTextField(10); // ȸ��id
	JTextField txtName = new JTextField(10);
	JPasswordField txtPw = new JPasswordField(10);
	JPasswordField txtPw1 = new JPasswordField(10);
	JRadioButton rBtn1 = new JRadioButton("����");
	JRadioButton rBtn2 = new JRadioButton("����");
	JTextField txtTel = new JTextField(10);
	
	MemberDAO  memberDAO = new MemberDAO();
	
	public MemberJoin(){
	
		int lableAlign = JLabel.RIGHT;
		Color backColor = Color.LIGHT_GRAY;
		
		setTitle("ȸ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ȸ������ Title ǥ�úκ�
		JLabel frmTitle = new JLabel("ȸ������");
		
		// ��Ʈ ����
		Font font = new Font("Gulim",Font.BOLD,30);
		// ���̺� ����
		frmTitle.setFont(font);
		frmTitle.setHorizontalAlignment(JLabel.CENTER);
		add(frmTitle,"North");
		
		// Grid ũ�� ����
								// rows, cols
		jPan1.setLayout(new GridLayout(9,3));
		jPan1.setBackground(backColor);
		
		
		jPan1.add(new JLabel());
		jPan1.add(new JLabel());
		jPan1.add(new JLabel());
		
		
		/********************************************
		 * id �Է�â ����
		 */
		JLabel lbText = new JLabel("���̵�",lableAlign);
		jPan1.add(lbText);
		
		Font txtFont = new Font("Gulim",Font.PLAIN,20);
		txtId.setFont(txtFont);
		
		jPan1.add(txtId);
		jPan1.add(new JLabel());
		
		//============================================
		
		/*********************************************
		 * �̸� �Է�â ����
		 */
		lbText = new JLabel("�̸�",lableAlign);
		jPan1.add(lbText);
		
		txtName.setFont(txtFont);
		jPan1.add(txtName);
		jPan1.add(new JLabel());
		//===========================================
		
		/********************************************
		 * ��й�ȣ �Է�â
		 */
		lbText = new JLabel("��й�ȣ",lableAlign);
		jPan1.add(lbText);
		
		jPan1.add(txtPw);
		jPan1.add(new JLabel());
		
		/********************************************
		 * ��й�ȣ Ȯ�� �Է�â
		 */
		lbText = new JLabel("��й�ȣȮ��",lableAlign);
		jPan1.add(lbText);
		
		jPan1.add(txtPw1);
		jPan1.add(new JLabel());
		
		/*********************************************
		 * ���� ����â 
		 */
		lbText = new JLabel("����",lableAlign);
		jPan1.add(lbText);
		
		// ���� ��ư�� panel
		JPanel bGrp = new JPanel();
		
		// ���� ��ư ����
		
		rBtn1.setBackground(backColor);
		
		rBtn2.setBackground(backColor);
		
		// 2���� ���� ��ư�� �׷����� �������ְ�
		ButtonGroup rGrp = new ButtonGroup();
		rGrp.add(rBtn1);
		rGrp.add(rBtn2);

		// ������ư�� �гο� ��ư�� �߰�
		bGrp.add(rBtn1);
		bGrp.add(rBtn2);
		bGrp.setBackground(backColor);
		// ������ ���� ��ư�� �г��� �����г� �߰�
		jPan1.add(bGrp);
		jPan1.add(new JLabel());
		
		//======================================================
		
		/*******************************************************
		 * ��ȭ��ȣ �Է�â
		 */
		lbText = new JLabel("��ȭ��ȣ",lableAlign);
		jPan1.add(lbText);
		
		
		jPan1.add(txtTel);
		
		jPan1.add(new JLabel());

		
		/*******************************************************
		 * ȸ������ ��ư
		 */
		
		JButton btnJoin = new JButton("����");
		btnJoin.addActionListener(new JoinAction());
		
		jPan1.add(new JLabel());
		jPan1.add(btnJoin);
		jPan1.add(new JLabel());
		
		add(jPan1,"Center");
		
		// ȭ���߾ӿ� ����
		setLocationRelativeTo(null);
		setSize(500,700);
		pack();
		setVisible(true);
	}
	
	// �̺�Ʈ �ڵ鷯 class, ��ư �̺�Ʈ�� ó���ϴ� Ŭ����
	class JoinAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/***********************************
			 * �ʼ��Է� �׸��� �Էµ��������� �޽����� �����ش�.
			 */
			// ȸ�� ID �� �Է����� �ʾ�����
			if(txtId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(txtId, "ȸ��ID�� �ʼ��׸��Դϴ�");
				txtId.requestFocus(true);
				return ;
			}
			// �̸��� �Է����� �ʾ�����
			if(txtName.getText().isEmpty()){
				JOptionPane.showMessageDialog(jPan1, "�̸��� �ʼ��׸��Դϴ�");
				txtName.requestFocus(true);
				return ;
			}
			
			String strPw = new String(txtPw.getPassword()); // �˼����� ��
			String strPw1 = new String(txtPw1.getPassword()); // 
			
//			if(txtPw.getText().isEmpty()){
			if(strPw.isEmpty()) {
				JOptionPane.showMessageDialog(jPan1, "��й�ȣ�� �Է��ϼ���");
				txtPw.requestFocus(true);
				return ;
			}
//			if(txtPw1.getText().isEmpty()){
			if(strPw1.isEmpty()){
				JOptionPane.showMessageDialog(jPan1, "��й�ȣ Ȯ���� �Է��ϼ���");
				txtPw1.requestFocus(true);
				return ;
			}
			// ��й�ȣ�Է°� Ȯ�� ���� ���� �ٸ���
//			if(!txtPw.getText().equals(txtPw1.getText())) {
			if(!strPw.equals(strPw1)) {
				JOptionPane.showMessageDialog(jPan1, "��й�ȣ ���� �ٸ��ϴ� Ȯ���ϼ���");
				txtPw.setText(""); // TextFiel ������ ����
				txtPw1.setText("");
				txtPw.requestFocus(true);
				return ;
			}
			
			// TextField�� �Է��� ������DTO�� ����
			MemberDTO dto = new MemberDTO();
			dto.setUserId(txtId.getText());
			dto.setUserName(txtName.getText());
//			dto.setUserPw(new String(txtPw.getPassword()));
			dto.setUserPw(strPw);
			
			// 2���� ���� ��ư ���¿� ���� setUserSex���� ����
			if(rBtn1.isSelected()) dto.setUserSex("����");// ���ڰ� ����
			if(rBtn2.isSelected()) dto.setUserSex("����");// ���ڰ� ����
			dto.setUserTel(txtTel.getText());
			
			int ret = memberDAO.insert(dto);
			if(ret > 0) {
				JOptionPane.showMessageDialog(jPan1,
						Integer.toString(ret)+" ������ ���������� �߰� �Ǿ����ϴ�");
			} else {
				JOptionPane.showMessageDialog(jPan1,
						" ������ �߰��� ���� �߽��ϴ�.");
				
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new MemberJoin();
	}

	
	}


