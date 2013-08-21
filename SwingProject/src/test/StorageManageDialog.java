package test;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class StorageManageDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1659266002992705086L;

	public javax.swing.JButton btnAdd;

	public javax.swing.JButton btnClose;

	public javax.swing.JButton btnDelete;
	public javax.swing.JButton btnDetail;
	public javax.swing.JButton btnEdit;
	private javax.swing.JPanel pnlCenter;
	private javax.swing.JPanel pnlEditor;
	private javax.swing.JPanel pnlNorth;
	private javax.swing.JPanel pnlSouth;
	private javax.swing.JScrollPane storageListSclPane;
	public javax.swing.JTable storageListTbl;

	public static void main(String[] args) {
		
      new StorageManageDialog(new Frame("test"),true);
	}
	/**
	 * Creates new form StorageManageDialog
	 */
	public StorageManageDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlNorth = new javax.swing.JPanel();
		pnlEditor = new javax.swing.JPanel();
		btnAdd = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnEdit = new javax.swing.JButton();
		btnDetail = new javax.swing.JButton();
		pnlCenter = new javax.swing.JPanel();
		storageListSclPane = new javax.swing.JScrollPane();
		storageListTbl = new javax.swing.JTable();
		pnlSouth = new javax.swing.JPanel();
		btnClose = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setName("Storage Manage Dialog"); // NOI18N
		setPreferredSize(new java.awt.Dimension(860, 420));

		pnlNorth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		pnlNorth.setLayout(new java.awt.BorderLayout());

		pnlEditor
				.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		pnlEditor.setLayout(new java.awt.GridBagLayout());

		btnAdd.setText("create");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
		pnlEditor.add(btnAdd, gridBagConstraints);

		btnDelete.setText("delete");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(15, 25, 5, 5);
		pnlEditor.add(btnDelete, gridBagConstraints);

		btnEdit.setText("edit");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(15, 25, 5, 5);
		pnlEditor.add(btnEdit, gridBagConstraints);

		btnDetail.setText("detail");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(15, 25, 5, 5);
		pnlEditor.add(btnDetail, gridBagConstraints);

		pnlNorth.add(pnlEditor, java.awt.BorderLayout.WEST);

		getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

		pnlCenter.setLayout(new java.awt.GridBagLayout());

		storageListTbl
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{
										"storage1",
										"/opt/storage1/defaultCluster/storagePool1",
										"shared storage", "GFS", "1,024",
										"512", "2013.07.13 8:00",
										"it can be store template and virtual machines" },
								{
										"storage2",
										"/opt/storage1/defaultCluster/storagePool1",
										"unshared storage", "NFS", "2,048",
										"1,024", "2013.08.01 14:00",
										"it just can be store template" } },
						new String[] { "Name", "Path", "Type",
								"File System Type", "Total Size(GB)",
								"Free Size(GB)", "Create Time", "Description" }) {
					boolean[] canEdit = new boolean[] { false, false, false,
							false, false, false, false, false };
					Class[] types = new Class[] { java.lang.String.class,
							java.lang.String.class, java.lang.String.class,
							java.lang.String.class, java.lang.String.class,
							java.lang.String.class, java.lang.String.class,
							java.lang.String.class };

					public Class getColumnClass(int columnIndex) {
						return types[columnIndex];
					}

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		storageListSclPane.setViewportView(storageListTbl);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.weightx = 0.1;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		pnlCenter.add(storageListSclPane, gridBagConstraints);

		getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

		pnlSouth.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		btnClose.setText("Close");
		pnlSouth.add(btnClose);
		getContentPane().add(pnlSouth, java.awt.BorderLayout.PAGE_END);
		pack();
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}