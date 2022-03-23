package com.learn.hutooltest;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

import java.nio.charset.StandardCharsets;


/**
 * @author Feng Jie
 * @date 2021/11/17 14:47
 */
public class EncryptTest {
    public static void main(String[] args) {
        String content ="test中文";
// 随机生成密钥
        byte[] key =SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
// 构建
        AES aes =SecureUtil.aes(key);
// 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
// 解密为字符串
        String decryptStr = aes.decryptStr("444369e18263b2076a2a62fe440c85a3", CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }
}
