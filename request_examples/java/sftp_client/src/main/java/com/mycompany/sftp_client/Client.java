/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sftp_client;

/**
 *
 * @author mazinger
 * 
 *
 */

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Client {

    /**
     * @param args the command line arguments
     */
    private static String remoteHost = "localhost";
    private static String username = "user1";
    private static String password = "user1";
    
    public static ChannelSftp setupJsch() throws JSchException {
    JSch jsch = new JSch();
    jsch.setKnownHosts("");
    Session jschSession = jsch.getSession(username, remoteHost);
    jschSession.setPassword(password);
    jschSession.connect();
    return (ChannelSftp) jschSession.openChannel("sftp");
}
    public static void Upload() throws JSchException, SftpException {
    ChannelSftp channelSftp = setupJsch();
    channelSftp.connect();
  
    String localFile = "";
    String remoteDir = "";
  
    channelSftp.put(localFile, remoteDir + "java.txt");
  
    channelSftp.exit();
}
    
    public static void Download() throws JSchException, SftpException {
    ChannelSftp channelSftp = setupJsch();
    channelSftp.connect();
  
    String remoteFile = "java.txt";
    String localDir = "";
  
    channelSftp.get(remoteFile, localDir + "java.txt");
  
    channelSftp.exit();
}
    
    public static void main(String[] args) throws SftpException, JSchException {
        
        
        
        System.out.println("Uploading");
        Upload();
        System.out.println("Downloading");
        Download();
        
        
    }   
}


