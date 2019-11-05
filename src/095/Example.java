/*
Example.java

*/

public class Example {

  public static void main(String args[]) {
    System.out.println( "Frame" );

    // フレームシステムの初期化
    AIFrameSystem fs = new AIFrameSystem();

    fs.writeSlotValue( "キャラクター", "武器", false );
    fs.writeSlotValue( "キャラクター", "性別",  "不明" );
    fs.writeSlotValue( "キャラクター", "タイトル", fs.getFrame("ゲームタイトル") );

    fs.createClassFrame("キャラクター", "人間");
    fs.createClassFrame("キャラクター", "動物");
    fs.createClassFrame("キャラクター", "その他");

    // ゲームタイトル インスタンスフレーム 群
    fs.createInstanceFrame( "ゲームタイトル", "星のカービィ" );

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
    fs.createInstanceFrame("ゲームタイトル", "星のカービィ");



    fs.writeSlotValue( "キャラクター", "武器", false );
    fs.writeSlotValue( "キャラクター", "性別",  "不明" );
    fs.writeSlotValue( "キャラクター", "タイトル", fs.getFrame("ゲームタイトル") );

    fs.createInstanceFrame( "その他", "カービィ" );
    fs.writeSlotValue( "カービィ", "武器", false );
    fs.writeSlotValue( "カービィ", "性別", "不明" );
    fs.writeSlotValue( "カービィ", "タイトル", fs.getFrame("星のカービィ") );

    fs.createInstanceFrame( "その他", "メタナイト" );
    fs.writeSlotValue( "メタナイト", "武器", true );
    fs.writeSlotValue( "メタナイト", "性別", "不明" );
    fs.writeSlotValue( "メタナイト", "タイトル", fs.getFrame("星のカービィ") );

    fs.createInstanceFrame( "その他", "デデデ" );
    fs.writeSlotValue( "デデデ", "武器", true );
    fs.writeSlotValue( "デデデ", "性別", "不明" );
    fs.writeSlotValue( "デデデ", "タイトル", fs.getFrame("星のカービィ") );

    /*
    // クラスフレーム human の生成
    fs.createClassFrame( "human" );
    // height スロットを設定
    fs.writeSlotValue( "human", "height", new Integer( 160 ) );
    // height から weight を計算するための式 weight = 0.9*(height-100) を
    // when-requested demon として weight スロットに割り当てる
    fs.setWhenRequestedProc( "human", "weight", new AIDemonProcReadTest() );

    // インスタンスフレーム tora のﾌ生成
    fs.createInstanceFrame( "human", "tora" );

    // height と weight はデフォルト値
    System.out.println( fs.readSlotValue( "tora", "height", false ) );
    System.out.println( fs.readSlotValue( "tora", "weight", false ) );

    // weight はデフォルト値
    fs.writeSlotValue( "tora", "height", new Integer( 165 ) );
    System.out.println( fs.readSlotValue( "tora", "height", false ) );
    System.out.println( fs.readSlotValue( "tora", "weight", false ) );

    // 再びデフォルト値を表示
    fs.writeSlotValue( "tora", "weight", new Integer( 50 ) );
    System.out.println( fs.readSlotValue( "tora", "height", true ) );
    System.out.println( fs.readSlotValue( "tora", "weight", true ) );
    */
  }

}
