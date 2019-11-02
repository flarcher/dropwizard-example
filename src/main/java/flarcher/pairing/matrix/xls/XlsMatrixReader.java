package flarcher.pairing.matrix.xls;

import flarcher.pairing.Army;
import flarcher.pairing.matrix.Matrix;
import flarcher.pairing.matrix.MatrixReader;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XlsMatrixReader implements MatrixReader {

	public static XlsMatrixReader fromFile(File inputFile) {
		if (!inputFile.canRead()) {
			throw new IllegalArgumentException(String.format("Can not read %s", inputFile.getAbsolutePath()));
		}
		try {
			return new XlsMatrixReader(new FileInputStream(inputFile));
		}
		catch (FileNotFoundException fnf) {
			throw new IllegalArgumentException(String.format("Can not find %s", inputFile.getAbsolutePath()));
		}
	}

	public static XlsMatrixReader fromStream(InputStream inputStream) {
		if (inputStream == null) {
			throw new IllegalArgumentException("No stream");
		}
		return new XlsMatrixReader(inputStream);
	}

	private XlsMatrixReader(InputStream inputStream) {
		try {
			this.document = new XSSFWorkbook(inputStream);
		}
		catch (IOException ioe) {
			try {
				inputStream.close();
			}
			catch (IOException ioe2) {}
			throw new IllegalStateException(ioe);
		}
	}

	private final XSSFWorkbook document;
	private final static int MAX_ORIGIN_SEARCH_CELL_DISTANCE = 10;

	private static boolean notEmptyCell(XSSFCell cell) {
		return cell != null && cell.getCellType() != CellType.BLANK;
	}

	private XSSFCell getOrigin() {
		XSSFSheet sheet = document.getSheetAt(0);// Assuming we use the first sheet
		for (int i = 0; i < MAX_ORIGIN_SEARCH_CELL_DISTANCE; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			for (int j = 0; j < MAX_ORIGIN_SEARCH_CELL_DISTANCE; j++) {
				XSSFCell cell = row.getCell(j);
				if (notEmptyCell(cell)) {
					return cell;
				}
			}
		}
		throw new IllegalArgumentException("No content found");
	}

	private static void printArmies(List<Army> armies) {
		System.out.println(armies.toString());
	}

	@Override
	public Matrix get() {
		XSSFCell origin = getOrigin();
		XSSFCell cell = origin;

		// Reading column armies
		int index = 0;
		List<Army> columnArmies = new ArrayList<>();
		do {
			columnArmies.add(new Army(cell.getStringCellValue(), index++, false));
			cell = cell.getRow().getCell(cell.getColumnIndex() + 1);
		} while (notEmptyCell(cell));
		printArmies(columnArmies);

		// Reading row armies
		index = 0;
		List<Army> rowArmies = new ArrayList<>();
		cell = origin.getSheet()
				.getRow(origin.getRowIndex() + 1)
				.getCell(origin.getColumnIndex() - 1);
		do {
			rowArmies.add(new Army(cell.getStringCellValue(), index++, true));
			cell = cell.getSheet().getRow(cell.getRowIndex() + 1).getCell(cell.getColumnIndex());
		} while (notEmptyCell(cell));
		printArmies(rowArmies);

		return null; // TODO
	}

	@Override
	public void close() throws Exception {
		try {
			document.close();
		}
		catch (IOException ioe) {
			throw new IllegalStateException(ioe);
		}
	}
}
