package oasis.letu.helper

object StringFormatter {
    fun formatStringToInt(string: String) =
        string.filter { it.isDigit() }.toInt()
}
