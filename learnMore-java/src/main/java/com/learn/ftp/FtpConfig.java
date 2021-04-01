package com.learn.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.SocketException;

/**
 * @author yankai
 */
public class FtpConfig {
    private static final Logger logger = LoggerFactory.getLogger(FtpConfig.class);
    private static final int timeout = 1000*30;
    public static FTPClient ftpClient(String host, int port,String username, String password){

        FTPClient ftpClient = new FTPClient();
        //设置连接超时时间
        ftpClient.setConnectTimeout(timeout);
        //设置ftp字符集
        ftpClient.setControlEncoding("utf-8");
//        ftpClient.enterLocalPassiveMode();//设置被动模式，文件传输端口设置
        try {
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件传输模式为二进制，可以保证传输的内容不会被改变
//            ftpClient.connect(beansEntity.getIp()+":"+beansEntity.getPort());
            ftpClient.setDefaultPort(port);
            ftpClient.connect(host,port);
            ftpClient.login(username,password);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)){
                ftpClient.disconnect();
                logger.error("未连接到FTP，用户名或密码错误!");
                return null;
            }else {
                logger.info("FTP连接成功!");
                return ftpClient;
            }
        } catch (SocketException socketException) {
            logger.error("FTP的IP地址可能错误，请正确配置!");
            return null;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            logger.error("FTP的端口错误,请正确配置!");
            return null;
        }
    }

}