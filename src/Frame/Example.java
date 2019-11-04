package Frame;

/*
 Example.java

*/

public class Example {

	public static void main(String args[]) {
		System.out.println("Frame");

		// フレームシステムの初期化
		AIFrameSystem fs = new AIFrameSystem();

		// クラスフレーム キャラクター の生成
		fs.createClassFrame("キャラクター");
		// 武器 スロットを設定
		fs.writeSlotValue("キャラクター", "武器", Boolean.valueOf(false));
		// クラスフレーム 人間 の生成
		fs.createClassFrame("キャラクター", "人間");
		// クラスフレーム 人間 の生成
		fs.createClassFrame("キャラクター", "動物");
		// クラスフレーム 人間 の生成
		fs.createClassFrame("キャラクター", "その他");
		// クラスフレーム ゲームタイトル の生成
		fs.createClassFrame("ゲームタイトル");
		// クラスフレーム 人間 の生成
		fs.createInstanceFrame("ゲームタイトル", "スーパーマリオ");

		CreateCharactor(fs, "人間", "マリオ", true, true, "スーパーマリオ");
		System.out.println(fs.readSlotValue("マリオ", "武器"));
		System.out.println(fs.readSlotValue("マリオ", "武器",true));
		System.out.println(fs.readSlotValue("マリオ", "タイトル"));
		/*
		// height と weight はデフォルト値
		System.out.println(fs.readSlotValue("tora", "height", false));
		System.out.println(fs.readSlotValue("tora", "weight", false));

		// weight はデフォルト値
		fs.writeSlotValue("tora", "height", Integer.valueOf(165));
		System.out.println(fs.readSlotValue("tora", "height", false));
		System.out.println(fs.readSlotValue("tora", "weight", false));

		// 再びデフォルト値を表示
		fs.writeSlotValue("tora", "weight", Integer.valueOf(50));
		System.out.println(fs.readSlotValue("tora", "height", true));
		System.out.println(fs.readSlotValue("tora", "weight", true));*/
	}

	public static void CreateCharactor(AIFrameSystem fs, String inSuperName, String inName, boolean haveWeapon,
			boolean isMale, String title) {
		fs.createInstanceFrame(inSuperName, inName);
		fs.writeSlotValue(inName, "武器", Boolean.valueOf(haveWeapon));
		fs.writeSlotValue(inName, "性別", Boolean.valueOf(isMale));
		fs.writeSlotValue(inName, "タイトル", title);
	}

}