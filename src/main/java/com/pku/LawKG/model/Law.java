/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.model;

import java.util.ArrayList;
import java.util.List;

public class Law {
	private int id;
	private String title;
	private List<LawItem> lawItemList = new ArrayList<LawItem>();

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
