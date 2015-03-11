package network.login;

import kimogila.network.helpers.MessageRegistry;
import kimogila.network.helpers.MessageRegistryFactory;
import kimogila.network.protocol.swg.packets.LoginClientId;

public class LoginMessageRegistry extends MessageRegistryFactory {

	public void registerMessages(MessageRegistry factory) {
		factory.register(LoginClientId.class, 0); // TODO: Change opcode
	}
}
