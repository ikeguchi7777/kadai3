package SemanticNet;

import java.util.ArrayList;

/***
 * Semantic Net の使用例
 */
public class Example {
    public static void main(String args[]){
	SemanticNet sn = new SemanticNet();

	// 野球はスポーツである．
	sn.addLink(new Link("is-a","野球","スポーツ",sn));

	// 太郎は名古屋工業大学の学生である．
	sn.addLink(new Link("is-a","太郎","名古屋工業大学の学生",sn));

	// 太郎の専門は人工知能である．
	sn.addLink(new Link("専門","太郎","人工知能",sn));

	// フェラーリは車である．
	sn.addLink(new Link("is-a","フェラーリ","車",sn));

	// 車はエンジンを持つ．
	sn.addLink(new Link("has-a","車","エンジン",sn));

	// 太郎の趣味は野球である．
	sn.addLink(new Link("趣味","太郎","野球",sn));

	// 太郎はフェラーリを所有する．
	sn.addLink(new Link("所有","太郎","フェラーリ",sn));

	// 名古屋工業大学の学生は，学生である．
	sn.addLink(new Link("is-a","名古屋工業大学の学生","学生",sn));

	// 学生は勉強しない．
	sn.addLink(new Link("donot","学生","勉強",sn));

	sn.printLinks();
	sn.printNodes();

	ArrayList<Link> query = new ArrayList<Link>();
	query.add(new Link("own","?y","Ferrari"));
	query.add(new Link("is-a","?y","student"));
	query.add(new Link("hobby","?y","baseball"));
	sn.query(query);
    }

    public static SemanticNet makeSN() {
    	SemanticNet sn = new SemanticNet();

    	// 野球はスポーツである．
    	sn.addLink(new Link("だ","野球","スポーツ",sn));

    	// 太郎は名古屋工業大学の学生である．
    	sn.addLink(new Link("だ","太郎","名古屋工業大学の学生",sn));

    	// 太郎の専門は人工知能である．
    	sn.addLink(new Link("専門","太郎","人工知能",sn));

    	// フェラーリは車である．
    	sn.addLink(new Link("だ","フェラーリ","車",sn));

    	// 車はエンジンを持つ．
    	sn.addLink(new Link("持つ","車","エンジン",sn));

    	// 太郎の趣味は野球である．
    	sn.addLink(new Link("趣味","太郎","野球",sn));

    	// 太郎はフェラーリを所有する．
    	sn.addLink(new Link("所有","太郎","フェラーリ",sn));

    	// 名古屋工業大学の学生は，学生である．
    	sn.addLink(new Link("だ","名古屋工業大学の学生","学生",sn));

    	// 学生は勉強しない．
    	sn.addLink(new Link("しない","学生","勉強",sn));
    	return sn;
    }
}

