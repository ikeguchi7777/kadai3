package Morpheme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Morpheme {

	// 表層形
	String surface;

	// 品詞文字列
	String posStr;

	// 品詞階層
	String[] pos;

	// 活用形
	String conjForm;

	// 活用型
	String conjType;

	// 原形
	String base;

	// 読み
	String reading;

	// 発音
	String pron;

	String NETag;

	/**
	 * mainメソッド
	 */
	public static void main(String[] args) {
		// MeCabを起動
		startMeCab();

		// 文字列を形態素解析
		ArrayList<Morpheme> morphs = analyzeMorpheme("バック宙を50%成功するドアラ選手の年俸は食パン600gです");
		System.out.println(morphs);

		for (int i = 0; i < morphs.size(); i++) {
			// 形態素を1つずつmorphに格納するループ
			Morpheme morph = morphs.get(i);

			// 表層の文字列を取り出すには，getSurfaceメソッド
			String surface = morph.getSurface();
			System.out.println("表層の文字列: " + surface);

			// 動詞か否かチェック
			if (morph.isVerb()) {
				System.out.println("  動詞です");
			}

			// 品詞（第i+1階層）を取り出すには，getPos(i)
			String pos1 = morph.getPos(0);
			System.out.println("　品詞第一階層: " + pos1);
			String pos2 = morph.getPos(1);
			System.out.println("　品詞第二階層: " + pos2);

			// 原形を取り出すには，getBaseformメソッド
			String base = morph.getBaseform();
			System.out.println("　原形: " + base);

			// 読みを取り出すには，getReadingメソッド
			String read = morph.getReading();
			System.out.println("　読み: " + read);
		}
	}

	String mecabLine;
	static Process mecabPrc;
	static PrintWriter mecabOut;
	static BufferedReader mecabIn;
	static String mecabCmd = "C:\\Program Files (x86)\\MeCab\\bin\\mecab.exe";
	static String encoding = "Shift-JIS";

	/**
	 * コンストラクタ
	 */
	public Morpheme(String line) {
		mecabLine = line;
		String[] arr = line.split("\t");
		surface = arr[0];
		NETag = arr[2];
		String feat = arr[1];
		String[] tokens = feat.split(",");
		posStr = "";
		pos = new String[4];
		for (int i = 0; i <= 3; i++) {
			pos[i] = tokens[i];
			if (i > 0) {
				posStr += ",";
			}
			posStr += tokens[i];
		}
		conjType = tokens[4];
		conjForm = tokens[5];
		base = tokens[6];
		if (tokens.length > 7) {
			reading = tokens[7];
			pron = tokens[8];
		} else {
			reading = "";
			pron = "";
		}
	}

	/**
	 * 形態素解析の結果をMorphemeオブジェクトのリストにして返す
	 */
	static ArrayList<Morpheme> analyzeMorpheme(String str) {
		if (mecabPrc == null) {
			startMeCab();
		}
		mecabOut.println(str); // MeCabに文字列を送る
		mecabOut.flush();
		ArrayList<Morpheme> morphs = new ArrayList<Morpheme>();
		try {
			for (String line = mecabIn.readLine(); line != null; line = mecabIn.readLine()) {
				// mecabから結果を受け取る
				if (line.equals("EOS")) {
					break;
				} else {
					morphs.add(new Morpheme(line));
				}
			}
		} catch (IOException e) {
			System.err.println("MeCabから形態素解析結果を受け取る際にIOExceptionが発生しました");
			e.printStackTrace();
		}
		return morphs;
	}

	/**
	 * 形態素解析器MeCabを開始する
	 */
	static void startMeCab() {
		try {
			mecabPrc = Runtime.getRuntime().exec(mecabCmd);
			mecabOut = new PrintWriter(new OutputStreamWriter(mecabPrc.getOutputStream(), encoding));
			mecabIn = new BufferedReader(new InputStreamReader(mecabPrc.getInputStream(), encoding));
		} catch (IOException e) {
			System.err.println("形態素解析器MeCabを起動できませんでした");
			System.exit(-1);
		}
	}

	/**
	 * この形態素の表層的文字列を返す
	 */
	public String getSurface() {
		return surface;
	}

	/**
	 * この形態素の読みを返す
	 */
	public String getReading() {
		return reading;
	}

	/**
	 * この形態素の品詞（第一階層のみ）を返す
	 */
	public String getPos() {
		return pos[0];
	}

	/**
	 * この形態素の品詞第(i+1)階層を返す
	 */
	public String getPos(int i) {
		return pos[i];
	}

	/**
	 * この形態素の活用形を返す
	 */
	public String getConjugationForm() {
		return conjForm;
	}

	/**
	 * この形態素の活用形を返す
	 */
	public String getConjugationType() {
		return conjType;
	}

	/**
	 * この形態素の原形を返す
	 */
	public String getBaseform() {
		return base;
	}

	/**
	 * この形態素の発音を返す
	 */
	public String getPronunciation() {
		return pron;
	}

	/**
	 * この形態素が動詞ならtrue（真）を返し，そうでなければfalse（偽）を返す
	 */
	public boolean isVerb() {
		return pos[0].equals("動詞");
	}

	/**
	 * この形態素の情報を文字列にして返す
	 */
	public String toString() {
		return "<形態素 表層=\"" + surface + "\"" +
				" 品詞=\"" + posStr + "\"" +
				" 活用形=\"" + conjForm + "\"" +
				" 活用型=\"" + conjType + "\"" +
				" 原形=\"" + base + "\"" +
				" 読み=\"" + reading + "\"" +
				" 発音=\"" + pron + "\"" +
				"固有表現=\"" + NETag + " />";
	}
}