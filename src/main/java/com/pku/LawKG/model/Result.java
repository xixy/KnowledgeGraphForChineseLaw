/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.vocabulary.RDF;

import com.pku.LawKG.Exception.IllegalExtendException;

public class Result extends Node {

	private Map<Property, SPONode> childs=new HashMap<Property,SPONode>();
	public Map<Property, SPONode> getChilds() {
		return childs;
	}

	public static List<Property> legalProperty = new ArrayList<Property>();
	static {
		legalProperty.add(RDF.subject);
		legalProperty.add(RDF.object);
		legalProperty.add(RDF.predicate);
	}

	public void extend(Property p, Node n) throws IllegalExtendException {
		if (childs == null)
			childs = new HashMap<Property, SPONode>();
		if (childs.containsKey(p) || !legalProperty.contains(p)) {
			throw new IllegalExtendException("", this.getClass());
		}
		childs.put(p, (SPONode) n);

	}

}
