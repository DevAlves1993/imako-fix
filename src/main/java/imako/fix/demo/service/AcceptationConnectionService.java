package imako.fix.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.LogFactory;
import quickfix.MemoryStoreFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

@Service
public class AcceptationConnectionService {

    private final Logger LOG = LoggerFactory.getLogger(AcceptationConnectionService.class);

    public SocketAcceptor socketAcceptor(SessionSettings settings,Application application) {
        MessageFactory messageFactory = new DefaultMessageFactory();
        LogFactory logFactory = new SLF4JLogFactory(settings);
        MessageStoreFactory storeFactory = new MemoryStoreFactory();
        try {
            SocketAcceptor socketAcceptor = new SocketAcceptor(application, storeFactory
                ,settings, logFactory, messageFactory);
            LOG.info("Socket Acceptor was created with success");
            return socketAcceptor;
		} catch (ConfigError e) {
            e.printStackTrace();
            LOG.warn("The creation of Socket Acceptor was failed");
            LOG.error(e.getMessage());
		}
        return null;
    }

    public void connect(SocketAcceptor socketAcceptor)  {
        try {
            socketAcceptor.start();
            LOG.info("Socket is connected");
		} catch (RuntimeError | ConfigError e) {
            e.printStackTrace();
            LOG.warn("Connection of Socket is failed");
            LOG.error(e.getMessage());
        }
    }

    public void disconnect(SocketAcceptor socketAcceptor) {
        socketAcceptor.stop();
    }
}