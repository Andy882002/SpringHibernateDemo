package com.app1;

import java.util.Map;

public interface Buffer {

	public void set(String name, int value) throws InterruptedException;
	public Map get() throws InterruptedException;
}
