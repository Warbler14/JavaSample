package com.lotus.jewel.sample.ssh;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.config.keys.ClientIdentityLoader;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.channel.Channel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.sshd.common.config.keys.FilePasswordProvider;
import org.apache.sshd.common.keyprovider.FileKeyPairProvider;

public class SshClientSample {

    private static Logger logger = LogManager.getLogger(SshClientSample.class);

    public static void main(String[] args) {
//        String username = "ubuntu";
//        String password = "insung";
//        String host = "127.0.0.1";

        String username = "centos";
        String host = "13.125.226.8";

        int port = 22;
        long defaultTimeoutSeconds = 3;
        String command = "date";

        logger.info("start ssh send commmand : " + command);

//        try {
//
//            connectAndSendCommand(username, password, host, port, defaultTimeoutSeconds, command);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        try {
            String privateKeyPath = "C:\\aircode\\aws\\key";
            connectAndSendCommandWithKey(username, privateKeyPath, null, host, port, defaultTimeoutSeconds, command);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void connectAndSendCommand(String username, String password,
                                             String host, int port, long defaultTimeoutSeconds, String command) throws IOException {

        SshClient client = SshClient.setUpDefaultClient();
        client.start();

        try (ClientSession session = client.connect(username, host, port)
                .verify(defaultTimeoutSeconds, TimeUnit.SECONDS).getSession()) {

            session.addPasswordIdentity(password);

            session.auth().verify(defaultTimeoutSeconds, TimeUnit.SECONDS);

            String responseString = sendCommand(session, "", defaultTimeoutSeconds);

            logger.info(responseString);

            responseString = sendCommand(session, command, defaultTimeoutSeconds);
            logger.info(responseString);

        } finally {
            client.stop();
        }
    }

    public static void connectAndSendCommandWithKey(String username, String privateKeyPath, String privateKeyPassword,
                                             String host, int port, long defaultTimeoutSeconds, String command) throws IOException {

        SshClient client = SshClient.setUpDefaultClient();
        client.start();

        try (ClientSession session = client.connect(username, host, port)
                .verify(defaultTimeoutSeconds, TimeUnit.SECONDS).getSession()) {




//            session.setKeyIdentityProvider(ClientIdentityLoader.of(Paths.get("/path/to/your/private-key.pem")));

            // Start authentication
//            session.auth().publickey("your-ssh-username").verify();




            //org.apache.sshd.common.SshException: No more authentication methods available
//            Path keyPath = Paths.get("privateKeyPath");
//            FileKeyPairProvider provider = new FileKeyPairProvider(keyPath);
//            //provider.setPasswordFinder(FilePasswordProvider.of(/*your private key passphrase*/));
//            session.setKeyIdentityProvider(provider);

            session.auth().verify(defaultTimeoutSeconds, TimeUnit.SECONDS);

            String responseString = sendCommand(session, "", defaultTimeoutSeconds);

            logger.info(responseString);

            responseString = sendCommand(session, command, defaultTimeoutSeconds);
            logger.info(responseString);

        } finally {
            client.stop();
        }
    }

    private static String sendCommand(ClientSession session, String command, long defaultTimeoutSeconds) throws IOException {

        String result = null;

        try (ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
             ClientChannel channel = session.createChannel(Channel.CHANNEL_SHELL)) {

            channel.setOut(responseStream);
            try {
                channel.open().verify(defaultTimeoutSeconds, TimeUnit.SECONDS);

                try (OutputStream pipedIn = channel.getInvertedIn()) {
                    if (pipedIn == null) {
                        return null;
                    }

                    pipedIn.write(command.getBytes());
                    pipedIn.flush();
                }

                channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED),
                        TimeUnit.SECONDS.toMillis(defaultTimeoutSeconds));

                result = new String(responseStream.toByteArray());

            } finally {
                channel.close(false);
            }
        }

        return result;
    }

}
