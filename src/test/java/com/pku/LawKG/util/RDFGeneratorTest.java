package com.pku.LawKG.util;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.junit.Test;

import com.pku.LawKG.Exception.IllegalExtendException;
import com.pku.LawKG.model.Condition;
import com.pku.LawKG.model.FactUnit;
import com.pku.LawKG.model.Law;
import com.pku.LawKG.model.LawItem;
import com.pku.LawKG.model.Result;
import com.pku.LawKG.model.SPONode;

public class RDFGeneratorTest {
	public static Law law=new Law();
	public static LawItem lawItem = new LawItem();
	public static FactUnit factUnit = new FactUnit();
	public static Condition condition1 = new Condition();
	public static Condition condition2 = new Condition();
	public static Result result = new Result();
	static{

		try {
			SPONode s1=new SPONode();
			s1.setLabel("人");
			SPONode P1=new SPONode();
			P1.setLabel("在中华人民共和国境内从事");
			SPONode O1=new SPONode();
			O1.setLabel("食品添加剂的生产经营");
			
			SPONode s2=new SPONode();
			s2.setLabel("人");
			SPONode P2=new SPONode();
			P2.setLabel("在中华人民共和国境内从事");
			SPONode O2=new SPONode();
			O2.setLabel("食品的贮存和运输");
			
			SPONode p3 = new SPONode();
			p3.setLabel("遵守");
			SPONode O3 = new SPONode();
			O3.setLabel("本法");
			
			condition1.extend(RDF.subject,s1);
			condition1.extend(RDF.predicate,P1);
			condition1.extend(RDF.object,O1);
			condition2.extend(RDF.subject,s2);
			condition2.extend(RDF.predicate,P2);
			condition2.extend(RDF.object,O2);
			
			result.extend(RDF.subject, s1);
			result.extend(RDF.predicate, p3);
			result.extend(RDF.object, O3);
		} catch (IllegalExtendException e) {
			e.printStackTrace();
		}
		law.setId(10000);
		lawItem.setId(1);
		law.addLawItem(lawItem);
		lawItem.addFactUnit(factUnit);
		factUnit.addCondition(condition1);
		factUnit.addCondition(condition2);
		factUnit.addResult(result);
		
	}
	

	@Test
	public void testGenerateRDF() {
		Resource r = RDFGenerator.generateRDF(law);
	}

}
