/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.rdf.model.Property;

import com.pku.LawKG.Exception.IllegalExtendException;

public class SPONode extends Node {
	private Map<Property, SPONode> childs=new HashMap<Property,SPONode>();

	public Map<Property, SPONode> getChilds() {
		return childs;
	}

	public void extend(Property p, Node n) throws IllegalExtendException {
		if (childs == null)
			childs = new HashMap<Property, SPONode>();
		if (!(n instanceof SPONode))
			throw new IllegalExtendException("", this.getClass());
		childs.put(p, (SPONode) n);
	}
}
