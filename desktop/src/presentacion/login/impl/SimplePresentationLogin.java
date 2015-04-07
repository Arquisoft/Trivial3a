package presentacion.login.impl;

import presentacion.login.PresentationLogin;

public class SimplePresentationLogin implements PresentationLogin {

	@Override
	public FondoLogin getFondoLogin() {
		return new FondoLogin();
	}

	@Override
	public VentanaLogin getVentanaLogin() {
		return new VentanaLogin();
	}

	@Override
	public VentanaRegistro getVentanaRegistro(VentanaLogin vl) {
		return new VentanaRegistro(vl);
	}

}
