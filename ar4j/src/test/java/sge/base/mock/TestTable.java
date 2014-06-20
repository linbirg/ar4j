package sge.base.mock;

import sge.base.dao.Column;
import sge.base.dao.Table;

@Table(name="test_table")
public class TestTable {
	@Column(pk=true)
	private int id;
	
	@Column
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
