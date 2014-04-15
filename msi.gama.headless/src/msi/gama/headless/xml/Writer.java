/*********************************************************************************************
 * 
 *
 * 'Writer.java', in plugin 'msi.gama.headless', is part of the source code of the 
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 * 
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 * 
 * 
 **********************************************************************************************/
package msi.gama.headless.xml;

import msi.gama.headless.core.Simulation;


public interface Writer {
	public void writeSimulationHeader(Simulation s);
	public void writeResultStep(int step,String[] names, Object[] values);
	public void close();
}
