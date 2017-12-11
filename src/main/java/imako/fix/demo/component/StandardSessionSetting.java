package imako.fix.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import quickfix.ConfigError;
import quickfix.SessionSettings;

@Component
public class StandardSessionSetting {

    private final String STANDARD_SESSION_SETTING = "standard_session_setting.cfg"; 
    private final Logger LOG = LoggerFactory.getLogger(StandardSessionSetting.class);

    public SessionSettings create() {
        try {
            SessionSettings settings  = new SessionSettings(STANDARD_SESSION_SETTING);
            LOG.info("The setting session creation is executed with success");
            return settings;
		} catch (ConfigError e) {
            e.printStackTrace();
            LOG.warn("The setting session creation is  failed");
            LOG.error(e.getMessage());
		}
        return null;
    }

    public SessionSettings create(String fixVersion,String senderCompID, String targetCompID) {
        SessionSettings settings = new SessionSettings();
        settings.setString("BeginString", fixVersion);
        settings.setString("SenderCompID", senderCompID);
        settings.setString("TargetCompID", targetCompID);
        return settings;
    }
}