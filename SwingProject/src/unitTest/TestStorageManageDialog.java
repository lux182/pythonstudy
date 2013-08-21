package unitTest;

import static org.junit.Assert.*;

import java.awt.Frame;

import org.junit.Test;

import test.StorageManageDialog;

public class TestStorageManageDialog {

	@Test
	public void testStorageManageDialog() {
		Frame f= new Frame();
		new StorageManageDialog(f,true);
	}

}
