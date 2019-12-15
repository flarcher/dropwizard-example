package flarcher.pairing.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tournament {

	public Tournament() {
	}

	@JsonProperty("table_count")
	private int tableCount;

	public int getTableCount() {
		return tableCount;
	}

	public void setTableCount(int tableCount) {
		this.tableCount = tableCount;
	}
}
