//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.crypto.Cipher
// Encryption
fun encryption(text: String, key: Int): String {
    var encryptedText = "" // Initialize an empty string to store the encrypted text
    val adjustedShift = key % 26 // Ensure the shift is within the range of the alphabet (0-25)

    for (char in text) {
        if (char in 'A'..'Z') { // Check if the character is an uppercase letter
            var newChar = char + adjustedShift // Adding uppercase Char with adjusted key --> W + 3 = Z
            if (newChar > 'Z') { // Check if newChar > Z = 90
                newChar -= 26  // Wrap around to the beginning of the uppercase alphabet
            }
            encryptedText += newChar // Append newChar to encryptedText
        } else if (char in 'a'..'z') { // Check if the character is a lowercase letter
            var newChar = char + adjustedShift //  Shift the character by the adjusted key
            if (newChar > 'z') { // If the shifted character exceeds 'z'
                newChar -= 26 // Wrap around to the beginning of the lowercase alphabet
            }
            encryptedText += newChar // Append the encrypted character to the result
        } else if (char != ' ') { // Check if the character is not a space
            encryptedText += char  // Append the non-space character as is
        }
        // Note: Spaces are ignored and not added to encryptedText
    }
    return encryptedText // Return the fully constructed encrypted text
}

fun main() {
    val originalText = "Hello World!" // The text to be encrypted
    val key = 3 // The number of positions each letter should be shifted
    val encryptedText = encryption(originalText, key) // Encrypt the original text using the specified key
    println("Encrypted Text: $encryptedText") // Output the encrypted text
}

// Alternative approach

/*
fun caesarCipher(text: String, key: Int): String {
    // Encrypt a given text using Cipher with the key
    // @param text  The input.string to encrypt
    // @param key the number of the position each letter is shifted
    // @return the encrypted string

    val result = StringBuilder()
    val shift = key % 26  // Ensure the shift is within the alphabet range
    val adjustedShift = shift % 26

    for (char in text) {
        if (char.isLetter()) {
            val base = if (char.isUpperCase()) 'A' else 'a'
           // val newChar = (((char.code - base.code + shift + 26) % 26 + base.code).toChar()
            // val newChar = (((char - base ) + shift )  %26 + 26) base.code).toChar()
            val newChar = base + (char - base + adjustedShift + 26) % 26
            result.append(newChar)
        } else {
            result.append(char)
        }
    }
    return result.toString()
}

fun main() {
    val originalText = "Hello, World!"
    val key = 3
    val encryptedText = caesarCipher(originalText, key)
    println("Encrypted Text: $encryptedText")
}
*/

// Alternate approach
/*
fun encryption(text: String, key: Int) : String {
    var encryptedText = "" // declared a var of empty String to store the encrypted text result
    for (char in text) { // Loop through the text and store its return into char
        val shiftedChar = char + key // ASCII vale of each Char + Key. Exam: --> 'W' = 119 --> 119 + 3 = 122 --> 122 = 'Z'. So the shiftedChar value will be = Z
       encryptedText += shiftedChar // encryptedText + Z. It keeps adding the char one by one until it reaches the end of text. --> Zho....
    }
    return encryptedText // Here it returns all the Encrypted text.
}

fun main() {
    val originalText = "Welcome to Kotlin"
    val key = 3
    val result = encryption(originalText, 3)
    println("Encrypted text for 'Welcome to Kotlin' :  $result")
}

*/
