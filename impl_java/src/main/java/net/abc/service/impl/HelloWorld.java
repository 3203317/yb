package net.abc.service.impl;

import net.abc.service.IHelloWorld;

public class HelloWorld implements IHelloWorld {

	@Override
	public String say(String v) {
		return v + " 1234";
	}

	@Override
	public String say(String v, int i) {
		return v + "4567" + i;
	}

}
