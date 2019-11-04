import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Morpheme.Chunk;
import Morpheme.Sentence;
import SemanticNet.Link;
import SemanticNet.MakeSemanticNet;
import SemanticNet.SemanticNet;

public class SearchByNL {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		// String text = "知ってた？隣のお客さんはたくさん柿を食べるって。"; // 解析対象のテキスト
		String text = "";
		SemanticNet sn = MakeSemanticNet.makeSemanticNet();
		while (true) {
			System.out.println("いらっしゃいませ！いらっしゃいませ！いらっしゃいませ！:");
			text = stdin.nextLine();
			if (text.equals("exit"))
				break;
			System.out.println("解析対象のテキスト: " + text);

			// 対象テキストを文に分割した上でCaboChaに渡し，解析結果を受け取る．
			List<Sentence> sentences = Sentence.parseText(text);
			List<List<Link>> linkslist = new ArrayList<List<Link>>();
			for (Sentence sentence : sentences) { // 文を1つずつ処理するループ
				Sentence.Question q = sentence.getAgentQuestionType();

				for (Chunk chunk : sentence) {
					for (String likeLabel : chunk.getLikeLinkLabels()) {
						if (Link.LabelContains(likeLabel)) {
							List<String> keywords = sentence.getLikeKeywords(chunk);
							List<Link> links = sn.isLink(likeLabel, keywords);
							boolean isSame=false;
							if(linkslist.size()>0&&likeLabel.equals("だ")&&links.size()>0) {
								for (Link link : links) {
									List<Link> prelinks = linkslist.get(linkslist.size()-1);
									if(link.HasSameWord(prelinks)) {
										isSame=true;
										break;
									}
								}
							}
							if (links.size() > 0&&!isSame)
								linkslist.add(links);
						}
					}
				}
			}
			if(linkslist.size()==0)
			{
				System.out.println("質問がわかりません。");
				continue;
			}
			ArrayList answer = new ArrayList();
			answer = checkQuery(sn, answer, linkslist, 0);
			if(answer.size()==0)
			{
				System.out.println("質問がわかりません。");
				continue;
			}
			System.out.print("それは");
			for (Object object : answer) {
				HashMap<String, String> result = (HashMap) object;
				boolean isFirst = true;
				for (String s : result.values()) {
					if(!isFirst)
						System.out.print("と、");
					System.out.print(s);
					isFirst=false;
				}
			}
			System.out.println("です。");

		}
		stdin.close();
	}

	static ArrayList checkQuery(SemanticNet sn, ArrayList<Link> query, List<List<Link>> linkslist, int id) {
		if (id == linkslist.size()) {
			ArrayList ans = sn.doQuery(query);
			if (ans.size() != 0)
				return ans;
			return query;
		}
		for (Link link : linkslist.get(id)) {
			query.add(link);
			ArrayList ans =checkQuery(sn, query, linkslist, id + 1);
			if (query != ans)
				return ans;
			query.remove(query.size()-1);
		}
		return query;
	}

}
