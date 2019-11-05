package Frame;

class MakeFrame {
	public static AIFrameSystem makeFrame(){
		AIFrameSystem fs = new AIFrameSystem();
	// クラスフレーム  の生成
		fs.createClassFrame("キャラクター");
		fs.createClassFrame("ゲームタイトル");

		fs.writeSlotValue( "キャラクター", "武器", false );
		fs.writeSlotValue( "キャラクター", "性別",  "不明" );
		fs.writeSlotValue( "キャラクター", "タイトル", fs.getFrame("ゲームタイトル") );

		fs.createClassFrame("キャラクター", "人間");
		fs.createClassFrame("キャラクター", "動物");
		fs.createClassFrame("キャラクター", "その他");    

		// ゲームタイトル インスタンスフレーム 群
		fs.createInstanceFrame( "ゲームタイトル", "マリオ" );
		fs.createInstanceFrame( "ゲームタイトル", "カービィ" );
		fs.createInstanceFrame( "ゲームタイトル", "ZELDA" );
		fs.createInstanceFrame( "ゲームタイトル", "ファイアーエンブレム" );
		fs.createInstanceFrame( "ゲームタイトル", "ポケモン" );

		// マリオ インスタンスフレーム群
		fs.createInstanceFrame( "人間", "マリオ" );
		fs.writeSlotValue( "マリオ", "武器", true );
		fs.writeSlotValue( "マリオ", "性別", "男" );
		fs.writeSlotValue( "マリオ", "タイトル", fs.getFrame("スーパーマリオ") );

		fs.createInstanceFrame( "人間", "Dr.マリオ" );
		fs.writeSlotValue( "Dr.マリオ", "武器", false );
		fs.writeSlotValue( "Dr.マリオ", "性別", "男" );
		fs.writeSlotValue( "Dr.マリオ", "タイトル", fs.getFrame("スーパーマリオ") );
		
		fs.createInstanceFrame( "人間", "ルイージ" );
		fs.writeSlotValue( "ルイージ", "武器", true );
		fs.writeSlotValue( "ルイージ", "性別", "男" );
		fs.writeSlotValue( "ルイージ", "タイトル", fs.getFrame("スーパーマリオ") );

		fs.createInstanceFrame( "人間", "ピーチ" );
		fs.writeSlotValue( "ピーチ", "武器", true );
		fs.writeSlotValue( "ピーチ", "性別", "女" );
		fs.writeSlotValue( "ピーチ", "タイトル", fs.getFrame("スーパーマリオ") );

		fs.createInstanceFrame( "人間", "デイジー" );
		fs.writeSlotValue( "デイジー", "武器", true );
		fs.writeSlotValue( "デイジー", "性別", "女" );
		fs.writeSlotValue( "デイジー", "タイトル", fs.getFrame("スーパーマリオ") );
		
		fs.createInstanceFrame( "動物", "クッパ.Jr" );
		fs.writeSlotValue( "クッパ.Jr", "武器", true );
		fs.writeSlotValue( "クッパ.Jr", "性別", "男" );
		fs.writeSlotValue( "クッパ.Jr", "タイトル", fs.getFrame("スーパーマリオ") );
		
		fs.createInstanceFrame( "動物", "クッパ" );
		fs.writeSlotValue( "クッパ", "武器", false );
		fs.writeSlotValue( "クッパ", "性別", "男" );
		fs.writeSlotValue( "クッパ", "タイトル", fs.getFrame("スーパーマリオ") );
		
		fs.createInstanceFrame( "その他", "パックンフラワー" );
		fs.writeSlotValue( "パックンフラワー", "武器", true );
		//fs.writeSlotValue( "パックンフラワー", "性別", "不明" );
		fs.writeSlotValue( "パックンフラワー", "タイトル", fs.getFrame("スーパーマリオ") );

		//ポケモン インスタンスフレーム群
		fs.createInstanceFrame( "人間", "サトシ" );
		fs.writeSlotValue( "サトシ", "武器", false );
		fs.writeSlotValue( "サトシ", "性別", "男" );
		fs.writeSlotValue( "サトシ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "人間", "タケシ" );
		fs.writeSlotValue( "タケシ", "武器", false );
		fs.writeSlotValue( "タケシ", "性別", "男" );
		fs.writeSlotValue( "タケシ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "人間", "カスミ" );
		fs.writeSlotValue( "カスミ", "武器", false );
		fs.writeSlotValue( "カスミ", "性別", "女" );
		fs.writeSlotValue( "カスミ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "人間", "ハルカ" );
		fs.writeSlotValue( "ハルカ", "武器", false );
		fs.writeSlotValue( "ハルカ", "性別", "女" );
		fs.writeSlotValue( "ハルカ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "動物", "カモネギ" );
		fs.writeSlotValue( "カモネギ", "武器", true );
		//fs.writeSlotValue( "カモネギ", "性別", "不明" );
		fs.writeSlotValue( "カモネギ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "動物", "ミズゴロウ" );
		fs.writeSlotValue( "ミズゴロウ", "武器", false );
		//fs.writeSlotValue( "ミズゴロウ", "性別", "不明" );
		fs.writeSlotValue( "ミズゴロウ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "動物", "ピカチュウ" );
		fs.writeSlotValue( "ピカチュウ", "武器", false );
		//fs.writeSlotValue( "ピカチュウ", "性別", "不明" );
		fs.writeSlotValue( "ピカチュウ", "タイトル", fs.getFrame("ポケモン") );
		
		fs.createInstanceFrame( "その他", "ユンゲラー" );
		fs.writeSlotValue( "ユンゲラー", "武器", true );
		//fs.writeSlotValue( "ユンゲラー", "性別", "不明" );
		fs.writeSlotValue( "ユンゲラー", "タイトル", fs.getFrame("ポケモン") );
		
		//ゼルダ インスタンスフレーム群
		fs.createInstanceFrame( "人間", "リンク" );
		fs.writeSlotValue( "リンク", "武器", true );
		fs.writeSlotValue( "リンク", "性別", "男" );
		fs.writeSlotValue( "リンク", "タイトル", fs.getFrame("ZELDA") );
		
		fs.createInstanceFrame( "人間", "シーク" );
		fs.writeSlotValue( "シーク", "武器", true );
		fs.writeSlotValue( "シーク", "タイトル", fs.getFrame("ZELDA") );
		
		fs.createInstanceFrame( "人間", "ゼルダ" );
		fs.writeSlotValue( "ゼルダ", "武器", false );
		fs.writeSlotValue( "ゼルダ", "性別", "女" );
		fs.writeSlotValue( "ゼルダ", "タイトル", fs.getFrame("ZELDA") );
		
		fs.createInstanceFrame( "人間", "子供リンク" );
		fs.writeSlotValue( "子供リンク", "武器", true );
		fs.writeSlotValue( "子供リンク", "性別", "男" );
		fs.writeSlotValue( "子供リンク", "タイトル", fs.getFrame("ZELDA") );
		
		fs.createInstanceFrame( "人間","トゥーンリンク" );
		fs.writeSlotValue( "トゥーンリンク","武器", true );
		fs.writeSlotValue( "トゥーンリンク","性別", "男" );
		fs.writeSlotValue( "トゥーンリンク","タイトル", fs.getFrame("ZELDA") );
		
		fs.createInstanceFrame( "人間","ガノンドロフ" );
		fs.writeSlotValue( "ガノンドロフ","武器", false );
		fs.writeSlotValue( "ガノンドロフ","性別", "男" );
		fs.writeSlotValue( "ガノンドロフ","タイトル", fs.getFrame("ZELDA") );
		
		return fs;
	}

	public static void main(String args[]) {
		System.out.println( "Frame" );
		AIFrameSystem fs = makeFrame();

		System.out.println( fs.readSlotValue( "リンク", "武器", false ) );
		System.out.println( fs.readSlotValue( "リンク", "性別", false ) );
		AIFrame fr = (AIFrame)fs.readSlotValue( "リンク", "タイトル",false );
		System.out.println(fr.getmName());
	}

}


