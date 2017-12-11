package imako.fix.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

@Service
class ApplicationService implements Application{

    private Logger LOG = LoggerFactory.getLogger(ApplicationService.class);

	@Override
	public void onCreate(SessionID sessionId) {
        LOG.info("New Session was created");
       
	}

	@Override
	public void onLogon(SessionID sessionId) {
        LOG.info("A wind connexion to be established");
        
	}

	@Override
	public void onLogout(SessionID sessionId) {
        LOG.info("A Session was closed");

	}

	@Override
	public void toAdmin(Message message, SessionID sessionId) {
		LOG.info("Trace all the message which sent to Admin");
	}

	@Override
	public void fromAdmin(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        LOG.info("Trace all message whick receive");
        
	}

	@Override
	public void toApp(Message message, SessionID sessionId) throws DoNotSend {
        LOG.info("Trace all message whick sent from Application");
      
	}

	@Override
	public void fromApp(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        LOG.info("Trace all message whick receive from Application");   
        
	}

}