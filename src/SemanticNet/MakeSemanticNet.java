package SemanticNet;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * Semantic Net の使用例
 */
public class MakeSemanticNet{
	public static SemanticNet makeSemanticNet(){
		SemanticNet sn = new SemanticNet();
	//飛世裕貴のセマンティックネット
		sn.addLink(new Link("だ","飛世裕貴","名工大生",sn));
		sn.addLink(new Link("所有","飛世裕貴","ランボルギーニ",sn));
		sn.addLink(new Link("好き","飛世裕貴","酒",sn));
		sn.addLink(new Link("趣味","飛世裕貴","サッカー",sn));
		sn.addLink(new Link("専門","飛世裕貴","機械学習",sn));
		sn.addLink(new Link("出身","飛世裕貴","三重県",sn));
		sn.addLink(new Link("だ","名工大生","大学生",sn));
		sn.addLink(new Link("しない","大学生","勉強",sn));
		sn.addLink(new Link("だ","ランボルギーニ","自動車",sn));
		sn.addLink(new Link("だ","ビール","酒",sn));
		sn.addLink(new Link("だ","日本酒","酒",sn));
		sn.addLink(new Link("だ","サッカー","スポーツ",sn));
		sn.addLink(new Link("だ","バスケ","スポーツ",sn));
		sn.addLink(new Link("持つ","日本","三重県",sn));
		sn.addLink(new Link("持つ","日本","愛知県",sn));

	//池口弘尚のセマンティックネット
		sn.addLink(new Link("だ","池口","名工大生",sn));
		sn.addLink(new Link("所有","池口","Nintendo Switch",sn));
		sn.addLink(new Link("所有","池口","Alienware17 R4",sn));
		sn.addLink(new Link("所属","池口","グループ07",sn));
		sn.addLink(new Link("専門","池口","人工知能",sn));
		sn.addLink(new Link("製造","Nintendo","Nintendo Switch",sn));
		sn.addLink(new Link("だ","Nintendo Switch","電子機器",sn));
		sn.addLink(new Link("だ","Alienware17 R4","ノートパソコン",sn));
		sn.addLink(new Link("製造","Alienware","Alienware17 R4",sn));
		sn.addLink(new Link("だ","ノートパソコン","電子機器",sn));
		sn.addLink(new Link("だ","電子機器","Processing Unit",sn));

	//大原拓人のセマンティックネット
		sn.addLink(new Link("だ","大原拓人","長距離ランナー",sn));
		sn.addLink(new Link("ファン","大原拓人","冴えカノ",sn));
		sn.addLink(new Link("鑑賞","大原拓人","ブラクロ",sn));
		sn.addLink(new Link("出身","大原拓人","富山",sn));
		sn.addLink(new Link("趣味","大原拓人","モンハン",sn));
		sn.addLink(new Link("所有","大原拓人","ロードバイク",sn));
		sn.addLink(new Link("使用","大原拓人","VSCode",sn));
		sn.addLink(new Link("趣味","大原拓人","米津玄師",sn));
		sn.addLink(new Link("所有","大原拓人","Xperia",sn));
		sn.addLink(new Link("だ","長距離ランナー","陸上部員",sn));
		sn.addLink(new Link("だ","冴えカノ","アニメ",sn));
		sn.addLink(new Link("だ","ブラクロ","アニメ",sn));
		sn.addLink(new Link("持つ","日本","富山",sn));
		sn.addLink(new Link("だ","モンハン","ゲーム",sn));
		sn.addLink(new Link("だ","ロードバイク","自転車",sn));
		sn.addLink(new Link("だ","VSCode","エディタ",sn));
		sn.addLink(new Link("だ","米津玄師","アーティスト",sn));
		sn.addLink(new Link("だ","Xperia","スマホ",sn));
		sn.addLink(new Link("だ","iPhone","スマホ",sn));

	//野竹浩二朗のセマンティックネット
		sn.addLink(new Link("だ","野竹浩二朗","名工大生",sn));
		sn.addLink(new Link("趣味","野竹浩二朗","Splatoon",sn));
		sn.addLink(new Link("部活","野竹浩二朗","合唱",sn));
		sn.addLink(new Link("趣味","野竹浩二朗","歌",sn));
		sn.addLink(new Link("所有","野竹浩二朗","iPhone7",sn));
		sn.addLink(new Link("好き","野竹浩二朗","唐揚げ",sn));
		sn.addLink(new Link("出身","野竹浩二朗","日本",sn));
		sn.addLink(new Link("する","名工大生","勉強",sn));
		sn.addLink(new Link("だ","Splatoon","ゲーム",sn));
		sn.addLink(new Link("だ","歌","合唱",sn));
		sn.addLink(new Link("だ","スマホ","iPhone",sn));
		sn.addLink(new Link("材料","唐揚げ","鶏肉",sn));
		sn.addLink(new Link("原料","鶏肉","鶏",sn));
		sn.addLink(new Link("だ","日本","国",sn));

		return sn;
	}

    public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);
		int size = 0;
		String[] list = new String[3];
		while(size!=3){
			System.out.print("Enter Search Pattern:");
			String str = stdin.nextLine();
			String[] sentence = str.split("( |　)");
			if(sentence.length == 3){
				for(int i = 0;i<3;i++){
					list[i] = sentence[i];
				}
			}
			size = sentence.length;
		}
		SemanticNet sn = makeSemanticNet();
		//sn.printLinks();

		ArrayList<Link> query = new ArrayList<Link>();
		query.add(new Link(list[1],list[0],list[2]));

		sn.query(query);
    }
}
