/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.model;

import org.apache.jena.rdf.model.Property;

import com.pku.LawKG.Exception.IllegalExtendException;

interface Extensible{
	public void extend(Property p,Node n) throws IllegalExtendException;
}
