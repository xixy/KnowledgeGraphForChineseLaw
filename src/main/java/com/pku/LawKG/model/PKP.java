package com.pku.LawKG.model;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

public class PKP {
	/**
	 * The namespace of the vocabulary as a string
	 */
	public static final String uri = "http://www.property.pku.com/1.0#";;

	/**
	 * returns the URI for this schema
	 * 
	 * @return the URI for this schema
	 */
	public static String getURI() {
		return uri;
	}

	private static final Model m = ModelFactory.createDefaultModel();
	public static final Property CONDITION = m.createProperty(uri,
			"condition");
	public static final Property RESULT = m.createProperty(uri,
			"result");
	public static final Property CONTAINS = m.createProperty(uri,
			"contains");
	public static final Property ID = m.createProperty(uri,
			"id");	
	public static final Property HASFACT = m.createProperty(uri,
			"hasFact");	
	public static final Property HASLAWITEM = m.createProperty(uri,
			"hasLawItem");	
	public static final Property HASRESULT = m.createProperty(uri,
			"hasResult");	
	public static final Property HASCONDITION = m.createProperty(uri,
			"hasCondition");	
	public static final Property HASLABEL = m.createProperty(uri,
			"hasLabel");
}
