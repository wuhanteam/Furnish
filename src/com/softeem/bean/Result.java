package com.softeem.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;

public class Result implements Serializable {
	private Object[][] result = null;

	private int rowNumber = -1;

	private int colNumber = -1;

	private int totalRow = -1;

	private int beginRow = 1;

	private Hashtable colNames = null;

	public Result() {
	}

	public Result(Object[][] rs, Hashtable h) {
		this.colNames = h;
		this.result = rs;
		if (rs == null) {
			this.rowNumber = 0;
			this.colNumber = 0;
			this.totalRow = 0;
		} else {
			this.rowNumber = this.result.length;
			this.colNumber = this.result[0].length;
			this.totalRow = this.result.length;
		}
	}

	public Result(Object[][] rs, int totalRowNumber, Hashtable h) {
		this.colNames = h;
		this.result = rs;
		if (rs == null) {
			this.rowNumber = 0;
			this.colNumber = 0;
			this.totalRow = 0;
		} else {
			this.rowNumber = this.result.length;
			this.colNumber = this.result[0].length;
			this.totalRow = totalRowNumber;
		}
	}

	public int totalNum() {
		return this.totalRow;
	}

	public int rowNum() {
		return this.rowNumber;
	}

	public int colNum() {
		return this.colNumber;
	}

	public Object getObject(int i, int j) {
		return this.result[i][j];
	}

	public Object getObject(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getObject(i, j);
	}

	public String getString(int i, int j) {
		if (this.result[i][j] == null)
			return "";
		return (String) this.result[i][j];
	}

	public String getString(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getString(i, j);
	}

	public BigDecimal getBigDecimal(int i, int j) {
		//if (this.result[i][j] == null)
			return new BigDecimal(0);
		//return new BigDecimal(()this.result[i][j]);
	}

	public BigDecimal getBigDecimal(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getBigDecimal(i, j);
	}

	public short getShort(int i, int j) {
		if (this.result[i][j] == null)
			return 0;
		return ((BigDecimal) this.result[i][j]).shortValue();
	}

	public short getShort(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getShort(i, j);
	}

	public int getInt(int i, int j) {
		if (this.result[i][j] == null)
			return 0;
		return ((BigDecimal) this.result[i][j]).intValue();
	}

	public int getInt(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getInt(i, j);
	}

	public long getLong(int i, int j) {
		if (this.result[i][j] == null)
			return 0L;
		return ((BigDecimal) this.result[i][j]).longValue();
	}

	public long getLong(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getLong(i, j);
	}

	public float getFloat(int i, int j) {
		if (this.result[i][j] == null)
			return 0.0F;
		return ((BigDecimal) this.result[i][j]).floatValue();
	}

	public float getFloat(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getFloat(i, j);
	}

	public double getDouble(int i, int j) {
		if (this.result[i][j] == null)
			return 0.0D;
		return ((BigDecimal) this.result[i][j]).doubleValue();
	}

	public double getDouble(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getDouble(i, j);
	}

	public Date getDate(int i, int j) {
		if (this.result[i][j] == null)
			return null;
		return (Timestamp) this.result[i][j];
	}

	public Date getDate(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getDate(i, j);
	}

	public Timestamp getTimestamp(int i, int j) {
		if (this.result[i][j] == null)
			return null;
		return (Timestamp) this.result[i][j];
	}

	public Timestamp getTimestamp(int i, String colName) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		return getTimestamp(i, j);
	}

	public void setObject(int i, int j, Object x) {
		this.result[i][j] = x;
	}

	public void setObject(int i, String colName, Object x) {
		int j = ((Integer) this.colNames.get(colName.toUpperCase())).intValue();
		this.result[i][j] = x;
	}

	public void addColumn(String columnName) {
		if ((this.colNumber < 1) || (this.rowNumber < 1) || (columnName == null)) {
			return;
		}
		this.colNames.put(columnName.toUpperCase(), new Integer(this.colNumber));
		this.colNumber += 1;

		Object[][] newResult = new Object[this.rowNumber][this.colNumber];

		for (int i = 0; i < this.rowNumber; i++) {
			for (int j = 0; j < this.colNumber; j++) {
				if (j == this.colNumber - 1) {
					newResult[i][j] = null;
				} else {
					newResult[i][j] = this.result[i][j];
					this.result[i][j] = null;
				}
			}
		}
		this.result = newResult;
	}

	public void addColumns(String[] columnNames) {
		if ((this.colNumber < 1) || (this.rowNumber < 1) || (columnNames == null)) {
			return;
		}
		for (int i = 0; i < columnNames.length; i++) {
			this.colNames.put(columnNames[i].toUpperCase(), new Integer(this.colNumber));
			this.colNumber += 1;
		}

		Object[][] newResult = new Object[this.rowNumber][this.colNumber];
		for (int i = 0; i < this.rowNumber; i++) {
			for (int j = 0; j < this.colNumber; j++) {
				if (j >= this.result[0].length) {
					newResult[i][j] = null;
				} else {
					newResult[i][j] = this.result[i][j];
					this.result[i][j] = null;
				}
			}
		}
		this.result = newResult;
	}

	public boolean containsCol(String colName) {
		return this.colNames.containsKey(colName);
	}

	public int getBeginRow() {
		return this.beginRow;
	}

	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
}