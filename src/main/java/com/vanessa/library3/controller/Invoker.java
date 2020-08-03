package com.vanessa.library3.controller;

import java.util.Stack;

public class Invoker {
	private Stack<Command> executed;
	private Stack<Command> undone;

	public Invoker() {
		super();
		this.executed = new Stack<Command>();
		this.undone = new Stack<Command>();
	}

	public String execute(Command c) {
		executed.push(c);
		undone.clear();
		return c.execute();
	}

	public String undo() {
		if (executed.isEmpty())
			return "";

		Command c = executed.pop();
		undone.push(c);
		
		return c.undo();
	}

	public String redo() {
		if (undone.isEmpty())
			return "";

		Command c = undone.pop();
		executed.push(c);
		return c.execute();
	}
	
}