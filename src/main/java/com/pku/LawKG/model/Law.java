package com.pku.LawKG.model;

import java.util.ArrayList;
import java.util.List;

public class Law {
	private int id;
	private String title;
	private List<LawItem> lawItemList=new ArrayList<LawItem>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<LawItem> getLawItemList() {
		return lawItemList;
	}

	public void setLawItemList(List<LawItem> lawItemList) {
		this.lawItemList = lawItemList;
	}

	public void addLawItem(LawItem lawItem) {
		this.lawItemList.add(lawItem);
	}

}
