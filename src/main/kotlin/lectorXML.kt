import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class lectorXML : DefaultHandler() {
    private var currentElement = ""
    private var content = StringBuilder() // Me permite concatenar cadenas de forma eficiente.

    override fun startElement(uri: String, localName: String, qName: String, attributes: Attributes) {
        currentElement = qName
        // Añade una nueva linea por cada etiqueta que lee.
        content.append("\n$qName: ")
    }

    override fun endElement(uri: String, localName: String, qName: String) {
        if (qName.equals("row", ignoreCase = true)) { // Le ordeno que ignore mayúsculas, necesario para este caso.
            // Imprime el contenido completo del registro cuando se encuentra una etiqueta de cierre "row"
            println("Contenido del registro:${content.toString().trim()}")
            println("============================")
            content.clear()
        }
        currentElement = ""
    }

    override fun characters(ch: CharArray, start: Int, length: Int) {
        // Añade el contenido al StringBuilder solo si no son espacios en blanco
        val str = String(ch, start, length)
        if (!str.isBlank()) {
            content.append(str.trim())
        }
    }
}