package com.pku.LawKG.model;

public abstract class Node implements Extensible {
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
