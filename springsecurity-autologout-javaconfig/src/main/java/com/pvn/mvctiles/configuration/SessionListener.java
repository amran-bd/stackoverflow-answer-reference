package com.pvn.mvctiles.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener
{
	Logger OUT = LoggerFactory.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		OUT.trace("session created");
		event.getSession().setMaxInactiveInterval(60);
		
		//autologout configuration starts
		event.getSession().setAttribute("timeOutTimeInSeconds", 61);
		event.getSession().setAttribute("showTimerTimeInSeconds", 50);
		//autologout configuration ends
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		OUT.trace("session destroyed");
	}
}
