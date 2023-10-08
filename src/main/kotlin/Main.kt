import org.xml.sax.SAXException
import javax.xml.parsers.ParserConfigurationException
import javax.xml.parsers.SAXParserFactory
import java.io.IOException

fun main() {
    // Añado tratamiento de excepciones.
    try {
        val factory = SAXParserFactory.newInstance()
        val parser = factory.newSAXParser()
        val handler = lectorXML() // Sería conveniente modificar en el futuro para hacer al programa polivalente.

        parser.parse("salida.xml", handler)
    } catch (e: SAXException) {
        println("Error durante el análisis del archivo XML: ${e.message}")
    } catch (e: ParserConfigurationException) {
        println("Error al configurar el analizador SAX: ${e.message}")
    } catch (e: IOException) {
        println("Error al leer el archivo XML: ${e.message}")
    }
}