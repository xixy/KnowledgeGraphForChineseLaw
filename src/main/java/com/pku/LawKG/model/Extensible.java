package com.pku.LawKG.model;

import org.apache.jena.rdf.model.Property;

import com.pku.LawKG.Exception.IllegalExtendException;

interface Extensible{
	public void extend(Property p,Node n) throws IllegalExtendException;
}
