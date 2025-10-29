package com.example.yourappname

// We reuse the QuestionBank, KanjiQuestion, and McqOption data classes from QuizData.kt

fun getN4Mcq1Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_1",
        title = "N4 Test 1",
        questions = listOf(
            KanjiQuestion("1. 彼の話はとても（感動）しました。", listOf(McqOption("かんどう"), McqOption("かんどうう"), McqOption("かんど"), McqOption("かんどお")), 0),
            KanjiQuestion("2. （必要）な書類を持ってきてください。", listOf(McqOption("ひつよう"), McqOption("ひっよう"), McqOption("ひつよ"), McqOption("ひっよ")), 0),
            KanjiQuestion("3. この道は（危険）ですから、気をつけてください。", listOf(McqOption("きけん"), McqOption("きげん"), McqOption("きけんい"), McqOption("きげんい")), 0),
            KanjiQuestion("4. （交通）がとても便利な場所です。", listOf(McqOption("こうつう"), McqOption("こうづう"), McqOption("こうつ"), McqOption("こうず")), 0),
            KanjiQuestion("5. この本は（最近）とても人気があります。", listOf(McqOption("さいきん"), McqOption("さいじん"), McqOption("さいこん"), McqOption("さいしん")), 0),
            KanjiQuestion("6. 明日は（予定）が変わりました。", listOf(McqOption("よてい"), McqOption("よせい"), McqOption("よたい"), McqOption("よさい")), 0),
            KanjiQuestion("7. （注意）して運転してください。", listOf(McqOption("ちゅうい"), McqOption("ちゅい"), McqOption("ちゅうえ"), McqOption("ちゅえい")), 0),
            KanjiQuestion("8. （自由）に選んでください。", listOf(McqOption("じゆう"), McqOption("じゅう"), McqOption("じよう"), McqOption("じゅ")), 0),
            KanjiQuestion("9. 駅までの（方法）を教えてください。", listOf(McqOption("ほうほう"), McqOption("ほうぼう"), McqOption("ほっほう"), McqOption("ほっぼう")), 0),
            KanjiQuestion("10. 日本語を（続けて）勉強しています。", listOf(McqOption("つづけて"), McqOption("つつけて"), McqOption("つづける"), McqOption("つつける")), 0),
            KanjiQuestion("11. （きかい）を使って作業します。", listOf(McqOption("機会"), McqOption("機械"), McqOption("器会"), McqOption("機界")), 1),
            KanjiQuestion("12. 新しい（きそく）ができました。", listOf(McqOption("規則"), McqOption("規足"), McqOption("規続"), McqOption("規則る")), 0),
            KanjiQuestion("13. 大事な（しりょう）をなくしました。", listOf(McqOption("資料"), McqOption("資量"), McqOption("資両"), McqOption("資糧")), 0),
            KanjiQuestion("14. （けいけん）が大切です。", listOf(McqOption("経験"), McqOption("景験"), McqOption("経検"), McqOption("敬験")), 0),
            KanjiQuestion("15. （せいかつ）が便利になりました。", listOf(McqOption("生活"), McqOption("生括"), McqOption("生滑"), McqOption("生渇")), 0),
            KanjiQuestion("16. （じゅんび）をしましょう。", listOf(McqOption("準備"), McqOption("順備"), McqOption("準備る"), McqOption("潤備")), 0),
            KanjiQuestion("17. （じけん）が起こりました。", listOf(McqOption("事件"), McqOption("事検"), McqOption("事険"), McqOption("事建")), 0),
            KanjiQuestion("18. （ほうほう）を説明してください。", listOf(McqOption("方法"), McqOption("方法う"), McqOption("方歩"), McqOption("方訪")), 0),
            KanjiQuestion("19. （れんらく）してください。", listOf(McqOption("連絡"), McqOption("練絡"), McqOption("連落"), McqOption("練落")), 0),
            KanjiQuestion("20. 新しい（けっか）が出ました。", listOf(McqOption("結果"), McqOption("結科"), McqOption("結課"), McqOption("結家")), 0)
        )
    )
}

fun getN4Mcq2Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_2",
        title = "N4 Test 2",
        questions = listOf(
            KanjiQuestion("1. 週末は【運動】します。", listOf(McqOption("うんどう"), McqOption("うごどう"), McqOption("うんとう"), McqOption("うごとう")), 0),
            KanjiQuestion("2. わたしと【同じ】かばんですね。", listOf(McqOption("あなじ"), McqOption("おなじ"), McqOption("あいじ"), McqOption("おいじ")), 1),
            KanjiQuestion("3. きのう、サッカーの【試合】を見ました。", listOf(McqOption("しあい"), McqOption("ためあい"), McqOption("しあう"), McqOption("しごう")), 0),
            KanjiQuestion("4. ここでは【写真】をとらないでください。", listOf(McqOption("しゃしん"), McqOption("しゃじん"), McqOption("しゃこん"), McqOption("しゃごん")), 0),
            KanjiQuestion("5. この言葉の【意味】が分かりません。", listOf(McqOption("いあじ"), McqOption("いみ"), McqOption("あじみ"), McqOption("うみ")), 1),
            KanjiQuestion("6. この【問題】はむずかしいです。", listOf(McqOption("もんたい"), McqOption("しつだい"), McqOption("もんだい"), McqOption("しつもん")), 2),
            KanjiQuestion("7. 母は【台所】にいます。", listOf(McqOption("だいどころ"), McqOption("たいどころ"), McqOption("だいしょ"), McqOption("たいしょ")), 0),
            KanjiQuestion("8. 【地図】を見て、駅まで行きました。", listOf(McqOption("ちず"), McqOption("じず"), McqOption("ちと"), McqOption("じと")), 0),
            KanjiQuestion("9. 今日は【用事】があるので、早く帰ります。", listOf(McqOption("ようじ"), McqOption("ようこと"), McqOption("もちじ"), McqOption("もちこと")), 0),
            KanjiQuestion("10. あなたの【意見】を聞かせてください。", listOf(McqOption("いけん"), McqOption("いげん"), McqOption("いかん"), McqOption("いがん")), 0),
            KanjiQuestion("11. 来月、北海道へ【りょこう】します。", listOf(McqOption("旅行"), McqOption("流心"), McqOption("旅心"), McqOption("流考")), 0),
            KanjiQuestion("12. あまり【しんぱい】しないでください。", listOf(McqOption("心配"), McqOption("新配"), McqOption("神配"), McqOption("心くばり")), 0),
            KanjiQuestion("13. 私はスポーツが【とくに】好きです。", listOf(McqOption("別に"), McqOption("特の"), McqOption("特に"), McqOption("別にき")), 2),
            KanjiQuestion("14. パーティーに【しょうたい】されました。", listOf(McqOption("持待"), McqOption("招待"), McqOption("招待"), McqOption("持対")), 1),
            KanjiQuestion("15. このじしょはとても【べんり】です。", listOf(McqOption("便利"), McqOption("使利"), McqOption("不利"), McqOption("便理")), 0),
            KanjiQuestion("16. このにもつを【はこんで】ください。", listOf(McqOption("運んで"), McqOption("連んで"), McqOption("動んで"), McqOption("送んで")), 0),
            KanjiQuestion("17. インターネットで【しらべます】。", listOf(McqOption("選べます"), McqOption("調べます"), McqOption("週べます"), McqOption("間べます")), 1),
            KanjiQuestion("18. 日本の文化に【きょうみ】があります。", listOf(McqOption("興未"), McqOption("教味"), McqOption("興味"), McqOption("強味")), 2),
            KanjiQuestion("19. 車の運転には【ちゅうい】してください。", listOf(McqOption("注音"), McqOption("住意"), McqOption("注意"), McqOption("住音")), 2),
            KanjiQuestion("20. 【せかい】にはいろいろな国があります。", listOf(McqOption("世間"), McqOption("世介"), McqOption("世中"), McqOption("世界")), 3)
        )
    )
}

fun getN4Mcq3Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_3",
        title = "N4 Test 3",
        questions = listOf(
            KanjiQuestion("1. この【建物】はとても高いです。", listOf(McqOption("たてもの"), McqOption("けんぶつ"), McqOption("けんもの"), McqOption("たてぶつ")), 0),
            KanjiQuestion("2. 彼は【有名】な歌手です。", listOf(McqOption("ゆうめい"), McqOption("ありな"), McqOption("ゆうな"), McqOption("ありめい")), 0),
            KanjiQuestion("3. 田中さんはとても【親切】です。", listOf(McqOption("しんせつ"), McqOption("おやきり"), McqOption("しんきり"), McqOption("おやせつ")), 0),
            KanjiQuestion("4. 駅の近くに【便利】な店があります。", listOf(McqOption("びんり"), McqOption("べんり"), McqOption("びんり"), McqOption("べんり")), 1),
            KanjiQuestion("5. 今日は【特別】な日です。", listOf(McqOption("とくべつ"), McqOption("とくわけ"), McqOption("どくべつ"), McqOption("どくわけ")), 0),
            KanjiQuestion("6. 大学で日本の文化を【研究】しています。", listOf(McqOption("けんきゅう"), McqOption("けんきゅ"), McqOption("けんぐう"), McqOption("けんぐ")), 0),
            KanjiQuestion("7. あなたの【将来】の夢は何ですか。", listOf(McqOption("しょうらい"), McqOption("しょらい"), McqOption("しょうれい"), McqOption("しょれい")), 0),
            KanjiQuestion("8. 旅行の【経験】について話してください。", listOf(McqOption("けいけん"), McqOption("けけん"), McqOption("けいげん"), McqOption("けげん")), 0),
            KanjiQuestion("9. 日本の【文化】に興味があります。", listOf(McqOption("ぶんか"), McqOption("ぶんが"), McqOption("もんか"), McqOption("もんが")), 0),
            KanjiQuestion("10. 図書館で【本】を借りました。", listOf(McqOption("ほん"), McqOption("もと"), McqOption("ぼん"), McqOption("ぽん")), 0),
            KanjiQuestion("11. 毎朝、【しんぶん】を読みます。", listOf(McqOption("新聞"), McqOption("心聞"), McqOption("親聞"), McqOption("真聞")), 0),
            KanjiQuestion("12. 趣味は【りょうり】です。", listOf(McqOption("料理"), McqOption("料里"), McqOption("理料"), McqOption("理里")), 0),
            KanjiQuestion("13. どんな【おんがく】が好きですか。", listOf(McqOption("音楽"), McqOption("音学"), McqOption("音楽"), McqOption("音學")), 0),
            KanjiQuestion("14. 昨日は【びょうき】で学校を休みました。", listOf(McqOption("病気"), McqOption("病気"), McqOption("病気"), McqOption("病気")), 0),
            KanjiQuestion("15. 風邪をひいたので、【くすり】を飲みました。", listOf(McqOption("薬"), McqOption("楽"), McqOption("薬"), McqOption("楽")), 0),
            KanjiQuestion("16. 【かぞく】と旅行に行きました。", listOf(McqOption("家族"), McqOption("家旅"), McqOption("家属"), McqOption("家旅")), 0),
            KanjiQuestion("17. 私には【きょうだい】が三人います。", listOf(McqOption("兄弟"), McqOption("兄第"), McqOption("兄代"), McqOption("供弟")), 0),
            KanjiQuestion("18. 夏休みに【りょこう】するつもりです。", listOf(McqOption("旅行"), McqOption("旅券"), McqOption("旅館"), McqOption("旅人")), 0),
            KanjiQuestion("19. 私の【しゅみ】は映画を見ることです。", listOf(McqOption("趣味"), McqOption("趣未"), McqOption("趣昧"), McqOption("取味")), 0),
            KanjiQuestion("20. 毎週末、【うんどう】しています。", listOf(McqOption("運動"), McqOption("運勤"), McqOption("運働"), McqOption("運童")), 0)
        )
    )
}

fun getN4Mcq4Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_4",
        title = "N4 Test 4",
        questions = listOf(
            KanjiQuestion("1. この荷物は【送料】がかかりますか。", listOf(McqOption("そうりょう"), McqOption("しょうりょう"), McqOption("そうろ"), McqOption("しょうろ")), 0),
            KanjiQuestion("2. 彼は【医者】になるのが夢です。", listOf(McqOption("いしゃ"), McqOption("いじゃ"), McqOption("いし"), McqOption("いじ")), 0),
            KanjiQuestion("3. この店の料理は【味】がいいですね。", listOf(McqOption("におい"), McqOption("あじ"), McqOption("かじ"), McqOption("みみ")), 1),
            KanjiQuestion("4. 私は【動物】が大好きです。", listOf(McqOption("どうぶつ"), McqOption("とうぶつ"), McqOption("どうもつ"), McqOption("とうもつ")), 0),
            KanjiQuestion("5. コンサートの【会場】はどこですか。", listOf(McqOption("かいじょう"), McqOption("がいじょう"), McqOption("かいば"), McqOption("がいば")), 0),
            KanjiQuestion("6. これで【以上】です。", listOf(McqOption("いじょう"), McqOption("いしょう"), McqOption("いじょ"), McqOption("いしょ")), 0),
            KanjiQuestion("7. あなたの顔を見て、【安心】しました。", listOf(McqOption("あんしん"), McqOption("あんじん"), McqOption("あんぜん"), McqOption("あんぜ")), 0),
            KanjiQuestion("8. この町は【不便】ですが、静かです。", listOf(McqOption("ふびん"), McqOption("ふべん"), McqOption("ぶびん"), McqOption("ぶべん")), 1),
            KanjiQuestion("9. 毎日【仕事】がいそがしいです。", listOf(McqOption("しごと"), McqOption("しこと"), McqOption("じごと"), McqOption("じこと")), 0),
            KanjiQuestion("10. 【世界】にはたくさんの美しい場所があります。", listOf(McqOption("せかい"), McqOption("せがい"), McqOption("せかい"), McqOption("せがい")), 0),
            KanjiQuestion("11. 駅の前に新しい【ぎんこう】ができました。", listOf(McqOption("銀校"), McqOption("銀好"), McqOption("銀行"), McqOption("銀航")), 2),
            KanjiQuestion("12. 成田【くうこう】へはどう行きますか。", listOf(McqOption("空港"), McqOption("空巷"), McqOption("気港"), McqOption("気巷")), 0),
            KanjiQuestion("13. 【ちゅうしゃじょう】はどこにありますか。", listOf(McqOption("駐車場"), McqOption("駐軍場"), McqOption("注軍場"), McqOption("注射場")), 0),
            KanjiQuestion("14. この【きょうしつ】は広くて明るいです。", listOf(McqOption("教室"), McqOption("教失"), McqOption("強室"), McqOption("強失")), 0),
            KanjiQuestion("15. 【としょかん】で勉強しましょう。", listOf(McqOption("図書官"), McqOption("図書館"), McqOption("都書官"), McqOption("都書館")), 1),
            KanjiQuestion("16. 「私の夢」というテーマで【さくぶん】を書きました。", listOf(McqOption("作分"), McqOption("作聞"), McqOption("作本"), McqOption("作文")), 3),
            KanjiQuestion("17. 今日の【てんき】はどうですか。", listOf(McqOption("天気"), McqOption("天気"), McqOption("天気"), McqOption("天気")), 0),
            KanjiQuestion("18. 部屋の【でんき】をつけてください。", listOf(McqOption("電気"), McqOption("電所"), McqOption("電 気"), McqOption("電 気")), 0),
            KanjiQuestion("19. 【しつもん】がある人は手を挙げてください。", listOf(McqOption("質問"), McqOption("質間"), McqOption("失問"), McqOption("失間")), 0),
            KanjiQuestion("20. 【おきゃくさま】、こちらへどうぞ。", listOf(McqOption("お客様"), McqOption("お各様"), McqOption("お客様"), McqOption("お格様")), 2)
        )
    )
}

fun getN4Mcq5Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_5",
        title = "N4 Test 5",
        questions = listOf(
            KanjiQuestion("1. この国の【文化】はとても面白いです。", listOf(McqOption("ぶんか"), McqOption("もんか"), McqOption("ぶんが"), McqOption("もんが")), 0),
            KanjiQuestion("2. 彼の【説明】は分かりやすいです。", listOf(McqOption("せつめい"), McqOption("せつみょう"), McqOption("せいめい"), McqOption("せいみょう")), 0),
            KanjiQuestion("3. メールを【返事】してください。", listOf(McqOption("へんし"), McqOption("かえし"), McqOption("へんじ"), McqOption("かえじ")), 2),
            KanjiQuestion("4. それはとても【大事】なことです。", listOf(McqOption("だいじ"), McqOption("たいじ"), McqOption("おおごと"), McqOption("だいこと")), 0),
            KanjiQuestion("5. パーティーの【用意】をしましょう。", listOf(McqOption("ようい"), McqOption("ようり"), McqOption("もちい"), McqOption("もちり")), 0),
            KanjiQuestion("6. 明日は【都合】がわるいです。", listOf(McqOption("つごう"), McqOption("とごう"), McqOption("つこう"), McqOption("とこう")), 0),
            KanjiQuestion("7. 日本での【生活】はどうですか。", listOf(McqOption("せいかつ"), McqOption("しょうかつ"), McqOption("せいかっ"), McqOption("しょうかっ")), 0),
            KanjiQuestion("8. 彼女は【熱心】に勉強しています。", listOf(McqOption("ねっしん"), McqOption("ねつしん"), McqOption("あつしん"), McqOption("あつじん")), 1),
            KanjiQuestion("9. この【品物】は高いですが、質がいいです。", listOf(McqOption("しなもの"), McqOption("ひんもの"), McqOption("しなぶつ"), McqOption("ひんぶつ")), 0),
            KanjiQuestion("10. 遅れた【理由】を教えてください。", listOf(McqOption("りゆ"), McqOption("りゆう"), McqOption("りう"), McqOption("りゅう")), 1),
            KanjiQuestion("11. 外で変な【おと】がします。", listOf(McqOption("声"), McqOption("音"), McqOption("楽"), McqOption("言")), 1),
            KanjiQuestion("12. このスープはいい【あじ】ですね。", listOf(McqOption("味"), McqOption("未"), McqOption("昧"), McqOption("魅")), 0),
            KanjiQuestion("13. いろいろな【いろ】のペンがあります。", listOf(McqOption("色"), McqOption("光"), McqOption("形"), McqOption("見")), 0),
            KanjiQuestion("14. 人はいつか【しにます】。", listOf(McqOption("亡にます"), McqOption("死にます"), McqOption("往にます"), McqOption("尽にます")), 1),
            KanjiQuestion("15. 切手を【あつめて】います。", listOf(McqOption("集めて"), McqOption("集めて"), McqOption("進めて"), McqOption("寄せて")), 0),
            KanjiQuestion("16. 会議は午後１時から【はじまります】。", listOf(McqOption("始まります"), McqOption("初まります"), McqOption("治まります"), McqOption("終まります")), 0),
            KanjiQuestion("17. コンサートがもうすぐ【おわります】。", listOf(McqOption("終わります"), McqOption("終ります"), McqOption("続わります"), McqOption("帰わります")), 0),
            KanjiQuestion("18. この漢字の読み方を【しっていますか】。", listOf(McqOption("知っていますか"), McqOption("っていますか"), McqOption("っていますか"), McqOption("っていますか")), 0),
            KanjiQuestion("19. よく【かんがえて】から、答えてください。", listOf(McqOption("感えて"), McqOption("替えて"), McqOption("考えて"), McqOption("買えて")), 2),
            KanjiQuestion("20. 学校は家から【とおい】です。", listOf(McqOption("遠い"), McqOption("近い"), McqOption("高い"), McqOption("長い")), 0)
        )
    )
}

fun getN4Mcq6Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_6",
        title = "N4 Test 6",
        questions = listOf(
            KanjiQuestion("1. 駅前の【喫茶店】で会いましょう。", listOf(McqOption("きっさてん"), McqOption("きつさてん"), McqOption("きちゃてん"), McqOption("きちさてん")), 0),
            KanjiQuestion("2. 私は【歌舞伎】に興味があります。", listOf(McqOption("かぶき"), McqOption("うたまいき"), McqOption("かぶぎ"), McqOption("うたぶき")), 0),
            KanjiQuestion("3. この問題を【説明】してください。", listOf(McqOption("せつめい"), McqOption("せつみょう"), McqOption("さつめい"), McqOption("さつみょう")), 0),
            KanjiQuestion("4. 彼は【親切】な人です。", listOf(McqOption("しんせつ"), McqOption("おやせつ"), McqOption("しんぜつ"), McqOption("おやきり")), 0),
            KanjiQuestion("5. 将来の【夢】は何ですか。", listOf(McqOption("ゆめ"), McqOption("む"), McqOption("ぼう"), McqOption("ゆめみ")), 0),
            KanjiQuestion("6. 【急】に雨が降ってきました。", listOf(McqOption("きゅう"), McqOption("いそ"), McqOption("こ"), McqOption("きゅ")), 0),
            KanjiQuestion("7. このビルには【事務所】がたくさんあります。", listOf(McqOption("じむしょ"), McqOption("じむじょ"), McqOption("しごとば"), McqOption("しごとどころ")), 0),
            KanjiQuestion("8. 私は【特に】魚が好きです。", listOf(McqOption("とくに"), McqOption("どくに"), McqOption("とくべつに"), McqOption("どくべつに")), 0),
            KanjiQuestion("9. 会議の【場所】はどこですか。", listOf(McqOption("ばしょ"), McqOption("ばところ"), McqOption("じょしょ"), McqOption("じょところ")), 0),
            KanjiQuestion("10. 彼は【意見】をはっきり言います。", listOf(McqOption("いけん"), McqOption("いげん"), McqOption("いかん"), McqOption("いがん")), 0),
            KanjiQuestion("11. 駅まで【あるいて】行きます。", listOf(McqOption("歩いて"), McqOption("走いて"), McqOption("足いて"), McqOption("歩て")), 0),
            KanjiQuestion("12. 電車を【おりて】、バスに乗ります。", listOf(McqOption("降りて"), McqOption("下りて"), McqOption("降て"), McqOption("下て")), 0),
            KanjiQuestion("13. 彼はいつも【おなじ】服を着ています。", listOf(McqOption("同じ"), McqOption("同し"), McqOption("合じ"), McqOption("合し")), 0),
            KanjiQuestion("14. 【しんぱい】しないでください。大丈夫です。", listOf(McqOption("心配"), McqOption("新配"), McqOption("神配"), McqOption("真配")), 0),
            KanjiQuestion("15. 彼の【こえ】はとても大きいです。", listOf(McqOption("声"), McqOption("音"), McqOption("言"), McqOption("歌")), 0),
            KanjiQuestion("16. この【ちかく】に郵便局はありますか。", listOf(McqOption("近く"), McqOption("近こ"), McqOption("近かく"), McqOption("近こく")), 0),
            KanjiQuestion("17. ここに【じゅうしょ】と名前を書いてください。", listOf(McqOption("住所"), McqOption("住書"), McqOption("住処"), McqOption("十所")), 0),
            KanjiQuestion("18. この問題の【こたえ】が分かりません。", listOf(McqOption("答え"), McqOption("答"), McqOption("解え"), McqOption("解")), 0),
            KanjiQuestion("19. 週末は【かぞく】と過ごします。", listOf(McqOption("家族"), McqOption("家旅"), McqOption("家属"), McqOption("家旅")), 0),
            KanjiQuestion("20. 毎日【べんきょう】しなければなりません。", listOf(McqOption("勉強"), McqOption("勉教"), McqOption("勤強"), McqOption("勤教")), 0)
        )
    )
}

fun getN4Mcq7Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_7",
        title = "N4 Test 7",
        questions = listOf(
            KanjiQuestion("1. 彼は【医者】ですが、週末は絵を描いています。", listOf(McqOption("いしゃ"), McqOption("いじゃ"), McqOption("いし"), McqOption("いじ")), 0),
            KanjiQuestion("2. 彼の【意見】はいつも面白いです。", listOf(McqOption("いけん"), McqOption("いげん"), McqOption("いかん"), McqOption("いがん")), 0),
            KanjiQuestion("3. この【問題】は少し難しいです。", listOf(McqOption("もんだい"), McqOption("もんたい"), McqOption("もんたい"), McqOption("もんだい")), 0),
            KanjiQuestion("4. 私は【動物】がとても好きです。", listOf(McqOption("どうぶつ"), McqOption("どうもつ"), McqOption("とうぶつ"), McqOption("とうもつ")), 0),
            KanjiQuestion("5. 彼は【有名】な作家です。", listOf(McqOption("ゆうめい"), McqOption("ゆうみょう"), McqOption("うめい"), McqOption("うみょう")), 0),
            KanjiQuestion("6. この町は【交通】が便利です。", listOf(McqOption("こうつう"), McqOption("こうずう"), McqOption("ごうつう"), McqOption("ごうずう")), 0),
            KanjiQuestion("7. 【出発】の時間を教えてください。", listOf(McqOption("しゅっぱつ"), McqOption("しゅぱつ"), McqOption("しゅっはつ"), McqOption("しゅはつ")), 0),
            KanjiQuestion("8. あなたの【趣味】は何ですか。", listOf(McqOption("しゅみ"), McqOption("しゅび"), McqOption("しゅうみ"), McqOption("しゅうび")), 0),
            KanjiQuestion("9. 彼は【親切】で、よく手伝ってくれます。", listOf(McqOption("しんせつ"), McqOption("しんぜつ"), McqOption("おやせつ"), McqOption("おやぜつ")), 0),
            KanjiQuestion("10. 彼女は【料理】が上手です。", listOf(McqOption("りょうり"), McqOption("りょり"), McqOption("りょうり"), McqOption("りょり")), 0),
            KanjiQuestion("11. 毎日【うんどう】したほうがいいですよ。", listOf(McqOption("運動"), McqOption("運勤"), McqOption("運働"), McqOption("運童")), 0),
            KanjiQuestion("12. 彼の【けんきゅう】はとても進んでいます。", listOf(McqOption("研究"), McqOption("見究"), McqOption("研窮"), McqOption("見窮")), 0),
            KanjiQuestion("13. 駅で【ちず】をもらいました。", listOf(McqOption("地図"), McqOption("地図"), McqOption("池図"), McqOption("池図")), 0),
            KanjiQuestion("14. 【せかい】にはいろいろな国があります。", listOf(McqOption("世界"), McqOption("世間"), McqOption("世中"), McqOption("世介")), 0),
            KanjiQuestion("15. 彼女は【びじゅつかん】で働いています。", listOf(McqOption("美術館"), McqOption("美実館"), McqOption("美述館"), McqOption("美朮館")), 0),
            KanjiQuestion("16. この【へん】に銀行はありますか。", listOf(McqOption("辺"), McqOption("変"), McqOption("返"), McqOption("編")), 0),
            KanjiQuestion("17. 明日、【たいしかん】へ行きます。", listOf(McqOption("大使館"), McqOption("大使官"), McqOption("大使舘"), McqOption("大使菅")), 0),
            KanjiQuestion("18. この【しなもの】はいくらですか。", listOf(McqOption("品物"), McqOption("品物"), McqOption("品物"), McqOption("品物")), 0),
            KanjiQuestion("19. 【おゆ】をわかしてください。", listOf(McqOption("お湯"), McqOption("お湯"), McqOption("お湯"), McqOption("お湯")), 0),
            KanjiQuestion("20. 【とこや】はどこですか。", listOf(McqOption("床屋"), McqOption("床家"), McqOption("床室"), McqOption("床所")), 0)
        )
    )
}

fun getN4Mcq8Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_8",
        title = "N4 Test 8",
        questions = listOf(
            KanjiQuestion("1. 友人の【結婚】式に出席します。", listOf(McqOption("けいこん"), McqOption("けつこん"), McqOption("けっこん"), McqOption("けいごん")), 2),
            KanjiQuestion("2. 駅員に道を【案内】してもらいました。", listOf(McqOption("あんない"), McqOption("あんねい"), McqOption("かんない"), McqOption("がんない")), 0),
            KanjiQuestion("3. 【急行】電車は次の駅に止まりません。", listOf(McqOption("きゅこう"), McqOption("きゅうこう"), McqOption("いそぎこう"), McqOption("きゅうごう")), 1),
            KanjiQuestion("4. デパートで新しい【洋服】を買いたいです。", listOf(McqOption("よふく"), McqOption("ようぶく"), McqOption("よぶく"), McqOption("ようふく")), 3),
            KanjiQuestion("5. 隣のビルで【火事】がありました。", listOf(McqOption("かじ"), McqOption("ひじ"), McqOption("ひのこと"), McqOption("かごと")), 0),
            KanjiQuestion("6. 部屋の【空気】を入れかえましょう。", listOf(McqOption("くき"), McqOption("そらき"), McqOption("くうき"), McqOption("くうぎ")), 2),
            KanjiQuestion("7. あの【店員】はとても親切です。", listOf(McqOption("みせいん"), McqOption("てんいん"), McqOption("てんん"), McqOption("みせにん")), 1),
            KanjiQuestion("8. 古いお寺の【建物】を見に行きました。", listOf(McqOption("けんぶつ"), McqOption("たてぶつ"), McqOption("けんもの"), McqOption("たてもの")), 3),
            KanjiQuestion("9. 私はクラシック【音楽】をよく聞きます。", listOf(McqOption("おんがく"), McqOption("おとがく"), McqOption("おんらく"), McqOption("おとらく")), 0),
            KanjiQuestion("10. 【夕方】、公園を散歩します。", listOf(McqOption("ゆうかた"), McqOption("ゆうがた"), McqOption("せきがた"), McqOption("せきかた")), 1),
            KanjiQuestion("11. 風邪をひいた友達に「【おだいじに】」と言いました。", listOf(McqOption("お太事に"), McqOption("お大事に"), McqOption("お大事に"), McqOption("お犬事に")), 2),
            KanjiQuestion("12. 私の姉はまだ【わかい】です。", listOf(McqOption("若い"), McqOption("苦い"), McqOption("若"), McqOption("若り")), 0),
            KanjiQuestion("13. 昨日のパーティーはとても【たのしかった】です。", listOf(McqOption("楽いかった"), McqOption("楽しかった"), McqOption("薬しかった"), McqOption("楽しかた")), 1),
            KanjiQuestion("14. 今年の冬はとても【さむい】です。", listOf(McqOption("寒い"), McqOption("寒"), McqOption("暑い"), McqOption("冷い")), 0),
            KanjiQuestion("15. 彼の部屋はいつも【あかるい】です。", listOf(McqOption("明い"), McqOption("盟るい"), McqOption("暗るい"), McqOption("明るい")), 3),
            KanjiQuestion("16. 私の家は駅から【ちかい】です。", listOf(McqOption("折かい"), McqOption("近い"), McqOption("斤かい"), McqOption("返い")), 1),
            KanjiQuestion("17. この荷物はとても【おもい】です。", listOf(McqOption("動い"), McqOption("童い"), McqOption("重い"), McqOption("重ねい")), 2),
            KanjiQuestion("18. 彼女は【うたう】のが上手です。", listOf(McqOption("歌う"), McqOption("歌"), McqOption("唄う"), McqOption("唄")), 0),
            KanjiQuestion("19. 図書館に本を【かえします】。", listOf(McqOption("返るします"), McqOption("戻します"), McqOption("帰します"), McqOption("返します")), 3),
            KanjiQuestion("20. この【もんだい】は簡単です。", listOf(McqOption("問是"), McqOption("間題"), McqOption("問題"), McqOption("問答")), 2)
        )
    )
}

fun getN4Mcq9Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_9",
        title = "N4 Test 9",
        questions = listOf(
            KanjiQuestion("1. 兄は来年、大学を【卒業】します。", listOf(McqOption("そっぎょう"), McqOption("そつぎょう"), McqOption("そつぎょ"), McqOption("しゅつぎょう")), 1),
            KanjiQuestion("2. この町には【工業】の会社が多いです。", listOf(McqOption("こうぎょう"), McqOption("こぎょう"), McqOption("こうきょう"), McqOption("こきょう")), 0),
            KanjiQuestion("3. 毎日【地下鉄】で会社に行きます。", listOf(McqOption("じかてつ"), McqOption("ちがてつ"), McqOption("ちかてつ"), McqOption("じがてつ")), 2),
            KanjiQuestion("4. 今日は少し【頭】が痛いです。", listOf(McqOption("とう"), McqOption("ず"), McqOption("かしら"), McqOption("あたま")), 3),
            KanjiQuestion("5. 私は【黒い】猫を飼っています。", listOf(McqOption("くろい"), McqOption("こくい"), McqOption("くろり"), McqOption("こく")), 0),
            KanjiQuestion("6. このアプリはとても【便利】です。", listOf(McqOption("びんり"), McqOption("べんり"), McqOption("べんり"), McqOption("びんり")), 1),
            KanjiQuestion("7. 【一生懸命】日本語を勉強しています。", listOf(McqOption("いしょうけんめい"), McqOption("いっしょうけんめ"), McqOption("いっしょけんめい"), McqOption("いっしょうけんめい")), 3),
            KanjiQuestion("8. 今日は【気分】がいいです。", listOf(McqOption("きふん"), McqOption("きぷん"), McqOption("きぶん"), McqOption("きぶん")), 2),
            KanjiQuestion("9. 東京の【人口】は多いですか。", listOf(McqOption("じんこう"), McqOption("にんこう"), McqOption("ひとくち"), McqOption("じんくち")), 0),
            KanjiQuestion("10. 母は【台所】で料理をしています。", listOf(McqOption("たいどころ"), McqOption("だいどころ"), McqOption("だいしょ"), McqOption("たいしょ")), 1),
            KanjiQuestion("11. 手を洗うために【せっけん】を使います。", listOf(McqOption("石けん"), McqOption("石検"), McqOption("石鹸"), McqOption("石鹸")), 3),
            KanjiQuestion("12. 京都で【おみやげ】をたくさん買いました。", listOf(McqOption("お土産"), McqOption("お土上げ"), McqOption("おみあげ"), McqOption("お土産")), 0),
            KanjiQuestion("13. ホテルの【うけつけ】は１階です。", listOf(McqOption("受付け"), McqOption("受け付け"), McqOption("受付"), McqOption("受附")), 2),
            KanjiQuestion("14. 【さいふ】を忘れてしまいました。", listOf(McqOption("才布"), McqOption("財布"), McqOption("財 布"), McqOption("財符")), 1),
            KanjiQuestion("15. 私は彼が正しいと【おもいます】。", listOf(McqOption("思います"), McqOption("想います"), McqOption("相います"), McqOption("見います")), 0),
            KanjiQuestion("16. 冬はセーターを【きます】。", listOf(McqOption("切ります"), McqOption("来ます"), McqOption("着ます"), McqOption("着ります")), 2),
            KanjiQuestion("17. 【おなかがすきました】ね。何か食べましょう。", listOf(McqOption("お中が空きました"), McqOption("お腹が空きました"), McqOption("お腹が好きました"), McqOption("お腹が空きました")), 1),
            KanjiQuestion("18. 公園で子どもたちが【あそんでいます】。", listOf(McqOption("泳んでいます"), McqOption("学んでいます"), McqOption("遊ぶています"), McqOption("遊んでいます")), 3),
            KanjiQuestion("19. 運動すると【からだ】の調子が良くなります。", listOf(McqOption("体"), McqOption("休"), McqOption("木"), McqOption("本")), 0),
            KanjiQuestion("20. この部屋は電気がなくて【くらい】です。", listOf(McqOption("音い"), McqOption("黒い"), McqOption("暗い"), McqOption("闇い")), 2)
        )
    )
}

fun getN4Mcq10Bank(): QuestionBank {
    return QuestionBank(
        id = "n4_mcq_10",
        title = "N4 Test 10",
        questions = listOf(
            KanjiQuestion("1. 彼は【真面目】な学生です。", listOf(McqOption("まめ"), McqOption("まじめ"), McqOption("しんめんめ"), McqOption("まおも")), 1),
            KanjiQuestion("2. 旅行の【準備】は終わりましたか。", listOf(McqOption("じゅんび"), McqOption("しゅんび"), McqOption("じゅんびん"), McqOption("しゅんぴ")), 0),
            KanjiQuestion("3. この【辺り】は夜になると静かです。", listOf(McqOption("あたり"), McqOption("へんり"), McqOption("へん"), McqOption("あり")), 0),
            KanjiQuestion("4. 兄は【警察官】になりました。", listOf(McqOption("けいさつかん"), McqOption("けさつかん"), McqOption("けいさつがん"), McqOption("けさつがん")), 0),
            KanjiQuestion("5. 飛行機の【切符】を予約しました。", listOf(McqOption("きりふ"), McqOption("きっぷ"), McqOption("せっふ"), McqOption("せっぷ")), 1),
            KanjiQuestion("6. この問題について【相談】したいです。", listOf(McqOption("そうたん"), McqOption("しょうだん"), McqOption("そうだん"), McqOption("しょうたん")), 2),
            KanjiQuestion("7. 【危険】ですから、中に入らないでください。", listOf(McqOption("きけん"), McqOption("きげん"), McqOption("あぶけん"), McqOption("あぶない")), 0),
            KanjiQuestion("8. 彼女は【優しい】先生です。", listOf(McqOption("やしゃしい"), McqOption("やさしい"), McqOption("ゆうしい"), McqOption("ゆうしゃしい")), 1),
            KanjiQuestion("9. 電車が【遅れて】すみません。", listOf(McqOption("おくれて"), McqOption("おそくれて"), McqOption("ちれて"), McqOption("おくれて")), 0),
            KanjiQuestion("10. この会議はとても【重要】です。", listOf(McqOption("じゅうよう"), McqOption("しゅうよう"), McqOption("じゅよう"), McqOption("しゅよう")), 0),
            KanjiQuestion("11. 彼はいつも【いそがしそう】です。", listOf(McqOption("忙しそう"), McqOption("急がしそう"), McqOption("忙しいそう"), McqOption("急しいそう")), 0),
            KanjiQuestion("12. この川は【ふかい】ですか。", listOf(McqOption("深い"), McqOption("不開"), McqOption("付会"), McqOption("浅い")), 0),
            KanjiQuestion("13. 部屋の【まど】を閉めてください。", listOf(McqOption("窓"), McqOption("究"), McqOption("穴"), McqOption("門")), 0),
            KanjiQuestion("14. 【はじめに】、自己紹介をします。", listOf(McqOption("始めに"), McqOption("初めに"), McqOption("始に"), McqOption("元に")), 1),
            KanjiQuestion("15. 駅の【ひがし】口で会いましょう。", listOf(McqOption("東"), McqOption("西"), McqOption("日がし"), McqOption("日が差")), 0),
            KanjiQuestion("16. この店のパンはとても【やわらかい】です。", listOf(McqOption("軟らかい"), McqOption("柔らかい"), McqOption("柔かい"), McqOption("軟かい")), 1),
            KanjiQuestion("17. 彼の話は【とくべつ】面白いわけではない。", listOf(McqOption("別に"), McqOption("特別の"), McqOption("特別"), McqOption("特に")), 2),
            KanjiQuestion("18. 私は【しょうらい】、先生になりたいです。", listOf(McqOption("将来"), McqOption("少来"), McqOption("小来"), McqOption("将来")), 0),
            KanjiQuestion("19. この町には【おてら】や神社が多い。", listOf(McqOption("御寺"), McqOption("お寺"), McqOption("寺"), McqOption("手良")), 1),
            KanjiQuestion("20. 毎日、日本語の【ふくしゅう】をしています。", listOf(McqOption("複週"), McqOption("復習"), McqOption("復週"), McqOption("複習")), 1)
        )
    )
}

// This function provides the complete list of N4 quizzes
fun getAllN4QuestionBanks(): List<QuestionBank> {
    return listOf(
        getN4Mcq1Bank(),
        getN4Mcq2Bank(),
        getN4Mcq3Bank(),
        getN4Mcq4Bank(),
        getN4Mcq5Bank(),
        getN4Mcq6Bank(),
        getN4Mcq7Bank(),
        getN4Mcq8Bank(),
        getN4Mcq9Bank(),
        getN4Mcq10Bank()
    )
}
