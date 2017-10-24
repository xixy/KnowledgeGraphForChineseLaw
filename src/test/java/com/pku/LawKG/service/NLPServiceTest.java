/**
 * @author xixy10@foxmail.com
 * @version V0.1 2017年10月24日 上午10:19:35
 */
package com.pku.LawKG.service;

import org.junit.Test;

import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.Tree;

public class NLPServiceTest {
	public String testText = "在中华人民共和国境内从事互联网域名服务及其运行维护、监督管理等相关活动，应当遵守本办法";

	@Test
	public void testGetTree() {
		Tree tree = NLPService.getTree(testText);
		System.out.print(tree.toString());
	}

	@Test
	public void testGetDependencies() {
		SemanticGraph dependency = NLPService.getDependencies(testText);
		System.out.print(dependency.toString());
	}

}
