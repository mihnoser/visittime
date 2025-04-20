fun main() {
    val timeAgo = agoToText(25920)
    println(timeAgo)
}
fun agoToText(seconds: Int): String {
    val tobe = "Собеседник был(а)"
    val minutes = seconds/60
    val hours = seconds/360
    val mins=minCorrect(minutes)
    val hrs=hourCorrect(hours)

    val text=when (seconds) {
        in 0..60 -> "$tobe только что"
        in 61..360 -> "$tobe $minutes $mins назад"
        in 361..8640 -> "$tobe $hours $hrs назад"
        in 8641..17280 -> "$tobe вчера"
        in 17281..25920 -> "$tobe позавчера"
        else -> "$tobe давно"
    }
    return text
}

fun minCorrect(minutes:Int): String{
    val minEnding=when (minutes){
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }
    return minEnding
}

fun hourCorrect(hours:Int): String{
    val hourEnding=when (hours){
        1,21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
    return hourEnding
}