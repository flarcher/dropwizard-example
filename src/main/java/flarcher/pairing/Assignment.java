package flarcher.pairing;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Assignment implements Cloneable {

	Assignment(int tableCount) {
		rowArmyIndexes = new int[tableCount]; // Filled with 0
		colArmyIndexes = new int[tableCount]; // Filled with 0
	}

	private Assignment(int[] rowArmyIndexes, int[] colArmyIndexes) {
		this.colArmyIndexes = colArmyIndexes;
		this.rowArmyIndexes = rowArmyIndexes;
	}

	private final int[] rowArmyIndexes; // 0 means not-assigned
	private final int[] colArmyIndexes; // 0 means not-assigned

	public Assignment assign(int table, Army row, Army column) {
		rowArmyIndexes[table] = row.getIndex();
		colArmyIndexes[table] = column.getIndex();
		return this;
	}

	public boolean isAssigned(int table) {
		return rowArmyIndexes[table] != 0 && colArmyIndexes[table] != 0;
	}

	boolean isComplete() {
		return IntStream.concat(
				Arrays.stream(rowArmyIndexes),
				Arrays.stream(colArmyIndexes)
		).allMatch(i -> i != 0);
	}

	int getTableCount() {
		return rowArmyIndexes.length;
	}

	@Override
	protected Assignment clone() throws CloneNotSupportedException {
		return new Assignment(rowArmyIndexes.clone(), colArmyIndexes.clone());
	}
}
