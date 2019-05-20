package GPP_Builder

/**
 *
 * @param dirFile The name of a directory file
 * @param indent the indent size used to show the folder structure on the printed page
 *
 */

def listDir(dirFile, indent){
  dirFile.eachFile { file ->
    (0..<indent).each {print "  |"}
    println "  ${file.getName()}"
    if (file.isDirectory())
      listDir(file, 2+indent)
  }
}

/**
 *
 * @param dirName The name of the top level directory the content of which is to be printed
 *
 */
def PrintDir(dirName){
  println "$dirName"
  listDir(new File(dirName), 0)
}

/**
 * The full path of a directory needs to be specified and then the script will print
 * the content of the directory and any sub-directories to the console, enabling the user to
 * visualise the folder structure.
 */
PrintDir("D:\\IJGradle\\GPP_Library\\src\\main\\groovy\\GPP_Library")

