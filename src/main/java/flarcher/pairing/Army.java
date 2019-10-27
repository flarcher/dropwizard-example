package flarcher.pairing;

import javax.annotation.concurrent.Immutable;
import java.util.Objects;

@Immutable
public class Army {

	/**
	 * Represents a player's army.
	 * @param name Army name.
	 * @param index  Index starting with 1 (not zero-based)
	 * @param isRow Is the army on a row or a column from the data source.
	 */
	public Army(String name, int index, boolean isRow) {
		this.name = name;
		this.index = index;
		this.isRow = isRow;
	}

	private final String name;
	private final int index;
	private final boolean isRow;

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	public boolean isRow() {
		return isRow;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Army army = (Army) o;
		return index == army.index &&
				isRow == army.isRow;
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, isRow);
	}
}
