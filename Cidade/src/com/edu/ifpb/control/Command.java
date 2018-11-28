package com.edu.ifpb.control;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public interface Command {
	public void execute(HttpServletRequest request,HttpServletResponse response);
}
