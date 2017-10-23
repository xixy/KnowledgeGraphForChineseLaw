package com.pku.LawKG.service;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class JeanService {
	// some definitions
	static String personURI = "http://somewhere/JohnSmith";
	static String fullName = "John Smith";
	
	public static void navigate(Model model){
		Resource vcard = model.getResource(personURI);
		vcard.addProperty(VCARD.NICKNAME, "Smithy")
	     .addProperty(VCARD.NICKNAME, "Adman");
		Resource name = (Resource) vcard.getProperty(VCARD.N)
                .getObject();
		System.out.println(name.getProperty(VCARD.Family).getString());
		
		// set up the output
		System.out.println("The nicknames of \""
		                      + fullName + "\" are:");
		// list the nicknames
		
		StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
		while (iter.hasNext()) {
		    System.out.println("    " + iter.nextStatement()
		                                    .getObject()
		                                    .toString());
		}
		
	}
	
	public static void query(Model model){
		ResIterator iter = model.listSubjectsWithProperty(VCARD.FN);
		while (iter.hasNext()) {
			System.out.print(1);
		    Resource r = iter.nextResource();
		    StmtIterator stmIte = r.listProperties();
		    while(stmIte.hasNext()){
		    	Statement stmt = stmIte.next();
		    	Resource subject = stmt.getSubject();
		    	System.out.println(subject.toString());
		    }
		}
	}
	
	public void listModel(Model model){
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
		
	}

	public static void main(String[] args) {
		// some definitions
		String personURI = "http://somewhere/JohnSmith";
		String givenName = "John";
		String familyName = "Smith";
		String fullName = givenName + " " + familyName;

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		// and add the properties cascading style
		Resource johnSmith = model
				.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(
						VCARD.N,
						model.createResource()
								.addProperty(VCARD.Given, givenName)
								.addProperty(VCARD.Family, familyName));


		model.write(System.out);
		navigate(model);
		query(model);
	}

}
