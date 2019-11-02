package flarcher.pairing.matrix.xls;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class MatrixReaderTest {

	@Test
	public void testXlsRead() {
		InputStream resourceAsStream = MatrixReaderTest.class.getResourceAsStream("/example.xlsx");
		try (XlsMatrixReader reader = XlsMatrixReader.fromStream(resourceAsStream)) {
			reader.get();
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Assert.fail();
		}
	}
}
