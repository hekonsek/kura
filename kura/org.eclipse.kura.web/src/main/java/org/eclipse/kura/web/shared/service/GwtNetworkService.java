/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech
 *******************************************************************************/
package org.eclipse.kura.web.shared.service;

import java.util.List;

import org.eclipse.kura.web.shared.GwtKuraException;
import org.eclipse.kura.web.shared.model.GwtFirewallNatEntry;
import org.eclipse.kura.web.shared.model.GwtFirewallOpenPortEntry;
import org.eclipse.kura.web.shared.model.GwtFirewallPortForwardEntry;
import org.eclipse.kura.web.shared.model.GwtNetInterfaceConfig;
import org.eclipse.kura.web.shared.model.GwtWifiConfig;
import org.eclipse.kura.web.shared.model.GwtWifiHotspotEntry;
import org.eclipse.kura.web.shared.model.GwtXSRFToken;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("network")
public interface GwtNetworkService extends RemoteService
{
	public ListLoadResult<GwtNetInterfaceConfig> findNetInterfaceConfigurations() throws GwtKuraException;

	public void updateNetInterfaceConfigurations(GwtXSRFToken xsrfToken, GwtNetInterfaceConfig config) throws GwtKuraException;
		
	public ListLoadResult<GwtFirewallOpenPortEntry> findDeviceFirewallOpenPorts(GwtXSRFToken xsrfToken) throws GwtKuraException;

	public void updateDeviceFirewallOpenPorts(GwtXSRFToken xsrfToken, List<GwtFirewallOpenPortEntry> entries) throws GwtKuraException;
		
	public ListLoadResult<GwtFirewallPortForwardEntry> findDeviceFirewallPortForwards(GwtXSRFToken xsrfToken) throws GwtKuraException;
	
	public ListLoadResult<GwtFirewallNatEntry> findDeficeFirewallNATs(GwtXSRFToken xsrfToken) throws GwtKuraException;
	
	public void updateDeviceFirewallPortForwards(GwtXSRFToken xsrfToken, List<GwtFirewallPortForwardEntry> entries) throws GwtKuraException;
	
	public void updateDeviceFirewallNATs(GwtXSRFToken xsrfToken, List<GwtFirewallNatEntry> entries) throws GwtKuraException;
	
	public void renewDhcpLease(GwtXSRFToken xsrfToken, String interfaceName) throws GwtKuraException;
	
	public ListLoadResult<GwtWifiHotspotEntry> findWifiHotspots(GwtXSRFToken xsrfToken, String interfaceName) throws GwtKuraException;
	
	public boolean verifyWifiCredentials(GwtXSRFToken xsrfToken, String interfaceName, GwtWifiConfig gwtWifiConfig) throws GwtKuraException;

	@Deprecated
	public void rollbackDefaultConfiguration(GwtXSRFToken xsrfToken);
}
