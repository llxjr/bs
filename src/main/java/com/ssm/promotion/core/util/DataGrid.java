package com.ssm.promotion.core.util;

import java.io.Serializable;

import net.sf.json.JSONArray;

public class DataGrid implements Serializable {

	private Long total;
	private JSONArray rows;

	public DataGrid() {

	}

	public DataGrid(Long total, Object rows) {
		this.total = total;
		this.rows = JSONArray.fromObject(rows);
	}

	public DataGrid(Long total, JSONArray rows) {
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public JSONArray getRows() {
		return rows;
	}

	public void setRows(JSONArray rows) {
		this.rows = rows;
	}

}
