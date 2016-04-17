package com.app;

import java.util.List;

public interface Buffer {

	public void set(int value) throws InterruptedException;
	public List<Integer> get() throws InterruptedException;
}
