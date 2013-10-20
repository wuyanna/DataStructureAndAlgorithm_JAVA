package com.ds.queue;

public interface IQueue<AT> {
	public void enqueue(AT item);
	public AT dequeue();
	public AT peekFront();
	public boolean isEmpty();
}
