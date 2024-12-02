package util

import java.io.File
import java.nio.charset.Charset

object FileUtil {
    fun getFile(fileName: String): List<String> {
        var fileData = listOf<String>()
        val resource = Thread.currentThread().contextClassLoader.getResource(fileName) ?: return fileData
        fileData = File(resource.path).readLines(Charset.defaultCharset())

        return fileData
    }
}