package com.neomades.asynclist.model;

public class Element {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasChildren() {
		return false;
	}
}
