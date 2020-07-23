package encryptdecrypt;

interface BaseAlgorithm {
    StringBuilder encrypt(StringBuilder text, int key);
    StringBuilder decrypt(StringBuilder text, int key);
}


