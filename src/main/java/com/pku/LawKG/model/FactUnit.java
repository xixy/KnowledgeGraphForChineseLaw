package com.pku.LawKG.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.rdf.model.Property;

import com.pku.LawKG.Exception.IllegalExtendException;

public class FactUnit extends Node {

	private List<Condition> conditions=new ArrayList<Condition>();
	private List<Result> results=new ArrayList<Result>();

	public List<Condition> getConditions() {
		return conditions;
	}

	public void addCondition(Condition condition) {
		conditions.add(condition);
	}

	public List<Result> getResults() {
		return results;
	}

	public void addResult(Result result){
		results.add(result);
	}

	public void extend(Property p, Node n) throws IllegalExtendException {
		if(n instanceof Condition){
			conditions.add((Condition)n);
		}else{
			if(n instanceof Result){
				results.add((Result)n);
			}
			else{
				throw new IllegalExtendException("",FactUnit.class);
			}
		}
	}
}
