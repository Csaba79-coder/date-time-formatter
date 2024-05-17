import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import scala.util.Try

object LocalDateFormatter {

  def main(args: Array[String]): Unit = {
    val dateString = Some("24-Aug-24")
    val dateJuly = Some("12-Jul-24")
    val dateOption: Option[LocalDate] = parseTextToLocalDate(dateString)
    val dateOptionJuly = parseTextToLocalDate(dateJuly)

    println(dateOption)
    println(dateOptionJuly)
  }

  private def parseTextToLocalDate(text: Option[String]): Option[LocalDate] = {
    // Define the DateTimeFormatter for the given date format
    val customDateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH)

    // Attempt to parse the date string into a LocalDate
    text match {
      case Some(text) => Try(LocalDate.parse(text, customDateFormatter)).toOption
      case None => None
    }
  }
}
