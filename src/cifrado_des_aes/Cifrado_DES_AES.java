
package cifrado_des_aes;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Cifrado_DES_AES {

    public String Cifrado(String Cadena, String Clave, int Tipo) {

        String CadenaFinal = "";
        String TipoCifrado = "";
        if (Tipo == 0) {
            TipoCifrado = "DES";
        } else {
            TipoCifrado = "AES";
        }
        SecretKeySpec obj = new SecretKeySpec(Clave.getBytes(), TipoCifrado);
        Cipher cifrador;
        try {
            cifrador = Cipher.getInstance(TipoCifrado);
            cifrador.init(Cipher.ENCRYPT_MODE, obj);
            byte[] bytcif = cifrador.doFinal(Cadena.getBytes());
            CadenaFinal = new BASE64Encoder().encode(bytcif);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
        return CadenaFinal;
    }

    public String Descifrar(String CadenaCifrada, String Clave, int Tipo) {
        String CadenaFinal = "";
        String TipoCifrado = "";
        if (Tipo == 0) {
            TipoCifrado = "DES";
        } else {
            TipoCifrado = "AES";
        }
        SecretKeySpec obj = new SecretKeySpec(Clave.getBytes(), TipoCifrado);
        Cipher cifrador;
        try {
            cifrador = Cipher.getInstance(TipoCifrado);
            cifrador.init(Cipher.DECRYPT_MODE, obj);
            byte[] cifr = new BASE64Decoder().decodeBuffer(CadenaCifrada);
            byte[] bytdes = cifrador.doFinal(cifr);
            CadenaFinal = new String(bytdes);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return CadenaFinal;
    }

}
