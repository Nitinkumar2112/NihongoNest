package com.example.yourappname // Make sure this package name matches yours

import androidx.annotation.DrawableRes

// Data structures for our Quiz
data class McqOption(val text: String)

data class KanjiQuestion(
    val questionText: String,
    val options: List<McqOption>,
    val correctAnswerIndex: Int // 0 for A, 1 for B, 2 for C, 3 for D
)

data class QuestionBank(
    val id: String, // A unique ID for saving the score
    val title: String,
    val questions: List<KanjiQuestion>
)

// The actual list of questions for MCQ 1
fun getMcq1Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_1",
        title = "MCQ 1",
        questions = listOf(
            KanjiQuestion("1. 山に のぼります。", listOf(McqOption("やま"), McqOption("さん"), McqOption("やまい"), McqOption("さんや")), 0),
            KanjiQuestion("2. 水を のみます。", listOf(McqOption("すい"), McqOption("みず"), McqOption("こうずい"), McqOption("すいえい")), 1),
            KanjiQuestion("3. 先生に ききます。", listOf(McqOption("せんせい"), McqOption("さきうまれ"), McqOption("せんうま"), McqOption("しょうせい")), 0),
            KanjiQuestion("4. 小さい ねこです。", listOf(McqOption("おおきい"), McqOption("こさい"), McqOption("ちいさい"), McqOption("しょうさい")), 2),
            KanjiQuestion("5. 木の したに います。", listOf(McqOption("もく"), McqOption("うえ"), McqOption("き"), McqOption("した")), 2),
            KanjiQuestion("6. 本を よみます。", listOf(McqOption("ほん"), McqOption("もと"), McqOption("ぽん"), McqOption("ぼん")), 0),
            KanjiQuestion("7. 私は 学生です。", listOf(McqOption("がくせい"), McqOption("がくしょう"), McqOption("まなびて"), McqOption("せいがく")), 0),
            KanjiQuestion("8. 一人で いきます。", listOf(McqOption("いちひと"), McqOption("ひとり"), McqOption("いっひと"), McqOption("いちにん")), 1),
            KanjiQuestion("9. 月を みます。", listOf(McqOption("つき"), McqOption("がつ"), McqOption("げつ"), McqOption("つち")), 0),
            KanjiQuestion("10. 日本に いきます。", listOf(McqOption("にっぽん"), McqOption("にほん"), McqOption("ひのもと"), McqOption("じほん")), 1),
            KanjiQuestion("11. みずを のみました。", listOf(McqOption("火"), McqOption("木"), McqOption("水"), McqOption("気")), 2),
            KanjiQuestion("12. (ひと)が たくさん います。", listOf(McqOption("入"), McqOption("大"), McqOption("上"), McqOption("人")), 3),
            KanjiQuestion("13. (つき)が きれいです。", listOf(McqOption("日"), McqOption("月"), McqOption("木"), McqOption("山")), 1),
            KanjiQuestion("14. 毎日 (ほん)を よみます。", listOf(McqOption("木"), McqOption("正"), McqOption("本"), McqOption("生")), 2),
            KanjiQuestion("15. これは (ちいさい) ねこです。", listOf(McqOption("小"), McqOption("少"), McqOption("中"), McqOption("白")), 0),
            KanjiQuestion("16. (がっこう)へ いきます。", listOf(McqOption("学生"), McqOption("学校"), McqOption("校生"), McqOption("生校")), 1),
            KanjiQuestion("17. きのう (やま)に のぼりました。", listOf(McqOption("木"), McqOption("山"), McqOption("川"), McqOption("土")), 1),
            KanjiQuestion("18. これは (にほん)の たべものです。", listOf(McqOption("日木"), McqOption("本日"), McqOption("日本"), McqOption("本人")), 2),
            KanjiQuestion("19. (おおきい) いぬが います。", listOf(McqOption("太"), McqOption("中"), McqOption("大"), McqOption("高")), 2),
            KanjiQuestion("20. (でんしゃ)で いきます。", listOf(McqOption("電車"), McqOption("電気"), McqOption("自電"), McqOption("車気")), 0)
        )
    )
}

fun getMcq2Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_2",
        title = "MCQ 2",
        questions = listOf(
            KanjiQuestion("1. (車)で いきます。", listOf(McqOption("くるま"), McqOption("しゃ"), McqOption("うま"), McqOption("じてん")), 0),
            KanjiQuestion("2. (火)を けします。", listOf(McqOption("ひ"), McqOption("ほ"), McqOption("か"), McqOption("び")), 0),
            KanjiQuestion("3. (中)に 入ります。", listOf(McqOption("なか"), McqOption("ちゅう"), McqOption("なが"), McqOption("うち")), 0),
            KanjiQuestion("4. (下)に あります。", listOf(McqOption("した"), McqOption("うえ"), McqOption("なか"), McqOption("さき")), 0),
            KanjiQuestion("5. (百)えんです。", listOf(McqOption("せん"), McqOption("じゅう"), McqOption("ひゃく"), McqOption("まん")), 2),
            KanjiQuestion("6. (女)の せんせいです。", listOf(McqOption("おとこ"), McqOption("おんな"), McqOption("じょ"), McqOption("かのじょ")), 1),
            KanjiQuestion("7. (友)だちと あそびます。", listOf(McqOption("とも"), McqOption("ゆう"), McqOption("たち"), McqOption("こう")), 0),
            KanjiQuestion("8. きのう (雨)が ふりました。", listOf(McqOption("ゆき"), McqOption("あめ"), McqOption("かぜ"), McqOption("あらし")), 1),
            KanjiQuestion("9. (白)い シャツを きます。", listOf(McqOption("はく"), McqOption("しろ"), McqOption("あお"), McqOption("くろ")), 1),
            KanjiQuestion("10. (天)きが いいです。", listOf(McqOption("あめ"), McqOption("そら"), McqOption("てん"), McqOption("うみ")), 2),
            KanjiQuestion("11. (そと)に いきましょう。", listOf(McqOption("下"), McqOption("外"), McqOption("出"), McqOption("方")), 1),
            KanjiQuestion("12. (こども)が あそんでいます。", listOf(McqOption("学生"), McqOption("小人"), McqOption("子供"), McqOption("少年")), 2),
            KanjiQuestion("13. (でんき)を つけて ください。", listOf(McqOption("電気"), McqOption("電車"), McqOption("気電"), McqOption("気光")), 0),
            KanjiQuestion("14. (はは)は やさしいです。", listOf(McqOption("お母"), McqOption("母"), McqOption("父"), McqOption("姉")), 1),
            KanjiQuestion("15. (おとうと)は こうこうせいです。", listOf(McqOption("弟"), McqOption("兄"), McqOption("妹"), McqOption("子")), 0),
            KanjiQuestion("16. (いえ)に かえります。", listOf(McqOption("家"), McqOption("室"), McqOption("戸"), McqOption("屋")), 0),
            KanjiQuestion("17. (まいにち) べんきょうします。", listOf(McqOption("毎日"), McqOption("日曜"), McqOption("日間"), McqOption("日夕")), 0),
            KanjiQuestion("18. (はな)が きれいです。", listOf(McqOption("草"), McqOption("花"), McqOption("木"), McqOption("草花")), 1),
            KanjiQuestion("19. (いま) なんじですか？", listOf(McqOption("今"), McqOption("金"), McqOption("間"), McqOption("生")), 0),
            KanjiQuestion("20. (たかい) やまです。", listOf(McqOption("高"), McqOption("多"), McqOption("太"), McqOption("大")), 0)
        )
    )
}

fun getMcq3Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_3",
        title = "MCQ 3",
        questions = listOf(
            KanjiQuestion("1. (出)かけます。", listOf(McqOption("しゅつ"), McqOption("で"), McqOption("い"), McqOption("だ")), 1),
            KanjiQuestion("2. (見)えますか？", listOf(McqOption("けん"), McqOption("み"), McqOption("みえ"), McqOption("みる")), 1),
            KanjiQuestion("3. (名)まえを かいてください。", listOf(McqOption("めい"), McqOption("みょう"), McqOption("な"), McqOption("なま")), 2),
            KanjiQuestion("4. (正)しい こたえは どれですか。", listOf(McqOption("ただ"), McqOption("しょう"), McqOption("せい"), McqOption("ただし")), 0),
            KanjiQuestion("5. (何)じに おきますか？", listOf(McqOption("か"), McqOption("なに"), McqOption("なん"), McqOption("いく")), 2),
            KanjiQuestion("6. (間)に あいだが あります。", listOf(McqOption("ま"), McqOption("あいだ"), McqOption("かん"), McqOption("けん")), 1),
            KanjiQuestion("7. (東)きょうに すんでいます。", listOf(McqOption("とう"), McqOption("ひがし"), McqOption("あずま"), McqOption("ひが")), 0),
            KanjiQuestion("8. (高)い たてものです。", listOf(McqOption("こう"), McqOption("たかい"), McqOption("おおきい"), McqOption("たけ")), 1),
            KanjiQuestion("9. (午)ごぜん 10じです。", listOf(McqOption("ご"), McqOption("ひる"), McqOption("うま"), McqOption("しょう")), 0),
            KanjiQuestion("10. (南)ぐちから はいります。", listOf(McqOption("なん"), McqOption("みなみ"), McqOption("ひがし"), McqOption("にし")), 1),
            KanjiQuestion("11. (にし)の そらが あかるいです。", listOf(McqOption("西"), McqOption("東"), McqOption("南"), McqOption("北")), 0),
            KanjiQuestion("12. (まんが)を よみます。", listOf(McqOption("多画"), McqOption("漫画"), McqOption("漢画"), McqOption("学画")), 1),
            KanjiQuestion("13. (すこし) まってください。", listOf(McqOption("小"), McqOption("少"), McqOption("中"), McqOption("白")), 1),
            KanjiQuestion("14. (くち)を あけてください。", listOf(McqOption("耳"), McqOption("出"), McqOption("口"), McqOption("名")), 2),
            KanjiQuestion("15. (いぬ)が います。", listOf(McqOption("犬"), McqOption("大"), McqOption("王"), McqOption("牛")), 0),
            KanjiQuestion("16. (くに)へ かえります。", listOf(McqOption("国"), McqOption("回"), McqOption("家"), McqOption("外")), 0),
            KanjiQuestion("17. (とも)だちが きます。", listOf(McqOption("学"), McqOption("語"), McqOption("友"), McqOption("母")), 2),
            KanjiQuestion("18. (あし)が いたいです。", listOf(McqOption("手"), McqOption("足"), McqOption("目"), McqOption("体")), 1),
            KanjiQuestion("19. (て)を あらいます。", listOf(McqOption("耳"), McqOption("目"), McqOption("手"), McqOption("足")), 2),
            KanjiQuestion("20. (はな)で においを かぎます。", listOf(McqOption("花"), McqOption("鼻"), McqOption("草"), McqOption("耳")), 1),
            KanjiQuestion("21. (め)で みます。", listOf(McqOption("耳"), McqOption("手"), McqOption("足"), McqOption("目")), 3)
        )
    )
}

fun getMcq4Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_4",
        title = "MCQ 4",
        questions = listOf(
            KanjiQuestion("1. (店)で パンを かいました。", listOf(McqOption("たな"), McqOption("てん"), McqOption("みせ"), McqOption("しょく")), 2),
            KanjiQuestion("2. (白)い シャツを きます。", listOf(McqOption("はく"), McqOption("しろ"), McqOption("しら"), McqOption("しる")), 1),
            KanjiQuestion("3. (行)きましょう。", listOf(McqOption("こう"), McqOption("ゆき"), McqOption("いき"), McqOption("い")), 2),
            KanjiQuestion("4. (父)と あそびます。", listOf(McqOption("ちち"), McqOption("ふ"), McqOption("とう"), McqOption("ち")), 0),
            KanjiQuestion("5. (学)こうに いきます。", listOf(McqOption("がっ"), McqOption("がく"), McqOption("まなぶ"), McqOption("こう")), 1),
            KanjiQuestion("6. (書)きますか？", listOf(McqOption("しょ"), McqOption("かき"), McqOption("か"), McqOption("しょく")), 1),
            KanjiQuestion("7. (食)べますか？", listOf(McqOption("の"), McqOption("たべ"), McqOption("しょく"), McqOption("た")), 1),
            KanjiQuestion("8. (読)みものが すきです。", listOf(McqOption("よみ"), McqOption("よ"), McqOption("どく"), McqOption("え")), 0),
            KanjiQuestion("9. (耳)で おとを ききます。", listOf(McqOption("はな"), McqOption("て"), McqOption("みみ"), McqOption("め")), 2),
            KanjiQuestion("10. (青)い そらです。", listOf(McqOption("あを"), McqOption("あお"), McqOption("せい"), McqOption("あか")), 1),
            KanjiQuestion("11. (はは)は せんせいです。", listOf(McqOption("母"), McqOption("父"), McqOption("姉"), McqOption("女")), 0),
            KanjiQuestion("12. (やすみ)は にちようびです。", listOf(McqOption("暇"), McqOption("安日"), McqOption("休み"), McqOption("休日")), 2),
            KanjiQuestion("13. (にちようび)に でかけます。", listOf(McqOption("日週日"), McqOption("日曜日"), McqOption("一曜日"), McqOption("日曜日")), 1),
            KanjiQuestion("14. (たべもの)が ありますか？", listOf(McqOption("食物"), McqOption("食べ物"), McqOption("食の物"), McqOption("飲食物")), 1),
            KanjiQuestion("15. (のむ) まえに ふたを あけます。", listOf(McqOption("飯"), McqOption("食"), McqOption("飲"), McqOption("水")), 2),
            KanjiQuestion("16. (いちにち)に さんかい おきます。", listOf(McqOption("一日"), McqOption("一月"), McqOption("一人"), McqOption("一時")), 0),
            KanjiQuestion("17. (せんしゅう) テストが ありました。", listOf(McqOption("今週"), McqOption("先週"), McqOption("前週"), McqOption("過週")), 1),
            KanjiQuestion("18. (くるま)で いきました。", listOf(McqOption("自動"), McqOption("車"), McqOption("自車"), McqOption("車道")), 1),
            KanjiQuestion("19. (がっこう)に いきます。", listOf(McqOption("学生"), McqOption("学科"), McqOption("学校"), McqOption("校学")), 2),
            KanjiQuestion("20. (いちねん) べんきょうします。", listOf(McqOption("一月"), McqOption("一年"), McqOption("一週"), McqOption("一日")), 1)
        )
    )
}

fun getMcq5Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_5",
        title = "MCQ 5",
        questions = listOf(
            KanjiQuestion("1. (雨)が ふっています。", listOf(McqOption("あま"), McqOption("う"), McqOption("あめ"), McqOption("あまご")), 2),
            KanjiQuestion("2. (火)ようびに でかけます。", listOf(McqOption("ひ"), McqOption("ほ"), McqOption("か"), McqOption("ひび")), 2),
            KanjiQuestion("3. (名)まえを かいてください。", listOf(McqOption("めい"), McqOption("な"), McqOption("なまえ"), McqOption("みょう")), 1),
            KanjiQuestion("4. (男)の せいとです。", listOf(McqOption("だん"), McqOption("おとこ"), McqOption("おと"), McqOption("たん")), 1),
            KanjiQuestion("5. (空)が きれいです。", listOf(McqOption("くう"), McqOption("あお"), McqOption("そら"), McqOption("くも")), 2),
            KanjiQuestion("6. (花)が さきました。", listOf(McqOption("はな"), McqOption("か"), McqOption("ばな"), McqOption("はなび")), 0),
            KanjiQuestion("7. (南)の まちに すんでいます。", listOf(McqOption("なん"), McqOption("みなみ"), McqOption("なみ"), McqOption("みん")), 1),
            KanjiQuestion("8. (左)に まがってください。", listOf(McqOption("みぎ"), McqOption("さ"), McqOption("ひだり"), McqOption("ひたり")), 2),
            KanjiQuestion("9. (天)きが いいです。", listOf(McqOption("あめ"), McqOption("てん"), McqOption("き"), McqOption("あま")), 1),
            KanjiQuestion("10. (金)を はらいます。", listOf(McqOption("きん"), McqOption("かね"), McqOption("こん"), McqOption("きね")), 1),
            KanjiQuestion("11. (みぎ)に いってください。", listOf(McqOption("有"), McqOption("右"), McqOption("石"), McqOption("古")), 1),
            KanjiQuestion("12. (こども)が あそんでいます。", listOf(McqOption("小人"), McqOption("子供"), McqOption("学生"), McqOption("男子")), 1),
            KanjiQuestion("13. (いえ)は おおきいです。", listOf(McqOption("家"), McqOption("屋"), McqOption("室"), McqOption("所")), 0),
            KanjiQuestion("14. (くに)へ かえります。", listOf(McqOption("国"), McqOption("地"), McqOption("村"), McqOption("州")), 0),
            KanjiQuestion("15. (ときどき) うちで たべます。", listOf(McqOption("時々"), McqOption("間時"), McqOption("今今"), McqOption("日日")), 0),
            KanjiQuestion("16. (なつ)は あついです。", listOf(McqOption("春"), McqOption("夏"), McqOption("秋"), McqOption("冬")), 1),
            KanjiQuestion("17. (やまぐち)さんは せんせいです。", listOf(McqOption("山口"), McqOption("山本"), McqOption("川山"), McqOption("山日")), 0),
            KanjiQuestion("18. (こうこう)の がくせいです。", listOf(McqOption("学校"), McqOption("高校"), McqOption("高学"), McqOption("校高")), 1),
            KanjiQuestion("19. (でんき)を けします。", listOf(McqOption("電車"), McqOption("電話"), McqOption("電気"), McqOption("自電")), 2),
            KanjiQuestion("20. (まいにち) べんきょうします。", listOf(McqOption("毎時"), McqOption("毎日"), McqOption("毎年"), McqOption("日毎")), 1)
        )
    )
}

fun getMcq6Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_6",
        title = "MCQ 6",
        questions = listOf(
            KanjiQuestion("1. (百)えん ください。", listOf(McqOption("はち"), McqOption("びゃく"), McqOption("ひゃく"), McqOption("ぴゃく")), 2),
            KanjiQuestion("2. (川)で およぎます。", listOf(McqOption("かわ"), McqOption("せん"), McqOption("すい"), McqOption("うみ")), 0),
            KanjiQuestion("3. (女)の こが います。", listOf(McqOption("じょ"), McqOption("おんな"), McqOption("にょ"), McqOption("め")), 1),
            KanjiQuestion("4. (学)こうは ここです。", listOf(McqOption("まな"), McqOption("がく"), McqOption("こう"), McqOption("せい")), 1),
            KanjiQuestion("5. (立)って ください。", listOf(McqOption("すわ"), McqOption("ある"), McqOption("た"), McqOption("たち")), 2),
            KanjiQuestion("6. (先)に いってください。", listOf(McqOption("まえ"), McqOption("せん"), McqOption("いま"), McqOption("さき")), 3),
            KanjiQuestion("7. (生)まれは とうきょうです。", listOf(McqOption("なま"), McqOption("せい"), McqOption("う"), McqOption("い")), 2),
            KanjiQuestion("8. (白)い シャツを きます。", listOf(McqOption("はく"), McqOption("しろ"), McqOption("はしろ"), McqOption("しら")), 1),
            KanjiQuestion("9. (天)ぷらが すきです。", listOf(McqOption("あま"), McqOption("てん"), McqOption("そら"), McqOption("き")), 1),
            KanjiQuestion("10. (車)で いきます。", listOf(McqOption("しゃ"), McqOption("くるま"), McqOption("てん"), McqOption("でん")), 1),
            KanjiQuestion("11. (ふゆ)は さむいです。", listOf(McqOption("冬"), McqOption("秋"), McqOption("夏"), McqOption("春")), 0),
            KanjiQuestion("12. (いぬ)が にひき います。", listOf(McqOption("犬"), McqOption("獣"), McqOption("央"), McqOption("牛")), 0),
            KanjiQuestion("13. (いま)は ごご さんじです。", listOf(McqOption("今"), McqOption("間"), McqOption("年"), McqOption("時")), 0),
            KanjiQuestion("14. (こうこうせい)です。", listOf(McqOption("高学生"), McqOption("校学生"), McqOption("高校生"), McqOption("高小生")), 2),
            KanjiQuestion("15. (ひゃく)えん ショップです。", listOf(McqOption("千"), McqOption("百"), McqOption("万"), McqOption("十")), 1),
            KanjiQuestion("16. (としょかん)に いきます。", listOf(McqOption("図書館"), McqOption("都書館"), McqOption("図学館"), McqOption("図館書")), 0),
            KanjiQuestion("17. (あさ)ごはんを たべます。", listOf(McqOption("朝"), McqOption("早"), McqOption("午"), McqOption("明")), 0),
            KanjiQuestion("18. (とき)が ありません。", listOf(McqOption("今"), McqOption("時"), McqOption("間"), McqOption("晩")), 1),
            KanjiQuestion("19. (うえ)に おいてください。", listOf(McqOption("下"), McqOption("上"), McqOption("北"), McqOption("南")), 1),
            KanjiQuestion("20. (ひがし)ぐちは こっちです。", listOf(McqOption("東"), McqOption("西"), McqOption("南"), McqOption("北")), 0)
        )
    )
}

fun getMcq7Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_7",
        title = "MCQ 7",
        questions = listOf(
            KanjiQuestion("1. (空)を みあげます。", listOf(McqOption("そら"), McqOption("くう"), McqOption("から"), McqOption("あお")), 0),
            KanjiQuestion("2. (南)に すんでいます。", listOf(McqOption("にし"), McqOption("ひがし"), McqOption("みなみ"), McqOption("きた")), 2),
            KanjiQuestion("3. (父)と あそびます。", listOf(McqOption("ちち"), McqOption("とう"), McqOption("おとこ"), McqOption("そふ")), 0),
            KanjiQuestion("4. (円)を はらいます。", listOf(McqOption("えん"), McqOption("まる"), McqOption("こん"), McqOption("がく")), 0),
            KanjiQuestion("5. (北)に いきます。", listOf(McqOption("ひがし"), McqOption("きた"), McqOption("にし"), McqOption("みなみ")), 1),
            KanjiQuestion("6. (男)の人は せが たかいです。", listOf(McqOption("だん"), McqOption("おとこ"), McqOption("なん"), McqOption("ひと")), 1),
            KanjiQuestion("7. (名)まえを かいてください。", listOf(McqOption("な"), McqOption("めい"), McqOption("まえ"), McqOption("じょう")), 0),
            KanjiQuestion("8. (多)くの ひとが きました。", listOf(McqOption("おお"), McqOption("たく"), McqOption("た"), McqOption("たい")), 0),
            KanjiQuestion("9. (左)に まがってください。", listOf(McqOption("ひだり"), McqOption("さ"), McqOption("みぎ"), McqOption("うしろ")), 0),
            KanjiQuestion("10. (外)で あそびましょう。", listOf(McqOption("そと"), McqOption("がい"), McqOption("ほか"), McqOption("うち")), 0),
            KanjiQuestion("11. (うま)に のります。", listOf(McqOption("馬"), McqOption("牛"), McqOption("車"), McqOption("鳥")), 0),
            KanjiQuestion("12. (てんき)が いいですね。", listOf(McqOption("天生"), McqOption("空気"), McqOption("天気"), McqOption("気天")), 2),
            KanjiQuestion("13. (やすみ)は にちようびです。", listOf(McqOption("安日"), McqOption("休日"), McqOption("休日"), McqOption("休み")), 3),
            KanjiQuestion("14. (こども)が います。", listOf(McqOption("小人"), McqOption("子人"), McqOption("子供"), McqOption("子供え")), 2),
            KanjiQuestion("15. (にちようび)に ピクニックを します。", listOf(McqOption("日用日"), McqOption("日曜日"), McqOption("日日曜"), McqOption("用日曜")), 1),
            KanjiQuestion("16. (おかね)が いります。", listOf(McqOption("金"), McqOption("銀"), McqOption("銭"), McqOption("玉")), 0),
            KanjiQuestion("17. (とけい)を みます。", listOf(McqOption("時計"), McqOption("時計"), McqOption("時軽"), McqOption("計時")), 0),
            KanjiQuestion("18. (たべもの)を かいました。", listOf(McqOption("食者"), McqOption("食物"), McqOption("食事"), McqOption("食家")), 1),
            KanjiQuestion("19. (ちち)は いしゃです。", listOf(McqOption("兄"), McqOption("父"), McqOption("祖"), McqOption("男")), 1),
            KanjiQuestion("20. (すこし) まってください。", listOf(McqOption("小し"), McqOption("少し"), McqOption("少時"), McqOption("小時")), 1)
        )
    )
}

fun getMcq8Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_8",
        title = "MCQ 8",
        questions = listOf(
            KanjiQuestion("1. (音)が きこえません。", listOf(McqOption("おと"), McqOption("おん"), McqOption("ね"), McqOption("しずか")), 0),
            KanjiQuestion("2. (天)の くもを みます。", listOf(McqOption("てん"), McqOption("あめ"), McqOption("そら"), McqOption("てんき")), 0),
            KanjiQuestion("3. (字)を きれいに かいてください。", listOf(McqOption("ぶん"), McqOption("じ"), McqOption("がく"), McqOption("もじ")), 1),
            KanjiQuestion("4. (中)に いれてください。", listOf(McqOption("なか"), McqOption("ちゅう"), McqOption("なが"), McqOption("あいだ")), 0),
            KanjiQuestion("5. (白)い シャツを きます。", listOf(McqOption("はく"), McqOption("しろ"), McqOption("しら"), McqOption("きいろ")), 1),
            KanjiQuestion("6. (店)で おかしを かいました。", listOf(McqOption("やま"), McqOption("いえ"), McqOption("みせ"), McqOption("たて")), 2),
            KanjiQuestion("7. (先)に いってください。", listOf(McqOption("まえ"), McqOption("せん"), McqOption("さき"), McqOption("うしろ")), 2),
            KanjiQuestion("8. (話)が おもしろかった。", listOf(McqOption("ごん"), McqOption("はなし"), McqOption("わ"), McqOption("けん")), 1),
            KanjiQuestion("9. (気)を つけてください。", listOf(McqOption("き"), McqOption("け"), McqOption("げ"), McqOption("きく")), 0),
            KanjiQuestion("10. (川)で およぎます。", listOf(McqOption("かわ"), McqOption("せん"), McqOption("がわ"), McqOption("みず")), 0),
            KanjiQuestion("11. (いえ)に かえります。", listOf(McqOption("家"), McqOption("店"), McqOption("校"), McqOption("国")), 0),
            KanjiQuestion("12. (としょかん)で ほんを よみます。", listOf(McqOption("図書間"), McqOption("図書家"), McqOption("図書館"), McqOption("図校館")), 2),
            KanjiQuestion("13. (でぐち)は どこですか。", listOf(McqOption("出口"), McqOption("出口け"), McqOption("外口"), McqOption("入口")), 0),
            KanjiQuestion("14. (ともだち)と はなします。", listOf(McqOption("友人"), McqOption("友男"), McqOption("友立"), McqOption("友達")), 3),
            KanjiQuestion("15. (せんせい)は にほんじんです。", listOf(McqOption("先生"), McqOption("先名"), McqOption("教生"), McqOption("先時")), 0),
            KanjiQuestion("16. (うえ)に あがります。", listOf(McqOption("上"), McqOption("空"), McqOption("高"), McqOption("下")), 0),
            KanjiQuestion("17. (いま)は なんじですか。", listOf(McqOption("会"), McqOption("今"), McqOption("合"), McqOption("令")), 1),
            KanjiQuestion("18. (ひる)ごはんを たべました。", listOf(McqOption("晩"), McqOption("朝"), McqOption("昼"), McqOption("早")), 2),
            KanjiQuestion("19. (ひとつ) ください。", listOf(McqOption("一人"), McqOption("一月"), McqOption("一日"), McqOption("一つ")), 3),
            KanjiQuestion("20. (まいにち) べんきょうします。", listOf(McqOption("毎日"), McqOption("毎時"), McqOption("毎年"), McqOption("間日")), 0)
        )
    )
}

fun getMcq9Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_9",
        title = "MCQ 9",
        questions = listOf(
            KanjiQuestion("1. (東)に いきます。", listOf(McqOption("とう"), McqOption("ひがし"), McqOption("あずま"), McqOption("にし")), 1),
            KanjiQuestion("2. (名)まえを かいてください。", listOf(McqOption("な"), McqOption("めい"), McqOption("なお"), McqOption("まえ")), 0),
            KanjiQuestion("3. (立)ってください。", listOf(McqOption("たち"), McqOption("りつ"), McqOption("たて"), McqOption("たつ")), 0),
            KanjiQuestion("4. (雨)が ふっています。", listOf(McqOption("あま"), McqOption("う"), McqOption("あめ"), McqOption("みず")), 2),
            KanjiQuestion("5. (男)のこが あそんでいます。", listOf(McqOption("おとこ"), McqOption("だん"), McqOption("おとこし"), McqOption("だんし")), 0),
            KanjiQuestion("6. (車)で いきます。", listOf(McqOption("てん"), McqOption("くるま"), McqOption("しゃ"), McqOption("ばす")), 1),
            KanjiQuestion("7. (百)えんです。", listOf(McqOption("ひゃく"), McqOption("もも"), McqOption("じゅう"), McqOption("はく")), 0),
            KanjiQuestion("8. (山下)さんは せんせいです。", listOf(McqOption("やました"), McqOption("さんした"), McqOption("やまもと"), McqOption("やまかみ")), 0),
            KanjiQuestion("9. (空)を みあげます。", listOf(McqOption("そら"), McqOption("くう"), McqOption("そらし"), McqOption("から")), 0),
            KanjiQuestion("10. (南)へ いきます。", listOf(McqOption("なん"), McqOption("みなみ"), McqOption("みなん"), McqOption("なんみ")), 1),
            KanjiQuestion("11. (おとこ)の せんせいです。", listOf(McqOption("男"), McqOption("先"), McqOption("生"), McqOption("名")), 0),
            KanjiQuestion("12. (はは)は せんせいです。", listOf(McqOption("父"), McqOption("母"), McqOption("女"), McqOption("姉")), 1),
            KanjiQuestion("13. (そと)は さむいです。", listOf(McqOption("北"), McqOption("外"), McqOption("先"), McqOption("出")), 1),
            KanjiQuestion("14. (こども)が あそんでいます。", listOf(McqOption("子者"), McqOption("小人"), McqOption("子供"), McqOption("少人")), 2),
            KanjiQuestion("15. (ひゃく)にんが きました。", listOf(McqOption("百"), McqOption("千"), McqOption("十"), McqOption("万")), 0),
            KanjiQuestion("16. (まえ)に たってください。", listOf(McqOption("後"), McqOption("南"), McqOption("北"), McqOption("前")), 3),
            KanjiQuestion("17. (たかい) やまです。", listOf(McqOption("高"), McqOption("多"), McqOption("大"), McqOption("上")), 0),
            KanjiQuestion("18. (よん)えんです。", listOf(McqOption("四"), McqOption("七"), McqOption("六"), McqOption("九")), 0),
            KanjiQuestion("19. (でんわ)を つかいます。", listOf(McqOption("電話"), McqOption("電語"), McqOption("電気"), McqOption("話電")), 0),
            KanjiQuestion("20. (がいこく)から きました。", listOf(McqOption("外国"), McqOption("外国人"), McqOption("海国"), McqOption("外間")), 0)
        )
    )
}

fun getMcq10Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_10",
        title = "MCQ 10",
        questions = listOf(
            KanjiQuestion("1. (人)が います。", listOf(McqOption("にん"), McqOption("じん"), McqOption("ひと"), McqOption("ひとり")), 2),
            KanjiQuestion("2. (日)ようびに あいましょう。", listOf(McqOption("にち"), McqOption("ひ"), McqOption("にっ"), McqOption("か")), 0),
            KanjiQuestion("3. (大)きい ビルです。", listOf(McqOption("おお"), McqOption("だい"), McqOption("たい"), McqOption("だいき")), 0),
            KanjiQuestion("4. (本)を よみます。", listOf(McqOption("ほん"), McqOption("もと"), McqOption("ぼん"), McqOption("ぽん")), 0),
            KanjiQuestion("5. (女)の こどもです。", listOf(McqOption("じょ"), McqOption("おんな"), McqOption("にょ"), McqOption("じょせい")), 1),
            KanjiQuestion("6. (山)に のぼります。", listOf(McqOption("やま"), McqOption("さん"), McqOption("ざん"), McqOption("さんや")), 0),
            KanjiQuestion("7. (水)を のみます。", listOf(McqOption("すい"), McqOption("みず"), McqOption("こうずい"), McqOption("すいえい")), 1),
            KanjiQuestion("8. (父)に あいます。", listOf(McqOption("ちち"), McqOption("とう"), McqOption("ふ"), McqOption("おとう")), 0),
            KanjiQuestion("9. (白)い シャツです。", listOf(McqOption("しろ"), McqOption("はく"), McqOption("しら"), McqOption("しろい")), 0),
            KanjiQuestion("10. (口)を あけてください。", listOf(McqOption("くち"), McqOption("こう"), McqOption("くう"), McqOption("ちゅう")), 0),
            KanjiQuestion("11. (みず)を のみます。", listOf(McqOption("木"), McqOption("火"), McqOption("水"), McqOption("気")), 2),
            KanjiQuestion("12. (て)で かきます。", listOf(McqOption("手"), McqOption("毛"), McqOption("木"), McqOption("足")), 0),
            KanjiQuestion("13. (くるま)に のります。", listOf(McqOption("車"), McqOption("自"), McqOption("転"), McqOption("馬")), 0),
            KanjiQuestion("14. (こども)が あそんでいます。", listOf(McqOption("小人"), McqOption("子供"), McqOption("女子"), McqOption("少人")), 1),
            KanjiQuestion("15. (おんな)の せんせいです。", listOf(McqOption("母"), McqOption("女"), McqOption("姉"), McqOption("妹")), 1),
            KanjiQuestion("16. (ひと)が たくさん います。", listOf(McqOption("人"), McqOption("入"), McqOption("休"), McqOption("大")), 0),
            KanjiQuestion("17. (としょかん)で べんきょうします。", listOf(McqOption("図書館"), McqOption("町書間"), McqOption("時書室"), McqOption("本室館")), 0),
            KanjiQuestion("18. (がくせい)です。", listOf(McqOption("学校"), McqOption("校生"), McqOption("学生"), McqOption("学年")), 2),
            KanjiQuestion("19. (みなみ)ぐちを つかってください。", listOf(McqOption("南"), McqOption("北"), McqOption("西"), McqOption("東")), 0),
            KanjiQuestion("20. (にほん)に いきます。", listOf(McqOption("日本"), McqOption("日木"), McqOption("日本"), McqOption("本日")), 0)
        )
    )
}

fun getMcq11Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_11",
        title = "MCQ 11",
        questions = listOf(
            KanjiQuestion("1. (子)どもが あそんでいます。", listOf(McqOption("し"), McqOption("す"), McqOption("こ"), McqOption("ね")), 2),
            KanjiQuestion("2. (中)に はいります。", listOf(McqOption("なか"), McqOption("ちゅう"), McqOption("じゅう"), McqOption("なが")), 0),
            KanjiQuestion("3. (母)に でんわを かけます。", listOf(McqOption("ちち"), McqOption("はは"), McqOption("おか"), McqOption("ぼ")), 1),
            KanjiQuestion("4. (先)に いってください。", listOf(McqOption("さき"), McqOption("せい"), McqOption("せん"), McqOption("まえ")), 0),
            KanjiQuestion("5. (上)に のぼります。", listOf(McqOption("うえ"), McqOption("かみ"), McqOption("じょう"), McqOption("あげ")), 0),
            KanjiQuestion("6. (天)きが いいです。", listOf(McqOption("あめ"), McqOption("てん"), McqOption("そら"), McqOption("て")), 1),
            KanjiQuestion("7. (生)まれは にほんです。", listOf(McqOption("せい"), McqOption("い"), McqOption("う"), McqOption("なま")), 2),
            KanjiQuestion("8. (円)を はらいます。", listOf(McqOption("えん"), McqOption("まる"), McqOption("いち"), McqOption("え")), 0),
            KanjiQuestion("9. (今)は ごご よじです。", listOf(McqOption("こん"), McqOption("いま"), McqOption("けん"), McqOption("こ")), 1),
            KanjiQuestion("10. (友)だちと あそびます。", listOf(McqOption("とも"), McqOption("ゆう"), McqOption("ともだち"), McqOption("しん")), 0),
            KanjiQuestion("11. (うえ)に あがってください。", listOf(McqOption("下"), McqOption("中"), McqOption("上"), McqOption("外")), 2),
            KanjiQuestion("12. (いぬ)が います。", listOf(McqOption("犬"), McqOption("大"), McqOption("牛"), McqOption("王")), 0),
            KanjiQuestion("13. (まえ)に ならんでください。", listOf(McqOption("後"), McqOption("今"), McqOption("先"), McqOption("前")), 3),
            KanjiQuestion("14. (ときどき) テレビを みます。", listOf(McqOption("時々"), McqOption("間間"), McqOption("日日"), McqOption("日時")), 0),
            KanjiQuestion("15. (ひる)ごはんを たべます。", listOf(McqOption("明"), McqOption("午"), McqOption("昼"), McqOption("朝")), 2),
            KanjiQuestion("16. (ひがし)ぐちから でます。", listOf(McqOption("西"), McqOption("南"), McqOption("東"), McqOption("北")), 2),
            KanjiQuestion("17. (よん)ページを よんでください。", listOf(McqOption("四"), McqOption("二"), McqOption("五"), McqOption("七")), 0),
            KanjiQuestion("18. (がっこう)に いきます。", listOf(McqOption("学間"), McqOption("学校"), McqOption("校生"), McqOption("校書")), 1),
            KanjiQuestion("19. (きた)の まちに いきます。", listOf(McqOption("北"), McqOption("南"), McqOption("東"), McqOption("西")), 0),
            KanjiQuestion("20. (とお)くに いきます。", listOf(McqOption("多"), McqOption("遠"), McqOption("通"), McqOption("十")), 1)
        )
    )
}

fun getMcq12Bank(): QuestionBank {
    return QuestionBank(
        id = "mcq_12",
        title = "MCQ 12",
        questions = listOf(
            KanjiQuestion("1. (大)きい いぬが います。", listOf(McqOption("たい"), McqOption("おお"), McqOption("だい"), McqOption("ちい")), 1),
            KanjiQuestion("2. (日)ようびに いきます。", listOf(McqOption("にち"), McqOption("じつ"), McqOption("ひ"), McqOption("び")), 0),
            KanjiQuestion("3. (本)を よみます。", listOf(McqOption("ほん"), McqOption("ぽん"), McqOption("もと"), McqOption("ぼん")), 0),
            KanjiQuestion("4. (学)こうに いきます。", listOf(McqOption("がく"), McqOption("ごう"), McqOption("まなぶ"), McqOption("がつ")), 0),
            KanjiQuestion("5. (下)に おいてください。", listOf(McqOption("か"), McqOption("げ"), McqOption("した"), McqOption("さ")), 2),
            KanjiQuestion("6. (金)ようびに あいましょう。", listOf(McqOption("かね"), McqOption("きん"), McqOption("ごん"), McqOption("かな")), 1),
            KanjiQuestion("7. (外)で あそびます。", listOf(McqOption("がい"), McqOption("そと"), McqOption("ほか"), McqOption("はず")), 1),
            KanjiQuestion("8. (女)のひとが はなします。", listOf(McqOption("じょ"), McqOption("にょ"), McqOption("おんな"), McqOption("め")), 2),
            KanjiQuestion("9. (山)に のぼります。", listOf(McqOption("やま"), McqOption("さん"), McqOption("やまい"), McqOption("や")), 0),
            KanjiQuestion("10. (上)ずに なりました。", listOf(McqOption("うえ"), McqOption("じょう"), McqOption("うわ"), McqOption("のぼ")), 1),
            KanjiQuestion("11. (くるま)が とまりました。", listOf(McqOption("車"), McqOption("転"), McqOption("車両"), McqOption("輪")), 0),
            KanjiQuestion("12. (こども)は あそんでいます。", listOf(McqOption("子供"), McqOption("学生"), McqOption("子犬"), McqOption("小人")), 0),
            KanjiQuestion("13. (ひと)が います。", listOf(McqOption("入"), McqOption("人"), McqOption("大"), McqOption("今")), 1),
            KanjiQuestion("14. (みなみ)ぐちに いきます。", listOf(McqOption("南"), McqOption("西"), McqOption("北"), McqOption("東")), 0),
            KanjiQuestion("15. (おんな)の せいとです。", listOf(McqOption("女"), McqOption("母"), McqOption("姉"), McqOption("妹")), 0),
            KanjiQuestion("16. (とけい)を かいました。", listOf(McqOption("時間"), McqOption("時計"), McqOption("日計"), McqOption("今時")), 1),
            KanjiQuestion("17. (いちにち)じゅう べんきょうします。", listOf(McqOption("一日"), McqOption("一人"), McqOption("一気"), McqOption("一月")), 0),
            KanjiQuestion("18. (ちち)に あいました。", listOf(McqOption("母"), McqOption("父"), McqOption("祖父"), McqOption("主")), 1),
            KanjiQuestion("19. (やすみ)の ひに いきます。", listOf(McqOption("休み"), McqOption("安み"), McqOption("体み"), McqOption("下み")), 0),
            KanjiQuestion("20. (ここのか)に うまれました。", listOf(McqOption("九日"), McqOption("九年"), McqOption("九月"), McqOption("九人")), 0)
        )
    )
}

// Create the list once at the top level
private val allQuestionBanks = listOf(
    getMcq1Bank(),
    getMcq2Bank(),
    getMcq3Bank(),
    getMcq4Bank(),
    getMcq5Bank(),
    getMcq6Bank(),
    getMcq7Bank(),
    getMcq8Bank(),
    getMcq9Bank(),
    getMcq10Bank(),
    getMcq11Bank(),
    getMcq12Bank()
)

// The function now simply returns the list that already exists
fun getAllQuestionBanks(): List<QuestionBank> {
    return allQuestionBanks
}

