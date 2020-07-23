# Encryption-Decryption

This program can both encrypt and decrypt text and ciphertext using three methods: shift (Caesar cipher), unicode, and reverse (more methods to be added in the future).

Prerequisites
-------------

This program requires Java to run and compile.

Installation
------------

1. Download this repository and unzip the .zip file in your desired location.
2. Using the command line, navigate to \Encryption-Decryption-master\src\encryptdecrypt.
3. Compile the program files using the command `javac *.java`.

How to use
----------

Once the the compilation is finished, the program can be run from the command line by navigating to \Encryption-Decryption-master\src and using the command `java encryptdecrypt.Main` in combination with any desired arguments (The order of the arguments does not matter).

Several arguments can be entered depending on the specific operation you want to perform: `-key`, `-alg`, `-mode`, `-data`, `-in`, and `-out`. As mentioned, the order of the arguments is of little importance, however, they should be followed by the appropriate value.

`-key`:

The key is an integer value which represents the number of traversing moves that need to be applied on each character of the given text in order to complete the encryption/decryption process. If no `-key` argument is given, the key value defaults to zero and the text will not be changed.

`-alg`:

The algorithm used to encrypt/decrypt the text. The available algorithms currently are `shift`, `reverse`, and `unicode`. Only one algorithm can be entered as a value to the `alg` argument at once. If the `-alg` argument is not used, the program will default to the shift algorithmn.

_Shift:_ Only alphabet characters will be shifted, retaining case (A-Z and a-z).

_Reverse:_ Every alphabet character will be switched with the its alphabet character peer from the opposite direction of the alphabet (A -> Z, B -> Y,..), retaining case (A-Z and a-z). Non-alphabet charaters will remain unaffected.

_Unicode:_ All characters are shifted and may become any unicode character.


`-mode`:

The mode can be set to either `enc` for encryption or `dec` for decryption. The program defaults to `enc` if the `-mode` argument is not used.

`-data`:

The `-data` argument should be followed by a string of the text to be encrypted/decrypted in quotation marks. The program will encrypt/decrypt this text prioritizing it over any text entered using the `-in` argument.

`-in`:

The `-in` argument should be followed by a file path and name. This should be a .txt file containing the text to be encrypted/decrypted.

`-out`:

The `-out` argument should be followed by a file path and name with a .txt extension. This is the file the resulting text will be written to after encryption/decryption. If the specified file does not already exist, it will be created; otherwise, the existing file will be overwritten.

Notes:
------
1 - More algorithms to Encrypt/Decrypt will be added in the future.\n
2 - I will decide on a suitable design pattern and reorganize the code accordingly

