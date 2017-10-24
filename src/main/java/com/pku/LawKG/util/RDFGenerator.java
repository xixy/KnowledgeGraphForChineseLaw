/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.util;

import java.util.Map;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.pku.LawKG.model.Condition;
import com.pku.LawKG.model.FactUnit;
import com.pku.LawKG.model.Law;
import com.pku.LawKG.model.LawItem;
import com.pku.LawKG.model.PKP;
import com.pku.LawKG.model.PKR;
import com.pku.LawKG.model.Result;
import com.pku.LawKG.model.SPONode;

public class RDFGenerator {

	public static Model model = ModelFactory.createDefaultModel();
	static{
		model.setNsPrefix("PKP", PKP.uri);
		model.setNsPrefix("PKR", PKR.uri);
	}
	
	

	/**
	 * 
	 * @param law
	 * @return
	 */
	public static Resource generateRDF(Law law) {
		int id = law.getId();
		// create an empty Model

		Resource lawResource = model.createResource(PKR.uri + id);
		lawResource.addProperty(PKP.ID, String.valueOf(id));
		// lawItemProperty
		for (LawItem lawItem : law.getLawItemList()) {
			lawResource.addProperty(PKP.HASLAWITEM, generateRDF(lawItem));
		}
		model.write(System.out,"RDF/XML");
		// list the statements in the Model
		StmtIterator iter = model.listStatements();

		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			System.out.print(subject.toString());
			System.out.print(" " + predicate.toString() + " ");
			if (object instanceof Resource) {
				System.out.print(object.toString());
			} else {
				// object is a literal
				System.out.print(" \"" + object.toString() + "\"");
			}

			System.out.println(" .");

		}

		return lawResource;

	}

	/**
	 * 
	 * @param lawItem
	 * @return
	 */
	public static Resource generateRDF(LawItem lawItem) {
		int id = lawItem.getId();
		// create an empty Model
		Resource lawItemResource = model.createResource(PKR.uri + id);
		lawItemResource.addProperty(PKP.ID, String.valueOf(lawItem.getId()));

		for (FactUnit factUnit : lawItem.getFactUnitList()) {
			lawItemResource.addProperty(PKP.HASFACT, generateRDF(factUnit));
		}

		return lawItemResource;
	}

	/**
	 * 
	 * @param factUnit
	 * @return
	 */
	public static Resource generateRDF(FactUnit factUnit) {
		Resource factUnitResource = model.createResource();
		for (Condition condition : factUnit.getConditions()) {
			factUnitResource.addProperty(PKP.HASCONDITION, generateRDF(condition));
		}
		for(Result result:factUnit.getResults()){
			factUnitResource.addProperty(PKP.HASRESULT, generateRDF(result));
		}
		return factUnitResource;

	}

	/**
	 * 
	 * @param condition
	 * @return
	 */
	public static Resource generateRDF(Condition condition) {
		Resource conditionResource = model.createResource();
		Map<Property, SPONode> childs = condition.getChilds();
		for (Property p : childs.keySet()) {
			conditionResource.addProperty(p, generateRDF(childs.get(p)));

		}
		return conditionResource;
	}

	/**
	 * 
	 * @param condition
	 * @return
	 */
	public static Resource generateRDF(Result result) {
		Resource resultResource = model.createResource();
		Map<Property, SPONode> childs = result.getChilds();
		for (Property p : childs.keySet()) {
			resultResource.addProperty(p, generateRDF(childs.get(p)));

		}
		return resultResource;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public static Resource generateRDF(SPONode node) {
		Resource nodeResource = model.createResource(PKR.uri + node.getLabel());
		nodeResource.addProperty(PKP.HASLABEL,node.getLabel());
		Map<Property, SPONode> childs = node.getChilds();
		for (Property p : childs.keySet()) {
			nodeResource.addProperty(p, generateRDF(childs.get(p)));

		}
		return nodeResource;
	}

}
