package presentacion;

import presentacion.login.PresentationLogin;
import presentacion.login.impl.SimplePresentationLogin;

public class SimplePresentationFactory implements PresentationFactory {

	@Override
	public PresentationLogin createPresentationLogin() {
		return new SimplePresentationLogin();
	}

}
