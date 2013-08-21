package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
@Deprecated
public class TreeEditTest {
	public static void main(String[] args) {
		JFrame frame = new TreeEditFrame();
//		frame.show();
		frame.setVisible(true);
	}
}
@Deprecated
class TreeEditFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeEditFrame() {
		setTitle("TreeEditTest");
		setSize(800, 600);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// construct tree

		TreeNode root = makeSampleTree();
		model = new DefaultTreeModel(root);
		tree = new JTree(model);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(new ImageIcon("1.gif"));
		renderer.setClosedIcon(new ImageIcon("2.gif"));
		renderer.setOpenIcon(new ImageIcon("3.gif"));
		// renderer.setBackgroundNonSelectionColor(Color.BLUE);
		// renderer.setBackgroundSelectionColor(Color.RED);
		renderer.setBorderSelectionColor(Color.RED);

		tree.setCellRenderer(renderer);

		// add scroll pane with tree to content pane

		Container contentPane = getContentPane();
		JScrollPane scrollPane = new JScrollPane(tree);
		contentPane.add(scrollPane, "Center");

		// make button panel

		JPanel panel = new JPanel();
		addSiblingButton = new JButton("Add Sibling");
		addSiblingButton.addActionListener(this);
		panel.add(addSiblingButton);
		addChildButton = new JButton("Add Child");
		addChildButton.addActionListener(this);
		panel.add(addChildButton);
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel.add(deleteButton);
		contentPane.add(panel, "South");
	}

	public TreeNode makeSampleTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
		DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
		root.add(country);
		DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
		country.add(state);
		DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
		state.add(city);
		city = new DefaultMutableTreeNode("Cupertino");
		state.add(city);
		state = new DefaultMutableTreeNode("Michigan");
		country.add(state);
		city = new DefaultMutableTreeNode("Ann Arbor");
		state.add(city);
		country = new DefaultMutableTreeNode("Germany");
		root.add(country);
		state = new DefaultMutableTreeNode("Schleswig-Holstein");
		country.add(state);
		city = new DefaultMutableTreeNode("Kiel");
		state.add(city);
		return root;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (selectedNode == null)
			return;

		if (event.getSource().equals(deleteButton)) {
			if (selectedNode.getParent() != null)
				model.removeNodeFromParent(selectedNode);
			// model.removeFromParent(selectedNode);
			return;
		}

		// add new node as sibling or child

		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");

		if (event.getSource().equals(addSiblingButton)) {
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode
					.getParent();

			if (parent != null) {
				int selectedIndex = parent.getIndex(selectedNode);
				model.insertNodeInto(newNode, parent, selectedIndex + 1);
			}
		} else if (event.getSource().equals(addChildButton)) {
			model.insertNodeInto(newNode, selectedNode,
					selectedNode.getChildCount());
		}

		// now display new node

		TreeNode[] nodes = model.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		tree.scrollPathToVisible(path);
	}

	private DefaultTreeModel model;

	private JTree tree;

	private JButton addSiblingButton;

	private JButton addChildButton;

	private JButton deleteButton;

	private JButton editButton;
}