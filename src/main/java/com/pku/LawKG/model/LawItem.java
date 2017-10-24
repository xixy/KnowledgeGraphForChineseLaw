/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.model;

import java.util.ArrayList;
import java.util.List;

public class LawItem {
	/**
	 * id of lawItem
	 */
	private int id;
	/**
	 * a list of factUnit
	 */
	private List<FactUnit> factUnitList=new ArrayList<FactUnit>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FactUnit> getFactUnitList() {
		return factUnitList;
	}
	
	public void addFactUnit(FactUnit factUnit){
		factUnitList.add(factUnit);
	}


}
