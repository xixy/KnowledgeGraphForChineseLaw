package com.pku.LawKG.service;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class NLPService {
	
	public static StanfordCoreNLP pipeline = new StanfordCoreNLP("CoreNLP-chinese.properties");
	/**
	 * 
	 * @param text
	 * @return
	 */
    public synchronized static Tree getTree(String text) {
    	System.out.print("start");

        // 用一些文本来初始化一个注释。文本是构造函数的参数。
        Annotation annotation;
        annotation = new Annotation(text);

        // 运行所有选定的代码在本文
        pipeline.annotate(annotation);
        
       // 从注释中获取CoreMap List，并取第0个值
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        CoreMap sentence = sentences.get(0);
        Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
        return tree;
    }
    
    public synchronized static SemanticGraph getDependencies(String text) {

        // 用一些文本来初始化一个注释。文本是构造函数的参数。
        Annotation annotation;
        annotation = new Annotation(text);

        // 运行所有选定的代码在本文
        pipeline.annotate(annotation);
        
       // 从注释中获取CoreMap List，并取第0个值
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        CoreMap sentence = sentences.get(0);
        SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
        //System.out.println("依存句法：");  
        //System.out.println(dependencies.toString());
        return dependencies;
        
/*        // 从CoreMap中取出CoreLabel List，逐一打印出来
        List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
        System.out.println("字/词" + "\t " + "词性" + "\t " + "实体标记");
        System.out.println("-----------------------------");
        for (CoreLabel token : tokens) {
            String word = token.getString(TextAnnotation.class);
            String pos = token.getString(PartOfSpeechAnnotation.class);
            String ner = token.getString(NamedEntityTagAnnotation.class);
            System.out.println(word + "\t " + pos + "\t " + ner);
        }*/

    }

}
