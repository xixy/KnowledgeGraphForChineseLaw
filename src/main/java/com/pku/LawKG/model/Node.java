/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
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
